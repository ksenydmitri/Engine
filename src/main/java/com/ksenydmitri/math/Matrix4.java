package main.java.com.ksenydmitri.math;

import static java.util.function.DoubleUnaryOperator.identity;

public class Matrix4 {

    double[][] matrix;

    public Matrix4() {
        matrix = new double[4][4];
        identity();
    }

    public static Matrix4 lookAt(Vector3 position, Vector3 target, Vector3 up) {
        Matrix4 matrix = new Matrix4();

        return matrix;
    }

    public static Matrix4 perspective(float fov, float aspectRatio, float near, float far) {
        Matrix4 matrix = new Matrix4();
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

