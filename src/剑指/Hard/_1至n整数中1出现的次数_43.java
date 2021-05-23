package 剑指.Hard;

import java.util.ArrayList;

public class _1至n整数中1出现的次数_43 {


//    /**
//     * 暴力破解
//     * 每次检查一个数含有几个一
//     * 这种方法超时了
//     */
//    public static int countDigitOne(int n) {
//        int count = 0;
//        for (int i = 1; i <= n; i ++)
//            count += containsOne(i);
//        return count;
//    }
//
//    public static int containsOne(int n) {
//        int count = 0;
//        while (n != 0) {
//            if (n % 10 == 1)  count ++;
//            n /= 10;
//        }
//        return count;
//    }


    /**
     * 题解解法
     * 从最低位开始，每次固定一位，将该位左右两边的数字分开，该位所出现的 1 的个数由左右两个数确定，high， low。当前位的进制为 digit
     * 假如该位为 0 ，即cur == 0，该位出现的 1 的次数 是 high * digit
     * cur == 1, high * digit + low + 1
     * cur > 1 , (high + 1) * digit
     * 每次循环左移一位，直到完成最高位结束
     */
    public static int countDigitOne(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0)  res += high * digit;
            else if (cur == 1)  res += high * digit + low + 1;
            else
                res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(countDigitOne(824883294));
    }

}
