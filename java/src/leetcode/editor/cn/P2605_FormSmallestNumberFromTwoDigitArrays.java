//给你两个只包含 1 到 9 之间数字的数组 nums1 和 nums2 ，每个数组中的元素 互不相同 ，请你返回 最小 的数字，两个数组都 至少 包含这个数
//字的某个数位。
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [4,1,3], nums2 = [5,7]
//输出：15
//解释：数字 15 的数位 1 在 nums1 中出现，数位 5 在 nums2 中出现。15 是我们能得到的最小数字。
// 
//
// 示例 2： 
//
// 输入：nums1 = [3,5,2,6], nums2 = [3,1,7]
//输出：3
//解释：数字 3 的数位 3 在两个数组中都出现了。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 9 
// 1 <= nums1[i], nums2[i] <= 9 
// 每个数组中，元素 互不相同 。 
// 
//
// Related Topics 数组 哈希表 枚举 👍 36 👎 0

package leetcode.editor.cn.java;


import java.util.HashSet;
import java.util.Set;

//Java:从两个数字数组里生成最小数字
//Time:2023-09-05 09:50:29
class P2605_FormSmallestNumberFromTwoDigitArrays {
    public static void main(String[] args) {
        Solution solution = new P2605_FormSmallestNumberFromTwoDigitArrays().new Solution();
        System.out.println(solution.minNumber(new int[]{4, 1, 3}, new int[]{5, 7}));
        System.out.println(solution.minNumber(new int[]{3,5,2,6}, new int[]{3,1,7}));
        System.out.println(solution.minNumber(new int[]{6,4,3,7,2,1,8,5}, new int[]{6,8,5,3,1,7,4,2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minNumber(int[] nums1, int[] nums2) {
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;

            Set<Integer> set = new HashSet<>();
            int same = 10;

            for (int j : nums1) {
                min1 = Math.min(min1, j);
                set.add(j);
            }
            for (int j : nums2) {
                if (set.contains(j)) {
                    same = Math.min(same, j);
                }
                min2 = Math.min(min2, j);
            }
            if (same != 10) {
                return same;
            }
            if (min1 < min2) {
                return min1 * 10 + min2;
            }
            return min2 * 10 + min1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
