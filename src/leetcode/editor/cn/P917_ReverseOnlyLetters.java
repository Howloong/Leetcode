//给你一个字符串 s ，根据下述规则反转字符串： 
//
// 
// 所有非英文字母保留在原有位置。 
// 所有英文字母（小写或大写）位置反转。 
// 
//
// 返回反转后的 s 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "ab-cd"
//输出："dc-ba"
// 
//
// 
// 
//
// 示例 2： 
//
// 
//输入：s = "a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
// 
//
// 
// 
//
// 示例 3： 
//
// 
//输入：s = "Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
// 
//
// 
//
// 提示 
//
// 
// 1 <= s.length <= 100 
// s 仅由 ASCII 值在范围 [33, 122] 的字符组成 
// s 不含 '\"' 或 '\\' 
// 
// Related Topics 双指针 字符串 👍 176 👎 0

package leetcode.editor.cn;

//Java：仅仅反转字母
class P917_ReverseOnlyLetters {
    public static void main(String[] args) {
        Solution solution = new P917_ReverseOnlyLetters().new Solution();
        System.out.println(solution.reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(solution.reverseOnlyLetters("7-28"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseOnlyLetters(String s) {
            int i = 0;
            int j = s.length() - 1;
            char[] c = s.toCharArray();
            while (i < j) {
                while (i<s.length()&&!Character.isLetter(c[i])) {
                    i++;
                }
                while (j>=0&&!Character.isLetter(c[j])) {
                    j--;
                }
                if (i >= j) {
                    break;
                }
                char temp =c[i];
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
