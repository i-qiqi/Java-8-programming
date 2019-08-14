package javaBasic;

public class ShallowCloneExample implements Cloneable {
    private int[] arr;

    public ShallowCloneExample(){
        arr = new int[10];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = i;
        }
    }

    public void set(int index , int value){
        arr[index] = value;
    }

    public int get(int index) {
        return arr[index];
    }

    protected ShallowCloneExample clone() throws CloneNotSupportedException {
        return (ShallowCloneExample) super.clone();
    }

    public static void main(String[] args){
        ShallowCloneExample e1 = new ShallowCloneExample();
        ShallowCloneExample e2 = null;
        try{
            e2 = e1.clone();
            System.out.println(e1.arr == e2.arr);
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        e1.set(2,22);
        System.out.println(e2.get(2));
    }

}
