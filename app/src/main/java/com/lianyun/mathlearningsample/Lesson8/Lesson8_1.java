package com.lianyun.mathlearningsample.Lesson8;

import java.util.ArrayList;

/**
 * @data: 2019/11/15 11:23
 * @author: hrq
 * @Email:
 * @Description:
 */
public class Lesson8_1 {

    /**
     * @param teams  目前还有多少队伍没有参与组合
     * @param result 保存当前已有的组合队伍
     * @param m
     * @Description 使用函数的递归（嵌套）调用，找出所有可能队伍的组合
     */
    public static void combine(ArrayList<String> teams, ArrayList<String> result, int m) {
        // 挑选完了m个元素，输出结果
        if (result.size() == m) {
            System.out.println(result);
            return;
        }

        for (int i = 0; i < teams.size(); i++) {
            //从剩下的队伍中，选择一队，加入结果
            ArrayList<String> newResult = (ArrayList<String>) result.clone();
            newResult.add(teams.get(i));

            //只考虑当前选择之后的队伍
            ArrayList<String> restTeams = new ArrayList<>(teams.subList(i + 1, teams.size()));
            combine(restTeams, newResult, m);
        }
    }

}
