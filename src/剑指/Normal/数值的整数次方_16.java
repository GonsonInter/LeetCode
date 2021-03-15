package 剑指.Normal;

public class 数值的整数次方_16 {

//    /**
//     * 递归, 直接递归会栈溢出
//     * 使用快速幂
//     * 这题看起来很简单，但能一步写成功很不容易，我们先来分析下。
//     *
//     * 当exponent是0的时候，直接返回1即可，
//     *
//     * 当exponent小于0的时候，需要把它转化为正数才能更方便计算，同时base要变为1/base。
//     *
//     * 当exponent大于0的时候要分为两种情况，一种是偶数，一种是奇数。
//     *
//     * 1， 如果exponent是偶数我们只需要计算
//     *
//     * Power(base*base, exponent/2)。举个例子，比如我们要计算Power（3，8），我们可以改为
//     * Power（3*3，8/2），也就是Power（9，4）。
//     *
//     * 2， 如果exponent是奇数，我们只需要计算
//     *
//     * base*Power(base*base, exponent/2)，比如Power（3，9），我们只需要计算3*Power（3*3，9/2），也就是3*Power（9，4）
//     */
//    public double myPow(double x, int n) {
//        if (n == 0)   return 1;
//        if (n < 0)
//            return 1 / x * myPow(1 / x, -n - 1);   //当n=Integer.MIN_VALUE的时候, n的相反数等于他自己，注意！
//        return (n & 1) == 0 ? myPow(x * x, n / 2) : myPow(x * x, n / 2) * x;
//    }

    /**
     * 非递归写法
     */
    public double myPow(double x, int n) {
        double result = 1.0;
        for (int i = n; i >= 1; i /= 2, x *= x) {
            if (i % 2 != 0)   // i为奇数
                result *= x;
        }
        return n < 0 ? 1 / result : result;
    }


}
