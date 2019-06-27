import java.awt.*;
import java.lang.*;
import javax.swing.*;
import java.awt.Graphics2D;
import java.awt.geom.*;

public class Dibujo extends Canvas{
	public static int tamV;
	public static double []V;
	public static int []W;
	//public static double [][]V;
	public static Curva c;
	public static int X,Y,I;//Valores para el patron
	public static int XC,YC,IC,ZC;//Valores para la curva
	public static ca1DSimulator ca;
	public static int generations;
	//public static double []y;
	public static  boolean curva=true;//cambiar static y pasar aqui curva
	public static boolean ready=false;
	public Dibujo(){//Recibimos el tamaño del vector
		
		/**this.num=num;
		x=new double[num];
		y=new double[num];
		this.x=x;
		this.y=y;
		*/
		
		X=0;
		Y=0;
		
		
		//Necesitamos metodos observadores para obtener el vector;
			
		setBackground(Color.decode("#F5FFFA"));
	}
	
	public static void act(int estados, int gen,int vecinos,int regla, boolean frontier,String Aleatorio,int tam,Curva curva){
	generations=gen;
	tamV=tam;
	c=curva;
	V=new double[tamV];
		W=new int[generations];
		ca= new ca1DSimulator(estados,generations,vecinos,regla,frontier,Aleatorio,tam);
		ready=true;
		c.reset();

	}
	public static void reset(){
	for(int i=0;i<tamV;++i){
	V[i]=0;
	}
	ready=false;
	generations=0;
	tamV=0;
	
	}

	public void Curva(){
	curva=true;	
	}
	
	
	public void paint(Graphics g){
		//super.paint(g);
		//System.out.println("Ready?: "+ready);
		int colores=1118481;	
		String col="#";
		String aux;
		if(ready){
			//System.out.println("Primer");
					V=ca.VectorActual();

				//System.out.println("Second");

		for(int r=1;r<generations;++r){
						
			//System.out.println("Second");

			for(int i=0;i<tamV;++i){

				/**System.out.println("Dentro del canvas "+r+" "+i);
				System.out.print("[ ");
				for(int j=0;j<tamV;++j){
					System.out.print(V[j]+" ");
			}
					System.out.print(" ]K");
					System.out.println();*/



				X=X+2;
				if(V[i]==0.0)colores=0;//El 0 siempre es negro cause i'm racist
				else colores=colores+(int)V[i]*100000;//-----------------
				aux=Integer.toString(colores,16);//Pasamos nuestro numero a hex
				col+=aux;
			//	System.out.println(col);
				g.setColor(Color.decode(col));
				g.fillRect(X,Y,3,3);
				colores=1118481;//reseteado a una especie de verde moco
				col="#";


			}
			try{
			Thread.sleep(5);
			}catch(Exception ex){}
			
			


			//c.repaint();
			ca.caComputacion(r);//Cuando r==generations sobra
			//System.out.println("Pido Vector");
			V=ca.VectorActual();//Hacer esto valor a valor con un vector aux//Idem
			Y=Y+3;
			X=0;
			}
		c.reset();

	c.curva(ca.VectorCurva(),generations);
			//c.repaint();
	Y=0;
	//c.curva(ca.VectorCurva(),generations);
	c.repaint();
	c.reset();
	//c.repaint();
	
	
		}
		
		

	}
		
	
}