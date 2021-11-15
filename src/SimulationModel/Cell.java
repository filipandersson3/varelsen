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

    public void update() {
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

    public void setNeighbours(int neighbours) {
        this.neighbours = neighbours;
    }
}
