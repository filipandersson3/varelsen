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
    int width = 200;
    int height = 200;
    Cell[] cells = new Cell[width*height];
    public SimulationModel() {
        for (int i = 0; i < cells.length; i++) {
            cells[i] = new Cell(i%width,(i/width),Math.random()>=0.5);
        }
    }
    public void update() {
        for (Cell cell:
             cells) {
            cell.update(cells,width);
        }
        for (Cell cell:
             cells) {
            cell.stateUpdate();
        }
    }

    public ArrayList<Shape> getShapes() {
        ArrayList<Shape> shapes = new ArrayList<>();
        for (Cell c:
             cells) {
            if (c.state()) {
                shapes.add(c.getShape());
            }
        }
        return shapes;
    }
}
