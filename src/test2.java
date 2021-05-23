import java.util.HashMap;

public class test2 {

    public static int maxCost = Integer.MAX_VALUE;
    private static HashMap<Character, Integer> aMap = new HashMap<>();
    private static HashMap<Character, Integer> dMap = new HashMap<>();
    private static char[] cand = new char[] {'1', '2', '3', '4'};

    public static void dfs(String str, int curCost) {
        if (str.length() == 1 || curCost >= maxCost)     return;
        if (isReStr(str))   maxCost = Math.min(maxCost, curCost);
        for (int i = 0; i < str.length(); i ++) {
            dfs(str.substring(0, i) + str.substring(i + 1), curCost + dMap.get(str.charAt(i)));
        }
        for (int i = 0; i < str.length(); i ++) {
            for (char x: cand) {
                dfs(str.substring(0, i) + x + str.substring(i), curCost + aMap.get(x));
            }
        }
    }

    public static boolean isReStr(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public static void main(String[] args) {
        aMap.put('1', 100);
        aMap.put('2', 200);
        aMap.put('3', 360);
        aMap.put('4', 220);
        dMap.put('1', 120);
        dMap.put('2', 350);
        dMap.put('3', 200);
        dMap.put('4', 320);

        dfs("123242122", 0);
        System.out.println(maxCost);
    }
}
