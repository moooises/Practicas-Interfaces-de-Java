import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.io.*;
 
// http://www.codetable.net/
 public class MenuCifrado{
 	 public static JFrame frame = new JFrame();
 	 public static JMenuBar BarraMenu;
 	 public static JMenu mFile,mFAutomata,mFTuring;
 	 public static JMenuItem P1,P2,mAbout,mHelp;
 	 public static TextField origen,destino,clave,desci;
 	 public static JButton cifrar,seleccionar;
 	 public static GridBagConstraints c = new GridBagConstraints();

 	 public static JFileChooser selectorArchivos;
 	 public static JLabel MensajeOrig,MensajeCifrado,Clave,DesClave;
 	 public static int []byt;
 	 public static int []A;
 	 public static int []B;
 	 public static int []codReg;
 	 public static int cant=0;
 	 
 //selectorArchivos = new JFileChooser();
 	 public MenuCifrado(){}
 	 
 	 public static void Menu(){
 	 	 
 	 	BarraMenu = new JMenuBar();
		mFile = new JMenu("File");
		mAbout = new JMenuItem("About");
		mHelp= new JMenuItem("Help");
		mFAutomata = new JMenu("Automata Celular");
		mFTuring = new JMenu("Maquina de Turing");
		P1 = new JMenuItem("Practica 1");
		P2 = new JMenuItem("Practica 2");
		frame.setResizable(true);
		mFAutomata.add(P1);
		mFAutomata.add(P2);
		mFile.add(mFAutomata);
		mFile.add(mFTuring);
		BarraMenu.add(mFile);
		for(int i=0;i<30;++i)
		BarraMenu.add(Box.createHorizontalGlue());
		BarraMenu.add(mAbout);
		BarraMenu.add(mHelp);
		frame.setJMenuBar(BarraMenu);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLayout(new GridBagLayout());
 	 	frame.setMinimumSize(new Dimension(800, 600)); 
 	 }
 	 
 	 public static void Grafico(){
 	 	c.gridx=0;
		c.gridy=0;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		MensajeOrig = new JLabel("Introduce mensaje a cifrar: ",SwingConstants.CENTER);
		c.weightx=1.0;
		c.weighty=1.0;
		frame.add(MensajeOrig,c);
 	 	c.weightx=0.0;
		c.weighty=0.0;
		//---------
		c.gridx=1;
		c.gridy=0;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		origen= new TextField();
		c.weightx=1.0;
		c.weighty=1.0;
		frame.add(origen,c);
 	 	c.weightx=0.0;
		c.weighty=0.0;
		//----------
		c.gridx=2;
		c.gridy=0;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		seleccionar= new JButton("Seleccionar archivo...");//,SwingConstants.CENTER);;
		c.weightx=1.0;
		c.weighty=1.0;
		frame.add(seleccionar,c);
 	 	c.weightx=0.0;
		c.weighty=0.0;
		//--------
		c.gridx=0;
		c.gridy=1;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		Clave= new JLabel("Clave Cifrado: ",SwingConstants.CENTER);
		c.weightx=1.0;
		c.weighty=1.0;
		frame.add(Clave,c);
 	 	c.weightx=0.0;
		c.weighty=0.0;
		//---------
		c.gridx=1;
		c.gridy=1;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		clave = new TextField();
		c.weightx=1.0;
		c.weighty=1.0;
		frame.add(clave,c);
 	 	c.weightx=0.0;
		c.weighty=0.0;
		//-------
		c.gridx=2;
		c.gridy=1;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		cifrar= new JButton("Cifrar");
		c.weightx=1.0;
		c.weighty=1.0;
		frame.add(cifrar,c);
 	 	c.weightx=0.0;
		c.weighty=0.0;
		//--------
		c.gridx=0;
		c.gridy=2;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		MensajeCifrado= new JLabel("Mensaje cifrado: ",SwingConstants.CENTER);
		c.weightx=1.0;
		c.weighty=1.0;
		frame.add(MensajeCifrado,c);
 	 	c.weightx=0.0;
		c.weighty=0.0;
		//------------
		c.gridx=1;
		c.gridy=2;
		c.gridwidth=2;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		destino= new TextField();
		c.weightx=1.0;
		c.weighty=1.0;
		frame.add(destino,c);
 	 	c.weightx=0.0;
		c.weighty=0.0;
		//-----------
		c.gridx=0;
		c.gridy=3;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		DesClave= new JLabel("Descifrado: ",SwingConstants.CENTER);
		c.weightx=1.0;
		c.weighty=1.0;
		frame.add(DesClave,c);
 	 	c.weightx=0.0;
		c.weighty=0.0;
		//--------
		c.gridx=1;
		c.gridy=3;
		c.gridwidth=2;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		desci = new TextField();
		c.weightx=1.0;
		c.weighty=1.0;
		frame.add(desci,c);
 	 	c.weightx=0.0;
		c.weighty=0.0;
		//-------
		frame.pack();
 	 }
 	 
 	 public static void Botones(){
 	 
 	 	 	cifrar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					destino.setText(null);
					desci.setText(null);
					A= new int[1000];
					B= new int[1000];
					byt= new int[1000];//8 espacios por cada letra, max 1000 letras
					char []cadChar=new char[1000];
					int []end=new int[1000];
					int []aux= new int[8];
					codReg= new int[8];

					for(int i=0;i<A.length;++i){
						A[i]=0;							//Reseteamos A para evitar problemas
					}
			
					for(int i=0;i<1000;++i){
						byt[i]=0;						//Reseteamos byt para evitar problemas
					}
					
					for(int i=0;i<B.length;++i){
						B[i]=0;							//Reseteamos B para evitar problemas
					}
					
					for(int i=0;i<end.length;++i){
						end[i]=0;							//Reseteamos B para evitar problemas
					}
					
					int regla=62;//Buscar la ma caotica despues del analisis
					String dest="";
					aux=base(regla,2);
					int l=aux.length-1;
					int k=0;
					while(l>=0){//Le damos la vuelta
						codReg[k]=aux[l];
						--l;
						k++;
					}
					String cadena="";

					cadena=origen.getText();
					cadChar= cadena.toCharArray();
					int ascii;
					
					int byti=0;
					int r=0;
					//System.out.println(cadena.length());
					while(byti<8*cadena.length()){
						//System.out.println(cadChar[r]);///--------------------
						try{
						ascii=(int)cadChar[r];
						++cant;
						}catch(Exception ex){
						ascii=(int)' ';	
						}
						aux=base(ascii,2);
						for(int j=byti;j<byti+8;++j){
														//System.out.println("j: "+j);

						byt[j]=aux[j%8];	
						}
						byti+=8;
						++r;
					}
					
					byti=0;				
					r=0;
					caCifrado();
					while(byti<1000){
						for(int j=byti;j<byti+8;++j){
																			//	System.out.println("Hola");///--------------------

							aux[j%8]=byt[j];
										}
							byti+=8;
							end[r]=Desbasebi(aux,2);
							r++;
											}
					
					//System.out.println("Cant: "+cant);
					dest="";
					for(int i=0;i<cant;++i)dest=dest+(char)end[i];//convertimos el vector unicode cifrado a char y a cadena
					destino.setText(dest);
					dest="";
					
					descifrar();
				}
		});
			
			 seleccionar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					String linea="";
					String aux;
					selectorArchivos = new JFileChooser();
					selectorArchivos.setFileSelectionMode(JFileChooser.FILES_ONLY);
					int seleccion = selectorArchivos.showOpenDialog(null);
					if (seleccion == JFileChooser.APPROVE_OPTION){
					File fichero = selectorArchivos.getSelectedFile();
					
					try{
					BufferedReader br= new BufferedReader(new FileReader(fichero));
						try{
							while((aux=br.readLine())!=null){
								linea=linea+aux;
							}
							origen.setText(linea);
						}catch(IOException io){}
					}catch(FileNotFoundException ex){}
																	}
					
				}
		});
			 
			 
 	 	 }
 	 
 	 
 	 public static int Desbasebi(int []a,int b){
 	 	 int i=7;
 	 	 int res=0;
 	 	 while(i>=0){
 	 	 	 res+=a[i]*Math.pow(b,7-i);//ojo con esto, mirar en nextGen
 	 	 	 	 --i;
 	 	 }
 	 	 return res;
 	 }
 	 
 	 public static int[] base(int nregla,int nestados){
		int []aux= new int[8];
		int g=7,divd=nregla,div=nestados,r;
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
		
		//for(int j=0;j<aux.length;++j)System.out.print(aux[j]);
		//System.out.println();



		return aux;

		}
		
		public static void descifrar(){
			int []end=new int[1000];
			String dest="";
			int byti=0;
			int r=0;
			for(int i=0;i<A.length;++i){
			A[i]=0;							//Reseteamos A para evitar problemas
			}
			
			/**
			for(int i=0;i<1000;++i){
			byt[i]=0;						//Reseteamos byt para evitar problemas
			}
			*/
			
			for(int i=0;i<B.length;++i){
				B[i]=0;							//Reseteamos B para evitar problemas
			}

			int help=0;
			int []aux=new int[8];
			char []cadOrg= new char[125];//El max de caracteres que caben en 1000 bits
			String original=clave.getText();
			cadOrg= original.toCharArray();
			
			for(int i=0;i<original.length();++i){
				aux=base((int)cadOrg[i],2);
				for(int j=0;j<8;++j){	
					A[j+help]=aux[j];
				}
				help+=8;
			}
			
			xor();
			for(int j=0;j<40000;++j){//La primera ya la hicimos
			//System.out.println("J: "+j);
			nextGen();
				for(int i=0;i<1000;++i){
					A[i]=B[i];//Tienes que comprobar el vector al reves
				}
				xor();


				}
			
				byti=0;
				r=0;
			while(byti<1000){
				for(int j=byti;j<byti+8;++j){
																			//	System.out.println("Hola");///--------------------

					aux[j%8]=byt[j];
										}
					byti+=8;
					end[r]=Desbasebi(aux,2);
					r++;
											}
				for(int i=0;i<cant;++i)dest=dest+(char)end[i];//convertimos el vector unicode cifrado a char y a cadena
				desci.setText(dest);
			
			
			
		}
		
		public static void caCifrado(){
			int help=0;
			int []aux=new int[8];
			char []cadOrg= new char[125];//El max de caracteres que caben en 1000 bits
			String original=clave.getText();
			cadOrg= original.toCharArray();
			
			for(int i=0;i<original.length();++i){
				aux=base((int)cadOrg[i],2);
				for(int j=0;j<8;++j){	
					A[j+help]=aux[j];
				}
				help+=8;
			}
			
		//	A=generador_lineal(655539,0,2147483648.0,1,1000);
			xor();
			for(int j=0;j<40000;++j){//La primera ya la hicimos
			//System.out.println("J: "+j);
			nextGen();
			for(int i=0;i<1000;++i){
			A[i]=B[i];
			}
			xor();

			
			
			}

	}
	
	public static void xor(){
		String cadena=origen.getText();
		//for(int i=0;i<40;++i)System.out.print(" "+byt[i]);
		for(int i=0;i<cadena.length()*8;++i){
			byt[i]=byt[i]^A[i];
		}
		//System.out.println();
	}
	
		public static void nextGen(){
		int estados=2;
		int vecinos=1;
		int res=0;
		int t=1000;
		int []genes= new int[2*vecinos+1];
		int derch=0,izq=0;
		int j=0;
		int sum=0;
		int sumi=0;
		int pm;
		int pmedio=((int)Math.ceil((2*vecinos+1)/2));

		for(int i=0;i<1000;++i){
			pmedio=((int)Math.ceil((2*vecinos+1)/2));
			res=0;
			j=0;
			pm=pmedio;
			sum=0;
			genes[pmedio]=A[i];
			derch=i;
			izq=i;
			sumi=0;
					
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
					
					int k=(2*vecinos);
					
					while(k>=0){
						res=res+genes[k]*(int)Math.pow(estados,k);
						k--;
					}
					//System.out.println("res: "+res);
					//System.out.println("B: "+B[i]);
					B[i]=codReg[(int)res];

						
				
			}
					
	}
	
	public static int[]generador_lineal(int a, int b, double c, int seed, int x){
		int m=(int)c;
		int numeros[]=new int[x];
		numeros[0]=(a*seed+b)%m;
			//	System.out.println(numeros[0]);
		for(int i=1;i<x;++i){

		numeros[i]=((a*numeros[i-1]+b)%m);	
				//System.out.println(numeros[i]);
		}
		for(int i=0;i<x;++i){

		numeros[i]=numeros[i]/(int)m;	
				//System.out.println(numeros[i]);
		}
		//System.out.println("END");
		return numeros;
				
	}
	
	public static void main(String []args){
		Menu();
		Grafico();
		Botones();
		
	}
 }