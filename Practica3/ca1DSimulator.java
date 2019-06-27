
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

public class ca1DSimulator implements ca1DSim{
	public static double [][]V ;//cambiar tamaño
	//public static double []W ;//cambiar tamaño
	public static double []aux;
	public static double []A;
	public static double []B;
	public static int []W;
	public static int[]codReg;//aqui se almacena las reglas en base 'estados'
	public static int estados,generations,vecinos;
	public static int regla;
	public static boolean frontier;
	public static char[] reglaC;
	public static String reglaS;
	//public static Dibujo grafico;
	//public static Curva poblacion;
	public static int gen;
	public static int t;

	public static randomGenerator r = new randomGenerator();
	
	public ca1DSimulator(int estados, int generations,int vecinos,int regla, boolean frontier,String Aleatorio,int tam){
		this.estados=estados;
		this.generations=generations;
		this.vecinos=vecinos;
		this.regla=regla;
		this.frontier=frontier;
		t=tam;//this.
		int T=9;
		//grafico=graf;
		//this.t=grafico.getWidth();
		//poblacion=curva;
		//int t=8;//(2*vecinos+1)*(estados-1);
		A = new double[t];
		B = new double[t];
		W = new int[generations];
		aux= new double[t];
		generador(Aleatorio,vecinos,estados);
		reglaC= new char[t];
		reglaS=Integer.toString(regla,estados);

		//reglaC=reglaS.toCharArray();
		//for(int i=0;i<reglaS.length();++i){
			//codReg[i]=Character.getNumericValue(reglaC[i]);
		//}
		int q=((2*vecinos+1)*(estados-1));
		// h=(int)(Math.pow(estados,q));
		codReg=new int[q+1];
		base(regla,estados,q+1);
							//System.out.println(reglaS.length());

					//System.out.println(codReg.length);
		System.out.print("t: "+t);			
		System.out.print("CodReg: ");
		for(int i=0;i<q+1;++i){
			System.out.print(" "+codReg[i]);
		}
		System.out.println();
		/**
		caComputacion(generations);
		//grafico.repaint();
		System.out.println("PENE1");	
		for(int i=0;i<gen;++i){
		System.out.print(" "+W[i]);	
		}
		System.out.println();	
		poblacion.curva(W,generations);
		poblacion.repaint();
		System.out.println("Deberia haber pintado");
		*/
	}
	
	public static double[] VectorActual(){
		//System.out.println("Devuelve A");
	return A;	
	}
	
	public static int[] VectorCurva(){
	return W;	
	}
	
	public static void base(int nregla,int nestados,int tamano){
	//	int n=(int)Math.pow(nestados,tamano);//--------------------------------------------
		System.out.println("Tamano: "+tamano);
	//	System.out.println("n: "+n);
		int []res= new int[tamano+1];//vector de la mitad de la regla, arreglar esto
		int g=0,divd=nregla,div=nestados,r;
		while(divd>=nestados && g!=tamano){
			if(divd/div<nestados){
						System.out.println("gif: "+g);
			res[g]=divd%div;
			
			++g;
			

			res[g]=divd/div;
			++g;
			divd=divd/div;
			System.out.println("gif: "+g);

									}
			else{
				res[g]=divd%div;
				divd=divd/div;
				++g;
				System.out.println("divd: "+divd);
				System.out.println("gelse: "+g);
				}
				

		}
		System.out.print("Res:");
		for(int i=0;i<g;++i){
			System.out.print(" "+res[i]);	
		}
		System.out.println();
		codReg=res;
		/**
		for(int i=0;i<g;++i){//Esto lo invierte
			codReg[i]=res[(g-1)-i];
		}*/
		
		//int []res= new int[n];
		/**if(nregla<128){
			res[0]=0;
		for(int i=-1;i<g;++i){
		
		res[i+1]=aux[g-(i+1)];	
		}
		}
		else{
		for(int i=0;i<g;++i){
		
		res[i]=aux[g-(i+1)];	
		}*/
		/**for(int i=0;i<g;++i){
			res[i]=aux[i];	
		}*/
				//return res;

		}


		//System.out.println("Tamalo:" +g);
		/**for(int i=0;i<g;++i){
			System.out.println(aux[i]);
		}*/
		
	
		
	
	

	public static void generador(String gen,int vecinos,int estados){
		//int t=8;//((2*vecinos+1)*(estados-1))+1;
		boolean normalizar= true;
		System.out.println("T:"+t);
	switch (gen){
		case "5Xn-1 mod 2^5": A=r.generador_lineal(5.0,0.0,32.0,1.0,t);break;
		case "7Xn-1 mod 2^5": A=r.generador_lineal(7.0,0.0,32.0,1.0,t);break;
		case "3Xn-1 mod 31": A=r.generador_lineal(3.0,0.0,31.0,1.0,t);break;
		case "7^5Xn-1 mod (2^31-1)": A=r.generador_lineal(16807.0,0.0,2147483647.0,1.0,t);break;
		case "(Wn-Xn+Yn) mod 32362": A=r.generador_combinado(146.0,142.0,157.0,0.0,0.0,0.0,31727.0,31657.0,32363.0,1.0,1.0,1.0,1.0,t);break;
		case "48271Xn-1 mod (2^31-1)": A=r.generador_lineal(48271.0,0.0,2147483647.0,1.0,t);break;
		case "(2^16+3)Xn-1 mod 2^31": A=r.generador_lineal(655539.0,0.0,2147483648.0,1.0,t);break;
		case "Nulo": A[(t/2)]=1.0; System.out.println("t/2: "+t/2);normalizar=false;break;
	}
	if(normalizar){
		for(int i=0;i<t;++i){
			A[i]=A[i]*(estados-1);
			A[i]=Math.round(A[i]);
			
		}
		
		
		/**for(int j=0;j<t;++j){
			V[0][j]=aux[j];
			if(V[0][j]!=0)++W[0];
		}*/
	}
	
	System.out.print("[ ");
			for(int j=0;j<t;++j){
					System.out.print(A[j]+" ");
			}
						System.out.print("] ");
						System.out.println();
						
		/**for(int k=0;k<t;++k){
			System.out.println("Generador: "+V[0][k]);			
		}*/
	}
	
	/**
	@override
	*/
	public void caComputacion(int nGen){
		gen=nGen;
		//System.out.println("Entro en computacion");
		/**System.out.print("[ ");
			for(int j=0;j<t;++j){
					System.out.print(A[j]+" ");
			}
						System.out.print("] ");
						System.out.println();*/
						//Asi nos aseguramos
			//grafico.actualizar(A,t);
		//	grafico.repaint();
			nextGen();
		

			//grafico.actualizar(V,8,true,gen);

			//Pintamos en dibujo

			//Pintamos en curva
			for(int i=0;i<t;++i){
			A[i]=B[i];
			}
			//++gen;
			//DibujonGen;
			

			
			/**System.out.print("[ ");
			for(int j=0;j<t;++j){
					System.out.print(A[j]+" ");
			}
						System.out.print("] ");
						System.out.println();*/
			//B=0;
		
		
	/**	for(int i=0;i<nGen;++i){
				System.out.print("[");
			for(int j=0;j<t;++j){
					System.out.print(V[i][j]+" ");
			}
					System.out.print("]");
					System.out.println();
		}*/
		
			//grafico.actualizar(V,t,nGen);
			//System.out.println("Actualizo");
			
	}

	/**
	@override 
	*/
	//Hacer esto generations veces
	public void nextGen(){//hacer esto concurrente***************************************************************************************************
	/**	System.out.println("Entro en Gen. "+gen);
		System.out.print("V: ");
		for(int i=0;i<8;++i){
			System.out.print(" "+V[gen-1][i]);
		}*/
		//System.out.println();
		int derch=0,izq=0;
		int j=0;
		double sum=0;
		int sumi=0;
		//double vderch,vizq;
		for(int i=0;i<t;++i){//8 es el tamaño del vector, que seguramente podremos cambiar
			j=0;
			sum=0;
			sum=A[i];
			derch=i;
			izq=i;
			sumi=0;
			//vderch=0;
			//vizq=0;
			//System.out.println("Frontera: "frontier);
			if(frontier){
				//if(i-vecinos<0)derch=V.length()-vecinos;
				//if(i+vecinos>=V.length())izq=vecinos-1;			
				while(j!=vecinos){
					derch=derch+1;
					izq=izq-1;
					
					if(izq<0)izq=t-1;
					if(derch>=t)derch=0;
					sum=sum+A[izq]+A[derch];
					++j;
					
				}
				sumi=(int)sum;
				try{
					if(codReg[(int)sum]!=0)W[gen]=W[gen]+1;
				}catch(Exception ex){
					W[gen]=W[gen]+1;
					}
					
				try{
					B[i]=codReg[(int)sum];
				}catch(Exception ex){
					B[i]=0.0;	
				}
			}else{
					
					//System.out.println("i: "+i+" Sumai: "+sum);
					while(j!=vecinos){
						//vderch=0;vizq=0;
					//	System.out.println("[");
						derch=derch+1;
						izq=izq-1;
						//System.out.println("i="+i+" ");
					//System.out.println("derch="+derch+" ");
					//if(derch<t)System.out.println("Valor derch="+A[derch]+" ");
					//System.out.println("Valor izq="+izq+" ");
					//if(izq>=0)System.out.println("Valor izq= "+A[izq]+" ");

						if(izq>=0 || derch<t){
							if(izq<0 && derch<t){
								sum=sum+A[derch];
														}
							else{
								if(izq>=0 && derch>=t){
								sum=sum+A[izq];	
								}
								else{
								sum=sum+A[izq]+A[derch];	
								}
							}
						}
						else{
						sum=sum;	
						}
											//System.out.println("sum="+sum+" ");
											//System.out.println();
	
						//System.out.println("izq: "+izq);
						//System.out.println("derch: "+derch);
						//if(derch<t)System.out.println("Vderch: "+V[gen-1][derch]);
						//if(izq>=0)System.out.println("Vizq: "+V[gen-1][izq]);
						//System.out.println("vizq: "+vizq);
						//System.out.println("vderch: "+vderch);
						//System.out.println("Sum: "+sum);

						++j;
					}
					//System.out.println("sum: "+sum);
					//System.out.println();
					//sumi=(int)sum;
					try{
						if(codReg[(int)sum]!=0)W[gen]=W[gen]+1;
					}catch(Exception ex){
						W[gen]=W[gen]+1;
					}
						//System.out.print("B["+i+"]="+sumi+" ");
				//	System.out.println("i: "+i+" Sumi: "+sumi);
				try{
					B[i]=codReg[(int)sum];
				}catch(Exception ex){
				B[i]=0.0;	
				}
					//System.out.println("V[gen][i]: "+V[gen][i]);
					
					
				}
			}
			//System.out.print("END: ");
				/**for(int k=0;k<8;++k){
					System.out.print(" "+V[gen][k]);
					}*/
					//	System.out.println();
					
	
	}
	

	
	}
	