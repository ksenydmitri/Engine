package main.java.com.ksenydmitri.Objects;

import main.java.com.ksenydmitri.math.Matrix4;
import main.java.com.ksenydmitri.math.Vector3;

public class Camera implements SceneObject {
    private Vector3 position; // Позиция камеры
    private Vector3 target;   // Точка, на которую смотрит камера
    private Vector3 up;       // Вектор "вверх" для камеры

    public Camera() {
        position = new Vector3(0, 0, 5);
        target = new Vector3(0, 0, 0);   // Камера смотрит в центр сцены
        up = new Vector3(0, 1, 0);       // Вектор "вверх" направлен по оси Y
    }

    @Override
    public void update(float deltaTime) {
        // Логика обновления камеры (например, перемещение или вращение)
    }

    @Override
    public void render() {
        // Метод для соблюдения интерфейса SceneObject
        // Камера не отрисовывается, но этот метод должен быть реализован
    }

    // Получение матрицы вида (view matrix)
    public Matrix4 getViewMatrix() {
        return Matrix4.lookAt(position, target, up);
    }

    // Получение матрицы проекции (projection matrix)
    public Matrix4 getProjectionMatrix(float fov, float aspectRatio, float near, float far) {
        return Matrix4.perspective(fov, aspectRatio, near, far);
    }
}
