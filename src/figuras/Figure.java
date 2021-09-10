package figuras;
import java.awt.*;


public abstract class Figure implements IVisible{
    protected int x, y, h, w;
    protected Color c, bkg;
    public Figure(int x, int y, int w, int h, Color c, Color bkg)
    {
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
        this.c = c;
        this.bkg = bkg;
    }

    public boolean clicked(int x, int y) {
        return (this.x<=x && x<=this.x+this.w && this.y<=y && y<=this.y+this.h);
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    public int getWidth()
    {
        return this.w;
    }

    public int getHeight()
    {
        return this.h;
    }

    public void drag(int dx, int dy)
    {
        this.x += dx;
        this.y += dy;
    }

}
