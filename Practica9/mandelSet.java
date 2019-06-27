import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import java.util.concurrent.*;

public class mandelSet extends JFrame implements Runnable {
  private final int MAX_ITER = 10000;
  private final double ZOOM = 150;
  private BufferedImage Imagen;
  private int limitInf,limitSup;
  private double zx, zy, cX, cY, tmp;
  public CyclicBarrier barrier;


  public void run(){
    compute();
    try{
    barrier.await();
  }catch(Exception ex){}
  }

  public mandelSet(int limitInf,int limitSup){
    this.limitInf=limitInf;
    this.limitSup=limitSup;
  }


  public mandelSet() {
   super("Conjunto de Mandelbrot");
   setBounds(100, 100, 800, 600);
   setResizable(false);
   setDefaultCloseOperation(EXIT_ON_CLOSE);
   Imagen = new BufferedImage(getWidth(), getHeight(),BufferedImage.TYPE_INT_RGB);

   int nTareas=Runtime.getRuntime().availableProcessors();

   barrier= new CyclicBarrier(nTareas);

   ThreadPoolExecutor pool= new ThreadPoolExecutor(nTareas,nTareas,0L,TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
   int tVentana=getHeight()/nTareas;
   if(tVentana==0){
   tVentana=getHeight();
   nTareas=1;
   }
   int linf=0;
   int lsup=tVentana;

   for(int j=0;j<nTareas;++j){
       if(lsup>getHeight())lsup=getHeight();
       pool.execute(new mandelSet(linf,lsup));
       linf=lsup;
       lsup+=tVentana;
     }

 //System.out.println("hay2");
 pool.shutdown();
 try{
 pool.awaitTermination(2, TimeUnit.SECONDS);
 }catch(Exception ex){}

}

  public void compute(){
    for (int y = limitInf; y < limitSup; y++) {
      for (int x = 0; x < getWidth(); x++) {
            zx = zy = 0;
            cX = (x - 400) / ZOOM;//los que empiezan por C son los numeros complejos
            cY = (y - 300) / ZOOM;
            int iter = MAX_ITER;
            while (zx * zx + zy * zy < 4 && iter > 0) {// es 4 porque en este caso es una matriz, en el pdf es un vector
                  tmp = zx * zx - zy * zy + cX;
                  zy = 2.0 * zx * zy + cY;
                  zx = tmp;
                  iter--;
            }
            Imagen.setRGB(x, y, iter | (iter << 8));// << lo que hace es añadir 0 por la derecha al numero en binario de iter y hacer la operacion or
      }
    }//aqui finaliza la rutina a paralelizar
  }

  public void paint(Graphics g){
    g.drawImage(Imagen, 0, 0, this);
  }
  public static void main(String[] args) {
  	  new Mandelbrot().setVisible(true);
  }
}
