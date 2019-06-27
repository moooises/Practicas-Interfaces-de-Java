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


class tumoralGrowth{


  public static JMenuBar BarraMenu;
  public static JMenu mFile,mFAutomata,mFTuring;
  public static JMenuItem P1,P2,mAbout,mHelp;
  public static GridBagConstraints cb = new GridBagConstraints();
//  public static JComboBox<String> CFrontera;
  public static JButton Start,Stop;
  public static TextField TGeneraciones,TCELL,TPp,TPq,TPm,TNP,TPs;
  public static JLabel LGeneraciones,LCELL,LPp,LPm,LNP,LPs,LSeed;
  public static JFrame frame= new JFrame();
  public static JComboBox<String> TSeed;


  public static Canvas Tumor;//Para pintar concurrentemente usar cyclerBArrier para indicar que todos los hilos han terminado de calcular
  public static Graphics2D Tumor2D;
  public static Canvas Curva;
  public static Graphics2D Curva2D;
  public static int Generaciones;
  public static String[] seed={"1 Celula Central","2 Celulas Random"};

  public static int X1,X2;
  public static double Y1,Y2;

  public static int[][][] celulas;
  public static int[][] celulasP;

  public static int p=0;
  public static int q=1;
  public static int nCells;
  public static double Ps,Pd,Pm,Pp,NP;
  public static int [] poblacion;




  public static void setup(String s){
    Random rd=new Random();

    celulas= new int[nCells][nCells][2];//usamo una matriz de 3D en lugar de 2 de 2D
    celulasP= new int[nCells][nCells];
    switch(s){
      case "1 Celula Central": celulas[nCells/2][nCells/2][p]=1;break;
      case "2 Celulas Random":
          int x1=rd.nextInt(nCells);
          int y1=rd.nextInt(nCells);
          int x2=rd.nextInt(nCells);
          int y2=rd.nextInt(nCells);
          celulas[x1][y1][p]=1;
          celulas[x2][y2][p]=1;
          break;
      }//meter mas casos en JComboBox

  }


public static void compute(int h){//esto sera el metodo run
  Random rd=new Random();

for(int i=0;i<nCells;++i){
  for(int j=0;j<nCells;++j){
    celulas[i][j][q]=celulas[i][j][p];//intercabiamos la matriz
    }
  }


  for(int i=0;i<nCells;++i){
    for(int j=0;j<nCells;++j){
      if(celulas[i][j][p]==1){//si esta muerta no podemos hacer nada
        double rr=rd.nextDouble();
        if(rr<Ps){//si rr en menor que la probabilidad de supervivencia sobrevive
          int PH=0;
          boolean proliferacion=true;
          double rp=rd.nextDouble();//
          double[] P= probabilidades(i,j);//Calcula las probablidades de ploriferacion o migracion de la celula[i][j]
          int x=i;
          int y=j;
          if(0<=rp && rp<=P[0]){
            x=i-1;
            y=j;
          }
          else{
            if(P[0]<rp && rp<=P[0]+P[1]){
              x=i+1;
              y=j;
            }
            else{
              if(P[0]+P[1]<rp && rp<=P[0]+P[1]+P[2]){
                x=i;
                y=j-1;
              }
              else{
                if(P[0]+P[1]+P[2]<rp && rp<=1){
                  x=i;
                  y=j+1;
                }
              }
            }
          }

          while(PH!=NP && proliferacion){
            double rrp=rd.nextDouble();
            if(rrp>=Pp){// si rrp>=Rp no prolifera
              proliferacion=false;
              double rrm=rd.nextDouble();
              if(rrm<Pm){// si rrm<Pm migra
                celulas[i][j][q]=0;
                if(x>=0 && nCells>x && y>=0 && nCells>y){celulas[x][y][q]=1;}
                else{celulas[i][j][q]=1;}
              }
              else{celulas[i][j][q]=1;}
            }
            else{PH++;}
          }

          if(proliferacion){
            celulas[i][j][q]=1;
          if(x<0 || nCells-1<x || y<0 || nCells-1<y){/** no ocurre nada*/}
            else{celulas[x][y][q]=1;}
          }
        }
        else{celulas[i][j][q]=0;}
      }
        celulasP[i][j]=celulas[i][j][q];
                if(celulasP[i][j]==1)    poblacion[h]++;
      }
    }



  }

  public static double[] probabilidades(int x, int y){
    double P1,P2,P3,P4,denominador;
    if(x==0){
      if(y==0){
        denominador=4-celulas[x+1][y][p]-celulas[x][y+1][p];
        P1=1/denominador;
        P2=(1-celulas[x+1][y][p])/denominador;
        P3=1/denominador;
        P4=(1-celulas[x][y+1][p])/denominador;
      }else{
        if(y==nCells-1){
          denominador=4-celulas[x+1][y][p]-celulas[x][y-1][p];
          P1=1/denominador;
          P2=(1-celulas[x+1][y][p])/denominador;
          P3=(1-celulas[x][y-1][p])/denominador;
          P4=1/denominador;
        }else{
          denominador=4-celulas[x+1][y][p]-celulas[x][y+1][p]-celulas[x][y-1][p];
          P1=1/denominador;
          P2=(1-celulas[x+1][y][p])/denominador;
          P3=(1-celulas[x][y-1][p])/denominador;
          P4=(1-celulas[x][y+1][p])/denominador;
        }
      }
    }else{
      if(x==nCells-1){
        if(y==0){
          denominador=4-celulas[x-1][y][p]-celulas[x][y+1][p];
          P1=(1-celulas[x-1][y][p])/denominador;
          P2=1/denominador;
          P3=1/denominador;
          P4=(1-celulas[x][y+1][p])/denominador;
        }else{
          if(y==nCells-1){
            denominador=4-celulas[x-1][y][p]-celulas[x][y-1][p];
            P1=(1-celulas[x-1][y][p])/denominador;
            P2=1/denominador;
            P3=(1-celulas[x][y-1][p])/denominador;
            P4=1/denominador;
          }else{
            denominador=4-celulas[x-1][y][p]-celulas[x][y+1][p]-celulas[x][y-1][p];
            P1=(1-celulas[x-1][y][p])/denominador;
            P2=1/denominador;
            P3=(1-celulas[x][y-1][p])/denominador;
            P4=(1-celulas[x][y+1][p])/denominador;
          }
        }
    }else{
        if(y==0){
            denominador=4-celulas[x+1][y][p]-celulas[x-1][y][p]-celulas[x][y+1][p];
            P1=(1-celulas[x-1][y][p])/denominador;
            P2=(1-celulas[x+1][y][p])/denominador;
            P3=1/denominador;
            P4=(1-celulas[x][y+1][p])/denominador;
        }else{
          if(y==nCells-1){
            denominador=4-celulas[x+1][y][p]-celulas[x-1][y][p]-celulas[x][y-1][p];
            P1=(1-celulas[x-1][y][p])/denominador;
            P2=(1-celulas[x+1][y][p])/denominador;
            P3=(1-celulas[x][y-1][p])/denominador;
            P4=1/denominador;
          }else{
            denominador=4-celulas[x+1][y][p]-celulas[x-1][y][p]-celulas[x][y+1][p]-celulas[x][y-1][p];
            if(denominador!=0){
              P1=(1-celulas[x-1][y][p])/denominador;
              P2=(1-celulas[x+1][y][p])/denominador;
              P3=(1-celulas[x][y-1][p])/denominador;
              P4=(1-celulas[x][y+1][p])/denominador;
            }else{
              P1=0.25;
              P2=0.25;
              P3=0.25;
              P4=0.25;
            }
          }
                }
        }
      }
    double[] P={P1,P2,P3,P4};
    return P;
  }




public static void pintar(){
  //Tumor2D.setColor(Color.BLACK);
  BufferedImage image=new BufferedImage(nCells, nCells, BufferedImage.TYPE_INT_RGB);
              for (int i=0;i<nCells ; i++)
              {
                  for(int j=0; j<nCells; j++)
                  if(celulasP[i][j]==1){image.setRGB(i,j,0x000000);}

                  else{image.setRGB(i,j,0xFFFFFF);}
              }
              Tumor2D.drawImage(image, 0, 0, Tumor.getWidth(),Tumor.getHeight(), Tumor);
  /**for(int x=0;x<nCells;++x){
    for(int y=0;y<nCells;++y){
      //System.out.println(celulasP[x][y]);
      if(celulasP[x][y]==1)
      Tumor2D.fillRect(x,y,1,1);
    }
  } */

  if(p==0){p=1;q=0;}
  else{p=0;q=1;}

}
public static void PintarCurva(int g){
  int altura=Curva.getHeight();
  int ancho=Curva.getWidth()/Generaciones;
	 //System.out.println(poblacion[g]);
  Curva2D.setColor(Color.BLUE);
  X2+=ancho;
  if(g==0){
    Y1=(double)altura;
    X2=ancho;
    X1=0;
  }
  Y2=(((double)poblacion[g]/((double)nCells*(double)nCells))*(double)altura);
  //System.out.println(Y2);

  Y2=(double)altura-Y2;
 // System.out.println("X1: "+X1+" Y1: "+Y1+" X2: "+X2+" Y2: "+Y2);
//   if((int)Y2==0)Y2=15;

  System.out.println(Y2);
  Curva2D.draw(new Line2D.Double(X1, Y1, X2,Y2));//)(X1,(int)Y1,X2,(int)Y2);
  X1=X2;
  //if((int)Y2==0)Y1=15;
 Y1=Y2;
}

public static void Boton(){
Start.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
      // public static TextField TVivas,TMuertas,TGeneraciones,TDIM;

      System.out.println("Start");

//  public static double Ps,Pd,Pm,Pp,NP;


      String generaciones,celulas,sed,sPs,sPm,sPp,sNp;
      generaciones=TGeneraciones.getText();
      sed=(String)TSeed.getSelectedItem();
      celulas=TCELL.getText();
      sPs=TPs.getText();
      sPm=TPm.getText();
      sPp=TPp.getText();
      sNp=TNP.getText();

      nCells=Integer.parseInt(celulas);

      Generaciones=Integer.parseInt(generaciones);
      poblacion= new int[Generaciones];

      Ps=Double.parseDouble(sPs);
      Pm=Double.parseDouble(sPm);
      Pp=Double.parseDouble(sPp);
      NP=Double.parseDouble(sNp);

      int X1=0;
      int X2=0;
      int Y1=Curva.getHeight();
      int Y2=0;

	    Tumor.update(Tumor.getGraphics());
      Curva.update(Curva.getGraphics());
      setup(sed);

      for(int i=0;i<Generaciones;++i){
      compute(i);
       pintar();
       PintarCurva(i);

    //   System.out.println("hay2");

          }
          System.out.println("Finish");

    }
});

Stop.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
      while(true){break;}
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
 cb.gridheight=7;
 cb.fill=GridBagConstraints.BOTH;
 Tumor= new Canvas();
 cb.weightx=1.0;
 cb.weighty=1.0;
 Tumor.setBackground(Color.WHITE);
 frame.add(Tumor,cb);
 cb.weightx=0.0;
 cb.weighty=0.0;
 //------------------
 cb.gridx=6;
 cb.gridy=0;
 cb.gridwidth=1;
 cb.gridheight=1;
 cb.fill=GridBagConstraints.NONE;
 LCELL= new JLabel("Celulas:",SwingConstants.CENTER);
 //c.weightx=1.0;
 //c.weighty=1.0;
 frame.add(LCELL,cb);
 cb.weightx=0.0;
 cb.weighty=0.0;
 //--------------
 cb.gridx=7;
 cb.gridy=0;
 cb.gridwidth=1;
 cb.gridheight=1;
 cb.fill=GridBagConstraints.HORIZONTAL;
 TCELL= new TextField("32");
 //c.weightx=1.0;
//	c.weighty=1.0;
 frame.add(TCELL,cb);
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
 LPs= new JLabel("Ps: ",SwingConstants.CENTER);
 //c.weightx=1.0;
 //c.weighty=1.0;
 frame.add(LPs,cb);
 cb.weightx=0.0;
 cb.weighty=0.0;
 //----------
 cb.gridx=7;
 cb.gridy=2;
 cb.gridwidth=1;
 cb.gridheight=1;
 TPs= new TextField ();
 //c.weightx=1.0;
 //c.weighty=1.0;
 frame.add(TPs,cb);
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

 LPm= new JLabel("Pm",SwingConstants.CENTER);
 //c.weightx=1.0;
 //c.weighty=1.0;
 frame.add(LPm,cb);
 cb.weightx=0.0;
 cb.weighty=0.0;
//-------------------
cb.gridx=7;
cb.gridy=3;
cb.gridwidth=1;
cb.gridheight=1;
TPm= new TextField ();
//c.weightx=1.0;
//c.weighty=1.0;
frame.add(TPm,cb);
cb.weightx=0.0;
cb.weighty=0.0;
 //---------------------
 cb.gridx=6;
 cb.gridy=4;
 cb.gridwidth=1;
 cb.gridheight=1;
 LPp= new JLabel("Pp",SwingConstants.CENTER);
 //c.weightx=1.0;
 //c.weighty=1.0;
 frame.add(LPp,cb);
 cb.weightx=0.0;
 cb.weighty=0.0;

//---------
cb.gridx=7;
cb.gridy=4;
cb.gridwidth=1;
cb.gridheight=1;
TPp= new TextField ();
//c.weightx=1.0;
//c.weighty=1.0;
frame.add(TPp,cb);
cb.weightx=0.0;
cb.weighty=0.0;
 //----
 cb.gridx=6;
 cb.gridy=5;
 cb.gridwidth=1;
 cb.gridheight=1;
 cb.fill=GridBagConstraints.HORIZONTAL;

 LNP= new JLabel("NP",SwingConstants.CENTER);
 frame.add(LNP,cb);
 cb.weightx=0.0;
 cb.weighty=0.0;
 //---
 cb.gridx=7;
 cb.gridy=5;
 cb.gridwidth=1;
 cb.gridheight=1;
 TNP= new TextField();
 frame.add(TNP,cb);
 cb.weightx=0.0;
 cb.weighty=0.0;
 //----
 cb.gridx=6;
 cb.gridy=6;
 cb.gridwidth=1;
 cb.gridheight=1;
 cb.fill=GridBagConstraints.HORIZONTAL;
 LSeed= new JLabel("Seed",SwingConstants.CENTER);
 frame.add(LSeed,cb);
 cb.weightx=0.0;
 cb.weighty=0.0;
 //---
 cb.gridx=7;
 cb.gridy=6;
 cb.gridwidth=1;
 cb.gridheight=1;
 cb.fill=GridBagConstraints.HORIZONTAL;
 TSeed= new JComboBox<>(seed);
 frame.add(TSeed,cb);
 cb.weightx=0.0;
 cb.weighty=0.0;

 //--------------------
 cb.gridx=6;
 cb.gridy=7;
 cb.gridwidth=1;
 cb.gridheight=1;
 cb.fill=GridBagConstraints.HORIZONTAL;
 Start= new JButton("Start");
 //c.weightx=1.0;
 //c.weighty=1.0;
 frame.add(Start,cb);
 cb.weightx=0.0;
 cb.weighty=0.0;
//-----------
cb.gridx=7;
cb.gridy=7;
cb.gridwidth=1;
cb.gridheight=1;
cb.fill=GridBagConstraints.HORIZONTAL;
Stop= new JButton("Stop");
//c.weightx=1.0;
//c.weighty=1.0;
frame.add(Stop,cb);
cb.weightx=0.0;
cb.weighty=0.0;
 //----------
 cb.gridx=0;
 cb.gridy=9;
 cb.gridwidth=8;
 cb.gridheight=10;
 cb.fill=GridBagConstraints.BOTH;
 Curva= new Canvas();
 cb.weightx=1.0;
 cb.weighty=1.0;
 Curva.setBackground(Color.WHITE);
 frame.add(Curva,cb);
 cb.weightx=0.0;
 cb.weighty=0.0;
 //----------
Tumor2D=(Graphics2D)Tumor.getGraphics();
Tumor2D.setBackground(Color.WHITE);
Curva2D=(Graphics2D)Curva.getGraphics();
Curva2D.setBackground(Color.WHITE);
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
