package SimulationModel;

import Shapes.Point;
import Shapes.Shape;
import Shapes.Sprite;

/**
 * This is a class
 * Created 2021-11-15
 *
 * @author Magnus Silverdal
 */
public class Cell {
    private int x;
    private int y;
    private boolean state;
    private boolean nextState;
    private int neighbours;

    public Cell(int x, int y, boolean state) {
        this.x = x;
        this.y = y;
        this.state = state;
    }

    public Shape getShape() {
        return new Point(x,y);
    }

    public void stateUpdate() {
        state = nextState;
    }

    public Sprite getSprite() {
        return null;
    }

    public boolean state() {
        return state;
    }

    public void setNextState(boolean nextState) {
        this.nextState = nextState;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getNeighbours() {
        return neighbours;
    }

    public void update(Cell[] cells, int width) {
        neighbours = 0;
        for (int m = -1; m < 2; m++) {
            for (int n = -1; n < 2; n++) {
                if (cellStateAt(x+m,y+n,cells,width) && !(m == 0 && n == 0)) {
                    neighbours++;
                }
            }
        }
        if (neighbours == 3) {
            nextState = true;
        } else if (neighbours > 3) {
            nextState = false;
        } else if (2 > neighbours){
            nextState = false;
        } else {
            nextState = state;
        }
    }

    private boolean cellStateAt(int x, int y, Cell[] cells, int width) {
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

    public void setNeighbours(int neighbours) {
        this.neighbours = neighbours;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
