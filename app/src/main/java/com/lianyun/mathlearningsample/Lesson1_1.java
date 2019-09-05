package com.lianyun.mathlearningsample;

import java.math.BigInteger;

/**
 * @data: 2019/7/8 11:47
 * @author: hrq
 * @Email:
 * @Description:
 */
public class Lesson1_1 {

    /**
     * @param decimalSource
     * @return String
     * @Description: 十进制转换成二进制
     */
    public static String decimalToBinary(int decimalSource) {
        // 转换成 BigInteger 类型，默认是十进制
        BigInteger bi = new BigInteger(String.valueOf(decimalSource));
        // 参数 2 指定的是转化成二进制
        return bi.toString(2);
    }

    /**
     * @param binarySource
     * @return int
     * @Description: 二进制转换成十进制
     */
    public static int binaryToDecimal(String binarySource) {
        // 转换为 BigInteger 类型，参数 2 指定的是二进制
        BigInteger bi = new BigInteger(binarySource, 2);
        // 默认转换成十进制
        return Integer.parseInt(bi.toString());
    }


}
