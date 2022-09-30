//给你一个整数 n ，请你找出并返回第 n 个 丑数 。 
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1690 
// 
//
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 981 👎 0

package leetcode.editor.cn;

//Java:丑数 II
//Time:2022-09-28 23:53:09
class P264_UglyNumberIi {
    public static void main(String[] args) {
        Solution solution = new P264_UglyNumberIi().new Solution();
        solution.nthUglyNumber(1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            int x = 1, y = 1, z = 1;
            int[] dp = new int[n + 1];
            dp[1] = 1;
            int index = 2;
            while (index <= n) {
                int res = Math.min(Math.min(dp[x] * 2, dp[y] * 3), dp[z] * 5);
                if (res % 2 == 0) {
                    x++;
                }
                if (res % 3 == 0) {
                    y++;
                }
                if (res % 5 == 0) {
                    z++;
                }
                dp[index++] = res;
            }
//            System.out.println(Arrays.toString(dp));
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
