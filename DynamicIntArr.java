public class DynamicIntArr {
    public static void main(String[] args) {
        DynamicIntArray array = new DynamicIntArray();
        for (int i = 0; i < 20; i++) {
            array.add(i);
        }
        
        array.remove(10);
        array.print();
        array.printArr();
        
        array.insert(10, 77);
        array.print();
        array.printArr();
    }
}

class DynamicIntArray {
    private int[] arr;
    private int size = 0;
    
    public DynamicIntArray() {
        arr = new int[10];
    }
    
    public void add(int element) {
        if (size == arr.length) {
            resize();
        }
        arr[size++] = element; 
    }
    
    public void remove(int index) {
        if (index >= size || index < 0) {
            System.out.println("Illegal index: the size is - " + size);
            return;
        }
        for (int i = index; i < size - 1; ++i) {
            arr[i] = arr[i + 1];
        }
        --size;
    }
    
    public void insert(int index, int element) {
        if (size == arr.length) {
            resize();
        }
        for (int i = size - 1; i >= index; --i){
            arr[i + 1] = arr[i]; 
        }
        arr[index] = element;
        ++size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int getSize() {
        return size;
    }
    
    public void print() {
        for (int i = 0; i < size; ++i) {
            System.out.print("[" + arr[i] + ']');
        }
        System.out.println();
    }
    
    public void printArr() {
        for (int i = 0; i < arr.length; ++i) {
            System.out.print("[" + arr[i] + ']');
        }
        System.out.println();
    }
    
    private void resize() {
        int[] newArr = new int[(int)(size * 1.5)];
        for (int i = 0; i < size; ++i){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
}