//给你一个 rows x cols 大小的矩形披萨和一个整数 k ，矩形包含两种字符： 'A' （表示苹果）和 '.' （表示空白格子）。你需要切披萨 k-1
// 次，得到 k 块披萨并送给别人。 
//
// 切披萨的每一刀，先要选择是向垂直还是水平方向切，再在矩形的边界上选一个切的位置，将披萨一分为二。如果垂直地切披萨，那么需要把左边的部分送给一个人，如果水平
//地切，那么需要把上面的部分送给一个人。在切完最后一刀后，需要把剩下来的一块送给最后一个人。 
//
// 请你返回确保每一块披萨包含 至少 一个苹果的切披萨方案数。由于答案可能是个很大的数字，请你返回它对 10^9 + 7 取余的结果。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：pizza = ["A..","AAA","..."], k = 3
//输出：3 
//解释：上图展示了三种切披萨的方案。注意每一块披萨都至少包含一个苹果。
// 
//
// 示例 2： 
//
// 输入：pizza = ["A..","AA.","..."], k = 3
//输出：1
// 
//
// 示例 3： 
//
// 输入：pizza = ["A..","A..","..."], k = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= rows, cols <= 50 
// rows == pizza.length 
// cols == pizza[i].length 
// 1 <= k <= 10 
// pizza 只包含字符 'A' 和 '.' 。 
// 
//
// Related Topics 记忆化搜索 数组 动态规划 矩阵 👍 201 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java:切披萨的方案数
//Time:2023-08-22 15:29:36
class P1444_NumberOfWaysOfCuttingAPizza {
    public static void main(String[] args) {
        Solution solution = new P1444_NumberOfWaysOfCuttingAPizza().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public static final int MOD = (int) 1e9 + 7;

        public int ways(String[] pizza, int k) {
            MatrixSum matrixSum = new MatrixSum(pizza);
            int m = pizza.length;
            int n = pizza[0].length();
            int[][][] memo = new int[k][m][n];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < m; j++) {
                    Arrays.fill(memo[i][j], -1);
                }
            }
            return dfs(k - 1, 0, 0, memo, matrixSum, m, n);
        }

        private int dfs(int c, int i, int j, int[][][] memo, MatrixSum matrixSum, int m, int n) {
            if (c == 0) {
                return matrixSum.query(i, j, m, n) > 0 ? 1 : 0;
            }
            if (memo[c][i][j] != -1) {
                return memo[c][i][j];
            }
            int res = 0;
            for (int j2 = j; j2 < n; j2++) {
                if (matrixSum.query(i, j, m, j2) > 0) {
                    res = (res + dfs(c - 1, i, j2, memo, matrixSum, m, n)) % MOD;
                }
            }
            for (int i2 = i; i2 < m; i2++) {
                if (matrixSum.query(i, j, i2, n) > 0) {
                    res = (res + dfs(c - 1, i2, j, memo, matrixSum, m, n)) % MOD;
                }
            }
            return memo[c][i][j] = res;
        }
    }

    class MatrixSum {
        private final int[][] sum;

        public MatrixSum(String[] matrix) {
            int m = matrix.length;
            int n = matrix[0].length();
            sum = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + (matrix[i].charAt(j) == 'A' ? 1 : 0);
                }
            }
        }

        public int query(int row1, int col1, int row2, int col2) {
            return sum[row2][col2] - sum[row2][col1] - sum[row1][col2] + sum[row1][col1];
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}
