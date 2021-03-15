package Easy;

import java.util.ArrayList;
import java.util.Stack;

public class 删除最外层的括号_1021 {
    public static String removeOuterParentheses(String S) {
        StringBuilder str = new StringBuilder();
        Stack<Character> stk = new Stack<>();

        int startIndex = 0;
        for (int index = 0; index < S.length(); index ++) {
            if (S.charAt(index) == ')' && !stk.empty()) {
                stk.pop();
                if (stk.size() == 0) {
                    str.append(S, startIndex + 1, index);
                    startIndex = index + 1;
                }
            } else stk.push(S.charAt(index));
        }

        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
    }
}
