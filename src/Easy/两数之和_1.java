package Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;


/**
 * 暴力破解
 */
//class Solution1 {
//    public int[] twoSum(int[] nums, int target) {
//
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[] {i, j};
//                }
//            }
//        }
//        return null;
//
//    }
//}





public class 两数之和_1 {

    /**
     * Hash表解法
     * 新建HashMap，key是数组元素的值，value是下标。遍历数组的时候检查HashMap中是否有targt-num的值，有就匹配，没有就
     * 将当前数组对象添加到HashMap中。
     */
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> require = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (require.containsKey(target - nums[i]))
                return new int[] {require.get(target - nums[i]), i};
            require.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {

        int[] arr = new int[] {0, 1, 2, 3};
        System.out.println(Arrays.toString(twoSum(arr, 3)));
    }
}
