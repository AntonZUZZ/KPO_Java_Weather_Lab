package com.company;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;

public class MyImage implements AutoCloseable{

    private BufferedImage image;

    private int image_height;
    private int image_width;
    private int image_type;

    private BufferedImage copy;

    private ArrayList<String> pixels = new ArrayList<String>();

    public void Load(String path) {
        try {
            File file = new File(path);

            this.image = ImageIO.read(file);

            this.image_height = image.getHeight();
            this.image_width = image.getWidth();
            this.image_type = image.getType();

            this.copy = new BufferedImage(image_width, image_height, image_type);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Decompose(String path) {
        try (FileWriter writer = new FileWriter(path, false)) {

            System.out.println("Запись исходного изображения по пикселям...");

            for (int i = 0; i < image_width; i++) {
                for (int j = 0; j < image_height; j++) {

                    Color color = new Color(image.getRGB(i, j));

                    Pixel pixel = new Pixel(i, j, color);

                    writer.write(pixel.toString());
                }
            }

            writer.flush();

            System.out.println("Исходное изображение записано по пикселям.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.gc(); // надеюсь, это работает
    }

    public void GetPixels(String path) //Чтение из файла
    {
        File file = new File(path);

        System.out.println("Чтение файла пикселей...");

        try
        {
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();

            while (line != null) {
                this.pixels.add(line);
                line = reader.readLine();
            }

            System.out.println("Файл пикселей прочитан.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Compose()
    {
        System.out.println("Формирование нового изображения...");

        //Разбиение на три канала и формирование картинки

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

            this.copy.setRGB(i/image_height, i%image_height, newColor.getRGB());
        }

        System.out.println("Новое изображение сформировано.");
    }

    public void Save(String path) //Запись новой картинки
    {
        try {
            System.out.println("Сохранение нового изображения...");

            File output = new File(path);
            ImageIO.write(copy, "png", output);

            System.out.println("Новое изображение сохранено.");
        } catch (IOException e) {
            e.printStackTrace();
        }
/*
        this.image = null;
        this.copy = null;
        this.pixels = null;
        System.gc();
 */
    }

    public void close()
    {
        System.out.println("Объект MyImage удалён.");
    }
}
