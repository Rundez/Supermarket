package Jframe;

import Models.Customer;
import Models.Time;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class Screen extends JPanel implements ActionListener {

    private int recX = 1;
    private int recY;

    public Screen(){
        recX = recX + 5;
    }
    @Override
    protected void paintComponent(Graphics g){
       g.fillRect(100,100,100,100);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        recX = recX + 5;
    }
}



