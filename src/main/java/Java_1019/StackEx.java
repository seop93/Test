package Java_1019;


public class StackEx {

    int[] arr = new int[1000];
    private int pointer = 0;

    public StackEx() {

    }

    public StackEx(int size) {
        this.arr = new int[size];
    }


    public void push(int value) {
        this.arr[this.pointer] = value;
        this.pointer++;

    }

    public int pop(){
        int value = this.arr[this.pointer -1] ;
        this.pointer--;

        return value;
    }

    public int[] getArr() {
        return arr;
    }

}
