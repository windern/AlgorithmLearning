package com.windern.algorithmlearning.mooc.array;

import java.util.Arrays;

/**
 * 5607. 生成平衡数组的方案数
 *
 * @author windern
 * @date 2020/11/22 11:36
 **/
public class WaysToMakeFair {

    public static int waysToMakeFair(int[] nums) {
        // 记录i位置后面的累加和
        int[] meno = new int[nums.length + 2];
        // 多加2个，这样下面循环不会溢出
        Arrays.fill(meno, 0);

        // 初始化化，最后两个值
        int i = nums.length - 1;
        while (i >= 0) {
            meno[i] = nums[i] + meno[i + 2];
            i--;
        }

        int ans = 0;
        for (i = 0; i < nums.length; i++) {
            // 假如移除i
            boolean oushu = i % 2 == 0;

            if (oushu) {
                // 前部分偶数和
                int qianou = meno[0] - meno[i];
                // 前部分奇数和
                int qianji = meno[1] - meno[i + 1];

                // 奇数变偶数，所以i+1就是偶数了
                int ou = qianou + meno[i + 1];
                int ji = qianji + meno[i + 2];
                if (ou == ji) {
                    ans++;
                }
            } else {
                // 前部分偶数和
                int qianou = meno[0] - meno[i + 1];
                // 钱部分奇数和
                int qianji = meno[1] - meno[i];

                int ou = qianou + meno[i + 2];
                int ji = qianji + meno[i + 1];
                if (ou == ji) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2};
        int result = waysToMakeFair(nums);
        // result = 3
        System.out.println(result);
    }
}
