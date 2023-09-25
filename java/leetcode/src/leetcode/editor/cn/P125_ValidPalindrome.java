//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 
//
// 示例 1: 
//
// 
//输入: "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串
// 
//
// 示例 2: 
//
// 
//输入: "race a car"
//输出: false
//解释："raceacar" 不是回文串
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// 字符串 s 由 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 👍 542 👎 0

package leetcode.editor.cn;

//Java：验证回文串
class P125_ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new P125_ValidPalindrome().new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));
        System.out.println(solution.isPalindrome(".;"));
        System.out.println(solution.isPalindrome("0P"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            if (s.length() <= 1) {
                return true;
            }
            int i = 0;
            int j = s.length() - 1;

            while (i <= j) {
                while (!Character.isLetterOrDigit(s.charAt(i))) {
                    ++i;
                    if (i == s.length()) {
                        return true;
                    }
                }
                while (!Character.isLetterOrDigit(s.charAt(j))) {
                    --j;
                }
                if (s.charAt(i) == s.charAt(j) || Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
                    ++i;
                    --j;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
