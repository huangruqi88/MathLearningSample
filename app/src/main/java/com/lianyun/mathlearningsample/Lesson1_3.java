package com.lianyun.mathlearningsample;

/**
 * @data: 2019/7/8 15:50
 * @author: hrq
 * @Email:
 * @Description:
 */

public class Lesson1_3 {

    /**
     * @Description: 二进制按位“或”的操作
     * @param num1- 第一个数字，num2- 第二个数字
     * @return 二进制按位“或”的结果
     */
    public static int or(int num1, int num2) {
        return (num1 | num2);
    }

    /**
     * @Description: 二进制按位“与”的操作
     * @param num1- 第一个数字，num2- 第二个数字
     * @return 二进制按位“与”的结果
     */
    public static int and(int num1, int num2) {
        return (num1 & num2);
    }

    /**
     * @Description: 二进制按位“异或”的操作
     * @param num1- 第一个数字，num2- 第二个数字
     * @return 二进制按位“异或”的结果
     */
    public static int xor(int num1, int num2) {
        return (num1 ^ num2);
    }

}

