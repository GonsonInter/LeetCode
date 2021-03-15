package 剑指.Normal;

import java.util.LinkedList;
import java.util.Queue;

public class 机器人的运动范围_13 {

    /**
     * DFS深度优先遍历
     */
    public static int movingCount(int m, int n, int k) {
        boolean[][] flag = new boolean[m][n];
        return dfs(m, n, 0, 0, k, flag);
    }

    public static int dfs (int m, int n, int i, int j, int k, boolean[][] flag) {
        if (i < 0 || j < 0 || i == m || j == n) return 0;
        if (k < sumByte(i, j))  return 0;
        if (flag[i][j])    return 0;
        flag[i][j] = true;
        return dfs(m, n, i + 1,j , k, flag) + dfs(m, n, i, j + 1, k, flag) + 1;
    }

    public static int sumByte(int x, int y) {
        int sum = 0;
        int xtemp = x, ytemp = y;
        while (xtemp != 0) {
            sum += xtemp % 10;
            xtemp /= 10;
        }
        while (ytemp != 0) {
            sum += ytemp % 10;
            ytemp /= 10;
        }
        return sum;
    }


//    /**
//     * BFS广度优先遍历
//     * 利用辅助队列
//     */
//    public static int movingCount(int m, int n, int k) {
//        if (k == 0)     return 1;
//        boolean[][] flag = new boolean[m][n];
        Queue<int []> queue = new LinkedList<>();
//        queue.offer(new int[] {0, 0});
//        int count = 0;
//        while (!queue.isEmpty()) {
//            int[] current = queue.poll();
//            if (current[0] < 0 || current[0] >= m || current[1] < 0 || current[1] >= n)
//                continue;
//            if (flag[current[0]][current[1]])   continue;
//            if (k >= sumByte(current[0], current[1])) {
//                count ++;
//                flag[current[0]][current[1]] = true;
//                queue.offer(new int[] {current[0] + 1, current[1]});
//                queue.offer(new int[] {current[0], current[1] + 1});
//            }
//
//        }
//        return count;
//    }
//
//    public static int sumByte(int x, int y) {
//        int sum = 0;
//        int xtemp = x, ytemp = y;
//        while (xtemp != 0) {
//            sum += xtemp % 10;
//            xtemp /= 10;
//        }
//        while (ytemp != 0) {
//            sum += ytemp % 10;
//            ytemp /= 10;
//        }
//        return sum;
//    }


    public static void main(String[] args) {
        System.out.println(movingCount(16, 8, 4));
    }
}
