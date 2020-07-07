package com.imalvisc.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序算法
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, -1, 15, 66, -3, 55};
        int[] tmpArr = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, tmpArr);
        System.out.println("排序后结果：" + Arrays.toString(arr));
    }

    private static void mergeSort(int arr[], int left, int right, int[] tmpArr) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, tmpArr);
            mergeSort(arr, mid + 1, right, tmpArr);
            merge(arr, left, mid, right, tmpArr);
        }
    }

    private static void merge(int arr[], int left, int mid, int right, int[] tmpArr) {
        System.out.println("left：" + left + " right：" + right);
        int i = left, j = mid + 1, t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                tmpArr[t] = arr[i];
                i++;
            } else {
                tmpArr[t] = arr[j];
                j++;
            }
            t++;
        }

        while (i <= mid) {
            tmpArr[t] = arr[i];
            i++;
            t++;
        }

        while (j <= right) {
            tmpArr[t] = arr[j];
            j++;
            t++;
        }

        int tmpL = left;
        t = 0;
        while (tmpL <= right) {
            arr[tmpL] = tmpArr[t];
            tmpL++;
            t++;
        }
    }

}
