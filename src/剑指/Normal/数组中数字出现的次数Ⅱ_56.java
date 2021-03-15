package 剑指.Normal;

public class 数组中数字出现的次数Ⅱ_56 {

    /**
     * 对于每一个出现三次的数，将其所有的位数统计起来，一定是整除三的
     * 将每一位的个数统计起来，对三取模就是哪个多出来的数。
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i ++) {
            int count = 0;
            int bit = 1 << i;
            for (int num : nums) {
                if ((num & bit) != 0)   count ++;
            }
            count = count % 3;
            res += count << i;
        }

        return res;
    }
}
