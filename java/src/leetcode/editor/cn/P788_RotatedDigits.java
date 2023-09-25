//我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。 
//
// 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况
//下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。 
//
// 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？ 
//
// 
//
// 示例： 
//
// 输入: 10
//输出: 4
//解释: 
//在[1, 10]中有四个好数： 2, 5, 6, 9。
//注意 1 和 10 不是好数, 因为他们在旋转之后不变。
// 
//
// 
//
// 提示： 
//
// 
// N 的取值范围是 [1, 10000]。 
// 
//
// Related Topics 数学 动态规划 👍 153 👎 0

package leetcode.editor.cn.java;

import java.util.Arrays;

//Java:旋转数字
//Time:2022-09-25 15:12:39
class P788_RotatedDigits {
    public static void main(String[] args) {
        Solution solution = new P788_RotatedDigits().new Solution();
        System.out.println(solution.rotatedDigits(20));
//        solution.rotatedDigits(100);
//        solution.rotatedDigits(1000);
//        solution.rotatedDigits(10000);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
 /*   class Solution {
        public int rotatedDigits(int n) {
            int sum = 0;
            int i = 1;
            Outer:
            while (i <= n) {
                boolean isExist = false;
                char[] c = String.valueOf(i).toCharArray();
                for (char c1 : c) {
                    if (c1 == '3' || c1 == '4' || c1 == '7') {
                        i++;
                        continue Outer;
                    }
                    if (!isExist && (c1 == '2' || c1 == '5' || c1 == '6' || c1 == '9')) {
                        isExist = true;
                    }
                }
                if (isExist) {
                    sum++;
//                    System.out.println(i);
                }
                i++;
            }
            return sum;
        }
    }*/
    class Solution {
        private int[] a = new int[6];
        private int[][] dp = new int[6][2];

        public int rotatedDigits(int n) {
            int len = 0;
            for (var e : dp) {
                Arrays.fill(e, -1);
            }
            while (n > 0) {
                a[++len] = n % 10;
                n /= 10;
            }
            return dfs(len, 0, true);
        }

        private int dfs(int pos, int ok, boolean limit) {
            if (pos <= 0) {
                return ok;
            }
            if (!limit && dp[pos][ok] != -1) {
                return dp[pos][ok];
            }
            int up = limit ? a[pos] : 9;
            int ans = 0;
            for (int i = 0; i <= up; ++i) {
                if (i == 0 || i == 1 || i == 8) {
                    ans += dfs(pos - 1, ok, limit && i == up);
                }
                if (i == 2 || i == 5 || i == 6 || i == 9) {
                    ans += dfs(pos - 1, 1, limit && i == up);
                }
            }
            if (!limit) {
                dp[pos][ok] = ans;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}


