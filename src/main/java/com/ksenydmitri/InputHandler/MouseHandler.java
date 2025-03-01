package main.java.com.ksenydmitri.InputHandler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import main.java.com.ksenydmitri.Objects.Camera;

public class MouseHandler implements MouseListener, MouseMotionListener, MouseWheelListener {
    private Camera camera;
    private int lastX;
    private int lastY;
    private boolean dragging;

    public MouseHandler(Camera camera) {
        this.camera = camera;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON2) {
            lastX = e.getX();
            lastY = e.getY();
            dragging = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON2) {
            dragging = false;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (dragging) {
            int dx = e.getX() - lastX;
            int dy = e.getY() - lastY;
            camera.rotate(dx * 0.1f, -dy * 0.1f); // Поворот камеры
            lastX = e.getX();
            lastY = e.getY();
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int notches = e.getWheelRotation();
        camera.zoom(notches * 0.5f); // Зум камеры
    }

    // Пустые реализации остальных методов интерфейсов
    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {}
}
