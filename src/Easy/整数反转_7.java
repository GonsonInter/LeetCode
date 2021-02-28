package Easy;


public class 整数反转_7 {

    /**
     * 我们可以一次构建反转整数的一位数字。在这样做的时候，我们可以预先检查向原整数附加另一位数字是否会导致溢出。
     */

    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int r = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && r > 7)) result = 0;
            else if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10 && r < -8)) result = 0;
            else result = result * 10 + r;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(reverse(153423646));
    }
}
