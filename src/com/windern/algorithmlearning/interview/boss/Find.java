package com.windern.algorithmlearning.interview.boss;

/**
 * Find
 *
 * @author: windern
 * @create: 2020/4/24 19:36
 **/
public class Find {

    public static char find(char[] chars1, char[] chars2) {
        int l = 0;
        int r = chars2.length - 1;

        while (l < r) {
            if (chars1[l] == chars2[l]) {
                if (chars1[r] == chars2[r]) {
                    return chars1[r + 1];
                }

                int mid = l + (r - l) / 2;
                if (chars1[mid] == chars2[mid]) {
                    l = mid + 1;
                } else {
                    return chars1[mid];
                }
            } else {
                return chars1[l];
            }
        }

        return chars1[r];
    }

    public static char find(char[] chars1, char[] chars2, int l, int r) {
        if (chars1[l] != chars2[l]) {
            return chars1[l];
        }

        if (chars1[r] == chars2[r]) {
            return chars1[r + 1];
        }

        int mid = l + (r - l) / 2;
        if (chars1[mid] == chars2[mid]) {
            return find(chars1, chars2, mid + 1, r);
        } else {
            return find(chars1, chars2, l, mid);
        }
    }

    public static char find2(char[] chars1, char[] chars2) {
        return find(chars1, chars2, 0, chars2.length - 1);
    }


    public static void main(String[] args) {
//        char[] chars1 = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
//        char[] chars2 = {'a', 'b', 'c', 'd', 'f', 'g'};

        char[] chars1 = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        char[] chars2 = {'a', 'b', 'c', 'd', 'e', 'f'};

//        char[] chars1 = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
//        char[] chars2 = {'b', 'c', 'd', 'e', 'f', 'g'};
        char c = find2(chars1, chars2);
        System.out.println(c);
    }
}
