//有两种形状的瓷砖：一种是 2 x 1 的多米诺形，另一种是形如 "L" 的托米诺形。两种形状都可以旋转。 
//
// 
//
// 给定整数 n ，返回可以平铺 2 x n 的面板的方法的数量。返回对 10⁹ + 7 取模 的值。 
//
// 平铺指的是每个正方形都必须有瓷砖覆盖。两个平铺不同，当且仅当面板上有四个方向上的相邻单元中的两个，使得恰好有一个平铺有一个瓷砖占据两个正方形。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: n = 3
//输出: 5
//解释: 五种不同的方法如上所示。
// 
//
// 示例 2: 
//
// 
//输入: n = 1
//输出: 1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 
//
// Related Topics 动态规划 👍 261 👎 0

package leetcode.editor.cn;

//Java:多米诺和托米诺平铺
//Time:2022-11-14 14:44:54
class P790_DominoAndTrominoTiling {
    public static void main(String[] args) {
        Solution solution = new P790_DominoAndTrominoTiling().new Solution();
        System.out.println(solution.numTilings(30));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTilings(int n) {
            int MOD = 1000000007;
            int[][] dp = new int[n+1][4];
            dp[0][0] = 0;
            dp[0][1] = 0;
            dp[0][2] = 0;
            dp[0][3] = 1;
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 1; i <= n; i++) {
                dp[i][0] = dp[i - 1][3];
                dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
                dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
                dp[i][3] = (((dp[i - 1][0] + dp[i - 1][1]) % MOD + dp[i - 1][2]) % MOD + dp[i - 1][3]) % MOD;

            }
            return dp[n][3];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
