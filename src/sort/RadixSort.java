package sort;

import java.util.Arrays;

public class RadixSort {
    public static void radixSort(int[] array) {
        if (array.length == 0) {
            return;
        }

        // 找到数组中的最大值，确定最大值的位数
        int max = Arrays.stream(array).max().getAsInt();
        int digitCount = String.valueOf(max).length();

        // 创建10个桶，用于存储每个位上的数字
        int[][] buckets = new int[10][array.length];
        int[] bucketSizes = new int[10];

        // 对每个位进行排序
        for (int digit = 1; digit <= digitCount; digit++) {
            // 将数组中的元素分配到桶中
            for (int num : array) {
                int bucketIndex = (num / (int) Math.pow(10, digit - 1)) % 10;
                buckets[bucketIndex][bucketSizes[bucketIndex]] = num;
                bucketSizes[bucketIndex]++;
            }

            // 将桶中的元素按顺序放回原始数组中
            int currentIndex = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < bucketSizes[i]; j++) {
                    array[currentIndex] = buckets[i][j];
                    currentIndex++;
                }
                bucketSizes[i] = 0; // 清空桶的计数器
            }
        }
    }
}