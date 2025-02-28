package main.java.com.ksenydmitri.Engine;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import main.java.com.ksenydmitri.Objects.Object3d;
import main.java.com.ksenydmitri.math.Vector2;
import main.java.com.ksenydmitri.math.Vector3;

public class SwingRenderer extends JPanel implements Renderer {
    private List<Object3d> objects; // Список объектов для отрисовки
    private double angle = 0;       // Угол вращения

    public SwingRenderer(List<Object3d> objects) {
        this.objects = objects;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Очистка экрана
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Отрисовка всех объектов
        for (Object3d object : objects) {
            g2d.setColor(object.getColor());
            List<Vector3> vertices = object.getVertices();
            List<int[]> edges = object.getEdges();

            for (int[] edge : edges) {
                Vector3 v1 = vertices.get(edge[0]);
                Vector3 v2 = vertices.get(edge[1]);

                // Простая проекция
                Vector2 p1 = v1.project(200, 5);
                Vector2 p2 = v2.project(200, 5);

                // Отрисовка линии
                g2d.drawLine(
                        (int) (p1.x + getWidth() / 2),
                        (int) (p1.y + getHeight() / 2),
                        (int) (p2.x + getWidth() / 2),
                        (int) (p2.y + getHeight() / 2)
                );
            }
        }
    }

    @Override
    public void render(List<Object3d> objects) {
        this.objects = objects;
        repaint();
    }

    @Override
    public void update() {
        angle += 0.0001;
        for (Object3d object : objects) {
            for (Vector3 vertex : object.getVertices()) {
                double x = vertex.x;
                double y = vertex.y;
                double z = vertex.z;

                // Вращение вокруг оси Y
                vertex.x = x * Math.cos(angle) - z * Math.sin(angle);
                vertex.z = x * Math.sin(angle) + z * Math.cos(angle);
            }
        }
    }
}
