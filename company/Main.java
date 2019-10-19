package com.company;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Properties;


public class Main {

    public static void main(String[] args) {

        File imageFolder = new File("D:\\project_pixels");
        File[] imageFiles = imageFolder.listFiles();
        String path1, path2;

        /*
        for (int i = 0; i < imageFiles.length; i++) {
            System.out.println("\n"+"Изображение №"+(i+1));

            path1 = imageFiles[i].toString();
            path2 = "D:\\project_pixels\\" + path1.substring(16,26) + ".txt";

            try {
                MyImage image = new MyImage();

                image.Load(path1);

                image.Decompose(path2);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

       */

        path2 = "D:\\project_pixels\\hashmap.txt";
        HashMap<Color, String> map = new HashMap<Color, String>();
/*
        for (int j = 0; j < 5; j++) {
            path1 = imageFiles[j].toString();

            File file = new File(path1);
            ArrayList<String> pixels = new ArrayList<String>();

            try {
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);

                String line = reader.readLine();

                while (line != null) {
                    pixels.add(line);
                    line = reader.readLine();
                }

                System.out.println("Файл пикселей прочитан.");

            } catch (IOException e) {
                e.printStackTrace();
            }

            String temp;
            String[] substring;
            String delimeter = "\\.";

            for (int i = 0; i < pixels.size(); i++) {

                temp = pixels.get(i);
                substring = temp.split(delimeter);
                int newRed = Integer.parseInt(substring[0]);
                int newGreen = Integer.parseInt(substring[1]);
                int newBlue = Integer.parseInt(substring[2]);
                Color newColor = new Color(newRed, newGreen, newBlue);


                if (!map.containsKey(newColor)) {
                    map.put(newColor, newColor.toString());
                }
            }
        }

        System.out.println(map.size());

        try {
            FileWriter writer = new FileWriter(path2, false);
            writer.write(Arrays.asList(map).toString());
            writer.flush();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
*/

        JFrame testWindow = new InterfaceTest();
        testWindow.setVisible(true);
    }
}
