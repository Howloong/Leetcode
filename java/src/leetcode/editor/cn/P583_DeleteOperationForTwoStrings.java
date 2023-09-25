//给定两个单词 word1 和
// word2 ，返回使得
// word1 和 
// word2 相同所需的最小步数。 
//
// 每步 可以删除任意一个字符串中的一个字符。 
//
// 
//
// 示例 1： 
//
// 
//输入: word1 = "sea", word2 = "eat"
//输出: 2
//解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
// 
//
// 示例 2: 
//
// 
//输入：word1 = "leetcode", word2 = "etco"
//输出：4
// 
//
// 
//
// 提示： 
// 
//
// 
// 1 <= word1.length, word2.length <= 500 
// word1 和 word2 只包含小写英文字母 
// 
//
// Related Topics 字符串 动态规划 👍 493 👎 0

package leetcode.editor.cn.java;

//Java:两个字符串的删除操作
//Time:2022-09-19 13:08:19
class P583_DeleteOperationForTwoStrings {
    public static void main(String[] args) {
        Solution solution = new P583_DeleteOperationForTwoStrings().new Solution();
        System.out.println(solution.minDistance("sea", "eat"));
//        System.out.println(solution.minDistance("leetcode", "etco"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
//            int[][] dp = new int[m + 1][n + 1];
            int[] dp = new int[n + 1];
/*            for (int i = 0; i <= m; i++) {
                dp[i][0] = i;
            }
            for (int j = 0; j <= n; j++) {
                dp[0][j] = j;
            }*/
            for (int i = 0; i <= n; i++) {
                dp[i] = i;
            }
            for (int i = 1; i <= m; i++) {
                int pre = dp[0];
                dp[0] = i;
                for (int j = 1; j <= n; j++) {
                    int cur = dp[j];
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//                        dp[i][j] = dp[i - 1][j - 1];
                        dp[j] = pre;
                    } else {
//                        dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + 1;
                        dp[j] = Math.min(dp[j], dp[j - 1]) + 1;
                    }
                    pre = cur;
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
