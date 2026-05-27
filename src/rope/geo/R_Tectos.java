

/**
* R_Tectos
* 2026-2026
* v 0.0.1
* @author @knupel
* @see https://github.com/knupel
*
* https://www.geowiki.fr/index.php?title=Sol_et_sous-sol
* https://fr.wikipedia.org/wiki/Lithosph%C3%A8re
*/

package rope.geo;

import java.util.ArrayList;
import processing.core.PApplet;
import rope.core.R_Graphic;
import rope.mesh.R_Line2D;
import rope.vector.vec3;



public class R_Tectos extends R_Graphic {
    private ArrayList<R_Line2D> ridges = new ArrayList<>();
    private ArrayList<R_Line2D> talwegs = new ArrayList<>();
    private ArrayList<vec3> tops = new ArrayList<>();
    private ArrayList<vec3> bottoms = new ArrayList<>();
    private vec3 size = new vec3(100);

    public R_Tectos(PApplet pa, int x, int y) {
        super(pa);
        size.x(x);
        size.y(y); 
    }


    /**
     * clear and the list of tectonic plate
     */
    @Override
    public void clear() {
        ridges.clear();
        talwegs.clear();
        tops.clear();
        bottoms.clear();
    }

    /**
     * 
     * @return ArrayList of R_Line2D
     */
    public ArrayList<R_Line2D> get_ridges() {
        return ridges;
    }

    /**
     * 
     * @return ArrayList of R_Line2D
     */
    public ArrayList<R_Line2D> get_talwegs() {
        return talwegs;
    }

        /**
     * 
     * @return ArrayList of vec3
     */
    public ArrayList<vec3> get_bottoms() {
        return bottoms;
    }

        /**
     * 
     * @return ArrayList of vec3
     */
    public ArrayList<vec3> get_tops() {
        return tops;
    }

    /**
     * Create the tectonic plate
     * @param grid
     * @param normal_value
     */
    public void init_plate(R_Lithos grid[], float normal_value) {
        for(R_Lithos elem : grid) {
            elem.z(normal_value);
        }
    }


    /**
     * Create Talwegs and Ridges
     * @param points_low
     * @param points_high
     */
    public void create_ridges_and_talwegs(int points_low, int points_high) {
        create_key_points(bottoms, talwegs, points_low, 0);
        create_key_points(tops, ridges, points_high, 1);
        clean_talwegs_ridges();
    }


    private void create_key_points(ArrayList<vec3> points, ArrayList<R_Line2D> lines, int num, float altitude) {
        points.clear();
        lines.clear();
        int max_to_next_point = (int)(min(size.x(), size.y()) * 0.4);
        vec3 seed = new vec3(random(size.x()), random(size.y()), altitude);
        // need to make .copy() along the algorithm to avoid the pointer effect
        points.add(seed.copy());
        for(int i = 0 ; i < num ; i++) {
            vec3 next_point = next_point(seed.copy(), max_to_next_point);
            R_Line2D next_line = new R_Line2D(this.pa, seed.copy(), next_point.copy());
            points.add(next_point);
            // check for crossing line, if that's don't cross we can add the ridge
            if(lines.size() > 0) {
            boolean crossing_is = false;
            for(R_Line2D previous_line : lines) {
                // need add the seed coordonanate as exception to avoid the intersection on this point, if we don't do that we cannot link the segment
                if(previous_line.intersection_is(next_line, seed.xy())) {
                crossing_is = true;
                seed.x(random(size.x()));
                seed.y(random(size.y()));
                break;
                }
            }
            if(!crossing_is) {
                lines.add(next_line.copy());
            } 
            } else {
            lines.add(next_line.copy());
            }
            // check if the next top is out of the range
            if(next_point.xy().in_rect(0,0,size.x(),size.y())) {
            seed.set(next_point.copy());
            } else {
            seed.set(random(size.x()), random(size.y()), altitude);
            points.add(seed.copy());
            }
        }
    }

    private vec3 next_point(vec3 origin, int max) {
        float dist = random(max);
        float angle = random(TAU);
        float x = sin(angle);
        float y = cos(angle);
        x = x * dist + origin.x();
        y = y * dist + origin.y();
        return new vec3(x,y,origin.z());
    }

    private void clean_talwegs_ridges() {
        for(int i = talwegs.size() -1 ; i >= 0; i--) {
            for(int k = ridges.size() -1 ; k >= 0; k--) {
                // avoid the Array out bounds
                if(i >= talwegs.size() || k >= ridges.size()) {
                    continue;
                }
                R_Line2D talweg = talwegs.get(i);
                R_Line2D ridge = ridges.get(k);
                if(ridge.intersection_is(talweg)) {
                    float pile_ou_face = random(1);
                    if(pile_ou_face > 0.5) {
                    talwegs.remove(i);
                    } else {
                    ridges.remove(k);
                    }
                }
            }
        }
    }





    /**
     * set grid point to follow the ridges and talwegs
     * @param grid
     */
    public void level_points_grid(R_Lithos grid[]) {
        level_points_grid(grid, bottoms);
        level_points_grid(grid, tops);
    }

    private void level_points_grid(R_Lithos grid[], ArrayList<vec3> points) {
        for(R_Lithos elem : grid) {
            for(vec3 point : points) {
                if(point.xy().compare(elem.pos().xy(), elem.radius())) {
                    if(point.z() == 1) elem.z(1);
                    if(point.z() == 0) elem.z(0);
                }
            }
        }
    }


    /**
     * 
     * @param grid
     */
    public void up_point_on_the_ridge(R_Lithos grid[]) {
        level_lines_grid(grid, ridges, 1);
    }

    /**
     * 
     * @param grid
     */
    public void down_point_on_the_talweg(R_Lithos grid[]){
        level_lines_grid(grid, talwegs, 0);
    }



    private void level_lines_grid(R_Lithos grid[], ArrayList<R_Line2D> lines, float level) {
        for(R_Lithos elem : grid) {
            for(R_Line2D line : lines) {
                if(line.meet_is(elem.pos(), elem.radius())) {
                    elem.z(level);
                    break;
                }
            }
        }
    }



    /**
     * 
     * @param grid
     * @param passes
     * @param convergence between 0 and 1
     */
    public void smooth_altitudes(R_Lithos grid[], int passes, float convergence) {
        float diam = grid[0].radius() * 2;
        // formule bizarre c'est + 1 et + 2
        int cols = (int)(size.x() / diam + 1);
        int rows = (int)(size.y() / diam + 2);
        int row_width = cols + 1;
        float[] values = new float[grid.length];
        boolean[] locked = new boolean[grid.length];
        for(int i = 0; i < grid.length; i++) {
            values[i] = grid[i].pos().z();
            locked[i] = values[i] == 1 || values[i] == 0;
        }
        for(int pass = 0; pass < passes; pass++) {
            float[] next = new float[grid.length];
            for(int i = 0; i < grid.length; i++) {
            if(locked[i]) {
                next[i] = values[i];
                continue;
            }

            int x = i % row_width;
            int y = i / row_width;
            float sum = 0;
            int count = 0;

            if(x > 0) {
                sum += values[i - 1];
                count++;
            }
            // if(x < row_width - 1) {
            if(x < row_width - 1 && i < values.length -1) {
                sum += values[i + 1];
                count++;
            }
            if(y > 0) {
                sum += values[i - row_width];
                count++;
            }
            if(y < rows - 1) {
            // if(y < rows - 1 && i < values.length - row_width) {
                sum += values[i + row_width];
                count++;
            }

            float neighbor_avg = sum / max(count, 1);
            next[i] = lerp(values[i], neighbor_avg, convergence);
            }

            values = next;
        }
        for(int i = 0; i < grid.length; i++) {
            grid[i].z(values[i]);
        }
    }

    /**
     * To give more life for the tectonic plate
     * @param grid
     * @param range
     */
    public void add_noise_altitudes(R_Lithos grid[], float range) {
        for(int i = 0; i < grid.length; i++) {
            float noise = random(-1,1) * range;
            float final_z = grid[i].z() + noise;
            grid[i].z(final_z);
        }
    }
}