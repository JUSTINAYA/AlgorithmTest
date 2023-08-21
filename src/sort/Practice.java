package sort;

public class Practice {
    public static void main(String[] args) {
        int[] array = {7, 2, 1, 6, 8, 5, 3, 4};
        System.out.println("排序前的数组:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        /*----------------------------------------*/
//        bbsort(array);
//        quicksort(array, 0, array.length-1);
//        insertsort(array);
        /*----------------------------------------*/
        System.out.println("\n排序后的数组:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void bbsort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void quicksort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int partition = partition(arr, lo, hi);
        quicksort(arr, lo, partition - 1);
        quicksort(arr, partition + 1, hi);
    }

    private static int partition(int[] arr, int lo, int hi) {
        int left = lo;
        int right = hi + 1;
        int key = arr[lo];
        while (true) {
            while (key > arr[++left]) {
                if (left == hi) break;
            }
            while (key < arr[--right]) {
                if (right == lo) break;
            }
            if (left >= right) {
                break;
            } else {
                swap(arr, left, right);
            }

        }
        swap(arr, lo, right);
        return right;
    }

    private static void insertsort(int[] arr) {
        int len = arr.length;
        int minIndex = 0;
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
