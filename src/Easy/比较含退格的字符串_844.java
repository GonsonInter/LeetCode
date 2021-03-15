package Easy;

import java.util.Stack;

public class 比较含退格的字符串_844 {

//    /**
//     * 双栈解法
//     */
//    public static boolean backspaceCompare(String S, String T) {
//        return simplify(S).equals(simplify(T));
//    }
//    public static String simplify(String s) {
//        Stack<Character> simplify = new Stack<>();
//        char[] arr = s.toCharArray();
//        for (char c : arr) {
//            if (c == '#' && !simplify.empty()) {
//                simplify.pop();
//            }
//            if (c != '#') {
//                simplify.push(c);
//            }
//        }
//        StringBuilder str = new StringBuilder();
//        while (!simplify.empty()) {
//            str.append(simplify.pop());
//        }
//        return str.toString();
//    }


    /**
     * 双指针解法
     */
    public static boolean backspaceCompare(String S, String T) {
        int skipS = 0, skipT = 0;   //记录要删除的字符个数
        int i = S.length() - 1;
        int j = T.length() - 1;

        while (i > 0 || j > 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS ++;
                    i--;
                } else if (skipS > 0){
                    skipS --;
                    i --;
                } else break;
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT ++;
                    j--;
                } else if (skipT > 0) {
                    skipT --;
                    j --;
                } else break;
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j))  return false;
            } else {
                if (i >= 0 || j >= 0)   return false;
            }
            i --;
            j --;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("bxj##tw", "bxj###tw"));
    }
}
