import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import figuras.*;

public class Main {
    public static void main (String[] args) {
        new MainFrame();
    }
}

class MainFrame extends JFrame {
    protected final int WIDTH = 640;
    protected final int HEIGHT = 640;
    ArrayList<Figure> figs = new ArrayList<>();
    Random rand = new Random();
    Point prevPt;
    public MainFrame () {
        this.addWindowListener (
                new WindowAdapter() {
                    public void windowClosing (WindowEvent e) {
                        System.exit(0);
                    }
                }
        );

        this.addKeyListener (
                new KeyAdapter() {
                    public void keyPressed (KeyEvent evt) {
                        int x = rand.nextInt(600);
                        int y = rand.nextInt(600);
                        int w = 100;
                        int h = 100;
                        if (evt.getKeyChar() == 'r')
                        {
                            Rect2D r = new Rect2D(x,y, w,h, Color.BLACK,Color.CYAN);
                            figs.add(r);
                        }
                        else if (evt.getKeyChar() == 'e')
                        {
                            Ellipse e = new Ellipse(x, y, w, h, Color.BLACK, Color.GREEN);
                            figs.add(e);
                        }
                        repaint();

                    }
                }
        );

        this.addMouseListener (
                new MouseAdapter() {
                    public void mousePressed (MouseEvent evt) {
                        prevPt = evt.getPoint();
                        System.out.println("prev"+prevPt);
                    }
                }
        );
        this.addMouseMotionListener(
                new MouseAdapter() {
                    public void mouseDragged(MouseEvent evt)
                    {
                        Graphics g = getGraphics();
                        Point currentPt = evt.getPoint();
                        System.out.println("current"+currentPt);
                        for (Figure fig: figs) {
                            if(fig.clicked((int)prevPt.getX(), (int)prevPt.getY()))
                            {
                                fig.drag((int) (currentPt.getX()-prevPt.getX()), (int)(currentPt.getY()-prevPt.getY()));
                            }
                        }
                        prevPt = currentPt;
                        repaint();
                        g.dispose();
                    }

                }
        );

        this.setTitle("Editor Gráfico");
        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);

    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setBackground(Color.white);
        g2d.clearRect(0, 0, getWidth(), getHeight());

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        for (Figure fig: this.figs) {
            fig.paint(g);
        }

    }

}




