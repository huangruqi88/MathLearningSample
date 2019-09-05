package com.lianyun.mathlearningsample.Lesson1;

import com.lianyun.mathlearningsample.Lesson3.Lesson3_2;

import static com.lianyun.mathlearningsample.Lesson1.Lesson1_1.decimalToBinary;

/**
 * @data: 2019/7/8 11:51
 * @author: hrq
 * @Email:
 * @Description:
 */
public class MathLearning1 {

    public static void main(String[] args) {
        //============================================================================
        //TODO:Lesson1_1
        //============================================================================
//        int a = 53;
//        String b = "110101";
//
//        // 获取十进制数 53 的二进制数
//        System.out.println(String.format(" 数字 %d 的二进制是 %s", a, Lesson1_1.decimalToBinary(a)));
//        // 获取二进制数 110101 的十进制数
//        System.out.println(String.format(" 数字 %s 的十进制是 %d", b, Lesson1_1.binaryToDecimal(b)));

        //============================================================================
        //TODO:Lesson1_2
        //============================================================================
//
//        int num = 53;
//        int m = 1;
//        //二进制左移一位，其实就是将数字翻倍。
//        System.out.println(String.format(" 数字 %d 的二进制左移 %d位是 %d", num, m, Lesson1_2.leftShift(num, m)));
//        // 获取二进制数 110101 的十进制数
//        System.out.println(String.format(" 数字 %d 的二进制右移 %d位是 %d", num, m, Lesson1_2.rightShift(num, m)));
//
//        System.out.println();
//
//        //二进制右移一位，就是将数字除以 2 并求整数商的操作。
//        m = 3;
//        System.out.println(String.format(" 数字 %d 的二进制左移 %d位是 %d", num, m, Lesson1_2.leftShift(num, m)));
//        // 获取二进制数 110101 的十进制数
//        System.out.println(String.format(" 数字 %d 的二进制右移 %d位是 %d", num, m, Lesson1_2.rightShift(num, m)));

        //============================================================================
        //TODO:Lesson1_3
        //============================================================================

            int a = 53;
            int b = 35;

            System.out.println(String.format(" 数字 %d(%s) 和数字 %d(%s) 的按位‘或’结果是 %d(%s)",
                    a, decimalToBinary(a), b, decimalToBinary(b),
                    Lesson1_3.or(a, b), decimalToBinary(Lesson1_3.or(a, b)))); // 获取十进制数 53 和 35 的按位“或”

            System.out.println(String.format(" 数字 %d(%s) 和数字 %d(%s) 的按位‘与’结果是 %d(%s)",
                    a, decimalToBinary(a), b, decimalToBinary(b),
                    Lesson1_3.and(a, b), decimalToBinary(Lesson1_3.and(a, b))));  // 获取十进制数 53 和 35 的按位“与”

            System.out.println(String.format(" 数字 %d(%s) 和数字 %d(%s) 的按位‘异或’结果是 %d(%s)",
                    a, decimalToBinary(a), a, decimalToBinary(a),
                    Lesson1_3.xor(a, a), decimalToBinary(Lesson1_3.xor(a, a))));  // 获取十进制数 53 和 35 的按位“异或”

    }
}
