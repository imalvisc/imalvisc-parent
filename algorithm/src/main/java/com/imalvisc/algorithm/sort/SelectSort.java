package com.imalvisc.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序算法
 */
public class SelectSort {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 100, 15, 66, -3, 55};
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            int minEle = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minEle) {
                    minIdx = j;
                    minEle = arr[j];
                }
            }
            if (minIdx != i) {
                arr[minIdx] = arr[i];
                arr[i] = minEle;
            }
        }
        System.out.println("排序后结果：" + Arrays.toString(arr));

    }

}
