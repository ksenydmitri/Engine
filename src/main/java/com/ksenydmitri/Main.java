package main.java.com.ksenydmitri;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import main.java.com.ksenydmitri.Engine.SwingRenderer;
import main.java.com.ksenydmitri.Objects.Object3d;
import main.java.com.ksenydmitri.math.Vector3;


public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("3D Renderer with Objects");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создаем список объектов
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

        objects.add(new Object3d(cubeVertices, cubeEdges, Color.WHITE));

        // Создаем второй объект (например, пирамиду)
        List<Vector3> pyramidVertices = new ArrayList<>();
        pyramidVertices.add(new Vector3(0, 1, 0));  // Верхняя вершина
        pyramidVertices.add(new Vector3(-1, -1, -1));
        pyramidVertices.add(new Vector3(1, -1, -1));
        pyramidVertices.add(new Vector3(1, -1, 1));
        pyramidVertices.add(new Vector3(-1, -1, 1));

        List<int[]> pyramidEdges = new ArrayList<>();
        pyramidEdges.add(new int[]{0, 1});
        pyramidEdges.add(new int[]{0, 2});
        pyramidEdges.add(new int[]{0, 3});
        pyramidEdges.add(new int[]{0, 4});
        pyramidEdges.add(new int[]{1, 2});
        pyramidEdges.add(new int[]{2, 3});
        pyramidEdges.add(new int[]{3, 4});
        pyramidEdges.add(new int[]{4, 1});

        objects.add(new Object3d(pyramidVertices, pyramidEdges, Color.RED));

        SwingRenderer renderer = new SwingRenderer(objects);
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