package com.lianyun.mathlearningsample.Lesson5;

import java.util.ArrayList;

/**
 * @data: 2019/9/5 16:39
 * @author: hrq
 * @Email:
 * @Description:
 */
public class Lesson5_1 {
    public static long[] rewards = {1, 2, 5, 10};

    public static void get(long totalReward, ArrayList<Long> result) {

        if (totalReward == 0) {
            //当 totalReward = 0 时，结束嵌套调用，输出解
            System.out.println(result);
            return;
        } else if (totalReward < 0){
            //当 totalReward < 0 时，证明它不是满足条件的解，不输出
            return;
        } else {
            for (int i = 0; i < rewards.length; i++) {

                ArrayList<Long> newResult = (ArrayList<Long>) result.clone();     //由于有 4 种情况，需要clone当前的解并传入被调用的函数
                newResult.add(rewards[i]);                                        // 记录当前的选择，解决一点问题
                get(totalReward - rewards[i],newResult);                //剩下的问题，留给嵌套调用去解决
            }
        }
    }
}
