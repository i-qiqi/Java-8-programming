import classloader.DecryptionClassLoader;
import classloader.DiskClassLoader;
import classloader.DiskClassLoader_1;
import org.junit.Test;
import utils.FileUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SuppressWarnings("all")
public class App {
    public static void main(String args[]){
        System.out.println(System.getProperty("sun.boot.class.path"));
//        System.out.println(System.getProperty("java.class.path"));
    }

    @Test
    public void testExtClassLoaderPath(){
        System.out.println(System.getProperty("java.ext.dirs"));
    }

    @Test
    public void testAppClassLoaderPath(){
        System.out.println(System.getProperty("java.class.path"));
    }

    @Test
    public void TestDiskClassLoader(){
        DiskClassLoader diskClassLoader = new DiskClassLoader("/home/bqzhu/Desktop/workspace/jhipster-learning/java-basic-8/lib");
        try {
            Class clazz = diskClassLoader.loadClass("java8.bqzhu.examples.TestClassLoader");
            if(clazz != null){
                Object obj = clazz.newInstance();
                Method method = clazz.getDeclaredMethod("say" , null);
                method.invoke(obj,null);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testEncryption(){
        FileUtils.test("/home/bqzhu/Desktop/workspace/jhipster-learning/java-basic-8/lib/TestClassLoader.class");
    }
    @Test
    public void TestDecryptionClassLoader(){
        DecryptionClassLoader decryptionClassLoader = new DecryptionClassLoader("/home/bqzhu/Desktop/workspace/jhipster-learning/java-basic-8/lib");
        try {
            Class clazz = decryptionClassLoader.loadClass("java8.bqzhu.examples.TestClassLoader");
            if(clazz != null){
                Object obj = clazz.newInstance();
                Method method = clazz.getDeclaredMethod("say" , null);
                method.invoke(obj,null);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testContextClassLoader(){
        final DiskClassLoader_1  diskClassLoader_1 = new DiskClassLoader_1("/home/bqzhu/Desktop/workspace/jhipster-learning/java-basic-8/lib/test");
        Class clazz1 = null;
        try {
            clazz1 = diskClassLoader_1.loadClass("com.zero.test.SpeakTest");
            System.out.println(clazz1.getClassLoader().toString());
            if(clazz1 != null){
                Object obj = clazz1.newInstance();
                Method method = clazz1.getDeclaredMethod("speak" , null);
                method.invoke(obj , null);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        final DiskClassLoader diskClassLoader = new DiskClassLoader("/home/bqzhu/Desktop/workspace/jhipster-learning/java-basic-8/lib");
//        Thread.currentThread().setContextClassLoader(diskClassLoader);
        System.out.println("Thread "+Thread.currentThread().getName()+" classloader : "+Thread.currentThread().getContextClassLoader().toString());
        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setContextClassLoader(diskClassLoader_1);
                System.out.println("Thread "+Thread.currentThread().getName()+" classloader: "+Thread.currentThread().getContextClassLoader().toString());
                ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                System.out.println(classLoader.toString());
                try {
                    Class clazz = classLoader.loadClass("com.zero.test.SpeakTest");
                    if(clazz != null){
                        Object obj = clazz.newInstance();
                        Method method = clazz.getDeclaredMethod("speak", null);
                        method.invoke(obj, null);
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }
}

