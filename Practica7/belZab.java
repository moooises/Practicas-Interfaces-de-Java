import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Random;
import java.io.*;
import java.lang.Object.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import java.awt.geom.*;
import java.awt.image.BufferedImage;


class belZab{
//  public static CyclicBarrier barrier;


  public static JMenuBar BarraMenu;
  public static JMenu mFile,mFAutomata,mFTuring;
  public static JMenuItem P1,P2,mAbout,mHelp;
  public static GridBagConstraints cb = new GridBagConstraints();
//  public static JComboBox<String> CFrontera;
  public static JButton Start;
  public static TextField TGeneraciones,TDIM,TAlfa,TBeta,TGamma;
  public static JLabel LGeneraciones,LDIM,LAlfa,LBeta,LGamma;
  public static JFrame frame= new JFrame();

  public static Canvas Vida;//Para pintar concurrentemente usar cyclerBArrier para indicar que todos los hilos han terminado de calcular
  public static Graphics2D Vida2D;
  public static int Generaciones;

  public static float [][][] a;
  public static float [][][] b;
  public static float [][][] c;

  public static Color[][] color;

  public static int p=0;
  public static int q=1;
  public static int width=200;
  public static int height=200;
  public static float alfa=1.2f;
  public static float beta=1.0f;
  public static float gamma=1.0f;

 /**public int FilasInf,FilasSup

  public belZab(){

  }*/

  public static void setup(){
    a=new float[width][height][2];
    b=new float[width][height][2];
    c=new float[width][height][2];
    color=new Color[width][height];
    Random rd=new Random();
    for(int x=0;x<width;++x){
      for(int y=0;y<height;++y){
        a[x][y][p]=rd.nextFloat();
        b[x][y][p]=rd.nextFloat();
        c[x][y][p]=rd.nextFloat();
      }
    }
  }


public static void compute(){//esto sera el metodo run
    for(int x=0;x<width;x++){
      for(int y=0;y<height;y++){
        float c_a=0.0f;
        float c_b=0.0f;
        float c_c=0.0f;
        for(int i=x-1;i<=x+1;++i){
          for(int j=y-1;j<=y+1;++j){
            c_a+=a[(i+width)%width][(j+height)%height][p];
            c_b+=b[(i+width)%width][(j+height)%height][p];
            c_c+=c[(i+width)%width][(j+height)%height][p];
          }
        }
        c_a/=9.0f;
        c_b/=9.0f;
        c_c/=9.0f;

        a[x][y][q]=constrain(c_a+c_a*(alfa*c_b-gamma*c_c));
        b[x][y][q]=constrain(c_b+c_b*(beta*c_c-alfa*c_a));
        c[x][y][q]=constrain(c_c+c_c*(gamma*c_a-beta*c_b));
      //  System.out.println("a: "+a[x][y][q]+" b: "+b[x][y][q]+" c: "+c[x][y][q]);
        color[x][y]= new Color(a[x][y][q],b[x][y][q],c[x][y][q]);

      }

    }
    //System.out.println("Hey");
}

public static float constrain(float x){
  if(x<0)return 0;
  else  {
    if(x>1)return 1;
    else return x;
  }
}

public static void pintar(){
  /**for(int x=0;x<width;++x){
    for(int y=0;y<height;++y){
      Vida2D.setColor(color[x][y]);
      Vida2D.fillRect(x,y,1,1);
    }
  }*/

  BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
              for (int j=0;j<width ; j++)
              {
                  for(int k=0; k<height; k++)
                      image.setRGB(j,k,color[j][k].getRGB());
              }
              Vida2D.drawImage(image, 0, 0, width,height, Vida);
/**
  for(int x=0;x<width;++x){
    for(int y=0;y<height;++y){
      Vida2D.setColor(color[x][y]);
      Vida2D.fillRect(x,y,1,1);
    }
  }
  */
  if(p==0){p=1;q=0;}
  else{p=0;q=1;}

}

public static void Boton(){
Start.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
      // public static TextField TVivas,TMuertas,TGeneraciones,TDIM;

      System.out.println("Start");


      String generaciones,dimensiones,sAlfa,sBeta,sGamma;
      generaciones=TGeneraciones.getText();
      dimensiones=TDIM.getText();
      sAlfa=TAlfa.getText();
      sBeta=TBeta.getText();
      sGamma=TGamma.getText();
      width=Integer.parseInt(dimensiones);
      height=width;
      if(width==0){
        width=Vida.getWidth();
        height=Vida.getHeight();
      }
      Generaciones=Integer.parseInt(generaciones);
      alfa=Float.parseFloat(sAlfa);
      beta=Float.parseFloat(sBeta);
      gamma=Float.parseFloat(sGamma);
	    Vida.update(Vida.getGraphics());
      setup();

      for(int i=0;i<Generaciones;++i){
      compute();
       pintar();
    //   System.out.println("hay2");

          }
          System.out.println("Finish");

    }
});

mAbout.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
      JOptionPane.showMessageDialog(null,"Lo he hecho yo : )");
    }
  });

mHelp.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
      JOptionPane.showMessageDialog(null,"Los colores que representa los estados son distintas tonalidades de azul\nLa curva de poblacion tiene de rango X[0,n� generaciones] e Y[0,400]");
    }
  });

}

public static void Marco(){
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

public static void Grafico(){
 cb.gridx=0;
 cb.gridy=0;
 cb.gridwidth=6;
 cb.gridheight=6;
 cb.fill=GridBagConstraints.BOTH;
 Vida= new Canvas();
 cb.weightx=1.0;
 cb.weighty=1.0;
 Vida.setBackground(Color.BLACK);
 frame.add(Vida,cb);
 cb.weightx=0.0;
 cb.weighty=0.0;
 //------------------
 cb.gridx=6;
 cb.gridy=0;
 cb.gridwidth=1;
 cb.gridheight=1;
 cb.fill=GridBagConstraints.NONE;
 LDIM= new JLabel("Dimension:",SwingConstants.CENTER);
 //c.weightx=1.0;
 //c.weighty=1.0;
 frame.add(LDIM,cb);
 cb.weightx=0.0;
 cb.weighty=0.0;
 //--------------
 cb.gridx=7;
 cb.gridy=0;
 cb.gridwidth=1;
 cb.gridheight=1;
 cb.fill=GridBagConstraints.HORIZONTAL;
 TDIM= new TextField("200");
 //c.weightx=1.0;
//	c.weighty=1.0;
 frame.add(TDIM,cb);
 cb.weightx=0.0;
 cb.weighty=0.0;
 //-----------------
 cb.gridx=6;
 cb.gridy=1;
 cb.gridwidth=1;
 cb.gridheight=1;
 LGeneraciones= new JLabel("Generaciones: ",SwingConstants.CENTER);
 //c.weightx=1.0;
 //c.weighty=1.0;
 frame.add(LGeneraciones,cb);
 cb.weightx=0.0;
 cb.weighty=0.0;
 //-------------
 cb.gridx=7;
 cb.gridy=1;
 cb.gridwidth=1;
 cb.gridheight=1;
 TGeneraciones= new TextField("500");
 //c.weightx=1.0;
 //c.weighty=1.0;
 frame.add(TGeneraciones,cb);
 cb.weightx=0.0;
 cb.weighty=0.0;
 //---------------
 cb.gridx=6;
 cb.gridy=2;
 cb.gridwidth=1;
 cb.gridheight=1;
 cb.fill=GridBagConstraints.BOTH;
 LAlfa= new JLabel("Alfa: ",SwingConstants.CENTER);
 //c.weightx=1.0;
 //c.weighty=1.0;
 frame.add(LAlfa,cb);
 cb.weightx=0.0;
 cb.weighty=0.0;
 //----------
 cb.gridx=7;
 cb.gridy=2;
 cb.gridwidth=1;
 cb.gridheight=1;
 TAlfa= new TextField ();
 //c.weightx=1.0;
 //c.weighty=1.0;
 frame.add(TAlfa,cb);
 cb.weightx=0.0;
 cb.weighty=0.0;
 //-----------------
 /**
 c.gridx=7;
 c.gridy=2;
 c.gridwidth=1;
 c.gridheight=1;
 CFrontera= new JComboBox<>(front);
 //c.weightx=1.0;
 //c.weighty=1.0;
 frame.add(CFrontera,c);
 c.weightx=0.0;
 c.weighty=0.0;
 *///----------------------
 cb.gridx=6;
 cb.gridy=3;
 cb.gridwidth=1;
 cb.gridheight=1;
 cb.fill=GridBagConstraints.HORIZONTAL;

 LBeta= new JLabel("Beta",SwingConstants.CENTER);
 //c.weightx=1.0;
 //c.weighty=1.0;
 frame.add(LBeta,cb);
 cb.weightx=0.0;
 cb.weighty=0.0;
//-------------------
cb.gridx=7;
cb.gridy=3;
cb.gridwidth=1;
cb.gridheight=1;
TBeta= new TextField ();
//c.weightx=1.0;
//c.weighty=1.0;
frame.add(TBeta,cb);
cb.weightx=0.0;
cb.weighty=0.0;
 //---------------------
 cb.gridx=6;
 cb.gridy=4;
 cb.gridwidth=1;
 cb.gridheight=1;
 LGamma= new JLabel("Gamma",SwingConstants.CENTER);
 //c.weightx=1.0;
 //c.weighty=1.0;
 frame.add(LGamma,cb);
 cb.weightx=0.0;
 cb.weighty=0.0;

//---------
cb.gridx=7;
cb.gridy=4;
cb.gridwidth=1;
cb.gridheight=1;
TGamma= new TextField ();
//c.weightx=1.0;
//c.weighty=1.0;
frame.add(TGamma,cb);
cb.weightx=0.0;
cb.weighty=0.0;
 //--------------------
 cb.gridx=6;
 cb.gridy=5;
 cb.gridwidth=2;
 cb.gridheight=1;
 cb.fill=GridBagConstraints.BOTH;
 Start= new JButton("Start");
 //c.weightx=1.0;
 //c.weighty=1.0;
 frame.add(Start,cb);
 cb.weightx=0.0;
 cb.weighty=0.0;
 //----------
Vida2D=(Graphics2D)Vida.getGraphics();
Vida2D.setBackground(Color.WHITE);
       //Curva2D=(Graphics2D)Curva.getGraphics();
       //Curva2D.setBackground(Color.WHITE);
 frame.pack();
}

public static void main(String[] args){
  frame.getContentPane().setLayout(new GridBagLayout());
  Marco();
  Grafico();
  Boton();
}
}
