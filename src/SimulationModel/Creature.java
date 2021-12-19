package SimulationModel;

import Shapes.Point;
import Shapes.Shape;
import Shapes.Sprite;

import java.util.ArrayList;

/**
 * This is a class
 * Created 2021-11-15
 *
 * @author Magnus Silverdal
 */
public abstract class Creature {
    private int x;
    private int y;
    private int color = 0xffffff;
    private boolean dead = false;

    public Creature(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Shape getShape() {
        return new Point(x,y,color);
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ArrayList<Creature> checkNeighbours(ArrayList<Creature> creatures) {
        ArrayList<Creature> creaturesNear = new ArrayList<>();
        for (Creature c:
                creatures) {
            for (int i = 0; i < 9; i++) {
                if (c.getX() == x-1+i%3 && c.getY() == y-1+i/3) {
                    if (!(c.getX() == x && c.getY() == y)) {
                        creaturesNear.add(c);
                    }
                }
            }
        }
        return creaturesNear;
    }

    public void kill() {
        dead = true;
    }

    public boolean isDead() {
        return dead;
    }

    public abstract void update(ArrayList<Creature> creatures);

    public void setColor(int color) {
        this.color = color;
    }

    public void moveRandom() {
        int rx = (int)(Math.random()*3)-1;
        int ry = (int)(Math.random()*3)-1;
        x=x+rx;
        y=y+ry;
    }
}
