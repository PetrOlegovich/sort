import java.util.Random;
public class Main {
    public static void main(String[] args) {

        int[] array = new int[10];
        for (int i = 0; i < array.length; i++)
            array[i] = new Random().nextInt(10);

        printArray(array);
        sort(array);
        printArray(array);
        System.out.println(binSearch(array,5));
    }


    public static void sort(int[] array) {
        for(int i = array.length / 2 - 1; i >= 0; i--)
            heapify(array, array.length, i);
        for (int i = array.length - 1; i >=0; i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }
    private static void heapify(int[] array, int heapSize, int rootIndex){
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;
        if (leftChild < heapSize && array[leftChild] > array[largest])
            largest = leftChild;
        if (rightChild < heapSize && array[rightChild] > array[largest])
            largest = rightChild;
        if (largest != rootIndex){
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            heapify(array, heapSize, largest);
        }
    }



    public static int binSearch(int[] array, int value){
        return binSearch(array, value, 0, array.length - 1);
    }
    public static int binSearch(int[] array, int value, int left, int right){
        if (left > right)
            return -1;
        int mid = (left + right) /2;
        if(array[mid] < value)
            return binSearch(array,value, mid +1, right);
        if(array[mid] > value)
            return binSearch(array,value,left,mid -1);
        else
            return mid;

    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }
    private static void quickSort(int[] array, int leftBorder, int rightBorder){
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = array[(leftMarker + rightMarker) / 2];
        while(leftMarker <= rightMarker){
            while (array[leftMarker] < pivot)
                leftMarker++;
            while (array[rightMarker] > pivot)
                rightMarker--;
            if (leftMarker <= rightMarker){
                if (leftMarker < rightMarker){
                    int temp = array[leftMarker];
                    array[leftMarker] = array[rightMarker];
                    array[rightMarker] = temp;
                }
                leftMarker++;
                rightMarker--;
            }
        }
        if (leftBorder < rightMarker)
            quickSort(array, leftBorder, rightMarker);
        if (leftMarker < rightBorder)
            quickSort(array, leftMarker, rightBorder);
    }

    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++){
            int value = array[i];
            int left = i -1;
            while (left >= 0 && value < array[left]){
                array[left + 1] = array[left];
                left--;
            }
            if (left + 1 != i)
                array[left +1] = value;
        }
    }
    public static void printArray(int[] array) {
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();

    }
}