import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPrincipal{
	public static JFrame frame= new JFrame();
	public static JFrame FHamimming,FEntriopia;
	public static JMenuBar BarraMenu;
	public static JMenu mFile,mFAutomata,mFTuring;
	public static JMenuItem P1,P2,mAbout,mHelp;
	public static JPanel panelup,paneldown;
	public static JLabel OP,Gen,Alt,Front,Est,Rango,Reg,JCurva;
	public static GridBagConstraints c = new GridBagConstraints();
	//public static GridBagConstraints h= new GridBagConstraints();
	//public static GridBagConstraints e= new GridBagConstraints();
	public static TextField TGen,TEst,TRango,TReg;
	public static JButton Start,BHamming,BEntriopia;
	public static JComboBox<String> JAlt,JFront,JReg;
	public static ca1DSimulator ca;
	public static randomGenerator a= new randomGenerator();
	public static Hamming H;
	public static Entriopia EN;
	public static Canvas grafico; //-------------------
	//public static Dibujo grafico2=new Dibujo();//--------------------
	public static Canvas curva;
	public static String[] alt= {"5Xn-1 mod 2^5","7Xn-1 mod 2^5","3Xn-1 mod 31","7^5Xn-1 mod (2^31-1)","(Wn-Xn+Yn) mod 32362","48271Xn-1 mod (2^31-1)","(2^16+3)Xn-1 mod 2^31","Nulo"};
	public static String[] front= {"Nula","Cilindrica"};
	public static String[] reg={"0","60","90","102","150","170","204","240"};
	public static boolean p4=false;
	public static int Geni,Estadosi;
	//public static int Prueba=69;




	
	public MenuPrincipal(){}
	
	public static void Menu(){
		BarraMenu = new JMenuBar();
		mFile = new JMenu("File");
		mAbout = new JMenuItem("About");
		mHelp= new JMenuItem("Help");
		mFAutomata = new JMenu("Automata Celular");
		mFTuring = new JMenu("Maquina de Turing");
		P1 = new JMenuItem("Practica 1");
		P2 = new JMenuItem("Practica 2");
		//this.init();
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//frame.setUndecorated(true);
		//frame.setMinimumSize(new Dimension(350,350));
		//frame.setMaximumSize(new Dimension(1000,1000));
		//frame.setSize(500,500);
		frame.setResizable(true);
		//frame.setEnabled(true);
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
		//frame.add(grafico,c);
		

		
	}
	
	private static void Grafico(){
		//gridx: especifica la celda principal de la fila
		//gridy: especifica la celda principal de la columna
		//Por defecto ambas son 0
		//gridwidth: especifica el numero de celdas en una fila
		//gridheight: especifica el numero de celdas en una columna
		//fill: se usa cuando el area del elemento a mostrar es mayor que el tamaño que el componente a pedido
		//BOTH: redimension el componenta tanto horizontal como vertical
		//weightx/y: especifica como distribuir el espacio extra horizontal/vertical
		c.gridx=0;
		c.gridy=0;
		c.gridwidth=2;
		c.gridheight=4;//;
		c.fill=GridBagConstraints.BOTH;
		grafico = new Canvas();
		c.weightx=1.0;
		c.weighty=1.0;
		//grafico.setPreferredSize(new Dimension(500,500));
		grafico.setBackground(Color.decode("#F5FFFA"));
		frame.getContentPane().add(grafico,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//----------
		c.gridx=3;
		c.gridy=0;
		c.gridwidth=2;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		OP= new JLabel("Opciones",SwingConstants.CENTER);
		OP.setFont(new Font("Serif",Font.BOLD, 30));
		OP.setForeground(Color.black);
		OP.setBackground(Color.white);
		frame.add(OP,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//------------
		c.gridx=3;
		c.gridy=1;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		Gen= new JLabel("Nº de Generaciones:",SwingConstants.CENTER);
		frame.add(Gen,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//----------
		c.gridx=3;
		c.gridy=2;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		Alt= new JLabel("Generador: ",SwingConstants.CENTER);
		frame.add(Alt,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//-----
		c.gridx=3;
		c.gridy=3;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		Front= new JLabel("Frontera: ",SwingConstants.CENTER);
		frame.add(Front,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//--------
		c.gridx=3;
		c.gridy=4;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		Est= new JLabel("Nº de estados: ",SwingConstants.CENTER);
		frame.add(Est,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//---------
		c.gridx=3;
		c.gridy=5;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		Rango= new JLabel("Rango de vecindad: ",SwingConstants.CENTER);
		frame.add(Rango,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//------
		c.gridx=3;
		c.gridy=6;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		Reg= new JLabel("Regla: ",SwingConstants.CENTER);
		frame.add(Reg,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//----
		c.gridx=4;
		c.gridy=1;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		TGen= new TextField();
		frame.add(TGen,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//--------
		c.gridx=4;
		c.gridy=4;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		TEst= new TextField("");
		frame.add(TEst,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//----------
		c.gridx=4;
		c.gridy=5;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		TRango= new TextField();
		frame.add(TRango,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//--------
		c.gridx=4;
		c.gridy=6;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		TReg= new TextField();
		frame.add(TReg,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//----------
		c.gridx=4;
		c.gridy=2;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		JAlt= new JComboBox<>(alt);
		frame.add(JAlt,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//----------
		c.gridx=4;
		c.gridy=3;
		c.gridwidth=1;
		c.gridheight=1;
		//c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		JFront= new JComboBox<>(front);
		frame.add(JFront,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//--------
		c.gridx=3;
		c.gridy=8;
		c.gridwidth=2;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		Start= new JButton("Start");
		frame.add(Start,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//---------
		c.gridx=3;
		c.gridy=7;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		BHamming= new JButton("Curva de Hamming");
		frame.add(BHamming,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//-----
		c.gridx=4;
		c.gridy=7;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		BEntriopia= new JButton("Curva de Entriopia");
		frame.add(BEntriopia,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//-----
		c.gridx=0;
		c.gridy=4;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		JCurva= new JLabel("Curva de poblacion",SwingConstants.CENTER);
		JCurva.setFont(new Font("Serif",Font.BOLD, 30));
		JCurva.setForeground(Color.black);
		JCurva.setBackground(Color.white);
		frame.add(JCurva,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//
		c.gridx=0;
		c.gridy=5;
		c.gridwidth=2;
		c.gridheight=4;//;
		c.fill=GridBagConstraints.BOTH;
		curva =new Canvas();
		curva.setBackground(Color.decode("#FFFFFF"));
		c.weightx=1.0;
		c.weighty=1.0;
		//curva.setPreferredSize(new Dimension(500,500));

		frame.add(curva,c);
		
		c.weightx=0.0;
		c.weighty=0.0;
		frame.pack();
		//curva.setVisible(true);
	}
	
	public static void Boton(){
		
		Start.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					p4=true;
					String nGen,GAlt,Front,nestados,rangov,rule;
					int ragoi,rulei;
					boolean front;
					nGen=TGen.getText();
					GAlt=(String)JAlt.getSelectedItem();
					Front=(String)JFront.getSelectedItem();
					nestados=TEst.getText();
					rangov=TRango.getText();
					rule=TReg.getText();
					Geni=Integer.parseInt(nGen);
					System.out.println("FronteraS: "+Front);
					if(Front.equals("Nula"))front=false;
					else front=true;
					System.out.println("Front: "+front);
					Estadosi=Integer.parseInt(nestados);
					ragoi=Integer.parseInt(rangov);
					rulei=Integer.parseInt(rule);
					//Aqui creamos el objeto ca1DSimulator y llamamos a todos sus meto	//
					ca= new ca1DSimulator(Estadosi,Geni,ragoi,rulei,front,GAlt,400,grafico,curva);
					//grafico.act(Estadosi,Geni,ragoi,rulei,front,GAlt,400,curva);//10100
					//grafico.repaint();
					//grafico.Curva();
					
				}
		});
		mAbout.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					JOptionPane.showMessageDialog(null,"Lo he hecho yo : )");
				}
			});
		mHelp.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					JOptionPane.showMessageDialog(null,"Los colores que representa los estados son distintas tonalidades de azul\nLa curva de poblacion tiene de rango X[0,nº generaciones] e Y[0,400]");
				}
			});
		BHamming.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
				if(p4){
					H= new Hamming(ca.VectorHamming());
					}
				}
		});
		BEntriopia.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
				if(p4){
					EN= new Entriopia(ca.MatrizEntriopia(),Estadosi,Geni);//----------------
					}
				}
		});
		
	}
	

		public static void main(String[] args){
		frame.getContentPane().setLayout(new GridBagLayout());
 		MenuPrincipal menu = new MenuPrincipal();
 		Menu();
		Grafico();	
		Boton();
		
	}
}
	
	/**
	
	private static void AnadirEventos(){
		
		P1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					JOptionPane.showMessageDialog(null,"P1");	
				}
			});
		P2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					JOptionPane.showMessageDialog(null,"P2");
				}
			});
		mAbout.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					JOptionPane.showMessageDialog(null,"Lo he hecho yo : )");
				}
			});
		mHelp.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					JOptionPane.showMessageDialog(null,"Help");
				}
			});
		Boton1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//JOptionPane.showMessageDialog(null,"Boton 1");
					//TAx1,TAx2,TAy1,TAy2,TAw1,TAw2,TBx1,TBx2,TBy1,TBy2,TBw1,TBw2,TMx1,TMx2,TMy1,TMy2,TMw1,TMw2,TSeedx1,TSeedx2,TSeedy1,TSeedy2,TSeedw1,TSeedw2,TNum ;
					String ax,bx,mx,seedx,ay,by,my,seedy,Snum;
					double axi,bxi,mxi,seedxi,ayi,byi,myi,seedyi;
					int numi;
					ax=TAx1.getText();
					bx=TBx1.getText();
					mx=TMx1.getText();
					seedx=TSeedx1.getText();
					ay=TAx2.getText();
					by=TBx2.getText();
					my=TMx2.getText();
					seedy=TSeedx2.getText();
					Snum=TNum.getText();
					
					axi=Double.parseDouble(ax);
					bxi=Double.parseDouble(bx);
					mxi=Double.parseDouble(mx);
					seedxi=Double.parseDouble(seedx);
					ayi=Double.parseDouble(ay);
					byi=Double.parseDouble(by);
					myi=Double.parseDouble(my);
					seedyi=Double.parseDouble(seedy);
					numi=Integer.parseInt(Snum);
					
					double[]x1= new double[numi];
					double[]y1= new double[numi];
					x1=a.generador_lineal(axi,bxi,mxi,seedxi,numi);
					y1=a.generador_lineal(ayi,byi,myi,seedyi,numi);
					
					grafico.reset(numi,x1,y1);
					grafico.repaint();

				}
			});
		Boton2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//JOptionPane.showMessageDialog(null,"Boton 2");
					//TAx1,TAx2,TAy1,TAy2,TAw1,TAw2,TBx1,TBx2,TBy1,TBy2,TBw1,TBw2,TMx1,TMx2,TMy1,TMy2,TMw1,TMw2,TSeedx1,TSeedx2,TSeedy1,TSeedy2,TSeedw1,TSeedw2,TNum ;
					String ax1,ay1,aw1,bx1,by1,bw1,mx1,my1,mw1,mv1,seedx1,seedy1,seedw1,seedv1,ax2,ay2,aw2,bx2,by2,bw2,mx2,my2,mw2,mv2,seedx2,seedy2,seedw2,seedv2,Snum;
					double axi1,ayi1,awi1,bxi1,byi1,bwi1,mxi1,myi1,mwi1,mvi1,seedxi1,seedyi1,seedwi1,seedvi1,axi2,ayi2,awi2,bxi2,byi2,bwi2,mxi2,myi2,mwi2,mvi2,seedxi2,seedyi2,seedwi2,seedvi2;
					int numi;
					ax1=TAx1.getText();
					ax2=TAx2.getText();
					ay1=TAy1.getText();
					ay2=TAy2.getText();
					aw1=TAw1.getText();
					aw2=TAw2.getText();
					bx1=TBx1.getText();
					bx2=TBx2.getText();
					by1=TBy1.getText();
					by2=TBy2.getText();
					bw1=TAw1.getText();
					bw2=TAw2.getText();
					mx1=TMx1.getText();
					mx2=TMx2.getText();
					my1=TMy1.getText();
					my2=TMy2.getText();
					mw1=TMw1.getText();
					mw2=TMw2.getText();
					seedx1=TSeedx1.getText();
					seedx2=TSeedx2.getText();
					seedy1=TSeedy1.getText();
					seedy2=TSeedy2.getText();
					seedw1=TSeedw1.getText();
					seedw2=TSeedw2.getText();
					Snum=TNum.getText();
					
					axi1=Double.parseDouble(ax1);
					axi2=Double.parseDouble(ax2);
					ayi1=Double.parseDouble(ay1);
					ayi2=Double.parseDouble(ay2);
					awi1=Double.parseDouble(aw1);
					awi2=Double.parseDouble(aw2);
					bxi1=Double.parseDouble(bx1);
					bxi2=Double.parseDouble(bx2);
					byi1=Double.parseDouble(by1);
					byi2=Double.parseDouble(by2);
					bwi1=Double.parseDouble(bw1);
					bwi2=Double.parseDouble(bw2);
					mxi1=Double.parseDouble(mx1);
					mxi2=Double.parseDouble(mx2);
					myi1=Double.parseDouble(my1);
					myi2=Double.parseDouble(my2);
					mwi1=Double.parseDouble(mw1);
					mwi2=Double.parseDouble(mw2);
					seedxi1=Double.parseDouble(seedx1);
					seedxi2=Double.parseDouble(seedx2);
					seedyi1=Double.parseDouble(seedy1);
					seedyi2=Double.parseDouble(seedy2);
					seedwi1=Double.parseDouble(seedw1);
					seedwi2=Double.parseDouble(seedw2);
					mvi1=32362;
					mvi2=32362;
					numi=Integer.parseInt(Snum);

					
					double[]x2= new double[numi];
					double[]y2= new double[numi];
					x2=a.generador_combinado(axi1,ayi1,awi1,bxi1,byi1,bwi1,mxi1,myi1,mwi1,mvi1,seedxi1,seedyi1,seedwi1,numi);
					y2=a.generador_combinado(axi2,ayi2,awi2,bxi2,byi2,bwi2,mxi2,myi2,mwi2,mvi2,seedxi2,seedyi2,seedwi2,numi);
					
					grafico.reset(numi,x2,y2);
					grafico.repaint();
					
					
				}
			}); 
	}
	
	private static void Crear(){
	
		frame.getContentPane().setLayout(new GridBagLayout());
 		MenuPrincipal menu = new MenuPrincipal();
		Grafico();
		PanelesyBotones();
		AnadirEventos();
		
	}
	
	*/
	
	/**private static void Paneles(){
		panelright= new JPanel();
		panelright.setLayout(new BorderLayout());
		panelright.setPreferredSize(new Dimension(500,Integer.MAX_VALUE));
		frame.add(panelright,BorderLayout.EAST);
		panelup = new JPanel();
		panelup.setLayout(new BorderLayout());
		parametros = new JLabel("Parametros",SwingConstants.CENTER);
		panelup.add(parametros,BorderLayout.NORTH);
		panelright.add(panelup,BorderLayout.NORTH);
		//panelup.setPreferredSize(new Dimension(Integer.MAX_VALUE,500));
		paneldown = new JPanel();
		paneldown.setLayout(new BorderLayout());
		botonera = new JLabel("Botonera",SwingConstants.CENTER);
		paneldown.add(botonera,BorderLayout.NORTH);
		panelright.add(paneldown,BorderLayout.SOUTH);
		panelup.setVisible(true);
		paneldown.setVisible(true);
		panelright.setVisible(true);
		//frame.pack();//---------------------Ajusta la ventana al tamaño de los componentes
	}*/
	
	/**public void init(){
		this.setResizable(true);
		this.BarraMenu.add(this.mFile);
		this.mFile.add(this.mFileOpen);
		this.BarraMenu.add(this.mAbout);
		this.BarraMenu.add(this.mHelp);
		this.setJMenuBar(this.BarraMenu);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}*/
	

		
