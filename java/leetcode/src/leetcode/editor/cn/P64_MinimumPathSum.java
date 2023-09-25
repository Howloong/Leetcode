//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 200 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 1560 👎 0

package leetcode.editor.cn;

//Java:最小路径和
//Time:2023-08-22 15:18:00
class P64_MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new P64_MinimumPathSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[] dp = new int[m * n];
            dp[0] = grid[0][0];
            for (int i = 1; i < n; i++) {
                dp[i] = dp[i - 1] + grid[0][i];
            }
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int index = i * n + j;
                    int up = index - n;
                    dp[index] = dp[up];
                    int left = j - 1;
                    if (left >= 0) {
                        dp[index] = Math.min(dp[index], dp[index - 1]);
                    }
                    dp[index] += grid[i][j];
                }
            }
            return dp[dp.length - 1];
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
