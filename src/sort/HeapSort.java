package sort;

public class HeapSort {
    public static void sort(int arr[]) {
        int n = arr.length;

        // 构建初始堆
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // 逐步取出堆顶元素，与末尾元素交换，并重新调整堆结构
        for (int i = n - 1; i >= 0; i--) {
            // 将堆顶元素与末尾元素交换
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 重新调整堆结构
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int arr[], int n, int i) {
        int largest = i; // 初始化当前节点为最大值
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // 如果左子节点比当前节点大，则更新最大值
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // 如果右子节点比当前节点大，则更新最大值
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // 如果最大值不是当前节点，则交换最大值与当前节点，并递归调整堆结构
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
}

/*
堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，
并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。

        7.1 算法描述
        将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
        将堆顶元素R[1]与最后一个元素R[n]交换，
        此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
        由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，
        然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。
        不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。*/
