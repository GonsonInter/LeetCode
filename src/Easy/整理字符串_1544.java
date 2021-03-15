package Easy;

import java.util.Arrays;
import java.util.Stack;

public class 整理字符串_1544 {

//    /**
//     * 使用栈解决
//     */
//    public String makeGood(String s) {
//        Stack<Character> stk = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (stk.empty() || Math.abs(Integer.valueOf(stk.peek()) - Integer.valueOf(s.charAt(i))) != 32) {
//                stk.push(s.charAt(i));
//                continue;
//            }
//            stk.pop();
//        }
//        char[] S = new char[stk.size()];
//        for (int i = 0; i < stk.size(); i ++) {
//            S[i] = stk.get(i);
//        }
//        String str = new String(S);
//        return str;
//    }


    /**
     原地算法
     时间复杂度 O(n)
     空间复杂度 O(1)
     */
    public String makeGood(String s) {
        int idx = -1;
        char [] ss = s.toCharArray();
        for(int i = 0; i < ss.length; ++i){
            if(idx == -1 || !isDelete(ss[i],ss[idx])){
                ss[++idx] = ss[i];
            }
            else{
                --idx;
            }
        }
        return String.valueOf(Arrays.copyOfRange(ss,0,idx+1));
    }

    public boolean isDelete(char c1,char c2){
        return Math.abs(c1-c2) == 32;
    }

}
