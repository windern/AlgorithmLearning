package com.windern.algorithmlearning.mooc.array;

/**
 * @author windern
 * @date 2020/11/21 16:48
 **/
public class BinarySearch {

    /**
     * 查找target所在的索引值
     * @param array 数组
     * @param target 目标
     * @return 索引值
     */
    private static int binarySearch(int[] array, int target) {
        //[l,r]区间内查找数据
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            // 不能用加法，可能整形溢出，改用减法
            int mid = l + (r - l)/2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                //[mid+1, r]之间查找
                l = mid + 1;
            } else {
                // [l,mid-1]之间查找
                r = mid - 1;
            }
        }

        return -1;
    }

    private static int[] createArray(int n) {
        int[] array = new int[n];
        for(int i=0;i<n;i++) {
            array[i] = i;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = createArray(10000000);
        int result = binarySearch(array, -2);
        System.out.println(result);
    }
}
