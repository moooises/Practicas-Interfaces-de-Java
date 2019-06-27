import java.awt.*;
import javax.swing.*;

public class Dibujo extends Canvas{
	public Dibujo(){
	setBackground(Color.decode("#FFFF00"));
	}
	
	public void paint(Graphics g){
		g.setColor(Color.PINK);
		g.fillRect(10,10,10,10);
	}
}