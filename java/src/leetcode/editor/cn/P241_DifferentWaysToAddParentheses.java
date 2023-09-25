//给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。 
//
// 生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 10⁴ 。 
//
// 
//
// 示例 1： 
//
// 
//输入：expression = "2-1-1"
//输出：[0,2]
//解释：
//((2-1)-1) = 0 
//(2-(1-1)) = 2
// 
//
// 示例 2： 
//
// 
//输入：expression = "2*3-4*5"
//输出：[-34,-14,-10,-10,10]
//解释：
//(2*(3-(4*5))) = -34 
//((2*3)-(4*5)) = -14 
//((2*(3-4))*5) = -10 
//(2*((3-4)*5)) = -10 
//(((2*3)-4)*5) = 10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= expression.length <= 20 
// expression 由数字和算符 '+'、'-' 和 '*' 组成。 
// 输入表达式中的所有整数值在范围 [0, 99] 
// 
// Related Topics 递归 记忆化搜索 数学 字符串 动态规划 👍 584 👎 0

package leetcode.editor.cn.java;

import java.util.ArrayList;
import java.util.List;

//Java：为运算表达式设计优先级
class P241_DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        Solution solution = new P241_DifferentWaysToAddParentheses().new Solution();
        System.out.println(solution.diffWaysToCompute("2*3-4*5"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> diffWaysToCompute(String expression) {
            return backTracking(expression);
        }

        public List<Integer> backTracking(String s) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '*' || c == '+' || c == '-') {
                    List<Integer> l1 = backTracking(s.substring(0, i));
                    List<Integer> l2 = backTracking(s.substring(i + 1));
                    for (int m :
                            l1) {
                        for (int n :
                                l2) {
                            switch (c) {
                                case '+' -> result.add(m + n);
                                case '-' -> result.add(m - n);
                                case '*' -> result.add(m * n);
                                default -> {
                                }
                            }
                        }
                    }
                }
            }
            if (result.isEmpty()) {
                result.add(Integer
                        .valueOf(s));
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
