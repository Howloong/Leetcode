//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由 可打印的 ASCII 字符组成 
// 
//
// Related Topics 双指针 字符串 👍 259 👎 0

package leetcode.editor.cn;

//Java:反转字符串中的元音字母
//Time:2022-08-01 15:55:21
class P345_ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new P345_ReverseVowelsOfAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            int i = 0;
            int j = s.length() - 1;
            char[] c = s.toCharArray();
            while (i < j) {
                while (i < j && c[i] != 'a' && c[i] != 'e' && c[i] != 'i' && c[i] != 'o' && c[i] != 'u' && c[i] != 'A' && c[i] != 'E' && c[i] != 'I' && c[i] != 'O' && c[i] != 'U') {
                    i++;
                }
                while (i < j && c[j] != 'a' && c[j] != 'e' && c[j] != 'i' && c[j] != 'o' && c[j] != 'u' && c[j] != 'A' && c[j] != 'E' && c[j] != 'I' && c[j] != 'O' && c[j] != 'U') {
                    j--;
                }
                char temp = c[i];
                c[i] = c[j];
                c[j] = temp;
                i++;
                j--;
            }
            return new String(c);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
