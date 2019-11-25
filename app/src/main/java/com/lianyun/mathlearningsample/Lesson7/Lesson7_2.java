package com.lianyun.mathlearningsample.Lesson7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @data: 2019/11/14 11:48
 * @author: hrq
 * @Email:
 * @Description:
 */
public class Lesson7_2 {

    //设置齐王的马跑的时间
    public static HashMap<String, Double> qHorsesTime = new HashMap<String, Double>() {
        {
            put("q1", 1.0);
            put("q2", 2.0);
            put("q3", 3.0);
        }
    };

    //设置田忌的马跑的时间
    public static HashMap<String, Double> tHorsesTime = new HashMap<String, Double>() {
        {
            put("t1", 1.5);
            put("t2", 2.5);
            put("t3", 3.5);
        }
    };

//    public static ArrayList<String> qHorses = new ArrayList<>(Arrays.asList("q1", "q2", "q3"));

    /**
     * @param horses 目前还剩多少没有出战的战马
     * @param result 保存当前已经出战的马匹及顺序
     * @Description 使用函数的递归（嵌套）调用，找出所有可能的马匹出战顺序
     */
    public static void permutate(ArrayList<String> horses, ArrayList<String> result, ArrayList<String> qHorses) {
        //所有马匹都已经出战，判断哪方获胜，输出结果
        if (horses.size() == 0) {
            System.out.println(result);
            compare(result, qHorses);
            System.out.println();
            return;
        }
        for (int i = 0; i < horses.size(); i++) {
            //从剩下的为出战的马匹中，选择一匹，加入结果
            ArrayList<String> newResult = (ArrayList<String>) result.clone();
            newResult.add(horses.get(i));

            // 将已出战的马匹从未出战的列表中移出
            ArrayList<String> restHorses = (ArrayList<String>) horses.clone();
            restHorses.remove(i);

            //递归调用，对于剩余的马匹继续生成排列
            permutate(restHorses, newResult,qHorses);

        }
    }

    private static void compare(ArrayList<String> tHorses, ArrayList<String> qHorses) {
        int tWonCount = 0;
        for (int i = 0; i < tHorses.size(); i++) {
            System.out.println(tHorsesTime.get(tHorses.get(i)) + " " + qHorsesTime.get(qHorses.get(i)));
            if (tHorsesTime.get(tHorses.get(i)) < qHorsesTime.get(qHorses.get(i))) {
                tWonCount++;
            }
        }
        if (tWonCount > tHorses.size() / 2) {
            System.out.println("田忌获胜！");
        } else {
            System.out.println("齐王获胜");
        }
        System.out.println();
    }
}
