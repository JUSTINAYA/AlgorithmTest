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

/*
基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，
直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。
最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。

        10.1 算法描述
        取得数组中的最大数，并取得位数；
        arr为原始数组，从最低位开始取每个位组成radix数组；
        对radix进行计数排序（利用计数排序适用于小范围数的特点）；*/
