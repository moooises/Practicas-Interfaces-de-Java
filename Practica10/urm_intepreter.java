import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.io.*;

class urm_intepreter{
    public static JFrame frame = new JFrame();
    public static JMenuBar BarraMenu;
    public static JMenu mFile,mFAutomata,mFTuring;
    public static JMenuItem P1,P2,mAbout,mHelp;
    public static TextArea origen,destino,clave;
    public static JButton cifrar,seleccionar;
    public static GridBagConstraints c = new GridBagConstraints();

    public static JFileChooser selectorArchivos;
    public static JLabel MensajeOrig,MensajeCifrado,Clave,DesClave;

  //ArrayList<string> instrucciones;
  String filename;
//  ArrayList<Configuracion> configuraciones;
  //ArrayList<Integer> memoria = new ArrayList<Integer>();
  ArrayList<Integer> registros = new ArrayList<Integer>();
  ArrayList<Integer> valores = new ArrayList<Integer>();
  String instruccion;
  char ch;

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
   MensajeOrig = new JLabel("Introduce programa en URM: ",SwingConstants.CENTER);
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
   origen= new TextArea();
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
   Clave= new JLabel("Variables de entrada: ",SwingConstants.CENTER);
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
   clave = new TextArea();
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
   cifrar= new JButton("Resolver");
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
   MensajeCifrado= new JLabel("Resultado: ",SwingConstants.CENTER);
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
   destino= new TextArea();
   c.weightx=1.0;
   c.weighty=1.0;
   frame.add(destino,c);
   c.weightx=0.0;
   c.weighty=0.0;
   //-------
   frame.pack();
  }

 public static void Botones(){

   cifrar.addActionListener(new ActionListener(){
     public void actionPerformed(ActionEvent e){

       //memoria
       new urm_intepreter();
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
          linea=linea+aux+"\n";
         }
         origen.setText(linea);
       }catch(IOException io){}
     }catch(FileNotFoundException ex){}
                             }

   }
});

}

  public urm_intepreter(){
    String cadena=origen.getText();
    /**ArrayList<String> programa= new ArrayList<String>();
        try{
            BufferedReader lector = new BufferedReader(new FileReader("hola.urm"));
            String line;

            while ((line =lector.readLine()) != null){
                //System.out.println(line);
                programa.add(line);
              }
            lector.close();
         }catch (Exception e){}*/
         String[] lineas=cadena.split("\n");
    inicializarmemoria();//procedimiento temporal para asignar valores a la memoria
    char [] aux1;
    char [] aux2;
    char [] aux3;
    int pos1,pos2;
  //  System.out.println(programa.size());
    configurar(-1);
    for(int i=0;i<lineas.length;++i){
    instruccion=lineas[i];
    //System.out.println(i);
    //System.out.println(instruccion);
    int k,q,s;
    ch=instruccion.charAt(0);
    switch(ch){
      //ArrayList<Integer> registros = new ArrayList<Integer>();
      //ArrayList<Integer> valores = new ArrayList<Integer>();
      case 'Z': //System.out.println("Z");
                k=3;
                while(instruccion.charAt(k)!=')')++k;
                aux1= new char[k-2];
                instruccion.getChars(2,k,aux1,0);
                pos1=Integer.parseInt(new String(aux1));
                if(registros.indexOf(pos1)!=-1)valores.set(registros.indexOf(pos1),0);
                else{
                  registros.add(pos1);
                  valores.add(0);
                }
                configurar(i);
                break;

      case 'S': //System.out.println("S");
                k=3;
                while(instruccion.charAt(k)!=')')++k;
                aux1= new char[k-2];
                instruccion.getChars(2,k,aux1,0);
                pos1=Integer.parseInt(new String(aux1));
                //System.out.println("S pos1: "+pos1);
                //System.out.println("R "+registros.indexOf(pos1));
                if(registros.indexOf(pos1)!=-1)valores.set(registros.indexOf(pos1),valores.get(registros.indexOf(pos1))+1);
                else{
                  registros.add(pos1);
                  valores.add(1);
                }
                //memoria.set(pos1-1,memoria.get(pos1-1)+1);
                configurar(i);
                break;

      case 'T': //System.out.println("T");
                k=3;
                while(instruccion.charAt(k)!=',')++k;
                aux1= new char[k-2];
                instruccion.getChars(2,k,aux1,0);
                q=k+1;
                while(instruccion.charAt(q)!=')')++q;
                aux2= new char[q-k-1];
                instruccion.getChars(k+1,q,aux2,0);
                pos1=Integer.parseInt(new String(aux1));
                pos2=Integer.parseInt(new String(aux2));
                if(registros.indexOf(pos1)!=-1 && registros.indexOf(pos2)!=-1)valores.set(registros.indexOf(pos2),valores.get(registros.indexOf(pos1)));
                else{
                  if(registros.indexOf(pos1)!=-1){
                      valores.set(registros.indexOf(pos2),0);
                  }
                  else{
                    registros.add(pos2);
                    valores.add(0);
                  }
                }
                //memoria.set(pos2-1,memoria.get(pos1-1));
                configurar(i);
                break;

      case 'J': //System.out.println("J");
                k=3;
                while(instruccion.charAt(k)!=',')++k;
                aux1= new char[k-2];
                instruccion.getChars(2,k,aux1,0);
                q=k+1;
                while(instruccion.charAt(q)!=',')++q;
                aux2= new char[q-k-1];
                instruccion.getChars(k+1,q,aux2,0);
                pos1=Integer.parseInt(new String(aux1));
                pos2=Integer.parseInt(new String(aux2));
              //  System.out.println("pos1= "+pos1+" pos2= "+pos2);

                if(registros.indexOf(pos1)!=-1 && registros.indexOf(pos2)!=-1){
                  if(valores.get(registros.indexOf(pos1))==valores.get(registros.indexOf(pos2))){
                    //System.out.println("Entro aqui");
                    configurar(i);
                    s=q+1;
                    while(instruccion.charAt(s)!=')')++s;
                    aux3= new char[s-q-1];
                    instruccion.getChars(q+1,s,aux3,0);
                    i=Integer.parseInt(new String(aux3));
                    //System.out.println("antes: "+i+" longitud: "+lineas.length);

                    if(i==0 || i>lineas.length)i=lineas.length+1;
                    else{
                      i=i-2;
                      //System.out.println("despues: "+i);

                        }
                  }
                }
                else{
                  if(registros.indexOf(pos1)==-1 && registros.indexOf(pos2)!=-1){
                        if(valores.get(registros.indexOf(pos2))==0){
                        configurar(i);
                        s=q+1;
                        while(instruccion.charAt(s)!=')')++s;
                        aux3= new char[s-q-1];
                        instruccion.getChars(q+1,s,aux3,0);
                        i=Integer.parseInt(new String(aux3));
                        if(i==0 || i>=lineas.length)i=lineas.length;
                        else i=i-2;
                      }
                  }
                  else{
                      if(registros.indexOf(pos2)==-1 && registros.indexOf(pos1)!=-1){
                          if(valores.get(registros.indexOf(pos1))==0){
                          configurar(i);
                          s=q+1;
                          while(instruccion.charAt(s)!=')')++s;
                          aux3= new char[s-q-1];
                          instruccion.getChars(q+1,s,aux3,0);
                          i=Integer.parseInt(new String(aux3));
                          //System.out.println(i);
                          if(i==0 || i>=lineas.length)i=lineas.length;
                          else i=i-2;
                          }

                  }
                  else{configurar(i);}
                }
                }

                /**if(memoria.get(pos1-1)==memoria.get(pos2-1)){
                  configurar(i);
                  s=q+1;
                  while(instruccion.charAt(s)!=')')++s;
                  instruccion.getChars(q+1,s,aux2,0);
                  i=Integer.parseInt(new String(aux2));
                  if(i==0 || i>=lineas.length)i=lineas.length;
                  else i=i-2;
                }
                else{
                  configurar(i);
                }*/
                break;

      default: System.out.println("Something's wrong");
              break;



    }

                                      }
  //for(int j=0;j<memoria.size();++j)System.out.println(""+memoria.get(j)+"\n");
  configurar(lineas.length);
  destino.setText(String.valueOf(valores.get(0)));

  }

  public void configurar(int contador){
    contador=contador+1;//la primera instruccion es 1
    System.out.print("("+contador+",<");//comprobar
    String aux;
    for(int i=0;i<valores.size();++i){
      if(i==registros.size()-1)aux=" R"+registros.get(i)+" = "+valores.get(i);
      else aux=" R"+registros.get(i)+" = "+valores.get(i)+",";
        System.out.print(aux);
    }
    System.out.print(" >)");
    System.out.println();
  }

  public void inicializarmemoria(){
    String aux=clave.getText();
    String []cad=aux.split(",");
    for(int i=1;i<cad.length+1;++i){
      registros.add(i);
      valores.add(Integer.parseInt(cad[i-1]));
    }
    /**
    memoria.add(3);
    memoria.add(5);
    memoria.add(0);
    memoria.add(1);
    memoria.add(1);*/
  }

  public static void main(String []args){
    Menu();
    Grafico();
    Botones();
  }

}
