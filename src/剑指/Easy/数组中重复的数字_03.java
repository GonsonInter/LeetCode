package 剑指.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 数组中重复的数字_03 {

//    /**
//     * Hash表
//     */
//    public int findRepeatNumber(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int num: nums) {
//            if (!map.containsKey(num))
//                map.put(num, 1);
//            else
//                map.put(num, map.get(num) + 1);
//        }
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() > 1)   return entry.getKey();
//        }
//        return -1;
//    }


//    /**
//     * 集合
//     */
//    public int findRepeatNumber(int[] nums) {
//        HashSet<Integer> set = new HashSet<>();
//        for (int num: nums) {
//            if (set.contains(num)) return num;
//            else set.add(num);
//        }
//        return -1;
//    }

//    /**
//     * 排序
//     */
//    public int findRepeatNumber(int[] nums) {
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 1; i ++) {
//            if (nums[i] == nums[i + 1]) return nums[i];
//        }
//        return -1;
//    }


    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i ++) {
            if (nums[i] == nums[i + 1]) return nums[i];
        }
        return -1;
    }

}
