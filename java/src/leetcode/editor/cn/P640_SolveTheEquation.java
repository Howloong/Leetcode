//求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。 
//
// 如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。 
//
// 题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。 
//
// 
//
// 示例 1： 
//
// 
//输入: equation = "x+5-3+x=6+x-2"
//输出: "x=2"
// 
//
// 示例 2: 
//
// 
//输入: equation = "x=x"
//输出: "Infinite solutions"
// 
//
// 示例 3: 
//
// 
//输入: equation = "2x=x"
//输出: "x=0"
// 
//
// 
//
// 提示: 
//
// 
// 3 <= equation.length <= 1000 
// equation 只有一个 '='. 
// equation 方程由整数组成，其绝对值在 [0, 100] 范围内，不含前导零和变量 'x' 。 
// 
//
// Related Topics 数学 字符串 模拟 👍 137 👎 0

package leetcode.editor.cn.java;

//Java:求解方程
//Time:2022-08-10 11:36:59
class P640_SolveTheEquation {
    public static void main(String[] args) {
        Solution solution = new P640_SolveTheEquation().new Solution();
        System.out.println(solution.solveEquation("0x=0"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String solveEquation(String equation) {
            String left = equation.split("=")[0];
            String right = equation.split("=")[1];
            if (!left.startsWith("-")) {
                left = "+" + left;
            }
            if (!right.startsWith("-")) {
                right = "+" + right;
            }
            int xRatio = getEquation(left)[0] - getEquation(right)[0];
            int numRatio = getEquation(left)[1] - getEquation(right)[1];
            if (xRatio == 0 && numRatio != 0) {
                return "No solution";
            }
            if (xRatio == 0) {
                return "Infinite solutions";
            }
            return "x=" + (-numRatio) / xRatio;
        }


        public int[] getEquation(String equation) {
            char[] c = equation.toCharArray();
            int xRatio = 0;
            int numRatio = 0;
            int i = 0;
            boolean isNegative;
            Outer:
            while (i < c.length) {
                isNegative = c[i] == '-';
                int j = i + 1;
                int ratio = 0;
                while (j < c.length && c[j] != '+' && c[j] != '-') {
                    if (c[j] == 'x') {
                        if (j == i + 1) {
                            ratio = 1;
                        }
                        if (isNegative) {
                            ratio = -ratio;
                        }
                        xRatio += ratio;
                        i = j + 1;
                        continue Outer;
                    }
                    ratio = ratio * 10;
                    ratio += (c[j] - '0');
                    j++;
                }
                if (isNegative) {
                    ratio = -ratio;
                }
                numRatio += ratio;
                i = j;
            }
            return new int[]{xRatio, numRatio};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
