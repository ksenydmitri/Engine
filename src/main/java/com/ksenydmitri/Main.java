package main.java.com.ksenydmitri;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import main.java.com.ksenydmitri.Engine.SwingRenderer;
import main.java.com.ksenydmitri.InputHandler.KeyboardHandler;
import main.java.com.ksenydmitri.InputHandler.MouseHandler;
import main.java.com.ksenydmitri.Objects.Camera;
import main.java.com.ksenydmitri.Objects.Object3d;
import main.java.com.ksenydmitri.math.Vector3;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("3D Renderer with Objects");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final List<Object3d> objects = new ArrayList<>();

        // Создаем куб
        List<Vector3> cubeVertices = new ArrayList<>();
        cubeVertices.add(new Vector3(-1, -1, -1));
        cubeVertices.add(new Vector3(1, -1, -1));
        cubeVertices.add(new Vector3(1, 1, -1));
        cubeVertices.add(new Vector3(-1, 1, -1));
        cubeVertices.add(new Vector3(-1, -1, 1));
        cubeVertices.add(new Vector3(1, -1, 1));
        cubeVertices.add(new Vector3(1, 1, 1));
        cubeVertices.add(new Vector3(-1, 1, 1));

        List<int[]> cubeEdges = new ArrayList<>();
        cubeEdges.add(new int[]{0, 1});
        cubeEdges.add(new int[]{1, 2});
        cubeEdges.add(new int[]{2, 3});
        cubeEdges.add(new int[]{3, 0});
        cubeEdges.add(new int[]{4, 5});
        cubeEdges.add(new int[]{5, 6});
        cubeEdges.add(new int[]{6, 7});
        cubeEdges.add(new int[]{7, 4});
        cubeEdges.add(new int[]{0, 4});
        cubeEdges.add(new int[]{1, 5});
        cubeEdges.add(new int[]{2, 6});
        cubeEdges.add(new int[]{3, 7});

        Object3d cube = new Object3d(cubeVertices, cubeEdges, Color.WHITE);
        objects.add(cube);

        // Создаем камеру
        Camera camera = new Camera();

        // Создаем рендерер и передаем в него объекты и камеру
        SwingRenderer renderer = new SwingRenderer(objects, camera);

        // Подключаем обработчик мыши для управления камерой
        MouseHandler mouseHandler = new MouseHandler(camera);
        renderer.addMouseListener(mouseHandler);
        renderer.addMouseMotionListener(mouseHandler);
        renderer.addMouseWheelListener(mouseHandler);

        // Подключаем обработчик клавиатуры для управления камерой
        KeyboardHandler keyboardHandler = new KeyboardHandler(camera);
        frame.addKeyListener(keyboardHandler);

        // Добавляем рендерер в окно
        frame.add(renderer);
        frame.setVisible(true);

        // Анимация
        while (true) {
            renderer.update();
            renderer.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
