package SimulationModel;

import Shapes.Point;
import Shapes.Shape;
import Shapes.Sprite;

/**
 * This is a class
 * Created 2021-11-15
 *
 * @author Magnus Silverdal
 */
public class Creature {
    private int x;
    private int y;

    public Creature(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Shape getShape() {
        return new Point(x,y,0x0000ff);
    }

    public Sprite getSprite() {
        return null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void update(Creature[] creatures) {

    }
}
