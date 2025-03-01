package main.java.com.ksenydmitri.Objects;

import main.java.com.ksenydmitri.math.Vector3;
import main.java.com.ksenydmitri.math.Matrix4;

public class Camera {
    private Vector3 position;
    private Vector3 direction;
    private Vector3 up;
    private float fov; // Поле зрения
    private float yaw; // Угол поворота вокруг оси Y (влево-вправо)
    private float pitch; // Угол поворота вокруг оси X (вверх-вниз)

    public Camera() {
        position = new Vector3(0, 0, 5);
        direction = new Vector3(0, 0, -1);
        up = new Vector3(0, 1, 0);
        fov = 60.0f;
        yaw = -90.0f; // Смотрим вдоль оси Z
        pitch = 0.0f;
        updateDirection();
    }

    public Vector3 getPosition() {
        return position;
    }

    public Vector3 getDirection() {
        return direction;
    }

    public void move(double dx, double dy, double dz) {
        position.x += dx;
        position.y += dy;
        position.z += dz;
    }

    public void rotate(float yaw, float pitch) {
        this.yaw += yaw;
        this.pitch += pitch;

        // Ограничение угла поворота по оси X (pitch)
        if (this.pitch > 89.0f) {
            this.pitch = 89.0f;
        } else if (this.pitch < -89.0f) {
            this.pitch = -89.0f;
        }

        updateDirection();
    }

    public void zoom(float zoomFactor) {
        moveForward(zoomFactor);
    }

    private void updateDirection() {
        direction.x = Math.cos(Math.toRadians(yaw)) * Math.cos(Math.toRadians(pitch));
        direction.y = Math.sin(Math.toRadians(pitch));
        direction.z = Math.sin(Math.toRadians(yaw)) * Math.cos(Math.toRadians(pitch));
        direction = direction.normalize();
    }

    public Matrix4 getViewMatrix() {
        Vector3 target = position.add(direction);
        return Matrix4.lookAt(position, target, up);
    }

    public Matrix4 getProjectionMatrix(float fov, float aspectRatio, float near, float far) {
        return Matrix4.perspective(fov, aspectRatio, near, far);
    }

    public void moveForward(float distance) {
        Vector3 forward = direction.multiply(distance);
        position = position.add(forward);
    }

}
