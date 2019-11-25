package com.lianyun.mathlearningsample.Lesson7;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @data: 2019/11/14 15:13
 * @author: hrq
 * @Email:
 * @Description:
 */
public class MathLearning7 {
    public static void main(String[] args) {
        ArrayList<String> horses = new ArrayList<>(Arrays.asList("t1","t2","t3"));
        Lesson7_1.permutate(horses,new ArrayList<String>());

//        //test2
//        ArrayList<String> tHorses = new ArrayList<>(Arrays.asList("t1","t2","t3"));
//        Lesson7_2.permutate(tHorses,new ArrayList<String>());
//        ArrayList<String> qHorses = new ArrayList<>(Arrays.asList("t1","t2","t3"));
//        Lesson7_2.permutate(qHorses,new ArrayList<String>());
    }
}
