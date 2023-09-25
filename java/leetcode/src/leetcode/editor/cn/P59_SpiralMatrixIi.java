//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 矩阵 模拟 👍 716 👎 0

package leetcode.editor.cn;

//Java：螺旋矩阵 II
class P59_SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new P59_SpiralMatrixIi().new Solution();
        solution.generateMatrix(5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int num = 1;

        public int[][] generateMatrix(int n) {
            if (n == 1) {
                return new int[][]{{1}};
            }
            int[][] result = new int[n][n];
            int i = n % 2 == 0 ? n * n : n * n - 1;
            int t = n - 1;
            int row = 0;
            int col = 0;

            while (num <= i) {
                leftToRight(result, col, col + t, row);
                col += t;
                topToBottom(result, row, row + t, col);
                row += t;
                rightToLeft(result, col, col - t, row);
                col -= t;
                bottomToTop(result, row, row - t, col);
                row -= t;
                t -= 2;
                row++;
                col++;
            }
            if (n % 2 == 1) {
                result[n / 2][n / 2] = num;
            }
            return result;
        }

        public void leftToRight(int[][] matrix, int startJ, int endJ, int row) {
            for (int j = startJ; j < endJ; j++) {
                matrix[row][j] = num++;
            }
        }

        public void topToBottom(int[][] matrix, int startI, int endI, int col) {
            for (int i = startI; i < endI; i++) {
                matrix[i][col] = num++;
            }
        }

        public void rightToLeft(int[][] matrix, int startJ, int endJ, int row) {
            for (int j = startJ; j > endJ; j--) {
                matrix[row][j] = num++;
            }
        }

        public void bottomToTop(int[][] matrix, int startI, int endI, int col) {
            for (int i = startI; i > endI; i--) {
                matrix[i][col] = num++;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
