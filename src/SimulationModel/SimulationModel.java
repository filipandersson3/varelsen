package SimulationModel;

import Shapes.Scene;
import Shapes.Shape;

import java.util.ArrayList;

/**
 * This is a class
 * Created 2021-10-18
 *
 * @author Magnus Silverdal
 */
public class SimulationModel {
    Scene scene;
    int width;
    int height;
    ArrayList<Creature> creatures = new ArrayList<>();
    public SimulationModel(int width, int height) {
        this.width = width;
        this.height = height;
        creatures.add(0, new Creature(5, 7));
        creatures.add(1, new Creature(4, 7));
    }
    public void update() {

    }

    public ArrayList<Shape> getShapes() {
        ArrayList<Shape> shapes = new ArrayList<>();
        for (Creature c:
                creatures) {
            shapes.add(c.getShape());
        }
        return shapes;
    }

    public ArrayList<Creature> getCells() {
        return creatures;
    }

    public int getWidth() {
        return width;
    }
}
