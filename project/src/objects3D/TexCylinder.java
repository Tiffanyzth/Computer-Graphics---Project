package objects3D;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

public class TexCylinder {

	
	public TexCylinder() { 
	}
	
	// remember to use Math.PI instead PI 
	// Implement using notes and examine Tetrahedron to aid in the coding  look at lecture  7 , 7b and 8 
	public void DrawTexCylinder(float radius, float height, int nSegments, Texture tex ) {
		//start drawing
		GL11.glBegin(GL11.GL_TRIANGLES);
		
		for (float i = 0.0f; i < nSegments; i += 1.0){ /* a loop around circumference of a tube */			
			float angle = (float) (Math.PI * i * 2.0 / nSegments) ;
			float nextAngle = (float) (Math.PI * (i + 1.0) * 2.0 / nSegments);
			
			/* compute sin & cosine so that we can get x1,x2,y1,y2 */
			float x1 = (float) Math.sin(angle)*radius, y1 = (float) Math.cos(angle)*radius;
			float x2 = (float) Math.sin(nextAngle)*radius, y2 = (float) Math.cos(nextAngle)*radius;
			
			/* draw top (green) triangle */
			GL11.glTexCoord2f(0.0f,0.0f);
			GL11.glNormal3f(x1, y1, 0.0f); GL11.glVertex3f(x1, y1, 0.0f);
			GL11.glTexCoord2f(1.0f,1.0f);
			GL11.glNormal3f(x2, y2, 0.0f); GL11.glVertex3f(x2, y2, height);
			GL11.glTexCoord2f(0.0f,1.0f);
			GL11.glNormal3f(x1, y1, 0.0f); GL11.glVertex3f(x1, y1, height);
			
			/* draw top roundness */
			//only need one normal
			GL11.glNormal3f(0.0f, 0.0f, height); 
			
			GL11.glVertex3f(0.0f, 0.0f, height);
			GL11.glVertex3f(x2, y2, height);			
			GL11.glVertex3f(x1, y1, height);
			
			/* draw bottom (red) triangle */
			GL11.glTexCoord2f(0.0f,0.0f);
			GL11.glNormal3f(x1, y1, 0.0f); GL11.glVertex3f(x1, y1, 0.0f);
			GL11.glTexCoord2f(0.0f,1.0f);
			GL11.glNormal3f(x2, y2, 0.0f); GL11.glVertex3f(x2, y2, 0.0f);
			GL11.glTexCoord2f(1.0f,1.0f);
			GL11.glNormal3f(x2, y2, 0.0f); GL11.glVertex3f(x2, y2, height);
			/* draw bottom roundness */
			//only need one normal
			GL11.glNormal3f(0.0f, 0.0f, -height); 
			
			GL11.glVertex3f(x1, y1, 0.0f);
			GL11.glVertex3f(x2, y2, 0.0f);
			GL11.glVertex3f(0.0f, 0.0f, 0.0f);
		} /* a loop around circumference of a tube */
		GL11.glEnd();
	}
}
