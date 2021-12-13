package Shapes;

/**
 * 2D point in screen coordinates
 * Created 2021-03-31
 *
 * @author Magnus Silverdal
 */
public class Point extends Shape{
    private int x;
    private int y;
    private int color = 0x00ff00;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
