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
    ArrayList<Creature> creatureGarbageList = new ArrayList<>();
    public SimulationModel(int width, int height) {
        this.width = width;
        this.height = height;
        creatures.add(0, new Creature(5, 7));
        creatures.add(1, new Creature(4, 7));
    }
    public void update() {
        for (Creature c:
             creatures) {
            c.update(creatures);
        }
        for (Creature c:
                creatures) {
            if (c.isDead()) {
                System.out.println(c.getX() + " " + c.getY() + " is dead not big surprise");
                creatureGarbageList.add(c);
                System.out.println("deleting...");
            }
        }

        for (Creature g:
                creatureGarbageList) {
            creatures.remove(g);
            System.out.println(g.getX() + " in garbage");
        }
        creatureGarbageList.clear();


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
