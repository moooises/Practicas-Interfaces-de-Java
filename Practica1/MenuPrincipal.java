import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPrincipal{
	private static JFrame frame= new JFrame();
	private static JMenuBar BarraMenu;
	private static JMenu mFile,mFAutomata,mFTuring;
	private static JMenuItem P1,P2,mAbout,mHelp;
	private static JPanel panelup,paneldown;
	private static JLabel Eparametros,Ebotonera;
	private static GridBagConstraints c = new GridBagConstraints();
	private static TextField parametros;
	private static JButton Boton1,Boton2,Boton3,Boton4,Boton5,Boton6;
	
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
		frame.setSize(1000,500);
		frame.setResizable(true);
		BarraMenu.add(mFile);
		mFile.add(mFAutomata);
		mFile.add(mFTuring);
		mFAutomata.add(P1);
		mFAutomata.add(P2);
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
		c.gridwidth=2;
		c.gridheight=4;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		Dibujo grafico = new Dibujo();
		grafico.setPreferredSize(new Dimension(500,500));

		frame.getContentPane().add(grafico,c);
		c.weightx=0.0;
		c.weighty=0.0;
	}
	
	private static void PanelesyBotones(){
		//1º panel
		panelup = new JPanel();
		panelup.setLayout(new BorderLayout());
		Eparametros = new JLabel("Parametros",SwingConstants.CENTER);
		panelup.add(Eparametros,BorderLayout.NORTH);
		c.gridx=2;
		c.gridy=0;
		c.gridwidth=2;
		c.gridheight=2;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		panelup.setPreferredSize(new Dimension(500,500));
		frame.add(panelup,c);
		c.weightx=0.0;
		c.weighty=0.0;
		c.gridx=2;
		c.gridy=2;
		c.gridwidth=2;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		Ebotonera = new JLabel("Botonera",SwingConstants.CENTER);
		frame.add(Ebotonera,c);
		c.weightx=0.0;
		c.weighty=0.0;
		c.gridx=2;
		c.gridy=3;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		Boton1= new JButton("Boton 1");
		frame.add(Boton1,c);
		c.weightx=0.0;
		c.weighty=0.0;
		c.gridx=3;
		c.gridy=3;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1.0;
		c.weighty=1.0;
		Boton2= new JButton("Boton 2");
		frame.add(Boton2,c);
		c.weightx=0.0;
		c.weighty=0.0;
		
		
		
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
					JOptionPane.showMessageDialog(null,"Boton 1");
				}
			});
		Boton2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					JOptionPane.showMessageDialog(null,"Boton 2");
				}
			});
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
		frame.getContentPane().setLayout(new GridBagLayout());
 		MenuPrincipal menu = new MenuPrincipal();
		Grafico();
		PanelesyBotones();
		AnadirEventos();
	}
		
}