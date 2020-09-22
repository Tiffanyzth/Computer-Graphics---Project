package objects3D;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;

public class TexCube2 {
	
	static float white[] = { 1.0f, 1.0f, 1.0f, 1.0f };
	
	public TexCube2() {

	}
	
	// Implement using Cube.java
	public void DrawTexCube(float length,float height, Texture tex) {
		Point4f vertices[] = {  
				new Point4f(-length/2, -length/2, -height/2, 0.0f), 
				new Point4f(-length/2, -length/2, height/2, 0.0f),
				new Point4f(-length/2, length/2, -height/2, 0.0f), 
				new Point4f(-length/2, length/2, height/2, 0.0f),
				new Point4f(length/2, -length/2, -height/2, 0.0f),
				new Point4f(length/2, -length/2, height/2, 0.0f),
				new Point4f(length/2, length/2, -height/2, 0.0f), 
				new Point4f(length/2, length/2, height/2, 0.0f) };

		int faces[][] = { 	{ 0, 4, 5, 1 }, 
							{ 0, 2, 6, 4 }, 
							{ 0, 1, 3, 2 }, 
							{ 4, 6, 7, 5 },
							{ 1, 5, 7, 3 },
							{ 2, 3, 7, 6 } };

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glColor3f(white[0], white[1], white[2]);
		for (int face = 0; face < 6; face++) { // per face
			Vector4f v = vertices[faces[face][1]].MinusPoint(vertices[faces[face][0]]);
			Vector4f w = vertices[faces[face][3]].MinusPoint(vertices[faces[face][0]]);
			Vector4f normal = v.cross(w).Normal();
			if(face==4) {
				GL11.glNormal3f(normal.x, normal.y, normal.z);
				//top left
				GL11.glTexCoord2f(0.05f,0.95f);
				GL11.glVertex3f(vertices[faces[face][0]].x, vertices[faces[face][0]].y, vertices[faces[face][0]].z);
				//bottom left
				GL11.glTexCoord2f(0.05f,0.05f);
				GL11.glVertex3f(vertices[faces[face][1]].x, vertices[faces[face][1]].y, vertices[faces[face][1]].z);
				//bottom right
				GL11.glTexCoord2f(0.95f,0.05f);
				GL11.glVertex3f(vertices[faces[face][2]].x, vertices[faces[face][2]].y, vertices[faces[face][2]].z);
				//top right
				GL11.glTexCoord2f(0.95f,0.95f);
				GL11.glVertex3f(vertices[faces[face][3]].x, vertices[faces[face][3]].y, vertices[faces[face][3]].z);
			}else {
				GL11.glNormal3f(normal.x, normal.y, normal.z);
				//top left
				GL11.glVertex3f(vertices[faces[face][0]].x, vertices[faces[face][0]].y, vertices[faces[face][0]].z);
				//bottom left
				GL11.glVertex3f(vertices[faces[face][1]].x, vertices[faces[face][1]].y, vertices[faces[face][1]].z);
				//bottom right
				GL11.glVertex3f(vertices[faces[face][2]].x, vertices[faces[face][2]].y, vertices[faces[face][2]].z);
				//top right
				GL11.glVertex3f(vertices[faces[face][3]].x, vertices[faces[face][3]].y, vertices[faces[face][3]].z);
			}
		} // per face

		GL11.glEnd();

	}
}


	 