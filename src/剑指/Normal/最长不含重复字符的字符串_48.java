package 剑指.Normal;

import java.util.HashMap;
import java.util.HashSet;

public class 最长不含重复字符的字符串_48 {


//    /**
//     * 动态规划算法
//     * dp[i] 表示以s[i]结尾的最长字串
//     */
//    public static int lengthOfLongestSubstring(String s) {
//        if (s.equals(""))   return 0;
//        int[] dp = new int[s.length()];
//        dp[0] = 1;
//        for (int i = 1; i < s.length(); i ++) {
//            String preStr = s.substring(i - dp[i - 1], i );
//            int index = preStr.lastIndexOf(s.charAt(i));
//            dp[i] = dp[i - 1] - index;
//            System.out.println(preStr);
//        }
//        int max = 0;
//        for (int num : dp)
//            max = Math.max(max, num);
//        return max;
//    }


//    /**
//     * 动态规划加哈希表，用HashMap保存当前字符上一次出现的位置
//     */
//    public static int lengthOfLongestSubstring(String s) {
//
//        HashMap<Character, Integer> map = new HashMap<>();
//        int res = 0, tmp = 0;
//        for(int j = 0; j < s.length(); j++) {
//            int i = map.getOrDefault(s.charAt(j), -1); // 获取索引 i
//            map.put(s.charAt(j), j); // 更新哈希表
//            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
//            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
//        }
//        return res;
//    }


    /**
     * 双指针 + 哈希表
     */
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1, res = 0;
        for(int j = 0; j < s.length(); j++) {
            if(map.containsKey(s.charAt(j)))
                i = Math.max(i, map.get(s.charAt(j))); // 更新左指针 i
            map.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }


    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcdd");
    }
}
