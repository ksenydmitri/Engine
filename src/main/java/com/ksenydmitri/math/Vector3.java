package main.java.com.ksenydmitri.math;

public class Vector3 {
    public double x;
    public double y;
    public double z;

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Сложение векторов
    public Vector3 add(Vector3 other) {
        return new Vector3(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    // Вычитание векторов
    public Vector3 subtract(Vector3 other) {
        return new Vector3(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    // Умножение на скаляр
    public Vector3 multiply(float scalar) {
        return new Vector3(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    // Скалярное произведение
    public double dot(Vector3 other) {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    // Векторное произведение
    public Vector3 cross(Vector3 other) {
        return new Vector3(
                this.y * other.z - this.z * other.y,
                this.z * other.x - this.x * other.z,
                this.x * other.y - this.y * other.x
        );
    }

    // Длина вектора
    public float length() {
        return (float) Math.sqrt(x * x + y * y + z * z);
    }

    // Нормализация вектора
    public Vector3 normalize() {
        float length = length();
        return new Vector3(x / length, y / length, z / length);
    }

    // Преобразование в 2D-координаты (простая проекция)
    public Vector2 project(double fov, double viewDistance) {
        double scale = fov / (viewDistance + z);
        return new Vector2(x * scale, y * scale);
    }
}
