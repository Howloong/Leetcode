//实现 strStr() 函数。 
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 说明： 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "hello", needle = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 字符串匹配 👍 1458 👎 0

package leetcode.editor.cn;

//Java：实现 strStr()
class P28_ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new P28_ImplementStrstr().new Solution();
        System.out.println(solution.strStr("hello", "ll"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0) {
                return 0;
            }
            int[] next = getNext(needle.toCharArray());
            int j = -1;
            for (int i = 0; i < haystack.length(); i++) {
                while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                    j = next[j];
                }
                if (haystack.charAt(i) == needle.charAt(j + 1)) {
                    ++j;
                }
                if (j == needle.length() - 1) {
                    return i - needle.length() + 1;
                }
            }
            return -1;
        }

        public int[] getNext(char[] needle) {
            int[] next = new int[needle.length];
            int j = -1;
            next[0] = j;
            for (int i = 0; i < next.length; i++) {
                while (j >= 0 && needle[i] != needle[j + 1]) {
                    j = next[j];
                }
                if (needle[i] == needle[j + 1]) {
                    ++j;
                }
                next[i] = j;

            }
            return next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
