package classloader;

import utils.FileUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@SuppressWarnings("all")
public class DiskClassLoader_1 extends ClassLoader{
    private String mlibPath;

    public DiskClassLoader_1(String mlibPath) {
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
