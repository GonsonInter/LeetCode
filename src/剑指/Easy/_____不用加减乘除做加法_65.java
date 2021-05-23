package 剑指.Easy;

public class _____不用加减乘除做加法_65 {


//    /**
//     * 每一位的数值和为 a ^ b
//     *  进位为 a & b >> 1
//     *   迭代
//     */
//    public int add(int a, int b) {
//        while (b != 0) {
//            int c = (a & b) << 1;
//            a ^= b;
//            b = c;
//        }
//        return a;
//    }


    /**
     * 每一位的数值和为 a ^ b
     *  进位为 a & b >> 1
     *   递归
     */
    public int add(int a, int b) {
        if (b == 0) return a;
        int c = (a & b) << 1;
        return add(a ^ b, c);
    }
}
