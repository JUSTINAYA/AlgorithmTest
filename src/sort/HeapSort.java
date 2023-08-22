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