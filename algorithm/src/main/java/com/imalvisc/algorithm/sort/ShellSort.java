package com.imalvisc.algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序算法
 */
public class ShellSort {

    public static void main(String[] args) {

        int[] arr = new int[]{1, -1, 15, 66, -3, 55};
        int insertVal;
        int insertIdx;
        for (int step = arr.length / 2; step > 0; step /= 2) {
            for (int i = step; i < arr.length; i++) {
                insertVal = arr[i];
                insertIdx = i - step;
                while (insertIdx >= 0 && insertVal < arr[insertIdx]) {
                    arr[insertIdx + step] = arr[insertIdx];
                    insertIdx -= step;
                }
                arr[insertIdx + step] = insertVal;
            }
        }
        System.out.println("排序后结果：" + Arrays.toString(arr));
    }

}
