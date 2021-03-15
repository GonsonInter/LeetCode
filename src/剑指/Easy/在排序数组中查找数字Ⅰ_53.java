package 剑指.Easy;

public class 在排序数组中查找数字Ⅰ_53 {


//    /**
//     * 二分查找
//     * 找到左边第一个后往后开始计数
//     */
//    public static int search(int[] nums, int target) {
//        if (nums.length == 0)   return 0;
//        int i = 0, j = nums.length - 1;
//        while (i < j) {
//            int mid = i + (j - i) / 2;
//            if (target <= nums[mid])    j = mid;
//            else    i = mid + 1;
//        }
//        if (nums[i] != target)  return 0;
//
//        int count = 0;
//        for (int k = i; k < nums.length && nums[k] == target; k ++)     count ++;
//
//        return count;
//    }


    /**
     * 二分查找，分别查找左边界和右边界，然后用右边界减去左边界就是元素个数
     */
    public static int search(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    static int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= tar) i = m + 1;
            else j = m - 1;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] {5,7,7,8,8,10}, 6));
    }

}
