package Easy;

import java.util.Stack;

public class 文件夹操作日志收集器_1598 {

//    /**
//     * 用栈实现
//     */
//    public static int minOperations(String[] logs) {
//        Stack<String> path = new Stack<>();
//        for (String log : logs) {
//            if (log.equals("../"))   {
//                if (!path.empty())
//                    path.pop();
//                continue;
//            }
//            if (log.equals ("./"))  continue;
//            path.push(log);
//        }
//        return path.size();
//    }


    /**
     * 不用栈实现
     */
    public static int minOperations(String[] logs) {
        int count = 0;
        for (String log : logs) {
            if (log.equals("../"))   {
                if (count > 0)
                    count --;
                continue;
            }
            if (log.equals ("./"))  continue;
            count ++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(new String[] {"./","../","./"}));
    }
}
