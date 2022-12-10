//给你两个长度可能不等的整数数组 nums1 和 nums2 。两个数组中的所有值都在 1 到 6 之间（包含 1 和 6）。
//
// 每次操作中，你可以选择 任意 数组中的任意一个整数，将它变成 1 到 6 之间 任意 的值（包含 1 和 6）。 
//
// 请你返回使 nums1 中所有数的和与 nums2 中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
//输出：3
//解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
//- 将 nums2[0] 变为 6 。 nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2] 。
//- 将 nums1[5] 变为 1 。 nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2] 。
//- 将 nums1[2] 变为 2 。 nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2] 。
// 
//
// 示例 2： 
//
// 输入：nums1 = [1,1,1,1,1,1,1], nums2 = [6]
//输出：-1
//解释：没有办法减少 nums1 的和或者增加 nums2 的和使二者相等。
// 
//
// 示例 3： 
//
// 输入：nums1 = [6,6], nums2 = [1]
//输出：3
//解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
//- 将 nums1[0] 变为 2 。 nums1 = [2,6], nums2 = [1] 。
//- 将 nums1[1] 变为 2 。 nums1 = [2,2], nums2 = [1] 。
//- 将 nums2[0] 变为 4 。 nums1 = [2,2], nums2 = [4] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 10⁵ 
// 1 <= nums1[i], nums2[i] <= 6 
// 
//
// Related Topics 贪心 数组 哈希表 计数 👍 81 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java:通过最少操作次数使数组的和相等
//Time:2022-12-07 10:06:49
class P1775_EqualSumArraysWithMinimumNumberOfOperations {
    public static void main(String[] args) {
        Solution solution = new P1775_EqualSumArraysWithMinimumNumberOfOperations().new Solution();
//        System.out.println(solution.minOperations(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 1, 2, 2, 2, 2}));
//        System.out.println(solution.minOperations(new int[]{1,1,1,1,1,1,1}, new int[]{6}));
        System.out.println(solution.minOperations(new int[]{6,6}, new int[]{12}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums1, int[] nums2) {
            int sum1 = Arrays.stream(nums1).sum();
            int sum2 = Arrays.stream(nums2).sum();
            if (sum2 == sum1) {
                return 0;
            }
            if (sum1 > sum2) {
                return func(nums2, sum2, nums1, sum1);
            }
            return func(nums1, sum1, nums2, sum2);
        }

        public int func(int[] nums1, int sum1, int[] nums2, int sum2) {
            if (!edge(nums1, nums2)) {
                return -1;
            }
            int diff = sum2 - sum1;
            int count = 0;
            int i = 0;
            int j = nums2.length - 1;
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            while (i < nums1.length && j > 0) {
                int t1 = 6 - nums1[i];
                int t2 = nums2[j] - 1;
                if (t1 > t2) {
                    diff -= t1;
                    i++;
                } else {
                    diff -= t2;
                    j--;
                }
                count++;
                if (diff <= 0) {
                    break;
                }
            }
            if (diff > 0) {
                while (i < nums1.length&&diff>0) {
                    diff -= (6 - nums1[i]);
                    count++;
                    i++;
                }
                while (j>=0&&diff>0) {
                    diff -= (nums2[j]-1);
                    count++;
                    j--;
                }
            }

            return count;
        }

        public boolean edge(int[] nums1, int[] nums2) {
            if (nums1.length >= nums2.length) {
                return nums1.length <= nums2.length * 6;
            }
            return edge(nums2, nums1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
