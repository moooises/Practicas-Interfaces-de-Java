import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

public class Hamming{
	public static GridBagConstraints h = new GridBagConstraints();
	public static JFrame Hamin = new JFrame("Curva de Hamming");
	public static JLabel HammingMedio;
	public static JTextField Media;//Reservado para el lugar donde mostrar el valor medio--//public static 
	public static Canvas Ham;
	public static Graphics2D Ham2D;
	public static int X,Y,I,Z;
	public static double W;
	public static int []H;
	
	
	public Hamming(int[] V){
		H= new int[V.length];
		H=V;
		//Hamin.setResizable(true);
		Hamin.setLocationRelativeTo(null);
		Hamin.setVisible(true);
		//Hamin.setDefaultCloseOperation(Hamin.EXIT_ON_CLOSE);
		Hamin.setLayout(new GridBagLayout());
		CrearFrame();
	//	Hamin.pack();
	Hamin.setMinimumSize(new Dimension(800, 600)); 
		Ham2D=(Graphics2D)Ham.getGraphics();
		Pintar();
		media();
		Media.setText(Double.toString(W));
	}
	
	public static void CrearFrame(){
	
		//Hamin.getContentPane().setLayout(new GridBagLayout())

		h.gridx=0;
		h.gridy=0;
		h.gridwidth=2;
		h.gridheight=2;
		h.fill=GridBagConstraints.BOTH;
		Ham= new Canvas();
		h.weightx=1.0;
		h.weighty=1.0;
		Ham.setBackground(Color.decode("#F5FFFA"));
		Hamin.add(Ham,h);
		h.weightx=0.0;
		h.weighty=0.0;
		//-----------
		h.gridx=0;
		h.gridy=4;
		h.gridwidth=1;
		h.gridheight=1;
		h.fill=GridBagConstraints.BOTH;
		HammingMedio= new JLabel("Distancia Media: ");
		Hamin.add(HammingMedio,h);
		h.weightx=0;
		h.weighty=0;
		//-------------
		h.gridx=1;
		h.gridy=4;
		//h.gridwidth=1;
	//	h.gridheight=1;
		//h.fill=GridBagConstraints.BOTH;
		Media= new JTextField();//String valor=""; Media.setText(valor); 
		Hamin.add(Media,h);
		h.weightx=0;
		h.weighty=0;
		
	}
	
	public static void Pintar(){
		

		
		for(int i=0;i<H.length;++i){
			//System.out.println("H= "+H[);
			if(i!=0){
			Y=H[i-1];
			}
			Z=H[i];
					Ham2D.setColor(Color.BLACK);
			Ham2D.drawLine(X,Y,I,Z);
			try{
				Thread.sleep(5);
			}catch(Exception ex){}
			X=I;
			I=I+100;
			
		//	System.out.println("X: "+X+" Y: "+Y+" I: "+I+" Z: "+Z);
		}
		I=0;
		Z=0;
		Y=0;
		X=0;

	}
	
	public static void media(){
	int w=0;
	int d=H.length;
		for(int i=0;i<d;++i){
			w=H[i]+w;
		}

		
			//System.out.println("w: "+w);
	W=(double)w;
		W=W/(double)d;
				//	System.out.println("W: "+W);
	}
	
	public void paint(Graphics g){}
	public void update(){}
	
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