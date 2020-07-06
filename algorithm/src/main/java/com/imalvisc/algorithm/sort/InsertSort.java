package com.imalvisc.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序算法
 */
public class InsertSort {

    public static void main(String[] args) {

        int[] arr = new int[]{1, -1, 15, 66, -3, 55};
        int insertVal;
        int insertIdx;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIdx = i - 1;
            while (insertIdx >= 0 && insertVal < arr[insertIdx]) {
                arr[insertIdx + 1] = arr[insertIdx];
                insertIdx--;
            }
            if (insertIdx != i - 1) {
                arr[insertIdx + 1] = insertVal;
            }
        }
        System.out.println("排序后结果：" + Arrays.toString(arr));

    }

}
