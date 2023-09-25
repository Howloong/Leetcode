//给你一个二进制字符串 s ，该字符串 不含前导零 。 
//
// 如果 s 包含 零个或一个由连续的 '1' 组成的字段 ，返回 true 。否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1001"
//输出：false
//解释：字符串中的 1 没有形成一个连续字段。
// 
//
// 示例 2： 
//
// 
//输入：s = "110"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s[i] 为 '0' 或 '1' 
// s[0] 为 '1' 
// 
// Related Topics 字符串 👍 18 👎 0

package leetcode.editor.cn.java;

//Java：检查二进制字符串字段
class P1784_CheckIfBinaryStringHasAtMostOneSegmentOfOnes {
    public static void main(String[] args) {
        Solution solution = new P1784_CheckIfBinaryStringHasAtMostOneSegmentOfOnes().new Solution();
        System.out.println(solution.checkOnesSegment("1101"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkOnesSegment(String s) {
           /* int i = s.length() - 1;
            int sum = 1;
            while (i > 0) {
                if (s.charAt(i) == '1' && s.charAt(i - 1) == '0') {
                    ++sum;
                }
                --i;
            }
            return sum<=1;*/
            return !s.contains("01");
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
