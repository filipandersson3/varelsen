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

    public void update(ArrayList<Creature> creatures) {
        for (Creature neighbour:
             checkNeighbours(creatures)) {
            System.out.print(" " + neighbour.getX()+ " " + neighbour.getY() + " ");
        }
        System.out.println("");

    }

    private ArrayList<Creature> checkNeighbours(ArrayList<Creature> creatures) {
        ArrayList<Creature> creaturesNear = new ArrayList<>();
        for (Creature c:
                creatures) {
            for (int i = 0; i < 9; i++) {
                if (c.getX() == x+i%3 && c.getY() == y+i/3) {
                    if (!(c.getX() == x && c.getY() == y))
                    creaturesNear.add(c);
                }
            }
        }
        return creaturesNear;
    }
}
