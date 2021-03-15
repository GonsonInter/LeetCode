package 剑指.Easy;

import java.util.Arrays;

public class 替换空格_05 {

//    /**
//     * 直接遍历法
//     */
//    public String replaceSpace(String s) {
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < s.length(); i ++) {
//            result.append(s.charAt(i) == ' ' ? "%20" : s.charAt(i));
//        }
//        return result.toString();
//    }

    /**
     * 直接遍历法
     */
    public String replaceSpace(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i ++) {
            result.append(s.charAt(i) == ' ' ? "%20" : s.charAt(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString("  ".split(" ")));
    }
}
