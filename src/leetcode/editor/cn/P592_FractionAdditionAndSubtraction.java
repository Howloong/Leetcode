//给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。 
//
// 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为
// 2/1。 
//
// 
//
// 示例 1: 
//
// 
//输入: expression = "-1/2+1/2"
//输出: "0/1"
// 
//
// 示例 2: 
//
// 
//输入: expression = "-1/2+1/2+1/3"
//输出: "1/3"
// 
//
// 示例 3: 
//
// 
//输入: expression = "1/3-1/2"
//输出: "-1/6"
// 
//
// 
//
// 提示: 
//
// 
// 输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。 
// 输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。 
// 输入只包含合法的最简分数，每个分数的分子与分母的范围是 [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。 
// 输入的分数个数范围是 [1,10]。 
// 最终结果的分子与分母保证是 32 位整数范围内的有效整数。 
// 
//
// Related Topics 数学 字符串 模拟 👍 95 👎 0

package leetcode.editor.cn;

//Java:分数加减运算
//Time:2022-07-27 12:25:22
class P592_FractionAdditionAndSubtraction {
    public static void main(String[] args) {
        Solution solution = new P592_FractionAdditionAndSubtraction().new Solution();
//        System.out.println(solution.fractionAddition("-1/2+1/2+1/3"));
//        System.out.println(solution.fractionAddition("1/3-1/2"));
//        System.out.println(solution.fractionAddition("-5/2+10/3+7/9"));
//        System.out.println(solution.fractionAddition("-1/2+1/2"));
        System.out.println(solution.fractionAddition("-4/7-3/4+2/3"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String fractionAddition(String expression) {
            if (!expression.startsWith("-")) {
                expression = "+" + expression;
            }
            int i = 0;
            String sum = "";
            while (i < expression.length()) {
                int j = i + 4;
                while (j < expression.length() && expression.charAt(j) != '+' && expression.charAt(j) != '-') {
                    j++;
                }
                sum = add(sum, expression.substring(i, j));
                i = j;
            }
            StringBuilder sb = new StringBuilder();
            if (sum.startsWith("-")) {
                sb.append("-");
            }
            i = 1;
            int m = 0, n = 0;
            while (sum.charAt(i) != '/') {
                m *= 10;
                m += sum.charAt(i) - '0';
                i++;
            }
            if (m == 0) {
                return "0/1";
            }
            i++;
            while (i < sum.length()) {
                n *= 10;
                n += sum.charAt(i) - '0';
                i++;
            }
            int t = maxMultiple(m, n);
            sb.append(m / t).append("/").append(n / t);
            return sb.toString();
        }

        public String add(String s1, String s2) {
            if (s1.equals("")) {
                return s2;
            }
            int len1 = s1.length();
            int len2 = s2.length();
            int i = 1, j = 1;
            int m1 = 0, n1 = 0;
            int m2 = 0, n2 = 0;
            while (s1.charAt(i) != '/') {
                m1 *= 10;
                m1 += s1.charAt(i) - '0';
                i++;
            }
            i++;
            while (s2.charAt(j) != '/') {
                n1 *= 10;
                n1 += s2.charAt(j) - '0';
                j++;
            }
            j++;
            while (i < len1) {
                m2 *= 10;
                m2 += s1.charAt(i) - '0';
                i++;
            }
            while (j < len2) {
                n2 *= 10;
                n2 += s2.charAt(j) - '0';
                j++;
            }
            int res2;
            if (m2 == n2) {
                res2 = m2;
            } else {
                res2 = minMultiple(m2, n2);
            }
            char m0 = s1.charAt(0);
            char n0 = s2.charAt(0);
            int res1;
            char res0;
            if (m0 == '+' && n0 == '+') {
                res1 = (res2 / m2) * m1 + (res2 / n2) * n1;
            } else if (m0 == '-' && n0 == '-') {
                res1 = -(res2 / m2) * m1 - (res2 / n2) * n1;
            } else if (m0 == '+' && n0 == '-') {
                res1 = (res2 / m2) * m1 - (res2 / n2) * n1;
            } else {
                res1 = -(res2 / m2) * m1 + (res2 / n2) * n1;
            }
            res0 = res1 >= 0 ? '+' : '-';
            return String.valueOf(res0) + (Math.abs(res1) ) + "/" + (res2);

        }

        public int minMultiple(int a, int b) {
            return (a * b) / maxMultiple(a, b);
        }


        public int maxMultiple(int a, int b) {
            int max = Math.max(a, b);
            int min = Math.min(a, b);
            a = max % min;
            if (a == 0) {
                return min;
            }
            return maxMultiple(a, min);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
