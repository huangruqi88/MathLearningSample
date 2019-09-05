package com.lianyun.mathlearningsample.Lesson3;

import com.lianyun.mathlearningsample.Lesson3.Lesson3_2;

import java.util.Arrays;

/**
 * @data: 2019/7/8 11:51
 * @author: hrq
 * @Email:
 * @Description:
 */
public class MathLearning3 {

    public static void main(String[] args) {
        //============================================================================
                                     //TODO:Lesson3_1
        //============================================================================
//        System.out.println(String.format(" 舍罕王给了这么多粒：%d",Lesson3_1.getNumberWheat(63)));


        //============================================================================
                                 //TODO:Lesson3_2
        //============================================================================
//        int num = 10;
//        double squareRoot = Lesson3_2.getSquareRoot(num, 0.000001, 10000);
//        if (squareRoot == -1.0) {
//            System.out.println("请输入大于 1 的整数！");
//        } else if (squareRoot == -2.0) {
//            System.out.println("未能找到解！");
//        } else {
//            System.out.println(String.format(" %d 的平方根是 %f",num,squareRoot));
//        }

        //============================================================================
        //TODO:Lesson3_2
        //============================================================================

        String[] dictionary = {"i","am","one","of","the","authors","in","geekbang",};

        Arrays.sort(dictionary);

        String wordToFind = "i";

        boolean found = Lesson3_3.search(dictionary,wordToFind);
        if (found) {
            System.out.println(String.format("找到了单词 %s",wordToFind));
        } else {
            System.out.println(String.format("未找到单词 %s",wordToFind));
        }
    }
}
