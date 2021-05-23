import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class test10 {
    static int n, m;
    static char[][] mat;
    public static int maximalRectangle(char[][] matrix, int row, int col) {
        if(row == 0) return 0;
        if(row == 1 && col == 1) return (matrix[0][0] - '0');
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int[] heights = new int[col + 2];
        col = col + 2;
        int h, width;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col - 2; j++) {
                if(matrix[i][j] == '1') {
                    heights[j + 1]++;
                } else {
                    heights[j + 1] = 0;
                }
            }
            stack.push(0);
            for(int j = 0; j < col; j++) {
                while((heights[j] < heights[stack.peek()])) {
                    h = heights[stack.pop()];
                    ans = Math.max( ans, h * (j - stack.peek() - 1) );
                }
                stack.push(j);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        mat = new char[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i ++) {
            String[] s = sc.nextLine().split("");
            for (int j = 0; j < m; j ++) {
                mat[i][j] = s[j].charAt(0);
            }
        }
        int times = sc.nextInt();
        for (int i = 0; i < times; i ++) {
            char[][] tMat = mat;
            int x = sc.nextInt(), y = sc.nextInt();
            tMat[x][y] = '0';
            System.out.println(maximalRectangle(tMat, n, m));
        }
    }
}
