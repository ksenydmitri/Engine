package main.java.com.ksenydmitri.Engine;

import java.util.List;
import main.java.com.ksenydmitri.Objects.Object3d;

public interface Renderer {
    void render(List<Object3d> objects);
    void update();
}
