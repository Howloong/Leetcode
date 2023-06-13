//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
// 
// 
// Related Topics 数组 回溯 👍 1414 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：N 皇后
class P51_NQueens {
    public static void main(String[] args) {
        Solution solution = new P51_NQueens().new Solution();
        System.out.println(solution.solveNQueens(9));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> result = new ArrayList<>();
        public ArrayDeque<String> path = new ArrayDeque<>();
        public StringBuilder sb = new StringBuilder();

        public List<List<String>> solveNQueens(int n) {
            char[][] board = new char[n][n];
            for (char[] c :
                    board) {
                Arrays.fill(c, '.');
            }
            backTracking(n, 0, board);
            return result;
        }

        public void backTracking(int n, int startRow, char[][] board) {
            if (path.size() == n) {
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < n; i++) {
                if (isValid(board, startRow, i)) {
                    board[startRow][i] = 'Q';
                    path.addLast(String.valueOf(board[startRow]));
                    backTracking(n, startRow + 1, board);
                    path.removeLast();
                    board[startRow][i] = '.';
                }
            }
        }

        public boolean isValid(char[][] board, int x, int y) {
            int n = board.length;
            for (char[] chars : board) {
                if (chars[y] == 'Q') {
                    return false;
                }
            }
            for (int i = x - 1, j = y + 1; i >= 0 && j < n; i--, j++) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }
            for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
