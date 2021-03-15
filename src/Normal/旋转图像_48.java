package Normal;

public class 旋转图像_48 {

    /**
     * 两次翻转
     */
//    public void rotate(int[][] matrix) {
//        int size = matrix.length;
//        int temp;      //临时变量
//        // 先水平轴对称
//        for (int j = 0; j < size / 2; j ++) {
//            for (int i = 0; i < size; i ++) {
//                temp = matrix[j][i];
//                matrix[j][i] = matrix[size-j-1][i];
//                matrix[size-j-1][i] = temp;
//            }
//        }
//
//        //再斜轴对称
//        for (int j = 0; j < size; j ++) {
//            for (int i = 0; i < j; i ++) {
//                temp = matrix[j][i];
//                matrix[j][i] = matrix[i][j];
//                matrix[i][j] = temp;
//            }
//        }
//    }


    /**
     * 寻找元素之间的直接关系
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

}
