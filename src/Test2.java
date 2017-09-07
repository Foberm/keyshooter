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
       createWindow("correct opaque", false);
    }



    private JLabel createLabel(final boolean opaque) {
        JLabel but = new JLabel("Testing") {

            /**
             * @inherited <p>
             * Overridden to take over background painting with
             * transparent color.
             */
            @Override
            protected void paintComponent(Graphics g) {
                if (!isOpaque() && getBackground().getAlpha() < 255) {
                    g.setColor(getBackground());
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
                super.paintComponent(g);
            }

        };
        but.setBackground(new Color(0, 0, 0, 0));
        but.setForeground(new Color(70, 155, 255));
        but.setOpaque(opaque);
        return but;
    }
    static Shoot game;
    static int x=1;
    static JWindow window;
    private void createWindow(String text, boolean opaque) {
         window = new JWindow(){
        	@Override
        	public void paint(Graphics g) {
        		super.paint(g);
        		Graphics2D g2d = (Graphics2D) g;
        		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        				RenderingHints.VALUE_ANTIALIAS_ON);
        		g.fillOval(x, 10, 30, 30);

        	}
        };
        game = new Shoot();
       // window.setLayout(null);
       // window.add(game);
        window.setOpacity(1f);
        window.setBackground(new Color(0, 0, 0, 0));
        window.setSize(new Dimension(300, 100));
        window.setAlwaysOnTop(true);

        window.setLocation(800, 600);
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