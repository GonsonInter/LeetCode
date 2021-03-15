package 剑指.Easy;

import java.util.HashMap;

public class 和为s的两个数字_57 {

//    /**
//     * HashMap
//     */
//    public int[] twoSum(int[] nums, int target) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            if (map.containsKey(num))   return new int[] {num, map.get(num)};
//            map.put(target - num, num);
//        }
//        return new int[] {};
//    }


    /**
     * 双指针
     * 由于是有序的
     */
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] < target - nums[j])    i ++;
            else if (nums[i] > target - nums[j])    j --;
            else return new int[] {nums[i], nums[j]};
        }
        return new int[] {};
    }

}
