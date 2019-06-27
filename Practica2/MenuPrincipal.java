import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPrincipal{
	private static JFrame frame= new JFrame();
	private static JMenuBar BarraMenu;
	private static JMenu mFile,mFAutomata,mFTuring;
	private static JMenuItem P1,P2,mAbout,mHelp;
	private static JPanel panelup,paneldown;
	private static JLabel Eparametros,Ebotonera,EAx,EAy,EAw,EBx,EBy,EBw,EMx,EMy,EMw,ESeedx,ESeedy,ESeedw,ENum;
	private static GridBagConstraints c = new GridBagConstraints();
	private static TextField TAx1,TAx2,TAy1,TAy2,TAw1,TAw2,TBx1,TBx2,TBy1,TBy2,TBw1,TBw2,TMx1,TMx2,TMy1,TMy2,TMw1,TMw2,TSeedx1,TSeedx2,TSeedy1,TSeedy2,TSeedw1,TSeedw2,TNum ;
	private static JButton Boton1,Boton2,Boton3,Boton4,Boton5,Boton6;
	private static randomGenerator a= new randomGenerator();
	private static Dibujo grafico = new Dibujo();//-------------------


	
	public MenuPrincipal(){
		BarraMenu = new JMenuBar();
		mFile = new JMenu("File");
		mAbout = new JMenuItem("About");
		mHelp= new JMenuItem("Help");
		mFAutomata = new JMenu("Automata Celular");
		mFTuring = new JMenu("Maquina de Turing");
		P1 = new JMenuItem("Practica 1");
		P2 = new JMenuItem("Practica 2");
		//this.init();
		frame.setSize(1000,1000);
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
		//frame.setLayout(new GridBagLayout());
		//Creamos el grafico
		//Dibujo grafico = new Dibujo();
	//	frame.add(grafico, BorderLayout.CENTER);
		
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
		c.gridwidth=3;
		c.gridheight=10;//;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		grafico.setPreferredSize(new Dimension(500,500));

		frame.getContentPane().add(grafico,c);
		c.weightx=0.0;
		c.weighty=0.0;
	}
	
	private static void PanelesyBotones(){
		//1º panel
		//panelup = new JPanel();
		//panelup.setLayout(new BorderLayout());
		Eparametros = new JLabel("Parametros",SwingConstants.CENTER);
		//panelup.add(Eparametros,BorderLayout.NORTH);
		c.gridx=3;
		c.gridy=0;
		c.gridwidth=8;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		//panelup.setPreferredSize(new Dimension(500,500));
		frame.add(Eparametros,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//--------------
		c.gridx=3;
		c.gridy=1;
		c.gridwidth=1;
		c.gridheight=2;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;//EAx,EAy,EAw,EBx,EBy,EBw,EMx,EMy,EMw,ESeedx,ESeedy,ESeedw
		EAx= new JLabel("a(X)",SwingConstants.CENTER);
		//Ebotonera = new JLabel("Botonera",SwingConstants.CENTER);
		frame.add(EAx,c);
		c.weightx=0.0;
		c.weighty=0.0;
		
		c.gridx=4;
		c.gridy=1;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=0;
		c.weighty=0;
		TAx1= new TextField("0");
		frame.add(TAx1,c);
		c.weightx=0.0;
		c.weighty=0.0;
		
		c.gridx=4;
		c.gridy=2;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		TAx2= new TextField("0");
		frame.add(TAx2,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//------------
		c.gridx=5;
		c.gridy=1;
		c.gridwidth=1;
		c.gridheight=2;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		EBx= new JLabel("b(X)",SwingConstants.CENTER);
		frame.add(EBx,c);
		c.weightx=0.0;
		c.weighty=0.0;
		
		c.gridx=6;
		c.gridy=1;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		TBx1= new TextField("0");
		frame.add(TBx1,c);
		c.weightx=0.0;
		c.weighty=0.0;
		
		c.gridx=6;
		c.gridy=2;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		TBx2= new TextField("0");
		frame.add(TBx2,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//---------------
		c.gridx=7;
		c.gridy=1;
		c.gridwidth=1;
		c.gridheight=2;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		EMx= new JLabel("m(X)",SwingConstants.CENTER);
		frame.add(EMx,c);
		c.weightx=0.0;
		c.weighty=0.0;
		
		c.gridx=8;
		c.gridy=1;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		TMx1= new TextField("0");
		frame.add(TMx1,c);
		c.weightx=0.0;
		c.weighty=0.0;
		
		c.gridx=8;
		c.gridy=2;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		TMx2= new TextField("0");
		frame.add(TMx2,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//----------
		c.gridx=9;
		c.gridy=1;
		c.gridwidth=1;
		c.gridheight=2;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		ESeedx= new JLabel("Seed(X)",SwingConstants.CENTER);
		frame.add(ESeedx,c);
		c.weightx=0.0;
		c.weighty=0.0;
		
		c.gridx=10;
		c.gridy=1;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		TSeedx1= new TextField("0");
		frame.add(TSeedx1,c);
		c.weightx=0.0;
		c.weighty=0.0;
		
		c.gridx=10;
		c.gridy=2;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		TSeedx2= new TextField("0");
		frame.add(TSeedx2,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//---------
		c.gridx=3;
		c.gridy=3;
		c.gridwidth=1;
		c.gridheight=2;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		EAy= new JLabel("A(Y)",SwingConstants.CENTER);
		frame.add(EAy,c);
		c.weightx=0.0;
		c.weighty=0.0;
		
		c.gridx=4;
		c.gridy=3;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		TAy1= new TextField("0");
		frame.add(TAy1,c);
		c.weightx=0.0;
		c.weighty=0.0;
		
		c.gridx=4;
		c.gridy=4;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		TAy2= new TextField("0");
		frame.add(TAy2,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//-----
		c.gridx=5;
		c.gridy=3;
		c.gridwidth=1;
		c.gridheight=2;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		EBy= new JLabel("B(Y)",SwingConstants.CENTER);
		frame.add(EBy,c);
		c.weightx=0.0;
		c.weighty=0.0;
		
		c.gridx=6;
		c.gridy=3;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		TBy1= new TextField("0");
		frame.add(TBy1,c);
		c.weightx=0.0;
		c.weighty=0.0;
		
		c.gridx=6;
		c.gridy=4;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		TBy2= new TextField("0");
		frame.add(TBy2,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//---
		c.gridx=7;
		c.gridy=3;
		c.gridwidth=1;
		c.gridheight=2;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		EMy= new JLabel("m(Y)",SwingConstants.CENTER);
		frame.add(EMy,c);
		c.weightx=0.0;
		c.weighty=0.0;
		
		c.gridx=8;
		c.gridy=3;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		TMy1= new TextField("0");
		frame.add(TMy1,c);
		c.weightx=0.0;
		c.weighty=0.0;
		
		c.gridx=8;
		c.gridy=4;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		TMy2= new TextField("0");
		frame.add(TMy2,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//---
		c.gridx=9;
		c.gridy=3;
		c.gridwidth=1;
		c.gridheight=2;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		ESeedy= new JLabel("Seed(y)",SwingConstants.CENTER);
		frame.add(ESeedy,c);
		c.weightx=0.0;
		c.weighty=0.0;
		
		c.gridx=10;
		c.gridy=3;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		TSeedy1= new TextField("0");
		frame.add(TSeedy1,c);
		c.weightx=0.0;
		c.weighty=0.0;
		
		c.gridx=10;
		c.gridy=4;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		TSeedy2= new TextField("0");
		frame.add(TSeedy2,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//-----
		c.gridx=3;
		c.gridy=5;
		c.gridwidth=1;
		c.gridheight=2;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		EAw= new JLabel("A(W)",SwingConstants.CENTER);
		frame.add(EAw,c);
		c.weightx=0.0;
		c.weighty=0.0;
		
		c.gridx=4;
		c.gridy=5;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		TAw1= new TextField("0");
		frame.add(TAw1,c);
		c.weightx=0.0;
		c.weighty=0.0;
		
		c.gridx=4;
		c.gridy=6;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		TAw2= new TextField("0");
		frame.add(TAw2,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//-------
		c.gridx=5;
		c.gridy=5;
		c.gridwidth=1;
		c.gridheight=2;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		EBw= new JLabel("B(W)",SwingConstants.CENTER);
		frame.add(EBw,c);
		c.weightx=0.0;
		c.weighty=0.0;
		
		c.gridx=6;
		c.gridy=5;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		TBw1= new TextField("0");
		frame.add(TBw1,c);
		c.weightx=0.0;
		c.weighty=0.0;
		
		c.gridx=6;
		c.gridy=6;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		TBw2= new TextField("0");
		frame.add(TBw2,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//-------
		c.gridx=5;
		c.gridy=5;
		c.gridwidth=1;
		c.gridheight=2;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		EBw= new JLabel("B(W)",SwingConstants.CENTER);
		frame.add(EBw,c);
		c.weightx=0.0;
		c.weighty=0.0;
		
		c.gridx=6;
		c.gridy=5;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		TBw1= new TextField("0");
		frame.add(TBw1,c);
		c.weightx=0.0;
		c.weighty=0.0;
		
		c.gridx=6;
		c.gridy=6;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		TBw2= new TextField("0");
		frame.add(TBw2,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//-------
		c.gridx=7;
		c.gridy=5;
		c.gridwidth=1;
		c.gridheight=2;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		EMw= new JLabel("m(W)",SwingConstants.CENTER);
		frame.add(EMw,c);
		c.weightx=0.0;
		c.weighty=0.0;
		
		c.gridx=8;
		c.gridy=5;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		TMw1= new TextField("0");
		frame.add(TMw1,c);
		c.weightx=0.0;
		c.weighty=0.0;
		
		c.gridx=8;
		c.gridy=6;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		TMw2= new TextField("0");
		frame.add(TMw2,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//-----
		c.gridx=9;
		c.gridy=5;
		c.gridwidth=1;
		c.gridheight=2;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		ESeedw= new JLabel("Seed(W)",SwingConstants.CENTER);
		frame.add(ESeedw,c);
		c.weightx=0.0;
		c.weighty=0.0;
		
		c.gridx=10;
		c.gridy=5;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		TSeedw1= new TextField("0");
		frame.add(TSeedw1,c);
		c.weightx=0.0;
		c.weighty=0.0;
		
		c.gridx=10;
		c.gridy=6;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		TSeedw2= new TextField("0");
		frame.add(TSeedw2,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//-----
		c.gridx=3;
		c.gridy=8;
		c.gridwidth=8;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		Ebotonera = new JLabel("Botonera",SwingConstants.CENTER);
		frame.add(Ebotonera,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//--
		c.gridx=3;
		c.gridy=9;
		c.gridwidth=4;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=0;
		c.weighty=0;
		Boton1= new JButton("Generador Lineal");
		frame.add(Boton1,c);
		c.weightx=0.0;
		c.weighty=0.0;
		//---
		c.gridx=7;
		c.gridy=9;
		c.gridwidth=4;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=0;
		c.weighty=0;
		Boton2= new JButton("Generador Combinado");
		frame.add(Boton2,c);
		
		c.weightx=0.0;
		c.weighty=0.0;
		/**
		c.gridx=3;
		c.gridy=9;
		c.gridwidth=4;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=0;
		c.weighty=0;
		Boton3=new JButton("Boton 3?");
		frame.add(Boton3,c);
		c.weightx=0;
		c.weighty=0;
		//--
		c.gridx=7;
		c.gridy=9;
		c.gridwidth=4;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=0;
		c.weighty=0;
		Boton4= new JButton("Boton4?");
		frame.add(Boton4,c);
		c.weightx=0;
		c.weighty=0;
		frame.setVisible(true);
		//---
		*/
		//-----
		c.gridx=3;
		c.gridy=7;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=0;
		c.weighty=0;
		ENum=new JLabel("Cantidad: ",SwingConstants.CENTER);
		frame.add(ENum,c);
		c.weightx=0;
		c.weighty=0;
		//------
		c.gridx=4;
		c.gridy=7;
		c.gridwidth=7;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=0;
		c.weighty=0;
		TNum=new TextField("1");
		frame.add(TNum,c);
		c.weightx=0;
		c.weighty=0;
		//---
		
		//No tenemos que hacer un panel, tenemos que añdir la etiqueta a una fila y columna
		//y lo mismo con cada boton
		/**
		//-Botones y 2º Panel
		paneldown= new JPanel();
		paneldown.setLayout(new BorderLayout());
		Ebotonera = new JLabel("Botonera",SwingConstants.CENTER);
		paneldown.add(Ebotonera,BorderLayout.NORTH);
		Boton1= new JButton("Boton 1");
		Boton1.setMargin(new Insets(1, 1, 1, 1));
		paneldown.add(Boton1);
		Boton2= new JButton("Boton 2");
		Boton2.setMargin(new Insets(1, 1, 1, 1));
		paneldown.add(Boton2);
		Boton3= new JButton("Boton 3");
		Boton3.setMargin(new Insets(1, 1, 1, 1));
		paneldown.add(Boton3);
		Boton4= new JButton("Boton 4");
		Boton4.setMargin(new Insets(1, 1, 1, 1));
		paneldown.add(Boton4);
		Boton5= new JButton("Boton 5");
		Boton5.setMargin(new Insets(1, 1, 1, 1));
		paneldown.add(Boton5);
		Boton6= new JButton("Boton 6");
		Boton6.setMargin(new Insets(1, 1, 1, 1));
		paneldown.add(Boton6);
		c.gridx=2;
		c.gridy=2;
		c.gridwidth=2;
		c.gridheight=2;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;

		paneldown.setPreferredSize(new Dimension(500,500));
		frame.add(paneldown,c);
		c.weightx=0.0;
		c.weighty=0.0;
		frame.setVisible(true);
		//---*/
	}
	
	
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
	
	public static void main(String[] args){
		Crear();	
		
	}
		
}