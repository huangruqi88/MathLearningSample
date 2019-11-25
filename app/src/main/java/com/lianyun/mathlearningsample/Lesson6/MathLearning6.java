package com.lianyun.mathlearningsample.Lesson6;

/**
 * @data: 2019/11/13 16:17
 * @author: hrq
 * @Email:
 * @Description:
 */
public class MathLearning6 {
    public static void main(String[] args) {
        int[] toSort ={3434, 3356, 67, 12334, 878667, 387};
        int[] sorted= Lesson6_1.mergeSort(toSort);
        for (int i = 0; i < sorted.length; i++) {
            System.out.println(sorted[i]);
        }
    }
}
