package SimulationModel;

import java.util.ArrayList;

/**
 * This is a class
 * Created 2021-11-15
 *
 * @author Magnus Silverdal
 */
public class Plant extends Creature {
    private int color = 0x00ff00;


    public Plant(int x, int y) {
        super(x,y);
        super.setColor(color);
    }

    public void update(ArrayList<Creature> creatures) {
    }
}
