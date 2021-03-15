package 剑指.Easy;

public class 调整数组顺序使基数位于偶数前面_21 {

    /**
     * 类似于快速排序的思想
     */
    public int[] exchange(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            if ((nums[low] & 1) == 0 && (nums[high] & 1) != 0) {
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                low ++;
                high --;
            } else if ((nums[low] & 1) == 1) low ++;
            else high --;
        }
        return nums;
    }

    /**
     * 分治法
     */
}
