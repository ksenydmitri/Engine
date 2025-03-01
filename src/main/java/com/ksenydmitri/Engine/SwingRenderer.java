package main.java.com.ksenydmitri.Engine;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import main.java.com.ksenydmitri.Objects.Camera;
import main.java.com.ksenydmitri.Objects.Object3d;
import main.java.com.ksenydmitri.math.Matrix4;
import main.java.com.ksenydmitri.math.Vector2;
import main.java.com.ksenydmitri.math.Vector3;
import main.java.com.ksenydmitri.math.Vector4;

public class SwingRenderer extends JPanel {
    private List<Object3d> objects; // Список объектов для отрисовки
    private Camera camera;          // Камера для рендеринга

    public SwingRenderer(List<Object3d> objects, Camera camera) {
        this.objects = objects;
        this.camera = camera;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Очистка экрана
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Получение матриц вида и проекции из камеры
        Matrix4 viewMatrix = camera.getViewMatrix();
        Matrix4 projectionMatrix = camera.getProjectionMatrix(60, (float) getWidth() / getHeight(), 0.1f, 100f);

        // Отрисовка всех объектов
        for (Object3d object : objects) {
            g2d.setColor(object.getColor());
            List<Vector3> vertices = object.getVertices();
            List<int[]> edges = object.getEdges();

            for (int[] edge : edges) {
                Vector3 v1 = vertices.get(edge[0]);
                Vector3 v2 = vertices.get(edge[1]);

                // Применение матриц вида и проекции к вершинам
                Vector4 transformedV1 = projectionMatrix.multiply(viewMatrix.multiply(v1.toVector4()));
                Vector4 transformedV2 = projectionMatrix.multiply(viewMatrix.multiply(v2.toVector4()));

                // Преобразование обратно в Vector3 для дальнейшего использования
                Vector3 screenV1 = transformedV1.toVector3();
                Vector3 screenV2 = transformedV2.toVector3();

                // Простая проекция
                Vector2 p1 = screenV1.project(getWidth(), getHeight());
                Vector2 p2 = screenV2.project(getWidth(), getHeight());

                // Отрисовка линии
                g2d.drawLine(
                        (int) (p1.x),
                        (int) (p1.y),
                        (int) (p2.x),
                        (int) (p2.y)
                );
            }
        }
    }

    public void update() {
        // Обновление объектов (если необходимо)
    }
}
