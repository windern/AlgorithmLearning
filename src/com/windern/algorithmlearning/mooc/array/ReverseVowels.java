package com.windern.algorithmlearning.mooc.array;

/**
 * 345. 反转字符串中的元音字母
 *
 * @author windern
 * @date 2020/11/21 22:18
 **/
public class ReverseVowels {

    public static String reverseVowels(String s) {
        char[] array = s.toCharArray();

        int i = 0;
        int j = array.length - 1;

        while (i < j) {
            if (!isVowel(array[i])) {
                i++;
            } else if (!isVowel(array[j])) {
                j--;
            } else {
                swap(array, i++, j--);
            }
        }

        return String.valueOf(array);
    }

    /**
     * 是否是元音，大小写要考虑
     *
     * @param c 字符
     * @return 是否元音
     */
    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
            || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    private static void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        String result = reverseVowels(s);
        System.out.println(result);
    }
}
