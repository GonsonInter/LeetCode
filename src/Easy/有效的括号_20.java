package Easy;

import java.util.Stack;

public class 有效的括号_20 {

    /**
     * 官方
     */
//    public boolean isValid(String s) {
//        int n = s.length();
//        if (n % 2 == 1) {
//            return false;
//        }
//
//        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
//            put(')', '(');
//            put(']', '[');
//            put('}', '{');
//        }};
//        Deque<Character> stack = new LinkedList<Character>();
//        for (int i = 0; i < n; i++) {
//            char ch = s.charAt(i);
//            if (pairs.containsKey(ch)) {
//                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
//                    return false;
//                }
//                stack.pop();
//            } else {
//                stack.push(ch);
//            }
//        }
//        return stack.isEmpty();
//    }



    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        int index = 0;
        while(index < arr.length) {
            if (stack.empty()) {
                stack.push(arr[index++]);
                continue;
            }

            switch (arr[index]) {
                case ')':
                    if (stack.peek() == '(') stack.pop();
                    else stack.push(arr[index]);
                    index ++;
                    break;
                case ']':
                    if (stack.peek() == '[') stack.pop();
                    else stack.push(arr[index]);
                    index ++;
                    break;
                case '}':
                    if (stack.peek() == '{') stack.pop();
                    else stack.push(arr[index]);
                    index ++;
                    break;
                default:
                    stack.push(arr[index++]);
            }
        }
        return stack.empty();
    }

    public static void main( String[] args ) {
        System.out.println(isValid("()[{}"));
    }
}
