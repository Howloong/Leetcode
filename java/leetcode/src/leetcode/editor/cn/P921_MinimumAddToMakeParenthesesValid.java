//只有满足下面几点之一，括号字符串才是有效的： 
//
// 
// 它是一个空字符串，或者 
// 它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者 
// 它可以被写作 (A)，其中 A 是有效字符串。 
// 
//
// 给定一个括号字符串 s ，移动N次，你就可以在字符串的任何位置插入一个括号。 
//
// 
// 例如，如果 s = "()))" ，你可以插入一个开始括号为 "(()))" 或结束括号为 "())))" 。 
// 
//
// 返回 为使结果字符串 s 有效而必须添加的最少括号数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "())"
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：s = "((("
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 只包含 '(' 和 ')' 字符。 
// 
//
// Related Topics 栈 贪心 字符串 👍 200 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;

//Java:使括号有效的最少添加
//Time:2022-10-04 16:02:27
class P921_MinimumAddToMakeParenthesesValid {
    public static void main(String[] args) {
        Solution solution = new P921_MinimumAddToMakeParenthesesValid().new Solution();
        System.out.println(solution.minAddToMakeValid("())"));
        System.out.println(solution.minAddToMakeValid("((("));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minAddToMakeValid(String s) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            char[] c = s.toCharArray();
            for (char c1 : c) {
                if (!stack.isEmpty()) {
                    if (stack.peek().equals('(') && c1 == ')') {
                        stack.pop();
                    } else {
                        stack.push(c1);
                    }
                } else {
                    stack.push(c1);
                }
            }
            return stack.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
