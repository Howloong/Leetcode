//给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
//
// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。 
//
// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：[7,1,5,3,6,4]
//输出：5
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2： 
//
// 
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 10⁵ 
// 0 <= prices[i] <= 10⁴ 
// 
//
// Related Topics 数组 动态规划 👍 2468 👎 0

package leetcode.editor.cn.java;

//Java:买卖股票的最佳时机
//Time:2022-07-31 22:57:56
class P121_BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new P121_BestTimeToBuyAndSellStock().new Solution();
        System.out.println(solution.maxProfit(new int[]{8, 9, 2, 5, 4, 7, 1}));
//        System.out.println(solution.maxProfit(new int[]{7,6,4,3,1}));
//        System.out.println(solution.maxProfit(new int[]{2,4,1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
        /*int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;*/
            int[] dp = new int[2];
//        0为持有
//        1为不持有
            dp[0] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[0] = Math.max(dp[0], -prices[i]);
                dp[1] = Math.max(dp[1], dp[0] + prices[i]);
            }
            return Math.max(dp[0], dp[1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
