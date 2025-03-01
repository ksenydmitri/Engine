package main.java.com.ksenydmitri.math;

public class Vector4 {
    public double x, y, z, w;

    public Vector4(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vector4 multiply(Matrix4 matrix) {
        double[] result = new double[4];
        for (int i = 0; i < 4; i++) {
            result[i] = matrix.matrix[i][0] * x
                    + matrix.matrix[i][1] * y
                    + matrix.matrix[i][2] * z
                    + matrix.matrix[i][3] * w;
        }
        return new Vector4(result[0], result[1], result[2], result[3]);
    }

    public Vector3 toVector3() {
        return new Vector3(x / w, y / w, z / w);
    }

    @Override
    public String toString() {
        return String.format("Vector4(%.2f, %.2f, %.2f, %.2f)", x, y, z, w);
    }
}
