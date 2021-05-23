import java.util.Scanner;

public class test4 {

    public static int[][] period =  {};
    public static int n, m;
    public static int t;
    public static int maxHit = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        t = Integer.parseInt(line[2]);

        dfs(t, 0, 0, 0, -1, -1);
        System.out.println(maxHit - (period[0][0] == 1 ? 1 : 0));
    }

    public static void dfs (int remain, int curScore, int curX, int curY, int lastX, int lastY) {
        if (curX < 0 || curX >= n || curY < 0 || curY >= m)  return;
        if (n - curX + m - curY > remain + 2)   return;
        curScore += (t - remain) % period[curX][curY] == 0 ? 1 : 0;
        if (curX == n - 1 && curY == m - 1) {
            maxHit = Math.max(maxHit, curScore);
            if (remain == 0)
                return;
        }
        if (curX + 1 != lastX)
            dfs(remain - 1, curScore, curX + 1, curY, curX, curY);
        if (curX - 1 != lastX)
            dfs(remain - 1, curScore, curX - 1, curY, curX, curY);
        if (curY + 1 != lastY)
            dfs(remain - 1, curScore, curX, curY + 1, curX, curY);
        if (curY - 1 != lastY)
            dfs(remain - 1, curScore, curX, curY - 1, curX, curY);
    }
}
