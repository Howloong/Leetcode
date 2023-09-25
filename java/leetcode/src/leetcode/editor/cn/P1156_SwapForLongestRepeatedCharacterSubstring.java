//如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。 
//
// 给你一个字符串 text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。返回其中最长的子串的长度。 
//
// 
//
// 示例 1： 
//
// 输入：text = "ababa"
//输出：3
// 
//
// 示例 2： 
//
// 输入：text = "aaabaaa"
//输出：6
// 
//
// 示例 3： 
//
// 输入：text = "aaabbaaa"
//输出：4
// 
//
// 示例 4： 
//
// 输入：text = "aaaaa"
//输出：5
// 
//
// 示例 5： 
//
// 输入：text = "abcdef"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 20000 
// text 仅由小写英文字母组成。 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 142 👎 0

package leetcode.editor.cn;

//Java:单字符重复子串的最大长度
//Time:2023-06-03 11:33:17
class P1156_SwapForLongestRepeatedCharacterSubstring {
    public static void main(String[] args) {
        Solution solution = new P1156_SwapForLongestRepeatedCharacterSubstring().new Solution();
        System.out.println(solution.maxRepOpt1("ababa"));
        System.out.println(solution.maxRepOpt1("aaabaaa"));
        System.out.println(solution.maxRepOpt1("aaabbaaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxRepOpt1(String text) {
            int length = text.length();
            int[] res = new int[length];
            for (char c : text.toCharArray()) {
                res[c - 'a']++;
            }
            int i = 0;
            int ans = 0;
            while (i < length) {
                int j = i;
                while (j < length && text.charAt(i) == text.charAt(j)) {
                    j++;
                }
                int k = j + 1;
                while (k < length && text.charAt(i) == text.charAt(k)) {
                    k++;
                }
                int len = k - i;
                ans = Math.max(ans, Math.min(len, res[text.charAt(i) - 'a']));
                i = j;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
