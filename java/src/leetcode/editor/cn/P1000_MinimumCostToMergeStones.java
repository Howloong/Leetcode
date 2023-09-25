//有 N 堆石头排成一排，第 i 堆中有 stones[i] 块石头。 
//
// 每次移动（move）需要将连续的 K 堆石头合并为一堆，而这个移动的成本为这 K 堆石头的总数。 
//
// 找出把所有石头合并成一堆的最低成本。如果不可能，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：stones = [3,2,4,1], K = 2
//输出：20
//解释：
//从 [3, 2, 4, 1] 开始。
//合并 [3, 2]，成本为 5，剩下 [5, 4, 1]。
//合并 [4, 1]，成本为 5，剩下 [5, 5]。
//合并 [5, 5]，成本为 10，剩下 [10]。
//总成本 20，这是可能的最小值。
// 
//
// 示例 2： 
//
// 输入：stones = [3,2,4,1], K = 3
//输出：-1
//解释：任何合并操作后，都会剩下 2 堆，我们无法再进行合并。所以这项任务是不可能完成的。.
// 
//
// 示例 3： 
//
// 输入：stones = [3,5,1,2,6], K = 3
//输出：25
//解释：
//从 [3, 5, 1, 2, 6] 开始。
//合并 [5, 1, 2]，成本为 8，剩下 [3, 8, 6]。
//合并 [3, 8, 6]，成本为 17，剩下 [17]。
//总成本 25，这是可能的最小值。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= stones.length <= 30 
// 2 <= K <= 30 
// 1 <= stones[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 242 👎 0

package leetcode.editor.cn.java;

import java.util.Arrays;

//Java:合并石头的最低成本
//Time:2023-04-04 09:40:25
class P1000_MinimumCostToMergeStones {
    public static void main(String[] args) {
        Solution solution = new P1000_MinimumCostToMergeStones().new Solution();
        System.out.println(solution.mergeStones(new int[]{3, 2, 4, 1}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
       /* public int mergeStones(int[] stones, int k) {
            int n = stones.length;
            if ((n - 1) % (k - 1) != 0) {
                return -1;
            }
            int[] sum = new int[n];
            int[][][] dp = new int[n][n][k + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    Arrays.fill(dp[i][j], Integer.MAX_VALUE);
                }
            }
            for (int i = 0, s = 0; i < n; i++) {
                dp[i][i][1] = 0;
                s += stones[i];
                sum[i] = s;
            }
            for (int len = 2; len<= n; len++) {
                for (int l = 0; l < n && l + len - 1 < n; l++) {
                    int r = l+len - 1;
                    for (int t = 2; t <= k; t++) {
                        for (int p = l; p < r; p += k - 1) {
                            dp[l][r][t] = Math.min(dp[l][p][1] + dp[p + 1][r][t - 1], dp[l][r][t]);
                        }
                    }
                    dp[l][r][1] = Math.min(dp[l][r][1], dp[l][r][k] + sum[r] - (l == 0 ? 0 : sum[l - 1]));
                }
            }
            return dp[0][n - 1][1];
        }*/

        public int mergeStones(int[] stones, int k) {
            int n = stones.length;
            if ((n - 1) % (k - 1) != 0) {
                return -1;
            }
            int[] sum = new int[n];
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            for (int i = 0, s = 0; i < n; i++) {
                dp[i][i] = 0;
                s += stones[i];
                sum[i] = s;
            }
            for (int len = 2; len <= n; len++) {
                for (int l = 0; l < n && l + len - 1 < n; l++) {
                    int r = l + len - 1;
                    for (int p = l; p < r; p += k - 1) {
                        dp[l][r] = Math.min(dp[l][r], dp[l][p] + dp[p + 1][r]);
                    }
                    if ((r - l) % (k - 1) == 0) {
                        dp[l][r] += sum[r] - (l == 0 ? 0 : sum[l - 1]);
                    }
                }
            }
            return dp[0][n - 1];
        }
    }

//leetcode submit region end(Prohibit modification and deletion)
}

