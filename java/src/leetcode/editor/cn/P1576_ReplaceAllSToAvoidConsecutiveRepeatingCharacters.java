//给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。 
//
// 注意：你 不能 修改非 '?' 字符。 
//
// 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。 
//
// 在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "?zs"
//输出："azs"
//解释：该示例共有 25 种解决方案，从 "azs" 到 "yzs" 都是符合题目要求的。只有 "z" 是无效的修改，因为字符串 "zzs" 中有连续重复的两
//个 'z' 。 
//
// 示例 2： 
//
// 
//输入：s = "ubv?w"
//输出："ubvaw"
//解释：该示例共有 24 种解决方案，只有替换成 "v" 和 "w" 不符合题目要求。因为 "ubvvw" 和 "ubvww" 都包含连续重复的字符。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 仅包含小写英文字母和 '?' 字符 
// 
//
// Related Topics 字符串 👍 112 👎 0

package leetcode.editor.cn.java;

//Java:替换所有的问号
//Time:2023-05-11 21:44:31
class P1576_ReplaceAllSToAvoidConsecutiveRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new P1576_ReplaceAllSToAvoidConsecutiveRepeatingCharacters().new Solution();
//        System.out.println(solution.modifyString("?z?"));
        System.out.println(solution.modifyString("?????ab?d???"));
        System.out.println(solution.modifyString("??"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String modifyString(String s) {
            StringBuilder sb = new StringBuilder(s);
            if (s.length() == 1 && s.charAt(0) == '?') {
                return "a";
            }
            if (sb.charAt(0) == '?') {
                if (sb.charAt(1) == '?') {
                    sb.setCharAt(0, 'a');
                } else {
                    sb.setCharAt(0, (char) (((sb.charAt(1) - 'a' + 1) % 26) + 'a'));

                }
            }
            if (sb.charAt(s.length() - 1) == '?') {
                if (sb.charAt(s.length() - 2) == '?') {
                    sb.setCharAt(s.length() - 1, 'a');
                } else
                    sb.setCharAt(s.length() - 1, (char) (((sb.charAt(s.length() - 2) - 'a' + 1) % 26) + 'a'));
            }
            for (int i = 1; i < s.length() - 1; i++) {
                if (s.charAt(i) == '?') {
                    for (int j = 0; j < 26; j++) {
                        char c = (char) (j + 'a');
                        if (sb.charAt(i - 1) != c && sb.charAt(i + 1) != c) {
                            sb.setCharAt(i, c);
                            break;
                        }
                    }
                }

            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
