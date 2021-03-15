package 剑指.Normal;

public class 数组中数字出现的次数Ⅰ_56 {


    /**
     * 分组异或
     *
     * 根据异或的特性，用一个零变量依次异或一次数组元素，结果是两个不同的数的异或之和
     *
     * 然后用这个数对整个数组进行分割，使不相同的两个数在不同的部分，相同的数在相同的部分，然后分别对两个部分进行零变量依次异或就能获得值
     */
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for (int num : nums)
            res ^= num;

        int lowbit = res & (-res);

        int a = 0, b = 0;

        for (int num : nums) {
            if ((num & lowbit) != 0)    a ^= num;
            else    b ^= num;
        }

        return new int[] {a, b};
    }
}
