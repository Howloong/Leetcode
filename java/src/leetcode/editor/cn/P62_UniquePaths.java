//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 示例 1： 
// 
// 
//输入：m = 3, n = 7
//输出：28 
//
// 示例 2： 
//
// 
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向下
// 
//
// 示例 3： 
//
// 
//输入：m = 7, n = 3
//输出：28
// 
//
// 示例 4： 
//
// 
//输入：m = 3, n = 3
//输出：6 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 10⁹ 
// 
//
// Related Topics 数学 动态规划 组合数学 👍 1473 👎 0

package leetcode.editor.cn.java;

//Java:不同路径
//Time:2022-07-25 12:11:50
class P62_UniquePaths {
    public static void main(String[] args) {
        Solution solution = new P62_UniquePaths().new Solution();
        System.out.println(solution.uniquePaths(0, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
   /*
    递归法：超时
    class Solution {
        public int uniquePaths(int m, int n) {
            return dfs(m, n, 1, 1);
        }

        public int dfs(int m, int n, int i, int j) {
            if (i > m || j > n) {
                return 0;
            }
            if (i == m && j == n) {
                return 1;
            }
            return dfs(m, n, i + 1, j) + dfs(m, n, i, j + 1);
        }
    }*/
    class Solution {
        public int uniquePaths(int m, int n) {
            if (m == 0 || n == 0) {
                return 0;
            }
            int[] dp;
            if (m < n) {
                dp = new int[m];
                getPath(n, m, dp);
                return dp[m - 1];
            } else {
                dp = new int[n];
                getPath(m, n, dp);
                return dp[n - 1];
            }
        }

        private void getPath(int m, int n, int[] dp) {
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[j] += dp[j - 1];
                }
            }
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
