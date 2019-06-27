import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;

public class Entriopia{

		public static String[] colores={"#000000","#000080","#008000","#008080","#00FF00","#00FFFF","#800000","#800080","#808000","#808080","#C0C0C0","#FF0000","#FF00FF","#FFFF00","#FA58D0","#FFFFFF"};
		public static double [][]EN;
		public static GridBagConstraints e = new GridBagConstraints();
		public static JFrame Entri = new JFrame("Curva de Entriopia Espacial");
		public static JLabel EntriopiaMedia,Temp;
		public static JTextField Media,temp;//Reservado para el lugar donde mostrar el valor medio--//public static 
		public static JButton BTemp;
		public static Canvas En;
		public static Graphics2D En2D;
		public static double X,Y,I,Z;
		public static int gen,est;
		public static double total;
		
		
		public Entriopia(double [][]M,int est, int gen){
			this.gen=gen;
			this.est=est;
			EN= new double[gen][est];
			EN=M;
			Entri.setLocationRelativeTo(null);
			Entri.setVisible(true);
			Entri.setLayout(new GridBagLayout());
			CrearFrame();
			Entri.setMinimumSize(new Dimension(800, 600)); 
			En2D=(Graphics2D)En.getGraphics();
			Pintar();
			//media();?????
			//Media.setText(Double.toString(W));
		}
		
		public static void CrearFrame(){
			e.gridx=0;
			e.gridy=0;
			e.gridwidth=3;
			e.gridheight=2;
			e.fill=GridBagConstraints.BOTH;
			En= new Canvas();
			e.weightx=1.0;
			e.weighty=1.0;
			En.setBackground(Color.decode("#F5FFFA"));
			Entri.add(En,e);
			e.weightx=0.0;
			e.weighty=0.0;
		//-----------
			e.gridx=0;
			e.gridy=3;
			e.gridwidth=1;
			e.gridheight=1;
			e.fill=GridBagConstraints.BOTH;
			EntriopiaMedia= new JLabel("Entriopia Media: ");
			Entri.add(EntriopiaMedia,e);
			e.weightx=0;
			e.weighty=0;
		//-------------
			e.gridx=1;
			e.gridy=3;
			e.gridwidth=2;
			e.gridheight=1;
			e.fill=GridBagConstraints.BOTH;
			Media= new JTextField();//String valor=""; Media.setText(valor); 
			Entri.add(Media,e);
			e.weightx=0;
			e.weighty=0;
			//-----
			e.gridx=0;
			e.gridy=4;
			e.gridwidth=1;
			e.gridheight=1;
			e.fill=GridBagConstraints.BOTH;
			Temp= new JLabel("Entripia Tempora:");//String valor=""; Media.setText(valor); 
			Entri.add(Temp,e);
			e.weightx=0;
			e.weighty=0;
			//----
			e.gridx=1;
			e.gridy=4;
			e.gridwidth=1;
			e.gridheight=1;
			e.fill=GridBagConstraints.BOTH;
			temp= new JTextField();//String valor=""; Media.setText(valor); 
			Entri.add(temp,e);
			e.weightx=0;
			e.weighty=0;
			//----
			e.gridx=2;
			e.gridy=4;
			e.gridwidth=1;
			e.gridheight=1;
			e.fill=GridBagConstraints.BOTH;
			BTemp= new JButton("Calcular");//String valor=""; Media.setText(valor); 
			Entri.add(BTemp,e);
			e.weightx=0;
			e.weighty=0;
		}
		
		public static void Pintar(){
			double aux=0;
			for(int j=0;j<gen;++j){
			X=I;
			Y=Z;
			if(j!=0){
				I=I+10;
				//Y=-1*aux;
				aux=0;
				for(int i=0;i<est;++i){

					int c=i%16;
					aux+=(EN[j][i]*(Math.log(EN[j][i])/Math.log(2)));
					//System.out.println("En: "+EN[j][i]+" Pr: "+EN[j][i]*(Math.log(EN[j][i])/Math.log(2)));
					if(i==est-1){
					Z=-1*aux;
										System.out.println("Y: "+Y+" Z: "+Z);

					En2D.setColor(Color.decode(colores[c]));
					En2D.draw(new Line2D.Double(X, Y, I, Z));
					total+=Z;
					//En2D.drawLine(X,Y,I,Z);
										}
		
		try{
			Thread.sleep(1);
		}catch(Exception ex){}


				}
			
			
			}
					}
		Z=Z/(double)gen;			
		Media.setText(Double.toString(Z));
		I=0;
		Z=0;
		}
		
		
		
}