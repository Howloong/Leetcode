//给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。 
//
// 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 1
//输出：5
//解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：15
//解释：仅由元音组成的 15 个字典序字符串为
//["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
//注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
// 
//
// 示例 3： 
//
// 
//输入：n = 33
//输出：66045
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 50 
// 
//
// Related Topics 数学 动态规划 组合数学 👍 131 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java:统计字典序元音字符串的数目
//Time:2023-03-29 16:31:54
class P1641_CountSortedVowelStrings {
    public static void main(String[] args) {
        Solution solution = new P1641_CountSortedVowelStrings().new Solution();
        System.out.println(solution.countVowelStrings(4
        ));
        System.out.println(solution.countVowelStrings(33));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*    public int countVowelStrings(int n) {
                return (n + 4) * (n + 3) * (n + 2) * (n + 1) / 24;

            } */
        public int countVowelStrings(int n) {
            int[] dp = new int[6];
            Arrays.fill(dp, 1);
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < 5; j++) {
                    dp[j + 1] += dp[j];
                }
            }
            return dp[5];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
