package ru.gb.jtwo.blesson.games.bricks;

import ru.gb.jtwo.blesson.games.common.GameCanvas;
import ru.gb.jtwo.blesson.games.common.Sprite;

import java.awt.*;

public class Brick extends Sprite {
    private final Color color;
    private float vX;
    private float vY;

    public Brick() {
        halfWidth = 20 + (float) (Math.random() * 50f);
        halfHeight = halfWidth;
        color = new Color (
                (int)(Math.random() * 255), //r
                (int)(Math.random() * 255), //g
                (int)(Math.random() * 255)  //b
        );
        vX = (float)(100f + (Math.random() * 200f));
        vY = (float)(100f + (Math.random() * 200f));
    }


    public Brick(int x, int y) {
        this();
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(GameCanvas canvas, float deltaTime) {
        x += vX * deltaTime;
        y += vY * deltaTime;
        if (getLeft() < canvas.getLeft()) {
            setLeft(canvas.getLeft());
            vX = -vX;
        }
        if (getRight() > canvas.getRight()) {
            setRight(canvas.getRight());
            vX = -vX;
        }
        if (getTop() < canvas.getTop()) {
            setTop(canvas.getTop());
            vY = -vY;
        }
        if (getBottom() > canvas.getBottom()) {
            setBottom(canvas.getBottom());
            vY = -vY;
        }

    }

    @Override
    public void render(GameCanvas canvas, Graphics g) {
        g.setColor(color);
        g.drawRect((int) getLeft(), (int) getTop(),
                (int) getWidth(), (int) getHeight());
    }
}
