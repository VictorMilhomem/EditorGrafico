package figuras;
import java.awt.*;


public class Rect2D extends Figure
{
    public Rect2D(int x, int y, int w, int h, Color c, Color bkg, boolean selected)
    {
        super(x, y, w, h, c, bkg, selected);
    }

    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;

        // background
        g2d.setPaint(this.bkg);
        g2d.fillRect(this.x, this.y, this.w, this.h);

        // contorno
        g2d.setPaint(this.c);
        g2d.drawRect(this.x, this.y, this.w, this.h);
    }


}