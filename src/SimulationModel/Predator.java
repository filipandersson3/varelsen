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
            for (int i = 0; i<checkNeighbours(creatures).size(); i++) {
                if (checkNeighbours(creatures).get(i).getClass() == Predator.class ||
                        checkNeighbours(creatures).get(i).getClass() == Prey.class) {
                    Creature target = checkNeighbours(creatures).get(i);
                    super.setX(target.getX());
                    super.setY(target.getY());
                    target.kill();
                    break;
                }
            }
            moveRandom();
        } else {
            moveRandom();
        }

    }
}
