package utils;

import java.io.*;

public class FileUtils {
    public static void test(String path){
        File file = new File(path);
        try {
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(path+"en");
            int b = 0;
            int b1 = 0;
            while((b = fis.read()) != -1){
                fos.write(b^2); // XOR 2 per byte.
            }
            fos.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //Get the file name required to load
    public static String getFileName(String name){
        int index = name.lastIndexOf('.');
        if(index == -1){
            return name+".class";
        }else{
            String fileName = "";
            fileName = name.substring(index+1)+".class";
            System.out.println("Loading File Name : "+fileName);
            return fileName;
        }
    }

    public static String getEnFileName(String name){
        int index = name.lastIndexOf('.');
        if(index == -1){
            return name+".classen";
        }else{
            String fileName = "";
            fileName = name.substring(index+1)+".classen";
            System.out.println("Loading File Name : "+fileName);
            return fileName;
        }
    }
}
