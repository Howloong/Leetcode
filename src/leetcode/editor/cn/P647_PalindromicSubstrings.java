//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。 
//
// 回文字符串 是正着读和倒过来读一样的字符串。 
//
// 子字符串 是字符串中的由连续字符组成的一个序列。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 977 👎 0

package leetcode.editor.cn;

//Java:回文子串
//Time:2022-09-21 11:28:10
class P647_PalindromicSubstrings {
    public static void main(String[] args) {
        Solution solution = new P647_PalindromicSubstrings().new Solution();
        System.out.println(solution.countSubstrings("xkjkqlajprjwefilxgpdpebieswu"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*     public int countSubstrings(String s) {
                 int len = s.length();
                 boolean[][] dp = new boolean[len + 1][len + 1];
                 int sum = 0;
                 for (int i = len; i > 0; i--) {
                     for (int j = i; j <= len; j++) {
                         if (s.charAt(i - 1) != s.charAt(j - 1)) {
                             dp[i][j] = false;
                         } else {
                             if (i + 1 == j || i == j) {
                                 dp[i][j] = true;
                                 sum++;
                             } else if (dp[i + 1][j - 1]) {
                                 sum++;
                                 dp[i][j] = true;
                             }
                         }
                     }
                 }
                 return sum;
             }*/
        public int countSubstrings(String s) {
            int len = s.length();
            int sum = 0;
            char[] c = s.toCharArray();
            for (int i = 0; i < len; i++) {
                sum += extend(c, i, i);
                sum += extend(c, i, i + 1);
            }
            return sum;
        }

        public int extend(char[] s, int i, int j) {
            int len = s.length;
            int sum = 0;
            while (i >= 0 && j < len && s[i] == s[j]) {
                sum++;
                i--;
                j++;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
