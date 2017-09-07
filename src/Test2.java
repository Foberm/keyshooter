import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

public class Test2  {

    public Test2() {
       createWindow();
    }

    static int x=1;
    static JWindow window;
    private void createWindow() {
         window = new JWindow(){
        	@Override
        	public void paint(Graphics g) {
        		super.paint(g);
        		g.fillOval(x, 0, 50, 50);

        	}
        };
        window.setBackground(new Color(0, 0, 0, 0));
        window.setSize(new Dimension(1920, 500));
        window.setAlwaysOnTop(true);
        window.setLocation(0, 1080-500);
        window.setVisible(true);

    }


    public static void main(String[] Args) {

                new Test2();


       	while (true) {
			window.repaint();
			x+=10;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }

    @SuppressWarnings("unused")
    private static final Logger LOG = Logger.getLogger(Test2.class
            .getName());
}