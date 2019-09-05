package com.lianyun.mathlearningsample;

/**
 * @data: 2019/7/11 11:27
 * @author: hrq
 * @Email:
 * @Description:
 */
public class Lesson3_2 {

    /**
     * @Description 计算大于 1 的正整数在建瓯平方根
     * @param n 带求的数， deltaThreshold- 误差阈值，maxTry- 二分查找的最大次数
     * @param deltaThreshold
     * @param maxTry
     * @return double- 平方根求的解
     */
    public static double getSquareRoot(int n, double deltaThreshold, int maxTry) {
        if (n <= 1) {
            return -1.0d;
        }
        double min = 1.0, max = (double) n;
        for (int i = 0; i < maxTry; i++) {
            double middle = (min + max) / 2;
            double square = middle * middle;
            double delta = Math.abs((square / n) - 1);
            if (delta <= deltaThreshold) {
                return middle;
            } else {
                if (square > n) {
                    max = middle;
                } else {
                    min = middle;
                }
            }
        }
        return -2.0D;
    }

}
