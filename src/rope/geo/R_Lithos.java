/**
* R_Lithos
* 2026-2026
* v 0.0.4
* @author @knupel
* @see https://github.com/knupel
*
* https://www.geowiki.fr/index.php?title=Sol_et_sous-sol
* https://fr.wikipedia.org/wiki/Lithosph%C3%A8re
*/


package rope.geo;

import rope.vector.vec3;


public class R_Lithos {
  private vec3 pos = new vec3();
  private int radius = 1;
  private vec3 size = new vec3(1);
  private int sol = 1;
  private int sous_sol = 1;
  private int moho = 1;
  
  public R_Lithos() {
  }

	/**
  * set position
  * @param x 
  * @param y 
  * @param z
  */
  public void pos(float x, float y, float z) {
    this.pos.x(x);
    this.pos.y(y);
    this.pos.z(z);
  }


    /**
	 * 
	 * @return vec3 copy of position
	 */
  public vec3 pos() {
    return this.pos.copy();
  }

  /**
	 * 
	 * @return vec3 pointer position
	 */
  public vec3 pointer_pos() {
    return this.pos;
  }


    /**
  * 
  * @param x position
  */
  public void x(float x) {
    this.pos.x(x);
  }

  /**
	 * 
	 * @return x position
	 */
  public float x() {
    return this.pos().x();
  }

  /**
  * 
  * @param y position
  */
  public void y(float y) {
    this.pos.y(y);
  }

  /**
	 * 
	 * @return y position
	 */
  public float y() {
    return this.pos().y();
  }

  /**
  * 
  * @param z position
  */
  public void z(float z) {
    this.pos.z(z);
  }

  /**
	 * 
	 * @return z position
	 */
  public float z() {
    return this.pos().z();
  }

  /**
  * 
  * @param radius
  */
  public void radius(int radius) {
    this.radius = radius;
  }

  /**
	 * 
	 * @return radius
	 */
  public int radius() {
    return this.radius;
  }
  
	/**
  * 
  * @param x 
  * @param y 
  * @param z
  */
  public void size(int x, int y, int z) {
    this.size.x(x);
    this.size.y(y);
    this.size.z(z);
  }

  /**
	 * 
	 * @return size
	 */
  public vec3 size() {
    return this.size.copy();
  }

	/**
	 * 
	 * @param sol 
	 */
  public void set_sol(int sol) {
    this.sol = sol;
  }
  
    /**
	 * 
	 * @return sol
	 */
  public int get_sol() {
    return this.sol;
  }

	/**
	 * 
	 * @param sous_sol
	 */
  public void set_sous_sol(int sous_sol) {
    this.sous_sol = sous_sol;
  }

  /**
	 * 
	 * @return sous_sol 
	 */
  public int get_sous_sol() {
    return this.sous_sol;
  }


  /**
	 * 
	 * @param moho
	 */
  public void set_moho(int moho) {
    this.moho = moho;
  }

  /**
	 * 
	 * @return moho 
	 */
  public int get_moho() {
    return this.moho;
  }
}