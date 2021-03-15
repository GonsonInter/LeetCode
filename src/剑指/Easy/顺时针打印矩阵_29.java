package 剑指.Easy;

import java.util.Arrays;

public class 顺时针打印矩阵_29 {

//    private enum dir {
//        UP, DOWN, LEFT, RIGHT
//    }
//    public static int[] spiralOrder(int[][] matrix) {
//        if (matrix.length == 0) return new int[] {};
//        int[] res = new int[matrix.length * matrix[0].length];
//        int index = 0;
//        dir currentDirection = dir.RIGHT;
//        int xBottom = 0, yBottom = 0, xTop = matrix.length - 1, yTop = matrix[0].length - 1;
//        int currentX = 0, currentY = 0;
//        while (currentX >= xBottom && currentX <= xTop &&
//                currentY >= yBottom && currentY <= yTop ) {
//            switch (currentDirection) {
//                case RIGHT:
//                    res[index ++] = matrix[currentX][currentY ++];
//                    if (currentY > yTop) {
//                        currentDirection = dir.DOWN;
//                        currentY = yTop;
//                        currentX ++;
//                        xBottom ++;
//                    }
//                    break;
//                case DOWN:
//                    res[index ++] = matrix[currentX ++][currentY];
//                    if (currentX > xTop) {
//                        currentDirection = dir.LEFT;
//                        currentX = xTop;
//                        currentY --;
//                        yTop --;
//                    }
//                    break;
//                case UP:
//                    res[index ++] = matrix[currentX --][currentY];
//                    if (currentX < xBottom) {
//                        currentDirection = dir.RIGHT;
//                        currentX = xBottom;
//                        currentY ++;
//                        yBottom ++;
//                    }
//                    break;
//                case LEFT:
//                    res[index ++] = matrix[currentX][currentY --];
//                    if (currentY < yBottom) {
//                        currentDirection = dir.UP;
//                        currentY = yBottom;
//                        currentX --;
//                        xTop --;
//                    }
//                    break;
//            }
//        }
//        return res;
//    }


    /**
     *
     */
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return new int[] {};
        int size = matrix.length * matrix[0].length;
        int[] res = new int[size];
        int index = 0;
        int t = 0, r = matrix[0].length - 1, b = matrix.length - 1, l = 0;

        // 遍历顺序 上，右，下，左
        while (index < size) {
            for (int i = t; i <= r; i ++)   res[index ++] = matrix[l][i];
            l ++;
            for (int i = l; i <= b; i ++)   res[index ++] = matrix[i][r];
            r --;
            if (index >= size)  break;
            for (int i = r; i >= t; i --)   res[index ++] = matrix[b][i];
            b --;
            for (int i = b; i >= l; i --)   res[index ++] = matrix[i][t];
            t ++;
        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}})));
    }
}
