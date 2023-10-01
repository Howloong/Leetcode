//整数的 数组形式 num 是按照从左到右的顺序表示其数字的数组。 
//
// 
// 例如，对于 num = 1321 ，数组形式是 [1,3,2,1] 。 
// 
//
// 给定 num ，整数的 数组形式 ，和整数 k ，返回 整数 num + k 的 数组形式 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：num = [1,2,0,0], k = 34
//输出：[1,2,3,4]
//解释：1200 + 34 = 1234
// 
//
// 示例 2： 
//
// 
//输入：num = [2,7,4], k = 181
//输出：[4,5,5]
//解释：274 + 181 = 455
// 
//
// 示例 3： 
//
// 
//输入：num = [2,1,5], k = 806
//输出：[1,0,2,1]
//解释：215 + 806 = 1021
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num.length <= 10⁴ 
// 0 <= num[i] <= 9 
// num 不包含任何前导零，除了零本身 
// 1 <= k <= 10⁴ 
// 
//
// Related Topics 数组 数学 👍 213 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java:数组形式的整数加法
//Time:2022-10-05 13:25:12
class P989_AddToArrayFormOfInteger {
    public static void main(String[] args) {
        Solution solution = new P989_AddToArrayFormOfInteger().new Solution();
        System.out.println(solution.addToArrayForm(new int[]{1, 9, 9, 9}, 32));
        System.out.println(solution.addToArrayForm(new int[]{9, 3}, 636));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> addToArrayForm(int[] num, int k) {
            int len = String.valueOf(k).length();
            int[] num2 = new int[Math.max(num.length, len)];
            for (int i = num2.length - 1; i >= 0; i--) {
                num2[i] = k % 10;
                k /= 10;
            }
            if (num.length < len) {
                int[] num1 = new int[len];
                System.arraycopy(num, 0, num1, len - num.length, num.length);
                return add(num1, num2);
            }
            return add(num, num2);
        }

        public List<Integer> add(int[] num1, int[] num2) {
            List<Integer> list = new ArrayList<>();
            boolean carry = false;
            for (int i = num2.length - 1; i >= 0; i--) {
                int t = (num1[i] + num2[i] + (carry ? 1 : 0));
                list.add(0, t % 10);
                carry = t >= 10;
            }
            if (carry) {
                list.add(0, 1);
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
