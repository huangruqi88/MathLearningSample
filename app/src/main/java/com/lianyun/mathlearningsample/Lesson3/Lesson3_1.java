package com.lianyun.mathlearningsample.Lesson3;

/**
 * @data: 2019/7/11 11:27
 * @author: hrq
 * @Email:
 * @Description:
 */
public class Lesson3_1 {

    public static long getNumberWheat(int grid) {
        long sum = 0;   //麦子总数
        long numberWheatInGrid = 0;  //当前麦子的数量

        numberWheatInGrid = 1;      //第一格子里的麦粒数量

        sum += numberWheatInGrid;

        for (int i = 2; i <= grid; i++) {
            numberWheatInGrid *= 2;     //当前格子里麦粒的数量是前一格的 2 倍
            sum += numberWheatInGrid;       // 累计麦粒的总数
        }
        return sum;
    }

}
