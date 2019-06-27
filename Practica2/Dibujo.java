import java.awt.*;
import java.lang.*;
import javax.swing.*;
import java.awt.Graphics2D;
import java.awt.geom.*;

public class Dibujo extends Canvas{
	public static int num;
	public static double []x;
	public static double []y;
	//public static boolean org=false;
	
	public Dibujo(){
		/**this.num=num;
		x=new double[num];
		y=new double[num];
		this.x=x;
		this.y=y;
		*/
		
		setBackground(Color.decode("#80FF52"));
	}
	
	public static void reset(int numi,double []a,double []b){
		num=numi;
		x=new double[num];
		y=new double[num];
		x=a;
		y=b;
		//org=true;
		/**
		for(int j=0;j<num;++j){
		System.out.println("x: "+x[j]+" y: "+y[j]);
		}
		*/
															}
		
	
	public void paint(Graphics g){
		g.setColor(Color.PINK);
		//g.fillRect(10,10,10,10);
		
		//if(org){
			
			for(int i=0;i<num;++i){
				Graphics2D aux = (Graphics2D) g;
                
                aux.draw(new Ellipse2D.Double(x[i]%this.getWidth(),y[i]%this.getHeight(),2,2));
								}
				//}
	}
	
}