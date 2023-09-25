//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 5538 👎 0

package leetcode.editor.cn;

//Java:最长回文子串
//Time:2022-08-05 14:13:35
class P5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new P5_LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("cbdd"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int last = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= s.length() - 1; i++) {
                String t = s.substring(0, i + 1);
                StringBuilder substr = new StringBuilder(t);
                if (substr.reverse().toString().equals(t)) {
                    last = substr.length();
                    sb = substr;
                }
            }
            return sb.toString();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
