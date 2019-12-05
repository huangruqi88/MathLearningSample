package com.lianyun.mathlearningsample.Lesson10;

public class Lesson10_1 {
    private static String word1;
    private static String word2;

    /**
     * @param a 第一个字符串，
     * @param b 第二个字符串
     * @return 两者之间的距离
     * @Description: 使用状态转移方程，计算两个字符串之间的编辑距离
     */
    public static int getStrDistance(String a, String b) {
        if (a == null || b == null) {
            return -1;
        }
        //初始用于记录化状态转移的二维表
        int[][] d = new int[a.length() + 1][b.length() + 1];
        //如果i为0；且j大于等于0，那么d[i,j]为j
        for (int j = 0; j <= b.length(); j++) {
            d[0][j] = j;
        }
        //如果i大于等于0，且j为0，那么d[i,j]为j
        for (int i = 0; i < a.length(); i++) {
            d[i][0] = i;
        }

        //实现状态转移方程
        //请注意由于Java语言实现的关系，代码里的状态转移是从d[i,j]到d[j+1,j+1]
        //而不是从d[i-1,j-1]到d[i,j]。本质上是一样的。
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                int r = 0;
                if (a.charAt(i) != b.charAt(j)) {
                    r = 1;
                }
                int first = d[i][j] + 1;
                int second = d[i + 1][j] + 1;
                int replace = d[i][j] + r;
                int min = Math.min(first, second);
                min = Math.min(min, replace);
                d[i + 1][j + 1] = min;
            }
        }
        return d[a.length()][b.length()];
    }

    /**
     * 协助理解公式   其实两个公式是一样的不同的写法，
     * 一个把+1放在去最小值之后，一个是在每个参数分别+1
     *
     * @param word1
     * @param word2
     * @return
     */
    public static int getStrDistance1(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        //如果其中一个字符串为空
        if (n * m == 0) {
            return n + m;
        }
        //数组来存储转换历史记录
        int[][] d = new int[n + 1][m + 1];
        //j为0的时候
        for (int i = 0; i < n + 1; i++) {
            d[i][0] = i;
        }
        //i为0的时候
        for (int j = 0; j < m + 1; j++) {
            d[0][j] = j;
        }
        //动态规划（DP）计算
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = d[i - 1][j] + 1;
                int down = d[i][j - 1] + 1;
                int left_down = d[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                d[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return d[n][m];
    }
}
