package Easy;

import java.util.Stack;

public class 删除字符串中的所有相邻重复项_1047 {

    /**
     *  用栈
     */
    public String removeDuplicates(String S) {
        if (S.length() == 0) return "";
        Stack<Character> stk = new Stack<>();
        stk.push(S.charAt(0));
        for (int i = 1; i < S.length(); i ++) {
            if (!stk.empty() && S.charAt(i) == stk.peek()) stk.pop();
            else stk.push(S.charAt(i));
        }
        char[] aq = new char[stk.size()];
        for(int i = 0; i < stk.size(); i++) {
            aq[i] = stk.get(i);
        }
        S= new String(aq);
        return S;

    }
}
