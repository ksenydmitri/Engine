package main.java.com.ksenydmitri.Objects;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import main.java.com.ksenydmitri.math.Vector3;

public class Object3d {
    private List<Vector3> vertices; // Вершины объекта
    private List<int[]> edges;     // Ребра объекта (индексы вершин)
    private Color color;           // Цвет объекта

    public Object3d(List<Vector3> vertices, List<int[]> edges, Color color) {
        this.vertices = vertices;
        this.edges = edges;
        this.color = color;
    }

    public List<Vector3> getVertices() {
        return vertices;
    }

    public List<int[]> getEdges() {
        return edges;
    }

    public Color getColor() {
        return color;
    }
}