//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入：prices = [3,3,5,0,0,3,1,4]
//输出：6
//解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 
//
// 示例 2： 
//
// 
//输入：prices = [1,2,3,4,5]
//输出：4
//解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3： 
//
// 
//输入：prices = [7,6,4,3,1] 
//输出：0 
//解释：在这个情况下, 没有交易完成, 所以最大利润为 0。 
//
// 示例 4： 
//
// 
//输入：prices = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 10⁵ 
// 0 <= prices[i] <= 10⁵ 
// 
//
// Related Topics 数组 动态规划 👍 1220 👎 0

package leetcode.editor.cn;

//Java:买卖股票的最佳时机 III
//Time:2022-09-14 10:33:23
class P123_BestTimeToBuyAndSellStockIii {
    public static void main(String[] args) {
        Solution solution = new P123_BestTimeToBuyAndSellStockIii().new Solution();
        System.out.println(solution.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int[] dp = new int[5];
            dp[0] = 0;
            dp[1] = -prices[0];
            dp[2] = 0;
            dp[3] = -prices[0];
            dp[4] = 0;
            for (int i = 1; i < prices.length; i++) {
                dp[1] = Math.max(- prices[i], dp[1]);
                dp[2] = Math.max(dp[1] + prices[i], dp[2]);
                dp[3] = Math.max(dp[2] - prices[i], dp[3]);
                dp[4] = Math.max(dp[3] + prices[i], dp[4]);
            }
            return Math.max(Math.max(Math.max(dp[0], dp[1]), Math.max(dp[2], dp[3])), dp[4]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}