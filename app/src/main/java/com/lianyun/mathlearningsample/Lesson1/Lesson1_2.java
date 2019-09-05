package com.lianyun.mathlearningsample.Lesson1;

/**
 * @data: 2019/7/8 11:47
 * @author: hrq
 * @Email:
 * @Description:
 */
public class Lesson1_2 {

    /**
     * @Description 向左移
     * @param num 等待移位的十进制数,
     * @param m  m- 向左移的位数
     * @return 移位后的十进制数
     */
    public static int leftShift(int num, int m){
        return num << m;
    }
    /**
     * @Description 向右移
     * @param num 等待移位的十进制数,
     * @param m  m- 向右移的位数
     * @return 移位后的十进制数
     */
    public static int rightShift(int num, int m){
        return num >>> m;
    }

}
