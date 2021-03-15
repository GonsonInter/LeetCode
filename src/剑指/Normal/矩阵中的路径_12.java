package 剑指.Normal;

public class 矩阵中的路径_12 {

    public boolean exist(char[][] board, String word) {
        char[] charArray = word.toCharArray();
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (dfs(board, charArray, i, j, 0))     return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] charArray, int i, int j, int k) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != charArray[k])   return false;
        if (k == charArray.length - 1)  return true;
        board[i][j] = '\0';
        return dfs(board, charArray, i - 1, j, k + 1) || dfs(board, charArray, i + 1, j, k + 1) ||
                dfs(board, charArray, i, j -1, k + 1) || dfs(board, charArray, i, j + 1, k + 1);
    }

}
