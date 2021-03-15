package Easy;

import java.util.ArrayList;
import java.util.List;

public class 用栈操作构建数组_1441 {
    public List<String> buildArray(int[] target, int n) {
        ArrayList<String> op = new ArrayList<>();
        int currentNum = 1;
        for (int num : target) {
            while (num > currentNum) {
                op.add("Push");
                op.add("Pop");
                currentNum++;
            }
            op.add("Push");
            currentNum++;
        }
        return op;
    }
}
