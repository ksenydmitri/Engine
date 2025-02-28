package main.java.com.ksenydmitri.math;

public class MathUtils {
    // Преобразование градусов в радианы
    public static float toRadians(float degrees) {
        return degrees * (float) Math.PI / 180.0f;
    }

    // Создание матрицы переноса
    public static Matrix4 createTranslationMatrix(Vector3 translation) {
        Matrix4 matrix = new Matrix4();
        matrix.matrix[0][3] = translation.x;
        matrix.matrix[1][3] = translation.y;
        matrix.matrix[2][3] = translation.z;
        return matrix;
    }

    // Создание матрицы масштабирования
    public static Matrix4 createScaleMatrix(float x, float y, float z) {
        Matrix4 matrix = new Matrix4();
        matrix.matrix[0][0] = x;
        matrix.matrix[1][1] = y;
        matrix.matrix[2][2] = z;
        return matrix;
    }

    // Создание матрицы вращения вокруг оси X
    public static Matrix4 createRotationXMatrix(float angle) {
        Matrix4 matrix = new Matrix4();
        float rad = toRadians(angle);
        matrix.matrix[1][1] = (float) Math.cos(rad);
        matrix.matrix[1][2] = -(float) Math.sin(rad);
        matrix.matrix[2][1] = (float) Math.sin(rad);
        matrix.matrix[2][2] = (float) Math.cos(rad);
        return matrix;
    }
}
