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
//
//        //快速排序
//        QuickSort.quickSort(array, 0, array.length-1);

//        //计数排序
//        CountSort.countSort(array);

//        //堆排序
//        HeapSort.sort(array);

//        //桶排序
//        BucketSort.bucketSort(array,5);

//        //基数排序
//        RadixSort.radixSort(array);

        System.out.println("\n排序后的数组:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
