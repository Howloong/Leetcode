//给定一个整数数组
// prices，其中第 prices[i] 表示第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入: prices = [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
//
// 示例 2: 
//
// 
//输入: prices = [1]
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 5000 
// 0 <= prices[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 1319 👎 0

package leetcode.editor.cn;

//Java:最佳买卖股票时机含冷冻期
//Time:2022-09-15 20:00:25
class P309_BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Solution solution = new P309_BestTimeToBuyAndSellStockWithCooldown().new Solution();
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 0, 2}));
        System.out.println(solution.maxProfit(new int[]{1, 2, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int[] dp = new int[4];
            dp[0] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                int temp1 = dp[0];
                int temp2 = dp[1];
                dp[0] = Math.max(Math.max(dp[2], dp[3])- prices[i], dp[0]);
                dp[1] = temp1 + prices[i];
                dp[2] = Math.max(dp[2], dp[3]);
                dp[3] = temp2;
            }
            return Math.max(Math.max(dp[0], dp[1]), Math.max(dp[2], dp[3]));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
