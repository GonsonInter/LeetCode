package 剑指.Easy;

public class 左旋转字符Ⅱ_58 {

    public String reverseLeftWords(String s, int n) {
        String s1 = s.substring(0, n);
        String s2 = s.substring(n, s.length());
        return s2 + s1;
    }
}
