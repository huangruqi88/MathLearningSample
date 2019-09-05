package com.lianyun.mathlearningsample.Lesson4;

import com.lianyun.mathlearningsample.Lesson3.Lesson3_1;

/**
 * @data: 2019/9/2 15:46
 * @author: hrq
 * @Email:
 * @Description:
 */
public class Lesson4_1 {
    public static void main(String[] args) {
        int gird = 63;
        long start,end;
        start = System.currentTimeMillis();
        System.out.println(String.format("舍罕王给了这么多粒：%d", Lesson3_1.getNumberWheat(gird)));
        end = System.currentTimeMillis();
        System.out.println(String.format("耗时 %d 毫秒",(end -start)));


        start = System.currentTimeMillis();
        System.out.println(String.format("舍罕王给了这么多粒：%d",(long)Math.pow(2,gird)));
        end = System.currentTimeMillis();
        System.out.println(String.format("耗时 %d 毫秒",(end -start)));

    }
}
