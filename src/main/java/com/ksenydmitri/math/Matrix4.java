package main.java.com.ksenydmitri.math;

import static java.util.function.DoubleUnaryOperator.identity;

public class Matrix4 {

    double[][] matrix;

    public Matrix4() {
        matrix = new double[4][4];
        identity();
    }

    public static Matrix4 lookAt(Vector3 position, Vector3 target, Vector3 up) {
        Vector3 zAxis = position.subtract(target).normalize();
        Vector3 xAxis = up.cross(zAxis).normalize();
        Vector3 yAxis = zAxis.cross(xAxis).normalize();

        Matrix4 matrix = new Matrix4();
        matrix.matrix[0][0] = xAxis.x;
        matrix.matrix[0][1] = xAxis.y;
        matrix.matrix[0][2] = xAxis.z;
        matrix.matrix[0][3] = -xAxis.dot(position);

        matrix.matrix[1][0] = yAxis.x;
        matrix.matrix[1][1] = yAxis.y;
        matrix.matrix[1][2] = yAxis.z;
        matrix.matrix[1][3] = -yAxis.dot(position);

        matrix.matrix[2][0] = zAxis.x;
        matrix.matrix[2][1] = zAxis.y;
        matrix.matrix[2][2] = zAxis.z;
        matrix.matrix[2][3] = -zAxis.dot(position);

        matrix.matrix[3][0] = 0;
        matrix.matrix[3][1] = 0;
        matrix.matrix[3][2] = 0;
        matrix.matrix[3][3] = 1;

        return matrix;
    }

    public static Matrix4 perspective(float fov, float aspectRatio, float near, float far) {
        float tanHalfFov = (float) Math.tan(Math.toRadians(fov) / 2);
        Matrix4 matrix = new Matrix4();

        matrix.matrix[0][0] = 1 / (aspectRatio * tanHalfFov);
        matrix.matrix[1][1] = 1 / tanHalfFov;
        matrix.matrix[2][2] = -(far + near) / (far - near);
        matrix.matrix[2][3] = -(2 * far * near) / (far - near);
        matrix.matrix[3][2] = -1;
        matrix.matrix[3][3] = 0;

        return matrix;
    }

    public void identity() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = (i == j) ? 1.0f : 0.0f;
            }
        }
    }

    public Matrix4 multiply(Matrix4 other) {
        Matrix4 result = new Matrix4();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result.matrix[i][j] = 0;
                for (int k = 0; k < 4; k++) {
                    result.matrix[i][j] += this.matrix[i][k] * other.matrix[k][j];
                }
            }
        }
        return result;
    }

    public Vector4 multiply(Vector4 vec) {
        double[] result = new double[4];
        for (int i = 0; i < 4; i++) {
            result[i] = matrix[i][0] * vec.x
                    + matrix[i][1] * vec.y
                    + matrix[i][2] * vec.z
                    + matrix[i][3] * vec.w;
        }
        return new Vector4(result[0], result[1], result[2], result[3]);
    }

    // Транспонирование матрицы
    public Matrix4 transpose() {
        Matrix4 result = new Matrix4();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result.matrix[i][j] = this.matrix[j][i];
            }
        }
        return result;
    }

    // Получение массива для передачи в шейдер
    public double[] toArray() {
        double[] array = new double[16];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array[i * 4 + j] = matrix[i][j];
            }
        }
        return array;
    }

}

