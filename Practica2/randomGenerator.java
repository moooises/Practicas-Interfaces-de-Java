import java.util.*;
public class randomGenerator{
/**	
	public static double[]261a(int sem, int num){
		//int sem=2;
		//int num=12;
		double numeros[]= new double[num];
		numeros[0]=((5*sem)%Math.pow(2,5));
		System.out.println(numeros[0]);
		for(int i=1;i<num;++i){
		numeros[i]=((5*numeros[i-1])%Math.pow(2,5));
		System.out.println(numeros[i]);
		}
		return numeros;
		
	}
	
	public static double[]261b(int sem, int num){
		
		double numeros[]= new double[num];
		numeros[0]=((7*sem)%Math.pow(2,5));
		System.out.println(numeros[0]);
		for(int i=1;i<num;++i){
			numeros[i]=((7*nuemros[i-1])%Math.pow(2,5));
		System.out.println(numeros[i]);
		}
		return numeros;
		
	}
	
	public static double[]262a(int sem,int num){
		
		double numeros[]= new double[num];
		numeros[0]=((3*sem)%31);
		System.out.println(numeros[0]);
		for(int i=1;i<num;++i){
			numeros[i]=((3*nuemros[i-1])%31);
		System.out.println(numeros[i]);
		}
		return numeros;	
	}
	
	public static double[]263a(int sem,int num){
		
		double numeros[]= new double[num];
		numeros[0]=((Math.pow(7,5)*sem)%(Math.pow(2,31)-5));
		System.out.println(numeros[0]);
		for(int i=1;i<num;++i){
			numeros[i]=((Math.pow(7,5)*numeros[i-1])%(Math.pow(2,31)-5));
		System.out.println(numeros[i]);
		}
		return numeros;	
	}
	*/

	
	/**
	public static double[] combinedl_LEcuyer(int sem1,int sem2,int sem3,int num){
		
		double x[] = new double[num];
		double y[]= new double[num];
		double w[]= new double[num];
		x[0]=(157*sem1)%32363;
		y[0]=(146*sem2)%31727;
		w[0]=(142*sem3)%31657;
		v[0]=(w[0](x[0]+y[0]))%32362;
		for(int i=i;i<num;++i){
			x[i]=(157*x[i-1])%32363;
			y[i]=(146*y[i-1])%31727;
			w[i]=(142*w[i-1])%31657
			w[i]=(W[i]+(x[i]+y[i]))%32362;
		}
		return w;
	}
	*/
	
	public static double[]generador_lineal(double a, double b, double m, double seed, int x){
		
		double numeros[]=new double[x];
		numeros[0]=(a*seed+b)%m;
			//	System.out.println(numeros[0]);
		for(int i=1;i<x;++i){

		numeros[i]=(a*numeros[i-1]+b)%m;	
				//System.out.println(numeros[i]);
		}
		//System.out.println("END");
		return numeros;
				
	}
	
	
	public static double[]generador_combinado(double ax,double ay, double aw,double bx,double by, double bw,double ma,double my, double mw,double mv, double seedx,double seedy,double seedw, int num ){
		
		double x[] = new double[num];
		double y[]= new double[num];
		double w[]= new double[num];
		double v[]= new double[num];
		x=generador_lineal(ax,bx,ma,seedx,num);
		y=generador_lineal(ay,by,my,seedy,num);
		w=generador_lineal(aw,bw,mw,seedw,num);
		v[0]=(w[0]-x[0]+y[0])%mv;
		for(int i=1;i<num;++i){
			v[i]=(w[i]-x[i]+y[i])%mv;
		}
		return w;
	}
	/**
	public static void main(String [] args){
		int num=12;
		double[] x= new double[num];
		double[] y= new double[num];
		x=generador_lineal(5,0,32,1,num);
		for(int i=0;i<num;++i){
		System.out.println(x[i]);	
		}		
		System.out.println("\n");	
		y=generador_combinado(157,146,142,0,0,0,32363,31727,31657,32362,1,1,1,num);
		for(int j=0;j<num;++j){
		System.out.println(y[j]);	
		}
		
		
		}*/
	
}
	
	/**public static double[] FishmanMoore(int sem, int num){
		
	double x[] = new double[num];	
	x[0]=(48271*sem)%(Math.pow(2,31)-1);
	for(int i=1;i<num;++i){
		x[i]=(x[i-1]*48271)%(Math.pow(2,31)-1);
		}
	return x;
	}
	*/
	/**
	public static double[] randu(int sem, int num){
	
		double x[]= new double[num];
		x[0]=(((Math.pow(2,16)+3)*sem)%Math.pow(2,31));
		for(int i=1;i<num;++i){
			x[i]=(((Math.pow(2,16)+3)*x[i-1])%Math.pow(2,31));
			}	
		return x;
	}*/

	
	
/*
import java.util.*;
class randomGenerator{
	public static double[]261a(int sem, int num){
		double numeros[] = new double(num);
		numeros[0]=((5*sem)%Math.pow(2,5));
		
		for(int i=0;i<num;++i){
		numero[i]=((5*numeros[i-1])%Math.pow(2,5));
		}
		return numeros;
	}
	
}
*/