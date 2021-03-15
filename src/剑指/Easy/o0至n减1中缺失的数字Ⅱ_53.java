package 剑指.Easy;

public class o0至n减1中缺失的数字Ⅱ_53 {


    /**
     * 二分法
     */
    public static int missingNumber(int[] nums) {
        if (nums.length < 2)    return -1;
        int i = 0, j = nums.length - 1;

        while (i <= j) {
            int midIndex = (j + i) / 2;
            int midNum = nums[midIndex];
            if (midNum == midIndex)  i = midIndex + 1;
            if (midNum > midIndex)  j = midIndex - 1;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[] {0,1,2,3,4,6,7,8,9,10,11,12}));
    }

}
