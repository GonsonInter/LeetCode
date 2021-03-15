package 剑指.Easy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class 第一个只出现一次的字符_50 {


//    /**
//     * 直接用HashMap统计每个元素出现的次数
//     * 最后找第一个次数为一的
//     */
//    public static char firstUniqChar(String s) {
//        if (s.length() == 0)    return ' ';
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i ++) {
//            if (!map.containsKey(s.charAt(i)))  map.put(s.charAt(i), 1);
//            else map.put(s.charAt(i), 1 + s.charAt(i));
//        }
//
//        for (int i = 0; i < s.length(); i ++) {
//            if (map.get(s.charAt(i)) == 1)   return s.charAt(i);
//        }
//        return ' ';
//    }


    /**
     * 有序Hash表， LinkedHashMap
     * LinkedHashMap是有序的
     */
    public static char firstUniqChar(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
            if(d.getValue()) return d.getKey();
        }
        return ' ';
    }


    public static void main(String[] args) {
        System.out.println(firstUniqChar("dwadvsdfvfbdvse"));
    }
}
