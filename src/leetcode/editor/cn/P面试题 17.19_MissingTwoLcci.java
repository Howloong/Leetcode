//给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？ 
//
// 以任意顺序返回这两个数字均可。 
//
// 示例 1: 
//
// 输入: [1]
//输出: [2,3] 
//
// 示例 2: 
//
// 输入: [2,3]
//输出: [1,4] 
//
// 提示： 
//
// 
// nums.length <= 30000 
// 
//
// Related Topics 位运算 数组 哈希表 👍 110 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java:消失的两个数字
//Time:2022-09-26 09:52:49
class MissingTwoLcci {
    public static void main(String[] args) {
        Solution solution = new MissingTwoLcci().new Solution();
        System.out.println(Arrays.toString(solution.missingTwo(new int[]{2, 3})));
//        System.out.println(Arrays.toString(solution.missingTwo(new int[]{1, 3, 4, 5, 6, 7, 8, 9})));
//        System.out.println(Arrays.toString(solution.missingTwo(new int[]{2})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] missingTwo(int[] nums) {
            int N = nums.length + 2;
            int xor = 1;
            for (int i = 2; i <= N; i++) {
                xor ^= i;
            }
            for (int i = 0; i < nums.length; i++) {
                xor ^= nums[i];
            }
            int lb = xor & (-xor);
            int t1 = 0;
            for (int i = 0; i < nums.length; i++) {
                if ((lb & nums[i]) == 0) {
                    t1 ^= nums[i];
                }
            }
            for (int i = 1; i <= N; i++) {
                if ((lb & i) == 0) {
                    t1 ^= i;
                }
            }
            return new int[]{t1, xor ^ t1};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
