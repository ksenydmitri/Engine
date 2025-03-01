package main.java.com.ksenydmitri.InputHandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import main.java.com.ksenydmitri.Objects.Camera;

public class KeyboardHandler implements KeyListener {
    private Camera camera;

    public KeyboardHandler(Camera camera) {
        this.camera = camera;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            camera.moveForward(0.1F); // Перемещение вперед
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            camera.moveForward(-0.1F); // Перемещение назад
        }
    }

    // Пустые реализации остальных методов интерфейса
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
