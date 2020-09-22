package objects3D;

import org.lwjgl.opengl.GL11;

public class Sphere {
	
	public Sphere() {

	}
	// Implement using notes and examine Tetrahedron to aid in the coding  look at lecture  7 , 7b and 8 
	// 7b should be your primary source, we will cover more about circles in later lectures to understand why the code works 
	public void DrawSphere(float radius,float nSlices,float nSegments) {
		//set the unit of angle increment
		float inctheta = (float) ((2.0f*Math.PI)/nSlices);
		float incphi = (float) (Math.PI/nSegments);
		//start drawing
		GL11.glBegin(GL11.GL_QUADS);
		
		//start two loops
		//Let's divide the sphere vertically into nSegments bars 
		for(float theta=(float) -Math.PI; theta<Math.PI; theta+=inctheta)	{					
			//and then divide this bar into nSlices slices
			for(float phi=(float) -(Math.PI/2.0f); phi<(Math.PI/2.0f); phi+=incphi){
				//set the next angle that we will use later
				float nextTheta = theta + inctheta;	
				float nextPhi = phi + incphi;
				//set the four points that made up one slice
				float x1 = (float) (Math.cos(theta)*radius*Math.cos(phi)), y1 = (float) (Math.sin(theta)*radius*Math.cos(phi));				
				float x2 = (float) (Math.cos(theta)*radius*Math.cos(nextPhi)), y2 = (float) (Math.sin(theta)*radius*Math.cos(nextPhi));
				float x3 = (float) (Math.cos(nextTheta)*radius*Math.cos(nextPhi)), y3 = (float) (Math.sin(nextTheta)*radius*Math.cos(nextPhi));
				float x4 = (float) (Math.cos(nextTheta)*radius*Math.cos(phi)), y4 = (float) (Math.sin(nextTheta)*radius*Math.cos(phi));
				//draw the four points whose coordinate of the normal line is equal to the coordinate of the point
				GL11.glNormal3f(x1, y1, (float)(radius*Math.sin(phi))); GL11.glVertex3f(x1, y1, (float)(radius*Math.sin(phi)));
				GL11.glNormal3f(x2, y2, (float)(radius*Math.sin(nextPhi))); GL11.glVertex3f(x2, y2, (float)(radius*Math.sin(nextPhi)));
				GL11.glNormal3f(x3, y3, (float)(radius*Math.sin(nextPhi))); GL11.glVertex3f(x3, y3, (float)(radius*Math.sin(nextPhi)));
				GL11.glNormal3f(x4, y4, (float)(radius*Math.sin(phi))); GL11.glVertex3f(x4, y4, (float)(radius*Math.sin(phi)));
			}
		}
		GL11.glEnd();
	}
}

 