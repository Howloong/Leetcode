//一个正整数如果能被 a 或 b 整除，那么它是神奇的。 
//
// 给定三个整数 n , a , b ，返回第 n 个神奇的数字。因为答案可能很大，所以返回答案 对 10⁹ + 7 取模 后的值。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：n = 1, a = 2, b = 3
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：n = 4, a = 2, b = 3
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁹ 
// 2 <= a, b <= 4 * 10⁴ 
// 
//
// 
//
// Related Topics 数学 二分查找 👍 141 👎 0

package leetcode.editor.cn.java;

//Java:第 N 个神奇数字
//Time:2022-11-22 10:14:13
class P878_NthMagicalNumber {
    public static void main(String[] args) {
        Solution solution = new P878_NthMagicalNumber().new Solution();
        System.out.println(solution.nthMagicalNumber(10, 10, 8));
//        System.out.println(solution.nthMagicalNumber(1000000000, 39999,40000));
//        System.out.println(solution.nthMagicalNumber(1, 2, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int MOD = (int) 1e9 + 7;

        public int nthMagicalNumber(int n, int a, int b) {
            if (a % b == 0) {
                return nthMagicalNumber(n, b);
            }
            if (b % a == 0) {
                return nthMagicalNumber(n, a);
            }
            if (a > b) {
                return nthMagicalNumber(n, b, a);
            }
            int p = b;
            while (p % a != 0) {
                p = p + b;
            }
            long left = a, right = (long) n * a;
            while (left <= right) {
                long mid = left + (right - left) / 2;
                long count = mid / a + mid / b - mid / p;
                if (count >= n) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return (int) (left % MOD);
        }

        public int nthMagicalNumber(int n, int a) {
            return (int) ((long) n * a % MOD) % MOD;
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}
