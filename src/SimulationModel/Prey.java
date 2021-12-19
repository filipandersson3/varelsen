package SimulationModel;

import java.util.ArrayList;

/**
 * This is a class
 * Created 2021-11-15
 *
 * @author Magnus Silverdal
 */
public class Prey extends Creature {
    private int color = 0x0000ff;


    public Prey(int x, int y) {
        super(x,y);
        super.setColor(color);
    }

    public void update(ArrayList<Creature> creatures) {
        if (checkNeighbours(creatures).size() > 0) {
            for (int i = 0; i<checkNeighbours(creatures).size(); i++) {
                if (checkNeighbours(creatures).get(i).getClass() == Plant.class) {
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
