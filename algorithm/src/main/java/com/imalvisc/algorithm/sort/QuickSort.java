package com.imalvisc.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序算法
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 100, 1000, 66, -3, 55};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后结果：" + Arrays.toString(arr));

    }

    private static void quickSort(int[] arr, int l, int r) {
        int p = arr[l];
        int i = l;
        int j = r;
        while (i < j) {
            while (i < j && arr[j] >= p) {
                j--;
            }
            while (i < j && arr[i] <= p) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, l, i);
        if (l < i - 1) {
            quickSort(arr, l, i - 1);
        }
        if (i + 1 < r) {
            quickSort(arr, i + 1, r);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
