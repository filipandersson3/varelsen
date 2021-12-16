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
             super.checkNeighbours(creatures)) {
            System.out.print(" " + neighbour.getX()+ " " + neighbour.getY() + " ");
        }
        if (super.checkNeighbours(creatures).size() > 0) {
            super.checkNeighbours(creatures).get(0).kill();
        } else {
            int r = (int)(Math.random()*3);
            if (r == 0) {
                super.setY(super.getY()-1); //bajs ändra
            }
            if (r == 1) {
                super.setX(super.getX()+1);
            }
            if (r == 2) {
                super.setY(super.getY()+1);
            }
            if (r == 3) {
                super.setX(super.getX()-1);
            }
        }

        //x = checkNeighbours(creatures).get(1).getX();
        //y = checkNeighbours(creatures).get(1).getY();

        System.out.println("");
        System.out.println("my name" + super.getX() + " " + super.getY());

    }
}
