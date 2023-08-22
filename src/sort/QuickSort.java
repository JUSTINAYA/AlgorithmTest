package sort;


public class QuickSort {
    public static int[] quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return arr;
        int partition = partition(arr, lo, hi);
        quickSort(arr, lo, partition - 1);
        quickSort(arr, partition + 1, hi);
        return arr;
    }


    private static int partition(int[] arr, int lo, int hi) {
        //把最左边的元素当作基准值
        int pivot = arr[lo];
        int left = lo; //
        int right = hi + 1;
        while (true) {
            //左指针遇到>=key的值，才停下
            while (arr[++left] < pivot) {
                if (left == hi) break;
            }

            //右指针遇到<=key的值，才停下
            while (pivot < arr[--right]) {
                if (right == lo) break;
            }

            if (left >= right) {
                //扫描了所有元素，结束循环
                break;
            } else {
                //交换左右指针
                swap(arr, left, right);
            }
        }
        //right指向的值一定是小于或等于key值，所以交换key和右指针的值
        swap(arr, lo, right);
        return right;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/*
快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，
则可分别对这两部分记录继续进行排序，以达到整个序列有序。

        6.1 算法描述
        快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：

        从数列中挑出一个元素，称为 “基准”（pivot）；
        重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面
        （相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
        递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。*/
