package com.company;

import java.io.*;

public class Task3 {

    public static int CountLength(int count)
    {count++;
        return count;
    }

    //Задание 3
//        Считать из файла строки и сформировать новый файл из строк где содержится хотя бы одна цифра
//                посчитать кол-во удаленных строк
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedReader br2 = null;
        try {
    br = new BufferedReader(new FileReader("Task3.txt"));
    br2 = new BufferedReader(new FileReader("Task3.txt"));
    String line;
int count = 0;
            while ((line = br.readLine()) != null) {
       count = CountLength(count);

    }
    String [] arrstr = new String[count];
    int _i = 0;
             while ((line = br2.readLine()) != null) {
arrstr[_i] = line;
_i++;
    }
    br.close();
    br2.close();
    count = 0;
            File file = new File("Task3.1.txt");
            PrintWriter pw = new PrintWriter(file);
            if(!file.exists())
                file.createNewFile();
            for (String str:arrstr
                 ) {
                if(str.matches(".*\\d+.*"))
                {
                    pw.println(str);
                count = CountLength(count);

                }


            }
           int countDeleted = arrstr.length - count;
            System.out.println("Колличество удаленных строк: "+countDeleted);

pw.close();
}

        catch (IOException e)
{
    System.out.println(e);
}
    }
}
