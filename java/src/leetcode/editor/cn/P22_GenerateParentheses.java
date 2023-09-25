//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 2791 👎 0

package leetcode.editor.cn.java;

import java.util.ArrayList;
import java.util.List;

//Java:括号生成
//Time:2022-08-04 15:00:15
class P22_GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22_GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> result = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            backTracking(n, n, "");
            return result;
        }

        public void backTracking(int left, int right, String str) {
            if (left == 0 && right == 0) {
                result.add(str);
                return;
            }
            if (left > 0) {
                backTracking(left - 1, right, str + "(");
            }
            if (right > left) {
                backTracking(left, right - 1, str + ")");
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
