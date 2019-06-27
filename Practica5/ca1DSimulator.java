
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

public class ca1DSimulator implements ca1DSim{
	public static int [][]C ;//cambiar tamaño
	public static double [][]E;
	//public static double []W ;//cambiar tamaño
	public static int []H;
	public static double []aux;
	public static double []A;
	public static double []B;
	public static double []S;
	public static int []W;
	public static int []YCurva;
	public static int []XCurva;
	public static int[]codReg;//aqui se almacena las reglas en base 'estados'
	public static int estados,generations,vecinos;
	public static int regla;
	public static boolean frontier;
	public static char[] reglaC;
	public static String reglaS;
	public static int X,Y,I;//Valores para el patron
	public static int X1,Y1,ngen,I1=2,Z1;//Valores para la curva
	public static int X2,Y2=0,I2=2,Z2;//Idem
	public static Canvas dibujoC;
	public static Canvas curvaC;
	public static Graphics2D dibujo2D;
	public static Graphics2D curva2D;
	public static String[] colores={"#000000","#000080","#008000","#008080","#00FF00","#00FFFF","#800000","#800080","#808000","#808080","#C0C0C0","#FF0000","#FF00FF","#FFFF00","#FA58D0","#FFFFFF"};
	//public static Dibujo grafico;
	//public static Curva poblacion;
	public static int gen;
	public static int t;

	public static randomGenerator r = new randomGenerator();
	
	public ca1DSimulator(int estados, int generations,int vecinos,int regla, boolean frontier,String Aleatorio,int tam,Canvas dibujo,Canvas curva){
		dibujoC=dibujo;
		Y1=dibujo.getHeight();
		curvaC=curva;
		dibujo2D=(Graphics2D)dibujoC.getGraphics();
		dibujo2D.setBackground(Color.decode("#F5FFFA"));
		curva2D=(Graphics2D)curvaC.getGraphics();
		curva2D.setBackground(Color.decode("#585858"));
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
		C= new int[generations][estados];
		E= new double[generations][estados];
		H= new int[generations-1];
		S= new double[generations];
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
		codReg=new int[(int)Math.pow(estados,q)];
		base(regla,estados,(int)Math.pow(estados,q));
		
		
		
		
		
							//System.out.println(reglaS.length());

					//System.out.println(codReg.length);
	//	System.out.print("t: "+t);			
		System.out.print("q: "+q+" CodReg: ");
		for(int i=0;i<(int)Math.pow(estados,q);++i){
			System.out.print(" "+codReg[i]);
		}
		System.out.println();
		
		caComputacion(generations);//-----------------------
		

	}
	
	public static int[] VectorHamming(){
		//System.out.println("Devuelve A");
	return H;	
	}
	
	public static double[][] MatrizEntriopia(){
	return E;	
	}
	
	public static double []Total(){
	return S;	
	}
	
	public static void base(int nregla,int nestados,int tamano){
	//	int n=(int)Math.pow(nestados,tamano);//--------------------------------------------
	//	System.out.println("Tamano: "+tamano);
	//	System.out.println("n: "+n);
		int []aux= new int[tamano];
		int g=tamano-1,divd=nregla,div=nestados,r;
		while(divd>=nestados && g>=0){
			if(divd/div<nestados){
						//System.out.println("gif: "+g);
			aux[g]=divd%div;
			
			--g;
			

			aux[g]=divd/div;
			--g;
			divd=divd/div;
		//	System.out.println("gif: "+g);

									}
			else{
				aux[g]=divd%div;
				divd=divd/div;
				--g;
			//	System.out.println("divd: "+divd);
			//	System.out.println("gelse: "+g);
				}
				

		}
		
		for(int j=0;j<aux.length;++j)System.out.print(aux[j]);
		//codReg=aux;
		int i=aux.length-1;
		int j=0;
		while(i>=0){
		codReg[j]=aux[i];
		--i;
		j++;
		}
		
		/**System.out.print("Res:");
		for(int i=0;i<g;++i){
			System.out.print(" "+res[i]);	
		}
		System.out.println();*/


		}


		//System.out.println("Tamalo:" +g);
		/**for(int i=0;i<g;++i){
			System.out.println(aux[i]);
		}*/
		
	
		
	
	

	public static void generador(String gen,int vecinos,int estados){
		//int t=8;//((2*vecinos+1)*(estados-1))+1;
		boolean normalizar= true;
		//System.out.println("T:"+t);
	switch (gen){
		case "5Xn-1 mod 2^5": A=r.generador_lineal(5.0,0.0,32.0,1.0,t);break;
		case "7Xn-1 mod 2^5": A=r.generador_lineal(7.0,0.0,32.0,1.0,t);break;
		case "3Xn-1 mod 31": A=r.generador_lineal(3.0,0.0,31.0,1.0,t);break;
		case "7^5Xn-1 mod (2^31-1)": A=r.generador_lineal(16807.0,0.0,2147483647.0,1.0,t);break;
		case "(Wn-Xn+Yn) mod 32362": A=r.generador_combinado(146.0,142.0,157.0,0.0,0.0,0.0,31727.0,31657.0,32363.0,1.0,1.0,1.0,1.0,t);break;
		case "Fishman and Moore": A=r.generador_lineal(48271.0,0.0,2147483647.0,1.0,t);break;
		case "RANDU": A=r.generador_lineal(655539.0,0.0,2147483648.0,1.0,t);break;
		case "Nulo": A[(t/2)]=1.0; System.out.println("t/2: "+A[t/2]);normalizar=false;break;
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
	
	/**System.out.print("[ ");
			for(int j=0;j<t;++j){
					System.out.print(A[j]+" ");
			}
						System.out.print("] ");
						System.out.println();*/
						
		/**for(int k=0;k<t;++k){
			System.out.println("Generador: "+V[0][k]);			
		}*/
	}
	
	/**
	*@override 
	*/
	public void caComputacion(int nGen){
		int h=0;
		gen=nGen;
		ngen=0;
					//for(int f=0;f<t;++f)System.out.print("|"+A[f]);

			pintarDibujo();
			
						curvaC.update(curvaC.getGraphics());
			for(int j=0;j<gen;++j){
				
			nextGen();
			pintarDibujo();
			pintarCurva(j);
			if(h!=0 && h<gen-1){
		//		System.out.println("h: "+h);
			for(int i=0;i<t;++i){
				if(A[i]!=B[i]){
					H[h]=H[h]+1;
				}
	
			}
		//	System.out.println("H[h]: "+H[h]);
			}
			//System.out.println();
			for(int i=0;i<t;++i){
			
				for(int r=0;r<estados;++r){
				if(A[i]==(double)r){
					E[ngen][r]=E[ngen][r]+1.0;

					r=estados;
					}
					
				}
				
				for(int b=0;b<estados;++b){
															//System.out.println("ET: "+E[ngen][b]+" t: "+t);
					E[ngen][b]=E[ngen][b]/(double)t;
					S[ngen]+=E[ngen][b];
				}
				
			A[i]=B[i];
			}
			
		/**	for(int u=0;u<estados;++u){
				System.out.println("E1["+ngen+"]["+u+"]: "+E[ngen][u]);
				}*/
			++ngen;
			++h;
			I1=I1+2;
			}
			
		/**	for(int l=0;l<gen;++l){
				for(int k=0;k<estados;++k){
				System.out.print(" "+E[l][k]);	
				}
				System.out.println();
			}*/

			//System.out.println("Sale");
			pintarDibujo();
Y=0;
I1=0;
//-------------------------Preguntar a Jesus como limpiar el canvas de la curva		
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
		double res=0;
		double []genes= new double[2*vecinos+1];
		int derch=0,izq=0;
		int j=0;
		double sum=0;
		int sumi=0;
		int pm;
		int pmedio=((int)Math.ceil((2*vecinos+1)/2));
		//System.out.println("pmedio: "+pmedio);
			//System.out.println();

		//double vderch,vizq;
		for(int i=0;i<t;++i){//8 es el tamaño del vector, que seguramente podremos cambiar
			int k=(2*vecinos);
			pmedio=((int)Math.ceil((2*vecinos+1)/2));
			res=0;
			j=0;
			pm=pmedio;
			sum=0;
			genes[pmedio]=A[i];
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

					
					if(izq<0)izq=codReg.length-1;
					if(derch>=t)derch=0;
					genes[(pm+1)]=A[derch];
					genes[(pm-1)]=A[izq];
					++j;
					
				}
				
					
					while(k>=0){
						//System.out.print(" "+genes[k]);
						res=res+genes[k]*Math.pow(estados,(2*vecinos)-k);
						k--;
					}
					B[i]=codReg[(int)res];
				
				try{
						++C[ngen][(int)B[i]];
					}catch(Exception ex){
						
					}
					
			}else{
					
					while(j!=vecinos){
					
						derch=derch+1;
						izq=izq-1;
						
					
						
						if(izq>=0 || derch<t){
							if(izq<0 && derch<t){
								genes[(pm+1)]=A[derch];
														}
							else{
								if(izq>=0 && derch>=t){
								genes[(pm-1)]=A[izq];	
								}
								else{
								genes[(pm-1)]=A[izq];
								genes[(pm+1)]=A[derch];	
								}
							}
						}
					
						++j;
					}
					//System.out.println(" genes: ");
	
					
					while(k>=0){
						//System.out.print(" "+genes[k]);
						res=res+genes[k]*Math.pow(estados,k);
						k--;
					}

				//System.out.print(" r: "+(int)res+" i: "+i);
					try{
					B[i]=codReg[(int)res];
					//System.out.print(" genes[res]: "+codReg[(int)res]);
					}catch(Exception ex){
						B[i]=0.0;	
					}
			/**	try{
					B[i]=codReg[(int)sum];
					
				}catch(Exception ex){
				B[i]=0.0;	
				}*/
				
				try{
						++C[ngen][(int)A[i]];
					}catch(Exception ex){
						
					}
					
					
					
				}
			}
					//System.out.print("B:");
					//for(int i=0;i<t;++i)System.out.print("|"+B[i]);	
					
	}
	
	public static void pintarDibujo(){
		//X=0;
		
		String aux;
		for(int i=t-1;i>=0;--i){
			
				int c=(int)A[i]%16;
				try{
				aux=colores[c];
				}catch(Exception ex){
					aux=colores[0];
				}
				dibujo2D.setColor(Color.decode(aux));
				dibujo2D.fillRect(X,Y,3,3);
				//System.out.println("X: "+X+" Y: "+Y);
				X=X+3;
				
			}
			try{
			Thread.sleep(1);
			}catch(Exception ex){}
			
			Y=Y+3;
			X=0;
		
	}
	
	public static void pintarCurva(int j){
		//origen=curva2D.getHeight();

		X1=I1;
		//X2=I2;
		//I1=I1+2;
		//I2=I2+2;
		//Y1=Z1;
		//Y2=Z2;
		if(j!=0){I1=I1+10;
		for(int i=0;i<estados;++i){
			if(j!=0){
			Y1=C[j-1][i];
			}
		int c=i%16;
		//Z1=(curvaC.getHeight()-C[j][i]);
		Z1=C[j][i];
		//Z2=(this.getHeight()-C[ngen+1][i])-100;
		//System.out.println("X: "+X+" Y: "+Y+" I: "+I+" Z: "+Z);
		curva2D.setColor(Color.decode(colores[c]));
		curva2D.drawLine(X1,Y1,I1,Z1);
		//curva2D.drawLine(X2,Y2,I2,Z2);
		
		try{
			Thread.sleep(1);
		}catch(Exception ex){}


	}
		}
	}
}

	
	/**switch ((int)A[i]%16){
					case 0:aux=colores[0];break;
					case 1:aux=colores[1];break;
					case 2:aux=colores[2];break;
					case 3:aux=colores[3];break;
					case 4:aux=colores[4];break;
					case 5:aux=colores[5];break;
					case 6:aux=colores[6];break;
					case 7:aux=colores[7];break;
					case 8:aux=colores[8];break;
					case 9:aux=colores[9];break;
					case 10:aux=colores[10];break;
					case 11:aux=colores[11];break;
					case 12:aux=colores[12];break;
					case 13:aux=colores[13];break;
					case 14:aux=colores[14];break;
					case 15:aux=colores[15];break;
					default: aux=colores[0];break;

				}*/
	
	