package main.java.com.ksenydmitri.GUI;

import javax.swing.*;
import java.awt.*;

public class GUIFrame {
    public GUIFrame() {
        JFrame frame = new JFrame();
        frame.setTitle("Render");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.pack();
        frame.setVisible(true);
    }
}
