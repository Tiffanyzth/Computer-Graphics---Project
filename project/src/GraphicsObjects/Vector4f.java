package GraphicsObjects;



public class Vector4f {

	public float x=0;
	public float y=0;
	public float z=0;
	public float a=0;
	
	public Vector4f() 
	{  
		x = 0.0f;
		y = 0.0f;
		z = 0.0f;
		a = 0.0f;
	}
	 
	public Vector4f(float x, float y, float z,float a) 
	{ 
		this.x = x;
		this.y = y;
		this.z = z;
		this.a = a;
	}
	
	 //implement Vector plus a Vector 
	public Vector4f PlusVector(Vector4f Additonal) 
	{ 
		Vector4f v = new Vector4f();
		v.x = this.x + Additonal.x;
		v.y = this.y + Additonal.y;
		v.z = this.z + Additonal.z;
		return v;
		//When vector plus the other vector, return a vector whose (x,y,z) equal to the origin vector's (x,y,z) plus 
		//the other vector's (x,y,z) separately. (If make the start of the other vector and the end of the origin vector coincide, 
		//the direction is from the start of the origin vector to the end of the other vector.)
		//X = Xv1 + Xv2; Y = Yv1 + Yv2; Z = Zv1 + Zv2;
	} 
	
	 //implement Vector minus a Vector 
	public Vector4f MinusVector(Vector4f Minus) 
	{ 
		Vector4f v = new Vector4f();
		v.x = this.x - Minus.x;
		v.y = this.y - Minus.y;
		v.z = this.z - Minus.z;
		return v;
		//When vector minus the other vector, return a vector whose (x,y,z) equal to the origin vector's (x,y,z) minus 
		//the other vector's (x,y,z) separately. (If make the start of the other vector and the start of the origin vector coincide, 
		//the direction is from the end of the other vector to the end of the origin vector.)
		//X = Xv1 - Xv2; Y = Yv1 - Yv2; Z = Zv1 - Zv2;
	}
	
	//implement Vector plus a Point 
	public Point4f PlusPoint(Point4f Additonal) 
	{ 
		 Point4f p = new Point4f();
		 p.x = this.x + Additonal.x;
		 p.y = this.y + Additonal.y;
		 p.z = this.z + Additonal.z;
		 return p;
		 //When vector plus a point, return a point whose (x,y,z) equal to the origin vector's (x,y,z) plus 
		 //the point's (x,y,z) separately.
		 //X = Xpoint + Xvector; Y = Ypoint + Yvector; Z = Zpoint + Zvector;
	} 
	//Do not implement Vector minus a Point as it is undefined 
	
	//Implement a Vector * Scalar 
	public Vector4f byScalar(float scale )
	{
		 Vector4f v = new Vector4f();
		 v.x = this.x * scale;
		 v.y = this.y * scale;
		 v.z = this.z * scale;
		 return v;
		 //When vector multiply a scale, return a vector whose (x,y,z) equal to the origin vector's (x,y,z) multiply 
		 //the scale separately. 
		 //X = Xv * scale; Y = Yv * scale; Z = Zv * scale;
	}
	
	//implement returning the negative of a  Vector  
	public Vector4f  NegateVector()
	{
		Vector4f v = new Vector4f();
		v.x = -this.x;
		v.y = -this.y;
		v.z = -this.z;
		return v;
		//The negative vector is whose (x,y,z) separately equal to the opposite number of the origin vector's (x,y,z)
		//X = -Xv; Y = -Yv; Z = -Zv;
	}
	
	//implement getting the length of a Vector  
	public float length()
	{
		float l = 0;
		l = this.x * this.x + this.y * this.y + this.z * this.z;
		l = (float) Math.sqrt(l);
		return l;
		//The length of a vector equal to the square root of (x^2 + y^2 + z^2)
	}
	
	//implement getting the Normal  of a Vector  
	public Vector4f Normal()
	{
		 Vector4f v = new Vector4f();
		 v.x = this.y;
		 v.y = -this.x;
		 v.z = 0;
		 return v;
		 //The dot product of normal vector's (x,y,z) and the origin vector's (x,y,z) = 0
		 //In 2D graphics, we set z=0 firstly.
		 //The origin vector is (x,y,0) and the normal vector is (y,-x,0).
		 //Then the dot product is xy + (-xy) + 0 = 0. So it satisfies our needs.
	} 
	
	//implement getting the dot product of Vector.Vector  

	public float dot(Vector4f v)
	{ 
		return ( this.x*v.x + this.y*v.y + this.z*v.z+ this.a*v.a);
	}
	
	// Implemented this for you to avoid confusion 
	// as we will not normally  be using 4 float vector  
	public Vector4f cross(Vector4f v)  
	{ 
    float u0 = (this.y*v.z - z*v.y);
    float u1 = (z*v.x - x*v.z);
    float u2 = (x*v.y - y*v.x);
    float u3 = 0; //ignoring this for now  
    return new Vector4f(u0,u1,u2,u3);
	}
 
}
	 
	   

/*

										MMMM                                        
										MMMMMM                                      
 										MM MMMM                                    
 										MMI  MMMM                                  
 										MMM    MMMM                                
 										MMM      MMMM                              
  										MM        MMMMM                           
  										MMM         MMMMM                         
  										MMM           OMMMM                       
   										MM             .MMMM                     
MMMMMMMMMMMMMMM                        MMM              .MMMM                   
MM   IMMMMMMMMMMMMMMMMMMMMMMMM         MMM                 MMMM                 
MM                  ~MMMMMMMMMMMMMMMMMMMMM                   MMMM               
MM                                  OMMMMM                     MMMMM            
MM                                                               MMMMM          
MM                                                                 MMMMM        
MM                                                                   ~MMMM      
MM                                                                     =MMMM    
MM                                                                        MMMM  
MM                                4 D                                      MMMMMM 
MM                                                                     MMMMMMMM 
MM                                                                  :MMMMMMMM   
MM                                                                MMMMMMMMM     
MM                                                              MMMMMMMMM       
MM                             ,MMMMMMMMMM                    MMMMMMMMM         
MM              IMMMMMMMMMMMMMMMMMMMMMMMMM                  MMMMMMMM            
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM               ZMMMMMMMM              
MMMMMMMMMMMMMMMMMMMMMMMMMMMMM          MM$             MMMMMMMMM                
MMMMMMMMMMMMMM                       MMM            MMMMMMMMM                  
  									MMM          MMMMMMMM                     
  									MM~       IMMMMMMMM                       
  									MM      DMMMMMMMM                         
 								MMM    MMMMMMMMM                           
 								MMD  MMMMMMMM                              
								MMM MMMMMMMM                                
								MMMMMMMMMM                                  
								MMMMMMMM                                    
  								MMMM                                      
  								MM                                        
                             GlassGiant.com */