package classloader;

import utils.FileUtils;

import java.io.*;

public class DecryptionClassLoader extends ClassLoader {
    private String mLibPath;

    public DecryptionClassLoader(String mLibPath) {
        this.mLibPath = mLibPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String fileName = FileUtils.getEnFileName(name);
        File file = new File(mLibPath , fileName);
        try {
            FileInputStream is = new FileInputStream(file);
            int len = 0;
            byte b = 0;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            while((len = is.read()) != -1){
                b = (byte) (len ^ 2);
                bos.write(b);
            }

            byte[] data = bos.toByteArray();
            is.close();
            bos.close();
            return defineClass(name , data , 0 , data.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }
}
