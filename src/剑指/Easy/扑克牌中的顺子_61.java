package 剑指.Easy;

import java.util.Arrays;

public class 扑克牌中的顺子_61 {


//    /**
//     * 排序遍历判断
//     */
//    public static boolean isStraight(int[] nums) {
//
//        int[] arr = Arrays.copyOf(nums, nums.length);
//        Arrays.sort(arr);
//
//        // 记录有几个0
//        int k = 0;
//        while (arr[k] == 0) k ++;
//
//        int i = k;
//        while (i < arr.length - 1){
//            if (arr[i + 1] - arr[i] == 1) {
//                i ++;
//                continue;
//            }
//            if (k == 0) return false;
//            k--;
//            arr[i] += 1;
//        }
//
//        return true;
//    }


    /**
     * 题解区k神的解法
     * 先对数组执行排序。
     * 判别重复： 排序数组中的相同元素位置相邻，因此可通过遍历数组，判断 nums[i] = nums[i + 1] 是否成立来判重。
     * 获取最大 / 最小的牌： 排序后，数组末位元素 nums[4] 为最大牌；元素 nums[joker] 为最小牌，其中 joker 为大小王的数量。
     */
    public static boolean isStraight(int[] nums) {
        int joker = 0;
        Arrays.sort(nums); // 数组排序
        for(int i = 0; i < 4; i++) {
            if(nums[i] == 0) joker++; // 统计大小王数量
            else if(nums[i] == nums[i + 1]) return false; // 若有重复，提前返回 false
        }
        return nums[4] - nums[joker] < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }


    public static void main(String[] args) {
        int[] arr = new int[] {1,2,12,0,3};
        System.out.println(isStraight(arr));

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
