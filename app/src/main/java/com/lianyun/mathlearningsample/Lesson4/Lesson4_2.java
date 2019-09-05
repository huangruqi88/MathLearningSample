package com.lianyun.mathlearningsample.Lesson4;

/**
 * @data: 2019/9/2 16:12
 * @author: hrq
 * @Email:
 * @Description:
 */
public class Lesson4_2 {

    /**
     * @param k      放到第几格， result保存当前格子的麦粒数和麦粒总数
     * @param result
     * @return 放到第K格时是否成立
     * @Desciption 使用函数的递归（嵌套）调用，进行数学归纳法证明
     */
    public static boolean preove(int k, Result result) {
        //证明n = 1 时，命题是否成立
        if (k == 1) {
            if ((Math.pow(2,1)-1) == 1) {
                result.wheatNum = 1;
                result.wheatTotalNum = 1;
                return true;
            } else {
                return false;
            }
        } else {
            //如果 n = (k-1)时命题成立，证明n = k时命题是否成立
            boolean proveOfPreviousOne = preove(k -1,result);
            result.wheatNum *= 2;
            result.wheatTotalNum += result.wheatNum;
            boolean proveOfCurrentOne = false;
            if (result.wheatTotalNum == (Math.pow(2,k) -1)) {
                proveOfCurrentOne = true;
            }
            if (proveOfPreviousOne && proveOfCurrentOne) {
                return true;
            } else {
                return false;
            }
        }
    }
}
