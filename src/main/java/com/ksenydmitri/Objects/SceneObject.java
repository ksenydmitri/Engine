package main.java.com.ksenydmitri.Objects;

public interface SceneObject {
    void update(float deltaTime);

    void render(); // Отрисовка с использованием OpenGL

    void move(int dx, int dy, int dz); // Движение объекта

    void rotateXZ(int angle); // Поворот в плоскости XY

    void rotateXZ(float angle); // Поворот в плоскости YZ

    void rotateYZ(float angle); // Поворот в плоскости YZ

}