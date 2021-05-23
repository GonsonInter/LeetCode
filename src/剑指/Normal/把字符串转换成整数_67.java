package 剑指.Normal;

public class 把字符串转换成整数_67 {


//    /**
//     * 我自己的答案
//     */
//    public static int strToInt(String str) {
//        str = str.trim();
//        if (str.length() == 0)  return 0;
//        boolean sign = true;
//        if (str.charAt(0) == '-')   {
//            sign = false;
//            str = str.substring(1);
//        }
//        else if (str.charAt(0) == '+')
//            str = str.substring(1);
//
//        int index = 0;
//        int res = 0;
//        int len = str.length();
//        while (index < len && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
//
//            if (res > Integer.MAX_VALUE / 10)  return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
//
//            if (res == Integer.MAX_VALUE / 10 && str.charAt(index) > '7') {
//                if (sign)
//                    return Integer.MAX_VALUE;
//                else if (str.charAt(index) > '8')
//                    return Integer.MIN_VALUE;
//            }
//
//            res = res * 10 + (str.charAt(index) - '0');
//            index ++;
//        }
//
//        return sign ? res : -res;
//    }


    /**
     * k神的答案
     */
    public static int strToInt(String str) {

        char[] c = str.trim().toCharArray();
        if(c.length == 0) return 0;
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if(c[0] == '-') sign = -1;
        else if(c[0] != '+') i = 0;
        for(int j = i; j < c.length; j++) {
            if(c[j] < '0' || c[j] > '9') break;
            if(res > bndry || res == bndry && c[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;
    }


    public static void main(String[] args) {
        System.out.println(strToInt("-91283472332"));
    }
}
