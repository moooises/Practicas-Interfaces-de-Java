import java.awt.*;
import java.lang.*;
import javax.swing.*;
import java.awt.Graphics2D;
import java.awt.geom.*;

public class Curva extends Canvas{
	public static int[] W;
	public static int X1,Y1,gen,I1=2,Z1;//En dibujo usamos generations
	public static int X2,Y2=0,I2=2,Z2;
	public static boolean ready=false;
	public static int origen;
	
	public Curva() {
		setBackground(Color.decode("#585858"));
		
		
	}
	
	public static void curva(int []c,int i){
		W= new int[i];
		W=c;
		ready=true;
		gen=i;
		//System.out.println("PENE2");	
		/**for(int i=0;i<Ngen;++i){
		System.out.print(" "+W[i]);	
		}
		System.out.println();	
*/
	}
	
	public void update(){
	//paint();	
	}
	
	public void paint(Graphics g){
		origen=this.getHeight();
		if(ready){
		//Y1=Z1;//(this.getHeight()-W)-100;
		//X1=0;
		//X2=0;
		//I1=10;
		//I2=10;
		//Z1=0;
		//Z2=0;
		//System.out.println("En la curva");

		for(int i=1;i<gen;++i){
		g.setColor(Color.BLUE);
		//I=I+40;
		//Y=this.getHeight();
		Z1=(this.getHeight()-W[i])-100;
		//System.out.println("X: "+X+" Y: "+Y+" I: "+I+" Z: "+Z);
		g.drawLine(X1,Y1,I1,Z1);
		Z2=W[i];
		g.setColor(Color.RED);
		g.drawLine(X2,Y2,I2,Z2);
		
		try{
			Thread.sleep(1);
		}catch(Exception ex){}

		X1=I1;
		X2=I2;
		I1=I1+2;
		I2=I2+2;
		Y1=Z1;
		Y2=Z2;

		}
		}
	}
	
	public static void reset(){
	
		X1=0;
		X2=0;
		Y1=origen;
		Y2=0;
		Z1=0;
		Z2=0;
		I1=10;
		I2=10;
	}
	
}

//this.getWidth(),y[i]%this.getHeight()