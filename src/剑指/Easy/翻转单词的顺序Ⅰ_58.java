package 剑指.Easy;

import java.util.Locale;
import java.util.regex.Pattern;

public class 翻转单词的顺序Ⅰ_58 {

//    /**
//     * 字符串分割
//     */
//    public static String reverseWords(String s) {
//        String[] res = s.split(" ");
//        StringBuffer sb = new StringBuffer();
//        for (int i = res.length - 1; i >= 0 ; i --) {
//            if (!res[i].trim().isEmpty()) {
//                sb.append(" ");
//                sb.append(res[i]);
//            }
//        }
//        return sb.toString().trim();
//    }


    /**
     * 双指针
     */
    public static String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        int j = s.length() - 1, i = j;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ')  i --;
            sb.append(s, i + 1, j + 1).append(" ");
            while (i >= 0 && s.charAt(i) == ' ')  i --;     //跳过空格
            j = i;
        }
        return sb.toString().trim();
    }


    public static void main(String[] args) {
        String res = "a b c  d r       f s";
        System.out.println(reverseWords(res));
    }
}
