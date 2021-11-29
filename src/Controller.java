import ScreenRenderer.ScreenRenderer;
import SimulationModel.SimulationModel;

import javax.swing.*;
import java.awt.event.*;

/**
 * This is a class
 * Created 2021-10-18
 *
 * @author Magnus Silverdal
 */
public class Controller implements Runnable{
    private Thread thread;
    private boolean running = false;
    private int fps = Integer.parseInt(JOptionPane.showInputDialog("fps?"));
    private int ups = Integer.parseInt(JOptionPane.showInputDialog("ups?"));
    private int width = Integer.parseInt(JOptionPane.showInputDialog("width?"));
    private int height = Integer.parseInt(JOptionPane.showInputDialog("height?"));
    private int scale = Integer.parseInt(JOptionPane.showInputDialog("scale?"));
    private JFrame frameNative;
    private String title = "game of life :) ";
    private ScreenRenderer viewNative;
    private SimulationModel model;
    private boolean paused = true;

    public Controller() {
        viewNative = new ScreenRenderer(width,height,scale);
        model = new SimulationModel(width/scale,height/scale);
        // Frame data
        frameNative = new JFrame(title+"Native");
        frameNative.add(viewNative);
        frameNative.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameNative.setResizable(false);
        frameNative.pack();
        frameNative.setLocationRelativeTo(null);
        frameNative.setVisible(true);
        frameNative.requestFocus();
        viewNative.addKeyListener(new PauseAL());
        viewNative.addMouseListener(new ClickML());
        viewNative.addMouseMotionListener(new DragML());
    }

    public synchronized void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        double nsFPS = 1000000000.0 / fps;
        double nsUPS = 1000000000.0 / ups;
        double deltaFPS = 0;
        double deltaUPS = 0;
        int frames = 0;
        int updates = 0;
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();

        while (running) {
            long now = System.nanoTime();
            deltaFPS += (now - lastTime) / nsFPS;
            if (!paused) {
                deltaUPS += (now - lastTime) / nsUPS;
                while(deltaUPS >= 1) {
                    model.update();
                    viewNative.draw(model.getShapes());
                    updates++;
                    deltaUPS--;
                }
            } else {
                frameNative.setTitle("Paused, press 'E' to unpause");
            }
            lastTime = now;
            while (deltaFPS >= 1) {
                viewNative.render();
                frames++;
                deltaFPS--;
            }

            if(System.currentTimeMillis() - timer >= 1000) {
                timer += 1000;
                frameNative.setTitle(this.title + "Native  |  " + updates + " ups, " + frames + " fps");
                frames = 0;
                updates = 0;
            }
        }
        stop();
    }

    public static void main(String[] args) {
        Controller c = new Controller();
        c.start();
    }

    private class PauseAL implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == 'e' || e.getKeyChar() == 'E') {
                paused = !paused;
            }
        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {

        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {

        }
    }
    private class ClickML implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            model.getCells()[mouseEvent.getX()/scale + (mouseEvent.getY()/scale)*model.getWidth()].setState(true);
            viewNative.draw(model.getShapes());
        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {
        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {
        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    }

    private class DragML implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent mouseEvent) {
            model.getCells()[mouseEvent.getX()/scale + (mouseEvent.getY()/scale)*model.getWidth()].setState(true);
            viewNative.draw(model.getShapes());
        }

        @Override
        public void mouseMoved(MouseEvent mouseEvent) {

        }
    }
}
