package com.company;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;


//
//Написать программу, которая позволяет ввести имя bmp-файла, считать его
//        заголовки и вывести на консоль информацию о размере файла, ширине и
//        высоте в пикселях, количестве бит на пиксель, разрешении горизонтальном
//        и вертикальном (количестве пикселей на метр), типе сжатия (без сжатия / 4бит
//        RLE / 8бит RLE)

public class test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя изображения");

        String filename  = scanner.nextLine()+".bmp";

        try {

            // Открываем изображение
            File file = new File(filename);
            BufferedImage source = ImageIO.read(file);

            System.out.println(source.getData());
        } catch (IOException e) {
            System.out.println(e);
        }
        scanner.close();
    }
}