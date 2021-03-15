package 剑指.Normal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class 字符串的排列_38______ {


    /**
     * 根据字符串排列的特点，考虑深度优先搜索所有排列方案。即通过字符交换，先固定第 1 位字符（ n 种情况）、再固定第 2 位字符（ n-1种情况）、
     * ... 、最后固定第 n 位字符（ 1 种情况）。
     * 当字符串存在重复字符时，排列方案中也存在重复的排列方案。为排除重复方案，需在固定某位字符时，保证 “每种字符只在此位固定一次” ，
     * 即遇到重复字符时不交换，直接跳过。从 DFS 角度看，此操作称为 “剪枝” 。
     */

    List<String> res = new LinkedList<>();
    char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    public void dfs(int index) {
        if (index == c.length - 1)  {
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();   // 用来保存当前的字符是否被访问过
        for (int i = index; i < c.length; i ++) {
            if (set.contains(c[i]))  continue;
            set.add(c[i]);
            swap(index, i);
            dfs(index + 1);
            swap(index, i);
        }
    }

    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

}
