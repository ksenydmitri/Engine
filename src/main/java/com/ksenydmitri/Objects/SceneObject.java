package main.java.com.ksenydmitri.Objects;

public interface SceneObject {
    void update(float deltaTime);
    void render(); // Отрисовка с использованием OpenGL
}