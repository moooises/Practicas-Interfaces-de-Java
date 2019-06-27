import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

public class Hamming extends Canvas{
	public static GridBagConstraints h = new GridBagConstraints();
	public static JFrame Hamin = new JFrame("Curva de Hamming");
	public static JLabel HammingMedio;
	public static JTextField Media;
	public static Canvas Ham;
	public static Graphics2D Ham2D;
	public static int X,Y,I,Z;
	public static double W;
	public static int []H;
	public static boolean ready=false;
	
	public Hamming(){
	
		setBackground(Color.decode("#F5FFFA"));


	}
	
	public static void act(int []V){
		H= new int[V.length];
		H=V;
		ready=true;
	}

	
	public void paint(Graphics g){
		
	if(ready){
		for(int i=0;i<H.length;++i){
			//System.out.println("H= "+H[);
			if(i!=0){
			Y=Z;
			}

			Z=this.getHeight()-H[i];
			g.setColor(Color.BLACK);
			g.drawLine(X,Y,I,Z);
			try{
				Thread.sleep(5);
			}catch(Exception ex){}
			//System.out.println("X: "+X+" Y: "+Y+" I: "+I+" Z: "+Z);
			X=I;
			I=I+10;
			
			
		}
		I=0;
		Z=0;
		Y=0;
		X=0;
		}
	}
	
	public static double media(){
	int w=0;
	int d=H.length;
		for(int i=0;i<d;++i){
			w=H[i]+w;
		}

		
			//System.out.println("w: "+w);
	W=(double)w;
		W=W/(double)d;
		return W;
				//	System.out.println("W: "+W);
	}
	
	}


/**
public static double []A;
	public static double []B;
	
	public Hamming(int tam){
	A= new double[tam];
	B= new double[tam];
	}
	
	public static void act(double []V,double []W){
	
		for(int i=0;i<A.kength;++i){
			A[i]=V[i];
		}
		
		for(int i=0;i<B.length;++i){
		B[i]=W[i];
		}
		
	}
	
	public static  int distancia(){//Devuelve el punto que pintas en el eje Y
		int cont=0;
		for(int i=0;i<A.length;++i){
			if(A[i]!=B[i])++cont;
		}
		return cont;
	}

*/