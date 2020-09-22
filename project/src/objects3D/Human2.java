package objects3D;

import org.newdawn.slick.opengl.Texture;
import org.lwjgl.opengl.GL11;
import GraphicsObjects.Utils;

public class Human2 {

	// basic colours
	static float black[] = { 0.0f, 0.0f, 0.0f, 1.0f };
	static float white[] = { 1.0f, 1.0f, 1.0f, 1.0f };

	static float grey[] = { 0.5f, 0.5f, 0.5f, 1.0f };
	static float spot[] = { 0.1f, 0.1f, 0.1f, 0.5f };

	// primary colours
	static float red[] = { 1.0f, 0.0f, 0.0f, 1.0f };
	static float green[] = { 0.0f, 1.0f, 0.0f, 1.0f };
	static float blue[] = { 0.0f, 0.0f, 1.0f, 1.0f };

	// secondary colours
	static float yellow[] = { 1.0f, 1.0f, 0.0f, 1.0f };
	static float magenta[] = { 1.0f, 0.0f, 1.0f, 1.0f };
	static float cyan[] = { 0.0f, 1.0f, 1.0f, 1.0f };

	// other colours
	static float orange[] = { 1.0f, 0.5f, 0.0f, 1.0f, 1.0f };
	static float brown[] = { 0.5f, 0.25f, 0.0f, 1.0f, 1.0f };
	static float dkgreen[] = { 0.0f, 0.5f, 0.0f, 1.0f, 1.0f };
	static float pink[] = { 1.0f, 0.6f, 0.6f, 1.0f, 1.0f };
	
	//supplement colors
	static float darkwhite[] = { 0.741f, 0.494f, 0.286f, 1.0f, 1.0f};
	static float wood[] = { 1.0f, 0.647f, 0.310f, 1.0f, 1.0f};
	static float hat[] = { 0.282f, 0.463f, 1.0f, 1.0f, 1.0f};
	
	
	
	public Human2() {

	}
	
	// Implement using notes  in Animation lecture  
	public void DrawHuman(float delta,boolean GoodAnimation, Texture tex_joint)
 { 
		 float theta = (float) (delta * 2 * Math.PI);
		 theta = theta * 20;
		 float LimbRotation;
		 if (GoodAnimation)
		 {
			 LimbRotation = (float) Math.cos(theta)*45;
		 }else
		 {
			 LimbRotation =0;
		 } 
		 
		  
		Sphere sphere= new Sphere();
		Cylinder cylinder= new Cylinder();
		TexSphere texSphere= new TexSphere();
		
		//pelvis
		 GL11.glColor3f(blue[0], blue[1], blue[2]);
		 GL11.glPushMatrix(); {
			 GL11.glTranslatef(0.0f,0.0f,0.0f);
			 sphere.DrawSphere(0.5f, 32, 32); 
			 			 
			 //	waist
			 GL11.glColor3f(white[0], white[1], white[2]);
			 GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(white));
			 GL11.glPushMatrix(); {
		            GL11.glTranslatef(0.0f,0.0f,0.0f);
		            GL11.glRotatef(-90.0f,1.0f,0.0f,0.0f);
		            cylinder.DrawCylinder(0.15f,1.5f,32);
			 } GL11.glPopMatrix();
			 
		     //  chest
			 GL11.glColor3f(blue[0], blue[1], blue[2]);
			 GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
			 GL11.glPushMatrix(); {		
				 GL11.glTranslatef(0.0f,1.2f,0.0f); 
				 sphere.DrawSphere(0.5f, 32, 32); 


		            // neck
		       	 GL11.glColor3f(white[0], white[1], white[2]);
		           GL11.glMaterial( GL11.GL_FRONT,  GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(white));
		            GL11.glPushMatrix(); {
		                GL11.glTranslatef(0.0f,0.25f, 0.0f);
		                GL11.glRotatef(-90.0f,1.0f,0.0f,0.0f);
		                //	GL11.glRotatef(45.0f,0.0f,1.0f,0.0f); 
		                cylinder.DrawCylinder(0.15f,1.0f,32);


		                // head
		           	 GL11.glColor3f(blue[0], blue[1], blue[2]);
		               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
		                GL11.glPushMatrix(); {
		                    GL11.glTranslatef(0.0f,0.0f,0.75f);
		                    GL11.glRotatef(-70, 0.0f, 0, 1.0f);
		                    GL11.glRotatef(-20, 1.0f, 0, 0.0f);
		                    sphere.DrawSphere(0.5f, 32, 32); 
		                    
		                    //nose
		                    GL11.glColor3f(red[0], red[1], red[2]);
				               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
				                GL11.glPushMatrix(); {
				                    GL11.glTranslatef(0.0f,0.0f,0.0f);
				                    GL11.glRotatef(-90.0f,1.0f,0.0f,0.0f);
				                    cylinder.DrawCylinder(0.07f,0.80f,32);
				                }GL11.glPopMatrix();
		                    
		                    //hat bottom
		                  GL11.glColor3f(hat[0], hat[1], hat[2]);
		 		           GL11.glMaterial( GL11.GL_FRONT,  GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(hat));
		 		            GL11.glPushMatrix(); {
		 		                GL11.glTranslatef(0.0f,0.4f, 0.20f);
		 		                GL11.glRotatef(15.0f,1.0f,0.0f,0.0f);
		 		                cylinder.DrawCylinder(0.6f,0.10f,32);
		 		                
		 		             //hat circle
				                  GL11.glColor3f(white[0], white[1], white[2]);
				 		           GL11.glMaterial( GL11.GL_FRONT,  GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(white));
				 		            GL11.glPushMatrix(); {
				 		                GL11.glTranslatef(0.0f,-0.4f, 0.0f);
				 		                cylinder.DrawCylinder(0.5f,0.30f,32);
				 		                
				 		             //hat top
						                  GL11.glColor3f(hat[0], hat[1], hat[2]);
						 		           GL11.glMaterial( GL11.GL_FRONT,  GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(hat));
						 		            GL11.glPushMatrix(); {
						 		                GL11.glTranslatef(0.0f,0.0f, 0.3f);
						 		                cylinder.DrawCylinder(0.5f,0.30f,32);
				 		            }GL11.glPopMatrix();		
				 		        }GL11.glPopMatrix();						 		                
		 		            }GL11.glPopMatrix();		 		            
		                }GL11.glPopMatrix();		                
		             } GL11.glPopMatrix();
		            

		            // left shoulder
		           	 GL11.glColor3f(blue[0],blue[1], blue[2]);
		               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
		                GL11.glPushMatrix(); {
		                    GL11.glTranslatef(0.65f,0.2f,0.0f);
		                    texSphere.DrawTexSphere(0.2f, 32, 32,tex_joint); 
		                    

		                    // left arm
		               	 GL11.glColor3f(white[0], white[1], white[2]);
		                   GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(white));
		                    GL11.glPushMatrix(); {
		                        GL11.glTranslatef(0.0f,0.0f,0.0f);
		                        GL11.glRotatef(90.0f,1.0f,0.0f,0.0f);
		                        GL11.glRotatef(-20.0f,0.0f,0.0f,1.0f);
		                        
		                        GL11.glRotatef(LimbRotation/3,1.0f,0.0f,0.0f); 
		                     //   GL11.glRotatef(27.5f,0.0f,1.0f,0.0f);  
		                        cylinder.DrawCylinder(0.1f,0.7f,32);


		                        // left elbow
		                   	 GL11.glColor3f(blue[0], blue[1], blue[2]);
		                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
		                        GL11.glPushMatrix(); {
		                            GL11.glTranslatef(0.0f,0.0f,0.7f);
		                            texSphere.DrawTexSphere(0.2f, 32, 32,tex_joint); 
		                            
		                            //left forearm
		                       	 GL11.glColor3f(white[0], white[1], white[2]);
		                           GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(white));
		                            GL11.glPushMatrix(); {
		                                GL11.glTranslatef(0.0f,0.0f,0.0f);
		                                	GL11.glRotatef(15.0f,1.0f,0.0f,0.0f);
//		                                  GL11.glRotatef(90.0f,0.0f,1.0f,0.0f); 
		                                
		                                cylinder.DrawCylinder(0.1f,0.8f,32);

		                                // left hand
		                           	 GL11.glColor3f(blue[0], blue[1], blue[2]);
		                               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
		                                GL11.glPushMatrix(); {
		                                    GL11.glTranslatef(0.0f,0.0f,0.9f);
		                                    texSphere.DrawTexSphere(0.2f, 32, 32,tex_joint);                                   

		                                } GL11.glPopMatrix();
		                            } GL11.glPopMatrix();
		                        } GL11.glPopMatrix();
		                    } GL11.glPopMatrix ();
		                } GL11.glPopMatrix ();
		                // to chest

		                // right shoulder
		                GL11.glColor3f(blue[0],blue[1], blue[2]);
			               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
			                GL11.glPushMatrix(); {
			                    GL11.glTranslatef(-0.65f,0.2f,0.0f);
			                    texSphere.DrawTexSphere(0.2f, 32, 32,tex_joint);  

		                    // right arm
			                    GL11.glColor3f(white[0], white[1], white[2]);
				                   GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(white));
				                    GL11.glPushMatrix(); {
				                        GL11.glTranslatef(0.0f,0.0f,0.0f);
				                        GL11.glRotatef(90.0f,1.0f,0.0f,0.0f);
				                        GL11.glRotatef(20.0f,0.0f,0.0f,1.0f);
				                        
				                        
				                        GL11.glRotatef(-LimbRotation/3,1.0f,0.0f,0.0f); 
				                        //	GL11.glRotatef(27.5f,0.0f,1.0f,0.0f);  
					                        cylinder.DrawCylinder(0.1f,0.7f,32);
		                        // right elbow
					                        GL11.glColor3f(blue[0], blue[1], blue[2]);
						                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
						                        GL11.glPushMatrix(); {
						                            GL11.glTranslatef(0.0f,0.0f,0.75f);
						                            texSphere.DrawTexSphere(0.2f, 32, 32,tex_joint); 
		                            //right forearm
						                            GL11.glColor3f(white[0], white[1], white[2]);
							                           GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(white));
							                            GL11.glPushMatrix(); {
							                                GL11.glTranslatef(0.0f,0.0f,0.0f);
							                                	GL11.glRotatef(15.0f,1.0f,0.0f,0.0f);
							                                //  GL11.glRotatef(90.0f,0.0f,1.0f,0.0f); 
							                                cylinder.DrawCylinder(0.1f,0.85f,32);
		                                // right hand
							                                GL11.glColor3f(blue[0], blue[1], blue[2]);
								                               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
								                                GL11.glPushMatrix(); {
								                                    GL11.glTranslatef(0.0f,0.0f,0.9f);
								                                    texSphere.DrawTexSphere(0.2f, 32, 32,tex_joint);                                 
								                                } GL11.glPopMatrix();
								                            } GL11.glPopMatrix();
								                        } GL11.glPopMatrix();
								                    } GL11.glPopMatrix ();
								                } GL11.glPopMatrix (); 
		                //chest
		            } GL11.glPopMatrix();
			
		            // pelvis
			} GL11.glPopMatrix();
		            // right hip
		       	 GL11.glColor3f(blue[0], blue[1], blue[2]);
		           GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
		            GL11.glPushMatrix(); {
		                GL11.glTranslatef(-0.35f,-0.15f,0.0f);
		                texSphere.DrawTexSphere(0.2f, 32, 32,tex_joint); 

		                // right high leg
		           	 GL11.glColor3f(white[0], white[1], white[2]);
		               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(white));
		                GL11.glPushMatrix(); {
		                    GL11.glTranslatef(0.0f,0.0f,0.0f);
		                    GL11.glRotatef(0.0f,0.0f,0.0f,0.0f);
		                    GL11.glRotatef(5.0f,0.0f,0.0f,1.0f);
		                    
		                    GL11.glRotatef((LimbRotation/9*3)+90,1.0f,0.0f,0.0f); 
		                    //	GL11.glRotatef(90.0f,1.0f,0.0f,0.0f); 
		                    cylinder.DrawCylinder(0.15f,1.0f,32);


		                    // right knee
		               	 GL11.glColor3f(blue[0], blue[1], blue[2]);
		                   GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
		                    GL11.glPushMatrix(); {
		                        GL11.glTranslatef(0.0f,0.0f,1.0f);
		                        GL11.glRotatef(0.0f,0.0f,0.0f,0.0f); 
		                        texSphere.DrawTexSphere(0.2f, 32, 32,tex_joint); 

		                        //right low leg
		                   	 GL11.glColor3f(white[0], white[1], white[2]);
		                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(white));
		                        GL11.glPushMatrix(); {
		                            GL11.glTranslatef(0.0f,0.0f,0.0f);
		                            	GL11.glRotatef(-10.0f,1.0f,0.0f,0.0f);
		                            	GL11.glRotatef((LimbRotation/9*2),1.0f,0.0f,0.0f); 
		                            cylinder.DrawCylinder(0.125f,1.75f,32);

		                            // right foot
		                       	 GL11.glColor3f(blue[0], blue[1], blue[2]);
		                           GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
		                            GL11.glPushMatrix(); {
		                                GL11.glTranslatef(0.0f,0.0f,1.7f);
		                                texSphere.DrawTexSphere(0.2f, 32, 32,tex_joint); 

		                            } GL11.glPopMatrix();
		                        } GL11.glPopMatrix();
		                    } GL11.glPopMatrix();
		                } GL11.glPopMatrix();
		            } GL11.glPopMatrix();

		            // pelvis


		            // left hip
		            GL11.glColor3f(blue[0], blue[1], blue[2]);
			           GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
			            GL11.glPushMatrix(); {
			                GL11.glTranslatef(0.35f,-0.15f,0.0f);
			               
			                texSphere.DrawTexSphere(0.2f, 32, 32,tex_joint); 

			                // left high leg
			           	 GL11.glColor3f(white[0], white[1], white[2]);
			               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(white));
			                GL11.glPushMatrix(); {
			                    GL11.glTranslatef(0.0f,0.0f,0.0f);
			                    GL11.glRotatef(0.0f,0.0f,0.0f,0.0f);
			                    GL11.glRotatef(-5.0f,0.0f,0.0f,1.0f);
			                    
			                    GL11.glRotatef((-LimbRotation/9*3)+90,1.0f,0.0f,0.0f); 
			                    //   GL11.glRotatef(90.0f,1.0f,0.0f,0.0f); 
			                    cylinder.DrawCylinder(0.15f,1.0f,32);


			                    // left knee
			               	 GL11.glColor3f(blue[0], blue[1], blue[2]);
			                   GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
			                    GL11.glPushMatrix(); {
			                        GL11.glTranslatef(0.0f,0.0f,1.0f);
			                        GL11.glRotatef(0.0f,0.0f,0.0f,0.0f); 
			                        texSphere.DrawTexSphere(0.2f, 32, 32,tex_joint); 

			                        //left low leg
			                   	 GL11.glColor3f(white[0], white[1], white[2]);
			                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(white));
			                        GL11.glPushMatrix(); {
			                            GL11.glTranslatef(0.0f,0.0f,0.0f);
			                            GL11.glRotatef(-10.0f,1.0f,0.0f,0.0f);
			                           //  GL11.glRotatef(0.0f,0.0f,0.0f,0.0f); 
			                            GL11.glRotatef(-(LimbRotation/9*2),1.0f,0.0f,0.0f); 
			                            cylinder.DrawCylinder(0.125f,1.75f,32);

			                            // left foot
			                       	 GL11.glColor3f(blue[0], blue[1], blue[2]);
			                           GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
			                            GL11.glPushMatrix(); {
			                                GL11.glTranslatef(0.0f,0.0f,1.7f);
			                                texSphere.DrawTexSphere(0.2f, 32, 32,tex_joint); 

			                            } GL11.glPopMatrix();
			                        } GL11.glPopMatrix();
			                    } GL11.glPopMatrix();
			                } GL11.glPopMatrix();
			            } GL11.glPopMatrix();
		 }


}
	 