package 剑指.Hard;

public class 数组中的逆序对_51 {

//    /**
//     * 暴力破解法
//     * 时间复杂度为O(n^2) 超时
//     */
//    public static int reversePairs(int[] nums) {
//        int count = 0;
//        for (int i = 0; i < nums.length; i++)
//            for (int j = 0; j < i; j++)
//                if (nums[i] < nums[j]) count++;
//        return count;
//    }


    /**
     * 归并排序
     */
    public static int reversePairs(int[] nums) {

        if (nums.length < 2) {
            return 0;
        }
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);

        int[] temp = new int[nums.length];      // 作为辅助数组
        return mergeSort(copy, 0, nums.length - 1, temp);

    }

    public static int mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left >= right)  return 0;
        int mid = left + (right - left) / 2;

        int leftPairs = mergeSort(nums, left, mid, temp);
        int rightPairs = mergeSort(nums, mid + 1, right, temp);

        if (nums[mid] <= nums[mid + 1])
            return leftPairs + rightPairs;

        int currentRev = merge(nums, left, mid, right, temp);

        return leftPairs + rightPairs + currentRev;
    }

    public static int merge(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i ++) {
            temp[i] = nums[i];
        }

        int i = left, j = mid + 1;
        int count = 0;

        for (int k = left; k <= right; k ++) {
            if (i > mid) {
                nums[k] = temp[j];
                j ++;
            }
            else if (j > right) {
                nums[k] = temp[i];
                i ++;
            }
            else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i ++;
            }
            else {
                nums[k] = temp[j];
                j ++;
                count += (mid + 1 - i);
            }
        }

        return count;
    }


    public static void main(String[] args) {
        System.out.println(reversePairs(new int[] {7,5,6,4,2,98,4,43,545,1,34,5,677,3,77,8,5,4,22,76,99}));
    }
}
