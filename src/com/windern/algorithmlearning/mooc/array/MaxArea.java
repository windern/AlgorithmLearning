package com.windern.algorithmlearning.mooc.array;

/**
 * 11. 盛最多水的容器
 *
 * @author windern
 * @date 2020/11/21 22:44
 **/
public class MaxArea {

    public static int maxArea(int[] height) {
        // 对撞指针，移动小的边界
        int i = 0;
        int j = height.length - 1;
        int ans = 0;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j -i);
            ans = Math.max(ans, area);
            // 移动小的边界，好结果只能在小的边界移动后
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = maxArea(height);
        // result = 49
        System.out.println(result);
    }
}
