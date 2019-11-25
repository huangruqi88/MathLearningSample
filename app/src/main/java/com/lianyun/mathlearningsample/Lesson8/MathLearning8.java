package com.lianyun.mathlearningsample.Lesson8;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @data: 2019/11/15 11:40
 * @author: hrq
 * @Email:
 * @Description:
 */
public class MathLearning8 {

    public static void main(String[] args) {
        ArrayList<String> teams = new ArrayList<>(Arrays.asList("t1","t2","t3"));
        Lesson8_1.combine(teams,new ArrayList<String>(),2);
    }

}
