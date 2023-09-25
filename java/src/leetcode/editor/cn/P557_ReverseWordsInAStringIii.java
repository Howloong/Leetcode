//给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 示例 2: 
//
// 
//输入： s = "God Ding"
//输出："doG gniD"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// s 包含可打印的 ASCII 字符。 
// s 不包含任何开头或结尾空格。 
// s 里 至少 有一个词。 
// s 中的所有单词都用一个空格隔开。 
// 
// Related Topics 双指针 字符串 👍 454 👎 0

package leetcode.editor.cn.java;

//Java：反转字符串中的单词 III
class P557_ReverseWordsInAStringIii {
    public static void main(String[] args) {
        Solution solution = new P557_ReverseWordsInAStringIii().new Solution();
        System.out.println(solution.reverseWords("Let's take LeetCode contest"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            int i = 0;
            int j = 0;
            char[] c = s.toCharArray();
            while (j < c.length - 1) {
                while (j < c.length - 1 && c[j + 1] != ' ') {
                    ++j;
                }
                swap(c, i, j);
                ++j;
                while (j < c.length - 1 && c[j] == ' ') {
                    ++j;
                }
                i = j;
            }
            return new String(c);
        }

        public void swap(char[] c, int start, int end) {
            char temp;
            while (start < end) {
                temp = c[start];
                c[start] = c[end];
                c[end] = temp;
                ++start;
                --end;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
