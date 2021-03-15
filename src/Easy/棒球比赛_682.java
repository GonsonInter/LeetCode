package Easy;

import java.util.Stack;

public class 棒球比赛_682 {
    public static int calPoints(String[] ops) {
        Stack<Integer> score = new Stack<>();
        for (String item : ops) {
            if (item.equals("D")) {
                score.push(2 * score.peek());
                continue;
            }
            if (item.equals("C")) {
                score.pop();
                continue;
            }
            if (item.equals("+")) {
                int temp1 = score.pop();
                int temp2 = score.peek();
                score.push(temp1);
                score.push(temp1 + temp2);
                continue;
            }
            score.push(Integer.parseInt(item));
        }

        int count = 0;
        while (!score.empty()) {
            count += score.pop();
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(calPoints(new String[] {"5","-2","4","C","D","9","+","+"}));
    }
}
