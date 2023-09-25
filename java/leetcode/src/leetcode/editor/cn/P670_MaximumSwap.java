//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。 
//
// 示例 1 : 
//
// 
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
// 
//
// 示例 2 : 
//
// 
//输入: 9973
//输出: 9973
//解释: 不需要交换。
// 
//
// 注意: 
//
// 
// 给定数字的范围是 [0, 10⁸] 
// 
//
// Related Topics 贪心 数学 👍 303 👎 0

package leetcode.editor.cn;

//Java:最大交换
//Time:2022-09-13 10:52:58
class P670_MaximumSwap {
    public static void main(String[] args) {
        Solution solution = new P670_MaximumSwap().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumSwap(int num) {
            char[] nums = String.valueOf(num).toCharArray();
            for (int i = 0; i < nums.length; i++) {
                int first = nums[i];
                int max = first;
                int index = i + 1;
                for (int j = i + 1; j < nums.length; j++) {
                    if (first < nums[j] && max <= nums[j]) {
                        max = nums[j];
                        index = j;
                    }
                }
                if (first < max) {
                    char temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                    return Integer.parseInt(new String(nums));
                }
            }
            return Integer.parseInt(new String(nums));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
