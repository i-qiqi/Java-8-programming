package javaBasic;

public class CloneExample implements Cloneable{
    int a;
    int b;
    public CloneExample clone() throws CloneNotSupportedException {
        return (CloneExample) super.clone();
    }

    public static void main(String[] args){
        CloneExample e1 = new CloneExample();
        try {
            CloneExample e2 = e1.clone();
            System.out.println(e1 == e2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}
