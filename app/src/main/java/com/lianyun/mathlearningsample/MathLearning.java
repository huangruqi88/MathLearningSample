package com.lianyun.mathlearningsample;

import com.lianyun.mathlearningsample.Lesson3.Lesson3_2;

/**
 * @data: 2019/7/8 11:51
 * @author: hrq
 * @Email:
 * @Description:
 */
public class MathLearning {

    public static void main(String[] args) {

//        int a = 53;
//        String b = "110101";
//
//        // 获取十进制数 53 的二进制数
//        System.out.println(String.format(" 数字 %d 的二进制是 %s", a, Lesson1_1.decimalToBinary(a)));
//        // 获取二进制数 110101 的十进制数
//        System.out.println(String.format(" 数字 %s 的十进制是 %d", b, Lesson1_1.binaryToDecimal(b)));

//        int num = 53;
//        int m = 1;
//
//        System.out.println(String.format(" 数字 %d 的二进制左移 %d位是 %d", num, m, Lesson1_2.leftShift(num, m)));
//        // 获取二进制数 110101 的十进制数
//        System.out.println(String.format(" 数字 %d 的二进制右移 %d位是 %d", num, m, Lesson1_2.rightShift(num, m)));
//
//        System.out.println();
//        m = 3;
//        System.out.println(String.format(" 数字 %d 的二进制左移 %d位是 %d", num, m, Lesson1_2.leftShift(num, m)));
//        // 获取二进制数 110101 的十进制数
//        System.out.println(String.format(" 数字 %d 的二进制右移 %d位是 %d", num, m, Lesson1_2.rightShift(num, m)));

//            int a = 53;
//            int b = 35;
//
//            System.out.println(String.format(" 数字 %d(%s) 和数字 %d(%s) 的按位‘或’结果是 %d(%s)",
//                    a, decimalToBinary(a), b, decimalToBinary(b), Lesson1_3.or(a, b), decimalToBinary(Lesson1_3.or(a, b)))); // 获取十进制数 53 和 35 的按位“或”
//
//            System.out.println(String.format(" 数字 %d(%s) 和数字 %d(%s) 的按位‘与’结果是 %d(%s)",
//                    a, decimalToBinary(a), b, decimalToBinary(b), Lesson1_3.and(a, b), decimalToBinary(Lesson1_3.and(a, b))));  // 获取十进制数 53 和 35 的按位“与”
//
//            System.out.println(String.format(" 数字 %d(%s) 和数字 %d(%s) 的按位‘异或’结果是 %d(%s)",
//                    a, decimalToBinary(a), a, decimalToBinary(a), Lesson1_3.xor(a, a), decimalToBinary(Lesson1_3.xor(a, a))));  // 获取十进制数 53 和 35 的按位“异或”


//        System.out.println(String.format(" 舍罕王给了这么多粒：%d",Lesson3_1.getNumberWheat(64)));


        int num = 10;
        double squareRoot = Lesson3_2.getSquareRoot(num, 0.000001, 10000);
        if (squareRoot == -1.0) {
            System.out.println("请输入大于 1 的整数！");
        } else if (squareRoot == -2.0) {
            System.out.println("未能找到解！");
        } else {
            System.out.println(String.format(" %d 的平方根是 %f",num,squareRoot));
        }
    }
}
