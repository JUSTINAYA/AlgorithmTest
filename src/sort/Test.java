package sort;

public class Test {
    public static void main(String[] args) {
        int[] array = {7, 2, 1, 6, 8, 5, 3, 4};
        System.out.println("排序前的数组:");
        for (int num : array){
            System.out.print(num + " ");
        }

//        //冒泡排序
//        BubbleSort.bubbleSort(array);
//
//        //选择排序
//        SelectionSort.selectionSort(array);
//
//        //插入排序
//        InsertionSort.insertionSort(array);
//
//        //希尔排序
//        ShellSort.shellSort(array);
//        //归并排序
//        array = MergeSort.mergeSort(array);

        //快速排序


        System.out.println("\n排序后的数组:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}