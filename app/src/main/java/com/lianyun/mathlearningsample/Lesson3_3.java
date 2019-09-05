package com.lianyun.mathlearningsample;

/**
 * @data: 2019/7/11 11:27
 * @author: hrq
 * @Email:
 * @Description:
 */
public class Lesson3_3 {

    /**
     * @param dictionary 排序后的字典
     * @param word2Find  word2Find- 待查的单词
     * @return boolean- 是否大仙待查的单词
     * @Description: 查找某个单词是否在字典里出现
     */
    public static boolean search(String[] dictionary, String word2Find) {
        if (dictionary == null) {
            return false;
        }
        if (dictionary.length <= 0) {
            return false;
        }

        int left = 0;
        int right = dictionary.length -1;

        while (left < right) {
            int middle = (left + right) / 2;

            if (dictionary[middle].equals(word2Find)) {
                return true;
            } else {

            }
        }

        return false;
    }
}
