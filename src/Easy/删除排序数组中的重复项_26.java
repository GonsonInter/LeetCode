package Easy;

import java.util.ArrayList;
import java.util.Arrays;

public class 删除排序数组中的重复项_26 {

//    /**
//     * 删除数组元素，移动数组元素
//     */
//    public static int removeDuplicates(int[] nums) {
//        int count = 0;
//        for (int i = 0; i < nums.length - 1; i ++) {
//            while (nums[i] == nums[i + 1] && i < nums.length - 1 - count) {
//                delete(nums, i + 1, count);
//                count ++;
//            }
//        }
//        return nums.length - count;
//    }
//
//    public static int[] delete(int[] nums, int index, int count) {
//        for (int i = index; i < nums.length - 1 - count; i ++)
//            nums[i] = nums[i + 1];
//        return nums;
//    }

    /**
     * 双指针解法
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0)   return 0;
        int i = 0;
        for (int j = 0; j < nums.length; j ++) {
//            if (nums[i] == nums[j])     continue;
//            if (i < nums.length - 1) {
//                nums[++i] = nums[j];
//            }


            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {1,1}));
    }
}
