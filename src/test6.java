import java.util.Scanner;

public class test6 {

    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] seq = new int[n];
            for (int i = 0; i < n; i ++)
                seq[i] = sc.nextInt();
            int[][] dp = new int[n][n];
            int max = 0;
            for (int i = 0; i < n; i ++) {
                for (int j = i; j < n; j ++) {
                    if (i == j)  {
                        dp[i][j] = seq[i] == 0 ? 1 : 0;
                    }
                    else {
                        if (seq[j] == 1) {
                            dp[i][j] = dp[i][j - 1] - 1;
                        }   else  {
                            dp[i][j] = dp[i][j - 1] + 1;
                        }
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
            int count = 0;
            for (int num : seq)
                if (num == 1)   count ++;
            System.out.println(max + count);
        }

    }
}
