package sort;

import java.util.Arrays;

public class CountSort {

    /**
     *
     * 计数排序
     * @param arr：要排序的数组
     * @return
     */
    public static int[] countSort(int[] arr){
        int n = arr.length;
        //先定义两个变量用来存放数组中的最大值和最小值
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < n; i++){
            if (max < arr[i]){
                max = arr[i];
            }
            if (arr[i] < min){
                min = arr[i];
            }
        }
        //定义一个长度为len的数组，这样做是为了防止数组中的最小值为1000，最大值为1010
        //这样创建一个大小为10的数组就行了，不用创建大小为1010的数组，浪费空间
        int len = max - min + 1;
        //哪个数字出现了一次，就把它的数字作为下标存起来，假如1006出现了一次，就把temp[1006-1000]加一
        int[] temp = new int[len];
        for (int i = 0; i < n; i++) {
            temp[arr[i] - min]++;
        }
        int k = 0;
        //对temp进行遍历，temp[i]的值就是i出现的次数，加入temp[5]=3，说明(5+1000)出现了3次
        for (int i = 0; i < len; i++) {
            for (int j = temp[i]; j > 0; j--){
                arr[k] = i + min;
                k++;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 9, 5, 0};
        System.out.println(Arrays.toString(arr));
        arr = countSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}

/*
计数排序不是基于比较的排序算法，其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。
 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。

        8.1 算法描述
        找出待排序的数组中最大和最小的元素；
        统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
        对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
        反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。*/
