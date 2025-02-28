package main.java.com.ksenydmitri.Objects;

import java.util.ArrayList;
import java.util.List;

public class Scene {
    private List<SceneObject> objects; // Список объектов сцены

    public Scene() {
        objects = new ArrayList<>();
    }

    // Добавление объекта на сцену
    public void addObject(SceneObject object) {
        objects.add(object);
    }

    // Обновление всех объектов на сцене
    public void update(float deltaTime) {
        for (SceneObject object : objects) {
            object.update(deltaTime);
        }
    }

    // Отрисовка всех объектов на сцене
    public void render() {
        for (SceneObject object : objects) {
            object.render();
        }
    }
}