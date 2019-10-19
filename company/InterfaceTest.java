package com.company;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class InterfaceTest extends JFrame {
    int x, y, w, h;

    InterfaceTest(){
        super("Map Analyzer 9000");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 800);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        setContentPane(panel);
//кнопка
        JButton butt1 = new JButton("Рассчитать");
        butt1.setSize(160,50);
        butt1.setLocation(420,700);
        panel.add(butt1);
//карта
        String picPath = "D:\\2000-02-26.png";
        try {
            BufferedImage myPicture = ImageIO.read(new File(picPath));

        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setSize(800,400);
        picLabel.setLocation(100,50);
        panel.add(picLabel);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
