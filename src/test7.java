import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class test7 {
    public static void main(String[] args) {
//        int[][] dist = new int[][] {
//                {0, 1, 12, -1, -1},
//                {-1, 0, 9, 3, -1},
//                {-1, -1, 0, -1, 5},
//                {-1, -1, 4, 0, 13},
//                {-1, -1, -1, -1, 0}
//        };
//
//        int[][] res = new int[dist.length][2];
//        Set<Integer> set = new HashSet<>();
//        set.add(0);
//        for (int i = 0; i < dist.length; i ++) {
//            int curMin = Integer.MAX_VALUE;
//            int lastFix = 0;
//            for (int j = 0; j < dist.length; j ++) {
//                if (!set.contains(j))   continue;
//                if (res[j][1] < curMin) {
//                    curMin = res[j][1];
//                    lastFix = j;
//                }
//            }
//            System.out.println(res[lastFix][0]);
//            int min = Integer.MAX_VALUE;
//            int fix = -1;
//            for (int j = 0; j < dist.length; j ++) {
//                if (!set.contains(j) &&
//                        dist[lastFix][j] != -1 &&
//                        dist[lastFix][j] < min) {
//                    min = dist[lastFix][j];
//                    fix = j;
//                }
//            }
//            if (fix != -1) {
//                res[fix][0] = fix;
//                res[fix][1] = min + curMin;
//                set.add(fix);
//            }
//
//        }

//        for (int i = 1; i < res.length; i ++) {
//            System.out.println(res[i][1]);
//        }
    }



    public static void dijstra(int[][] matrix, int source) {
        //最短路径长度
        int[] shortest = new int[matrix.length];
        //判断该点的最短路径是否求出
        int[] visited = new int[matrix.length];
        //存储输出路径
        String[] path = new String[matrix.length];

        //初始化输出路径
        for (int i = 0; i < matrix.length; i++) {
            path[i] = new String(source + "->" + i);
        }

        //初始化源节点
        shortest[source] = 0;
        visited[source] = 1;

        for (int i = 1; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;

            for (int j = 0; j < matrix.length; j++) {
                //已经求出最短路径的节点不需要再加入计算并判断加入节点后是否存在更短路径
                if (visited[j] == 0 && matrix[source][j] < min) {
                    min = matrix[source][j];
                    index = j;
                }
            }

            //更新最短路径
            shortest[index] = min;
            visited[index] = 1;

            //更新从index跳到其它节点的较短路径
            for (int m = 0; m < matrix.length; m++) {
                if (visited[m] == 0 && matrix[source][index] + matrix[index][m] < matrix[source][m]) {
                    matrix[source][m] = matrix[source][index] + matrix[index][m];
                    path[m] = path[index] + "->" + m;
                }
            }

        }
    }

}
