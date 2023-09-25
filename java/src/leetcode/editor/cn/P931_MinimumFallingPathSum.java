//给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。 
//
// 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第
//一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1
//, col + 1) 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
//输出：13
//解释：如图所示，为和最小的两条下降路径
// 
//
// 示例 2： 
//
// 
//
// 
//输入：matrix = [[-19,57],[-40,-5]]
//输出：-59
//解释：如图所示，为和最小的下降路径
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 100 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 284 👎 0

package leetcode.editor.cn.java;

import java.util.Arrays;

//Java:下降路径最小和
//Time:2023-07-13 21:56:41
class P931_MinimumFallingPathSum {
    public static void main(String[] args) {
        Solution solution = new P931_MinimumFallingPathSum().new Solution();
        System.out.println(solution.minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            int[] dp = new int[n * n];
            Arrays.fill(dp, Integer.MAX_VALUE);
            System.arraycopy(matrix[0], 0, dp, 0, n);
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int idx = i * n + j;
                    dp[idx] = Math.min(Math.min(dp[idx - n], j > 0 ? dp[idx - n - 1] : Integer.MAX_VALUE),
                            j < n - 1 ? dp[idx - n + 1] : Integer.MAX_VALUE) + matrix[i][j];
                }
            }
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                res = Math.min(res, dp[dp.length - n + i]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
