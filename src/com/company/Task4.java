package com.company;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
//Написать программу, которая создает на одном из разделов жесткого диска
//        директорию Lab6_Temp, автоматически копирует в эту директорию Ваш
//        файл lab.dat из задания 1 и создает в ней копию этого файла lab_backup.dat
//        путем побайтового копирования. Вывести на консоль информацию о файле
public class Task4 {

    public static void copyDirectory(File sourceLocation , File targetLocation)
            throws IOException {

        if (sourceLocation.isDirectory()) {
            if (!targetLocation.exists()) {
                targetLocation.mkdir();
            }

            String[] children = sourceLocation.list();
            for (int i=0; i<children.length; i++) {
                copyDirectory(new File(sourceLocation, children[i]),
                        new File(targetLocation, children[i]));
            }
        } else {

            InputStream in = new FileInputStream(sourceLocation);
            OutputStream out = new FileOutputStream(targetLocation);
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        }
    }

    public static void main(String[] args) {
        File folder = new File("C:\\Lab6_Temp");
File file = new File("C:\\Lab6_Temp\\lab_backup.dat");
        File copyfile = new File("C:\\Users\\savva\\IdeaProjects\\Lab6_task1\\lab.dat");
        try{

            copyDirectory(copyfile, file);
            Path path = copyfile.toPath();

            System.out.println("_____________________File info_____________________");
            System.out.println(path);

            String probeContentType = Files.probeContentType(path);
            System.out.println("type "+ probeContentType );

            BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);

            System.out.println("creationTime: " + attr.creationTime());
            System.out.println("lastAccessTime: " + attr.lastAccessTime());
            System.out.println("lastModifiedTime: " + attr.lastModifiedTime());

            System.out.println("isDirectory: " + attr.isDirectory());
            System.out.println("isOther: " + attr.isOther());
            System.out.println("isRegularFile: " + attr.isRegularFile());
            System.out.println("isSymbolicLink: " + attr.isSymbolicLink());
            System.out.println("size: " + attr.size());

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
