//给定一个平衡括号字符串 S，按下述规则计算该字符串的分数： 
//
// 
// () 得 1 分。 
// AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。 
// (A) 得 2 * A 分，其中 A 是平衡括号字符串。 
// 
//
// 
//
// 示例 1： 
//
// 输入： "()"
//输出： 1
// 
//
// 示例 2： 
//
// 输入： "(())"
//输出： 2
// 
//
// 示例 3： 
//
// 输入： "()()"
//输出： 2
// 
//
// 示例 4： 
//
// 输入： "(()(()))"
//输出： 6
// 
//
// 
//
// 提示： 
//
// 
// S 是平衡括号字符串，且只含有 ( 和 ) 。 
// 2 <= S.length <= 50 
// 
//
// Related Topics 栈 字符串 👍 374 👎 0

package leetcode.editor.cn.java;

import java.util.ArrayDeque;

//Java:括号的分数
//Time:2022-10-09 11:30:52
class P856_ScoreOfParentheses {
    public static void main(String[] args) {
        Solution solution = new P856_ScoreOfParentheses().new Solution();
        System.out.println(solution.scoreOfParentheses("(())"));
        System.out.println(solution.scoreOfParentheses("()"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        ArrayDeque<Character> arrayDeque;
        int index = 0;

        public int scoreOfParentheses(String s) {
            arrayDeque = new ArrayDeque<>();
            char[] chars = s.toCharArray();
            int i = 0;
            int sum = 0;
            int level = 0;
            while (i < chars.length) {
                if (chars[i] == '(') {
                    level++;
                } else {
                    level--;
                    if (chars[i - 1] == '(') {
                        sum += (1 << (level));
                    }
                }
                i++;

            }
            return sum;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
