package com.imalvisc.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序算法
 */
public class BobbleSort {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 100, 15, 66, -3, 55};
        int tmp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        System.out.println("排序后结果：" + Arrays.toString(arr));

    }

}
