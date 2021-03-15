package 剑指.Normal;

public class 数字序列中某一位的数字_44 {


//    /**
//     * base * digit 可能会造成越界问题
//     */
//    public static int findNthDigit(int n) {
//        if (n < 10) return n;
//        n -= 9;
//        int base = 90;
//        int digit = 2;
//        int last = 10;
//        while (n - base * digit > 0) {
//            n -= base * digit;
//            last = (int) (Math.pow(10, digit) - 1);
//            digit ++;
//            base *= 10;
//        }
//        int targetNum = last + (int) Math.ceil(n / Double.parseDouble(String.valueOf(digit))) - 1;
//        System.out.println(targetNum);
//        int offset = n % digit;
//        System.out.println(offset);
//        if (offset == 0)    return targetNum % 10;
//        int remainDig = digit - offset;
//        while (remainDig > 0) {
//            targetNum /= 10;
//            remainDig --;
//        }
//        return targetNum % 10;
//    }


    /**
     * 题解
     */
    public static int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }


    public static void main(String[] args) {
        System.out.println(findNthDigit(100000000));
    }
}
