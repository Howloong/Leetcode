//给定两个字符串s1 和 s2，返回 使两个字符串相等所需删除字符的 ASCII 值的最小和 。 
//
// 
//
// 示例 1: 
//
// 
//输入: s1 = "sea", s2 = "eat"
//输出: 231
//解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
//在 "eat" 中删除 "t" 并将 116 加入总和。
//结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
// 
//
// 示例 2: 
//
// 
//输入: s1 = "delete", s2 = "leet"
//输出: 403
//解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
//将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
//结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
//如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
// 
//
// 
//
// 提示: 
//
// 
// 0 <= s1.length, s2.length <= 1000 
// s1 和 s2 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 298 👎 0

package leetcode.editor.cn;

//Java:两个字符串的最小ASCII删除和
//Time:2022-09-19 12:29:20
class P712_MinimumAsciiDeleteSumForTwoStrings {
    public static void main(String[] args) {
        Solution solution = new P712_MinimumAsciiDeleteSumForTwoStrings().new Solution();
        System.out.println(solution.minimumDeleteSum("delete", "leet"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumDeleteSum(String s1, String s2) {
            int m = s1.length();
            int n = s2.length();
//            int[][] dp = new int[m + 1][n + 1];
            int[] dp = new int[n + 1];
/*            for (int i = 1; i <= m; i++) {
                dp[i][0] = s1.charAt(i - 1) + dp[i - 1][0];
            }
            for (int j = 1; j <= n; j++) {
                dp[0][j] = s2.charAt(j - 1) + dp[0][j - 1];
            }*/
            for (int i = 1; i <= n; i++) {
                dp[i] = s2.charAt(i - 1) + dp[i - 1];
            }
            for (int i = 1; i <= m; i++) {
                int pre = dp[0];
                dp[0] += s1.charAt(i - 1);
//                注意是+=，每次的dp[0]需要累加上一次的dp[0]
                for (int j = 1; j <= n; j++) {
                    int cur = dp[j];
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
//                        dp[i][j] = dp[i - 1][j - 1];
                        dp[j] = pre;
                    } else {
//                        dp[i][j] = Math.min(dp[i][j - 1] + s1.charAt(i-1), dp[i - 1][j] + s2.charAt(j-1));
                        dp[j] = Math.min(dp[j] + s1.charAt(i - 1), dp[j - 1] + s2.charAt(j - 1));
                    }
                    pre = cur;
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
