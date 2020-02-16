package Jframe;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    Screen s;
    public Frame(){
        Screen scr = new Screen();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,800);
        setResizable(false);
        setTitle("Supermarket");

    }
    public void init(){
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1,1,0,0));

        s = new Screen();
        add(s);

        setVisible(true);
    }
}
