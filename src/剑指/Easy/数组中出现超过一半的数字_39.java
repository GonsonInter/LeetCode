package 剑指.Easy;

import java.util.Arrays;

public class 数组中出现超过一半的数字_39 {


//    /**
//     * 排序以后找中间元素
//     */
//    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[nums.length / 2 + 1];
//    }

    /**
     * 投票算法
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        int current = nums[0];
        for (int num : nums) {
            if (num == current) {
                count ++;
            } else {
                count --;
                if (count == 0) current = num;
            }
        }
        return current;
    }
}
