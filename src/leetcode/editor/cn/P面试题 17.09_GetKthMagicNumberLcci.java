//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，
//5，7，9，15，21。 
//
// 示例 1: 
//
// 输入: k = 5
//
//输出: 9
// 
//
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 201 👎 0

package leetcode.editor.cn;

//Java:第 k 个数
//Time:2022-09-28 22:34:26
class GetKthMagicNumberLcci {
    public static void main(String[] args) {
        Solution solution = new GetKthMagicNumberLcci().new Solution();
        System.out.println(solution.getKthMagicNumber(150));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getKthMagicNumber(int k) {
            int x = 1, y = 1, z = 1;
            int[] dp = new int[k+1];
            dp[1] = 1;
            int index = 2;
            while (index <= k) {
                int res = Math.min(Math.min(dp[x] * 3, dp[y] * 5), dp[z] * 7);
                if (res % 3 == 0) {
                    x++;
                }
                if (res % 5 == 0) {
                    y++;
                }
                if (res % 7 == 0) {
                    z++;
                }
                dp[index++] = res;
            }
//            System.out.println(Arrays.toString(dp));
            return dp[k];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)
}
