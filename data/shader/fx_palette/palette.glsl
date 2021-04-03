#ifdef GL_ES
precision mediump float;
#endif

uniform float time;
uniform float hue;
uniform vec2 resolution;
uniform int mode;

// https://thebookofshaders.com/05/?lan=fr
//  Function from Iñigo Quiles
//  https://www.shadertoy.com/view/MsS3Wc
vec3 rgb_to_hsb( in vec3 c ){
	vec4 K = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);
	vec4 p = mix(	vec4(c.bg, K.wz),
            		vec4(c.gb, K.xy),
              	step(c.b, c.g));
	vec4 q = mix(	vec4(p.xyw, c.r),
          			vec4(c.r, p.yzx),
								step(p.x, c.r));
	float d = q.x - min(q.w, q.y);
	float e = 1.0e-10;
	return vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)),
									d / (q.x + e),
									q.x);
}

vec3 hsb_to_rgb(vec3 c){
	vec3 rgb = clamp(abs(mod(c.x*6.0+vec3(0.0,4.0,2.0),
                             6.0)-3.0)-1.0,
                     0.0,
                     1.0 );
	rgb = rgb*rgb*(3.0-2.0*rgb);
	return c.z * mix( vec3(1.0), rgb, c.y);
}

float map(float value, float min_0, float max_0, float min_1, float max_1) {
  return min_1 + (max_1 - min_1) * (value - min_0) / (max_0 - min_0);
}

void main(void) {
	vec2 uv = gl_FragCoord.xy/resolution.xy;
	vec3 color = vec3(hue,1.0,1.0);
	color = hsb_to_rgb(color);    

	if(mode == 0) color = hsb_to_rgb(vec3(uv.x,1.0,uv.y)); // from black
	else if(mode == 1) color = hsb_to_rgb(vec3(uv.x,uv.y,1.0)); // from white
	else if(mode == 2) {
		float sat = 1.0;
		float bri = 1.0;
		if(uv.y < 0.5) {
			bri = map(uv.y, 0, 0.5, 0, 1.0);
		} else {
			sat = map(uv.y, 0.5, 1.0, 1.0, 0);
		}
		color = hsb_to_rgb(vec3(uv.x,sat,bri)); // from white to color to black
	} else if(mode == 3) color = hsb_to_rgb(vec3(hue,uv.x,uv.y)); // from white with hue change
	gl_FragColor = vec4(color,1.0);
}