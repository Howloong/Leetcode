//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 3354 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;

//Java：有效的括号
class P20_ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P20_ValidParentheses().new Solution();
        System.out.println(solution.isValid("["));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            if (s.length() == 1) {
                return false;
            }
            ArrayDeque<Character> arrayDeque = new ArrayDeque<>();
            int i = 0;
            while (i != s.length()) {
                char c = s.charAt(i);
                switch (c) {
                    case '{':
                    case '(':
                    case '[':
                        arrayDeque.push(c);
                        break;
                    case ')':
                        if (arrayDeque.isEmpty()|| !arrayDeque.peek().equals('(')) {
                            return false;
                        }
                         arrayDeque.pop();
                        break;
                    case '}':
                        if (arrayDeque.isEmpty()|| !arrayDeque.peek().equals('{')) {
                            return false;
                        }
                        arrayDeque.pop();
                        break;
                    case ']':
                        if (arrayDeque.isEmpty()|| !arrayDeque.peek().equals('[')) {
                            return false;
                        }
                        arrayDeque.pop();
                        break;
                    default:
                        break;
                }
                ++i;
            }
            return arrayDeque.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
