package Normal;

import java.util.ArrayList;
import java.util.Stack;

public class 简化路径_71 {

    /**
     * 把普通字符、.、..都当做是路径的名称，用 / 分割开来
     * 判断 . 和 .. 以及空格对路径产生的影响，把他们拼接起来
     */
    public static String simplifyPath(String path) {

        if (path.equals(""))    return "/";
        String[] dirNames = path.split("/");

        Stack<String> names = new Stack<>();

        for (String name: dirNames) {
            if (!name.equals("")) {
                if (!name.equals(".") && !name.equals(".."))
                    names.push(name);
                if (name.equals("..")) {
                    if (!names.empty())
                        names.pop();
                }
            }
        }

        StringBuilder unifiedStr = new StringBuilder();
        if (names.empty())  unifiedStr.append('/');
        while (!names.empty())
            unifiedStr.insert(0, names.pop()).insert(0, '/');

        return unifiedStr.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/../"));
    }
}
