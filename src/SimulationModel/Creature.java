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
    private int color = 0xff0000;
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

    public void update(ArrayList<Creature> creatures) {
        for (Creature neighbour:
             checkNeighbours(creatures)) {
            System.out.print(" " + neighbour.getX()+ " " + neighbour.getY() + " ");
        }
        if (checkNeighbours(creatures).size() > 0) {
            checkNeighbours(creatures).get(0).kill();
        }

        //x = checkNeighbours(creatures).get(1).getX();
        //y = checkNeighbours(creatures).get(1).getY();

        System.out.println("");
        System.out.println("my name" + x + " " + y);

    }

    private ArrayList<Creature> checkNeighbours(ArrayList<Creature> creatures) {
        ArrayList<Creature> creaturesNear = new ArrayList<>();
        for (Creature c:
                creatures) {
            for (int i = 1; i < 10; i++) {
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
}
