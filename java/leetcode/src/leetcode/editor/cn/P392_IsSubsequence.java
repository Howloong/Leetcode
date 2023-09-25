//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。 
//
// 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而
//"aec"不是）。 
//
// 进阶： 
//
// 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代
//码？ 
//
// 致谢： 
//
// 特别感谢 @pbrother 添加此问题并且创建所有测试用例。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc", t = "ahbgdc"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "axc", t = "ahbgdc"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 100 
// 0 <= t.length <= 10^4 
// 两个字符串都只由小写字符组成。 
// 
//
// Related Topics 双指针 字符串 动态规划 👍 706 👎 0

package leetcode.editor.cn;

//Java:判断子序列
//Time:2022-08-01 17:11:35
class P392_IsSubsequence {
    public static void main(String[] args) {
        Solution solution = new P392_IsSubsequence().new Solution();
        System.out.println(solution.isSubsequence("abc", "ahbgdc"));
        System.out.println(solution.isSubsequence("axc", "ahbgdc"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isSubsequence(String s, String t) {
          /*  if (s.equals("")) {
                return true;
            }
            int index = 0;
            for (char c : t.toCharArray()) {
                if (c == s.charAt(index)) {
                    index++;
                    if (index == s.length()) {
                        return true;
                    }
                }
            }
            return false;
            */
//            int[][] dp = new int[s.length() + 1][t.length() + 1];
            int[] dp = new int[t.length() + 1];
            for (int i = 1; i <= s.length(); i++) {
                int pre = dp[0];
                for (int j = 1; j <= t.length(); j++) {
                    int cur = dp[j];
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
//                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        dp[j] = pre + 1;
                    } else {
//                        dp[i][j] = dp[i][j - 1];
                        dp[j] = dp[j - 1];
                    }
                    pre = cur;
                }
            }
            return dp[t.length()] == s.length();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
