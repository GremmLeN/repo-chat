package ru.gb.jtwo.blesson.games.common;

import java.awt.*;

public interface CanvasListener {
    void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime);
}
