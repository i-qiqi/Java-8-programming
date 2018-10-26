package classloader;

import org.junit.Test;
import utils.FileUtils;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DiskClassLoader extends ClassLoader{
    private String mlibPath;

    public DiskClassLoader(String mlibPath) {
        this.mlibPath = mlibPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String fileName = FileUtils.getFileName(name);
        File file = new File(mlibPath , fileName);
        try {
            FileInputStream is = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len = 0;
            while ((len = is.read()) != -1){
                bos.write(len);
            }
            byte[] data = bos.toByteArray();
            is.close();
            bos.close();
            //transform byte content of class file to class object.
            return defineClass(name , data, 0 , data.length);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.findClass(name);
    }




}
