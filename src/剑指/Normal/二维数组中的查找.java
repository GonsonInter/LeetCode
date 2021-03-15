package 剑指.Normal;

public class 二维数组中的查找 {

    /**
     * 线性查找
     * 从二维数组的右上角开始查找。如果当前元素等于目标值，则返回 true。如果当前元素大于目标值，则移到左边一列。如果当前元素小于目标值，则移到下边一行。
     *
     * 可以证明这种方法不会错过目标值。如果当前元素大于目标值，说明当前元素的下边的所有元素都一定大于目标值，因此往下查找不可能找到目标值，往左查找可能找到目标值。如果当前元素小于目标值，说明当前元素的左边的所有元素都一定小于目标值，因此往左查找不可能找到目标值，往下查找可能找到目标值。
     * 复杂度O（m+n）
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0)    return false;
        int y = 0;
        for (int x = matrix[0].length - 1; x >= 0; x --) {
            while (y < matrix.length && target >= matrix[y][x]) {
                if (target == matrix[y ++][x])  return true;
            }
        }
        return false;
    }
}
