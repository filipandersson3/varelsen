package SimulationModel;

import Shapes.Scene;
import Shapes.Shape;
import Shapes.Sprite;

import java.util.ArrayList;

/**
 * This is a class
 * Created 2021-10-18
 *
 * @author Magnus Silverdal
 */
public class SimulationModel {
    Scene scene;
    int width = 10;
    int height = 10;
    Cell[] cells = new Cell[width*height];
    public SimulationModel() {
        for (int i = 0; i < cells.length; i++) {
            cells[i] = new Cell(i%width,(i/width),Math.random()>=0.5);
        }
        cells[11] = new Cell(1,1, true);
        cells[12] = new Cell(2,1, true);
        cells[13] = new Cell(3,1, true);

    }
    public void update() {
        for (Cell cell:
             cells) {
            cell.setNeighbours(0);
            if (cellStateAt(cell.getX()-1, cell.getY()-1)) { //cell up and to left
                cell.setNeighbours(cell.getNeighbours()+1);
            }
            if (cellStateAt(cell.getX(),cell.getY()-1)) { //cell up
                cell.setNeighbours(cell.getNeighbours()+1);
            }
            if (cellStateAt(cell.getX()+1,cell.getY()-1)) { //cell up and to right
                cell.setNeighbours(cell.getNeighbours()+1);
            }
            if (cellStateAt(cell.getX()-1,cell.getY())) { //cell to left
                cell.setNeighbours(cell.getNeighbours()+1);
            }
            if (cellStateAt(cell.getX()+1,cell.getY())) { //cell to right
                cell.setNeighbours(cell.getNeighbours()+1);
            }
            if (cellStateAt(cell.getX()-1,cell.getY()+1)) { //cell below and to left
                cell.setNeighbours(cell.getNeighbours()+1);
            }
            if (cellStateAt(cell.getX(),cell.getY()+1)) { //cell below
                cell.setNeighbours(cell.getNeighbours()+1);
            }
            if (cellStateAt(cell.getX()+1,cell.getY()+1)) { //cell below and to right
                cell.setNeighbours(cell.getNeighbours()+1);
            }
            if (cell.getNeighbours() == 3) {
                cell.setNextState(true);
            } else if (cell.getNeighbours() > 3) {
                cell.setNextState(false);
            } else if (2 > cell.getNeighbours()){
                cell.setNextState(false);
            } else {
                cell.setNextState(cell.state());
            }
        }
        for (Cell cell:
             cells) {
            cell.update();
        }
    }

    private boolean cellStateAt(int x, int y) {
        try {
            if (cells[(x + y * width)].state()) {
                return true;
            } else {
                return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
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
