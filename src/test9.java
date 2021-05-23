import java.util.Scanner;

public class test9 {
    static int m, n, k;
    static int[][] mat;
    static int minCost = Integer.MAX_VALUE;
    public static void traverse(int u, int v, int cost) {
        if (u == n && v == m) {
            minCost = Math.min(cost, minCost);
            return;
        }
        for (int[] ints : mat) {
            if (ints[0] == u && ints[1] == v) {
                traverse(ints[2], ints[3], cost + ints[4]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        mat = new int[k][5];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 5; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        traverse(1, 1, 0);
        if (minCost == Integer.MAX_VALUE) {
            System.out.println(-1);
        }   else {
            System.out.println(minCost);
        }
    }
}
