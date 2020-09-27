package ru.gb.jtwo.blesson.games.common;

import ru.gb.jtwo.blesson.games.circles.MainCircles;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {

    private long lastFrameTime;
    private CanvasListener controller;

    public GameCanvas(CanvasListener controller) {
        this.controller = controller;
        lastFrameTime = System.nanoTime();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        controller.onDrawFrame(this, g, deltaTime);
        lastFrameTime = currentTime;
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    public int getLeft() { return 0; }
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }

}
