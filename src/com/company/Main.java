package com.company;
import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
//   Задание 2
//    записать арифметическую прогрессию начиная с 4 с шагом в 7
//    в бинарном виде в файл
//    далее считать, преобразовать и записать в другой файл


    public static void main(String[] args) {
BufferedReader br = null;
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int[] mass = new int[N];
        mass[0] = 4;
        for (int i = 1; i < N; i++) {
           mass[i] = mass[i-1]+7;
        }






        try{
            File file = new File("Task2.txt");
            if(!file.exists())
                file.createNewFile();
            PrintWriter pw = new PrintWriter(file);
            for (int element:mass
            ) {
                String binstr = Integer.toBinaryString(element);
                pw.println(binstr);


            }
            pw.close();

        }
        catch (IOException e){
            System.out.println(e);
        }

        try {
            String[] arr = new String[N];
            File file1 = new File("Task2.1.txt");
            PrintWriter pw1 = new PrintWriter(file1);
            if(!file1.exists())
                file1.createNewFile();
            br = new BufferedReader(new FileReader("Task2.txt"));
            String line;
            int i = 0;
            while ((line = br.readLine())!= null){
                arr[i] = line;

                i++;
            }

            for (int j = 4; j < 6; j++) {
                int num = Integer.parseInt(arr[j], 2);

             pw1.println(num);

            }
            pw1.close();
        }catch (IOException e){
            System.out.println(e);
        }
    }
}

