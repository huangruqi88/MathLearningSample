package com.lianyun.mathlearningsample.Lesson6;

import java.util.Arrays;

/**
 * @data: 2019/11/13 15:05
 * @author: hrq
 * @Email:
 * @Description:
 */
public class Lesson6_1 {

    /**
     * @param toSort 等待排序的数组
     * @return int[] 排序后的数组
     * @Description: 使用过函数的递归（嵌套）调用，实现归并排序（从小到大）
     */
    public static int[] mergeSort(int[] toSort) {
        if (toSort == null) {
            return new int[0];
        }
        //如果分解到只剩一个数，返回该数
        if (toSort.length == 1) {
            return toSort;
        }
        //将数组分解成左右两半
        int middle = toSort.length / 2;
        int[] left = Arrays.copyOfRange(toSort, 0, middle);
        int[] right = Arrays.copyOfRange(toSort, middle, toSort.length);

        //嵌套调用，对两半分别进行排序
        left = mergeSort(left);
        right = mergeSort(right);
        //合并排序后的两半
        int[] merged = merge(left, right);
        return merged;
    }

    /**
     * @param left  第一个数组
     * @param right 第二个数组
     * @return int[] 合并后的数组
     * @Decription 合并两个已经排序完毕的数字（从小到大）
     */
    private static int[] merge(int[] left, int[] right) {
        if (left == null) {
            left = new int[0];
        }
        if (right == null) {
            right = new int[0];
        }
        int[] mergedOne = new int[left.length + right.length];

        int middleIndex = 0, leftIndex = 0, rightIndex = 0;

        //轮流冲连个数组中取出较小的值，放入合并后的数组中
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                mergedOne[middleIndex] = left[leftIndex];
                leftIndex++;
            } else {
                mergedOne[middleIndex] = right[rightIndex];
                rightIndex++;
            }
            middleIndex++;
        }

        //将某个数组内剩余的数字放入合并的数组中
        if (leftIndex < left.length) {
            for (int i = leftIndex; i < left.length; i++) {
                mergedOne[middleIndex] = left[i];
                middleIndex++;
            }
        } else {
            for (int i = rightIndex; i < right.length; i++) {
                mergedOne[middleIndex] = right[i];
                middleIndex++;
            }
        }
        return mergedOne;
    }
}
