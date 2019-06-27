import java.util.*;
public class randomGenerator{
	
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
		
	public static double[] combinedl_LEcuyer(int sem1,int sem2,int num){
		
		double x[] = new double[num];
		double y[]= new double[num];
		double w[]= new double[num];
		x[0]=(40014*sem1)%2147483563;
		y[0]=(40692*sem2)%2147483399;
		w[0]=(x[0]-y[0])%2147483562;
		for(int i=i;i<num;++i){
			x[0]=(40014*x[i-1])%2147483563;
			y[0]=(40692*y[i-1])%2147483399;
			w[0]=(x[i-1]-y[i-1])%2147483562;
		}
		return w;
	}
	
	public static double[] FishmanMoore(int sem, int num){
		
	double x[] = new double[num];	
	x[0]=(48271*sem)%(Math.pow(2,31)-1);
	for(int i=1;i<num;++i){
		x[i]=(x[i-1]*48271)%(Math.pow(2,31)-1);
		}
	return x;
	}
	
	public static double[] randu(int sem, int num){
	
		double x[]= new double[num];
		x[0]=(((Math.pow(2,16)+3)*sem)%Math.pow(2,31));
		for(int i=1;i<num;++i){
			x[i]=(((Math.pow(2,16)+3)*x[i-1])%Math.pow(2,31));
			}	
		return x;
	}
	
	
		
	public static void main(String args[]){

		
	
	
}
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