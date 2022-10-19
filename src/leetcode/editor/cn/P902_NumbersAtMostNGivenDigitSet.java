//给定一个按 非递减顺序 排列的数字数组
// digits 。你可以用任意次数 digits[i] 来写的数字。例如，如果
// digits = ['1','3','5']，我们可以写数字，如
// '13', '551', 和 '1351315'。 
//
// 返回 可以生成的小于或等于给定整数 n 的正整数的个数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = ["1","3","5","7"], n = 100
//输出：20
//解释：
//可写出的 20 个数字是：
//1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
// 
//
// 示例 2： 
//
// 
//输入：digits = ["1","4","9"], n = 1000000000
//输出：29523
//解释：
//我们可以写 3 个一位数字，9 个两位数字，27 个三位数字，
//81 个四位数字，243 个五位数字，729 个六位数字，
//2187 个七位数字，6561 个八位数字和 19683 个九位数字。
//总共，可以使用D中的数字写出 29523 个整数。 
//
// 示例 3: 
//
// 
//输入：digits = ["7"], n = 8
//输出：1
// 
//
// 
//
// 提示： 
// 
//
// 
// 1 <= digits.length <= 9 
// digits[i].length == 1 
// digits[i] 是从 '1' 到 '9' 的数 
// digits 中的所有值都 不同 
// digits 按 非递减顺序 排列 
// 1 <= n <= 10⁹ 
// 
//
// Related Topics 数组 数学 字符串 二分查找 动态规划 👍 220 👎 0

package leetcode.editor.cn;

//Java:最大为 N 的数字组合
//Time:2022-10-18 23:11:44
class P902_NumbersAtMostNGivenDigitSet {
    public static void main(String[] args) {
        Solution solution = new P902_NumbersAtMostNGivenDigitSet().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //TODO 没做
        public int atMostNGivenDigitSet(String[] digits, int n) {
            String s = String.valueOf(n);
            int ans = 0, k = s.length();

            // 先统计位数比n小的数的个数
            int c = 1;
            for (int i = 1; i < k; ++i) {
                c *= digits.length;
                ans += c;
            }

            // 用前缀和的思想计算数组counts，counts[i]代表给定的digits中小于等于i的数字的数量
            int[] counts = new int[10];
            for (String d : digits)
                ++counts[d.charAt(0) - '0'];
            for (int i = 1; i < 10; ++i)
                counts[i] += counts[i - 1];

            // 从高位到低位遍历n中各个数字，遍历到第i位说明0 ~ i-1位的数字都在digits里
            for (int i = 0; i < k; ++i) {
                int curr = s.charAt(i) - '0';
                if (curr == 0)
                    break; // 遇到0直接退出循环，因为没有数字可选
                ans += counts[curr - 1] * Math.pow(digits.length, k - i - 1); // 当前位选择比curr小的数字，后面的i+1 ~ k-1位可以随便选数字
                if (counts[curr] == counts[curr - 1]) // 说明digits中不存在curr，退出循环
                    break;
                if (i == k - 1) // 执行到最后一次循环说明n里的数字都在digits里，也就是说可以用digits里的数字组合成n，因此ans需要加上1
                    ++ans;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
