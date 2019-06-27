import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.lang.Math;
import java.util.*;


public class Entriopia extends Canvas{

		//public static String[] colores={"#000000","#000080","#008000","#008080","#00FF00","#00FFFF","#800000","#800080","#808000","#808080","#C0C0C0","#FF0000","#FF00FF","#FFFF00","#FA58D0","#FFFFFF"};
		public static double [][]EN;
		public static double X,Y,I,Z;              
		public static int gen,est;
		public static double total=0;
		public static double Total;
		public static boolean read=false,ready=false;
		
		
		public Entriopia(){

			setBackground(Color.decode("#F5FFFA"));
			
			//Pintar();
			//media();?????
			//Media.setText(Double.toString(W));
		}
		
		public static void act(double [][]M,int esta, int gene){
			read=true;
			gen=gene;
			est=esta;
			EN= new double[gen][est];
			EN=M;
			//Total=0;
			//total=0;
			//System.out.println("Entro");
		}
		
		
		
		public void paint(Graphics g){
			double help=0;
			if(read){
				Y=this.getHeight();
			//	System.out.println("Entro  sdfsdsd");
			double aux=0;
			Graphics2D En2D=(Graphics2D)g;
			
			for(int j=0;j<gen;++j){
				if(j!=0){
					Y=Z;
				}
				X=I;
			

				I=I+10;
				//Y=-1*aux;
				aux=0;
				for(int i=0;i<est;++i){

					//int c=i%16;
					help=(EN[j][i]*(Math.log(EN[j][i])/Math.log(2)));
					if(Double.isNaN(help))help=0;
					aux+=help;

										}
					Z=(-1*aux);
					total=total+Z;
					Z=(Z/this.getHeight())*1000000;
				//	System.out.println("Z: "+Z+" aux: "+aux);


					En2D.setColor(Color.BLACK);
					En2D.draw(new Line2D.Double(X, Y, I, Z));
					//total+=Z;
					
					try{
						Thread.sleep(1);
					}catch(Exception ex){}
		



				}
			
			
			
					
		Z=Z/(double)gen;			
		//Media.setText(Double.toString(Z));
		I=0;
		Z=0;
		Total=total;
	//	System.out.println("TOTAL: "+Total);
		total=0;
		ready=true;
			}
		}
		
		
		public static double media(double[] T){
			double t=0;
			for(int i=0;i<gen;++i){
				t+=T[i];
			}
		//	System.out.println("t: "+t);		

			return (t/(double)gen-1);
		}
		
		public static double ETemporal(double []T,int t){
			double et=0;
			for(int i=0;i<t;++i){
				et=+T[i];
			}
			return et/(double)t;
		}

		
		
		
		
}