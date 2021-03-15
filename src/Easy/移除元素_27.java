package Easy;

public class 移除元素_27 {
//    /**
//     * 双指针解法1、相当于移动元素
//     */
//    public int removeElement(int[] nums, int val) {
//        int i = 0;
//        for (int j = 0; j < nums.length; j++) {
//            if (nums[j] != val)
//                nums[i ++] = nums[j];
//        }
//        return i;
//    }

    /**
     * 双指针解法2、要删除的元素和数组末尾元素交换，然后把数组的长度减一
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}
