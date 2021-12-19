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
public class Predator extends Creature {
    private int color = 0xff0000;


    public Predator(int x, int y) {
        super(x,y);
        super.setColor(color);
    }

    public void update(ArrayList<Creature> creatures) {
        for (Creature neighbour:
             checkNeighbours(creatures)) {
            System.out.print(" " + neighbour.getX()+ " " + neighbour.getY() + " baba");
        }
        System.out.println("");
        System.out.println("my name" + super.getX() + " " + super.getY());
        if (checkNeighbours(creatures).size() > 0) {
            Creature target = checkNeighbours(creatures).get(0);
            super.setX(target.getX());
            super.setY(target.getY());
            target.kill();
        } else {
            moveRandom();
        }

    }
}
