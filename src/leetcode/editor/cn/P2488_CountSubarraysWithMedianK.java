//给你一个长度为 n 的数组 nums ，该数组由从 1 到 n 的 不同 整数组成。另给你一个正整数 k 。 
//
// 统计并返回 nums 中的 中位数 等于 k 的非空子数组的数目。 
//
// 注意： 
//
// 
// 数组的中位数是按 递增 顺序排列后位于 中间 的那个元素，如果数组长度为偶数，则中位数是位于中间靠 左 的那个元素。 
// 
//
// 
// 例如，[2,3,1,4] 的中位数是 2 ，[8,4,3,5,1] 的中位数是 4 。 
// 
// 
// 子数组是数组中的一个连续部分。 
//
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,1,4,5], k = 4
//输出：3
//解释：中位数等于 4 的子数组有：[4]、[4,5] 和 [1,4,5] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,3,1], k = 3
//输出：1
//解释：[3] 是唯一一个中位数等于 3 的子数组。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 1 <= nums[i], k <= n 
// nums 中的整数互不相同 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 74 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

//Java:统计中位数为 K 的子数组
//Time:2023-03-16 10:13:05
class P2488_CountSubarraysWithMedianK {
    public static void main(String[] args) {
        Solution solution = new P2488_CountSubarraysWithMedianK().new Solution();
        System.out.println(solution.countSubarrays(new int[]{3, 2, 1, 4, 5}, 4));
        System.out.println(solution.countSubarrays(new int[]{2, 5, 1, 4, 3, 6}, 1));
        System.out.println(solution.countSubarrays(new int[]{2, 3, 1}, 3));
        System.out.println(solution.countSubarrays(new int[]{5, 19, 11, 15, 13, 16, 4, 6, 2, 7, 10, 8, 18, 20, 1, 3, 17, 9, 12, 14}, 6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubarrays(int[] nums, int k) {
            int kIndex = -1;
            int sum = 0;
            int cnt = 0;
            int start;
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            hashMap.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < k) {
                    sum -= 1;
                } else if (nums[i] > k) {
                    sum += 1;
                } else {
                    kIndex = i;
                }
                if (kIndex == -1) {
                    hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
                } else {
                    cnt += hashMap.getOrDefault(sum, 0);
                    cnt += hashMap.getOrDefault(sum - 1, 0);
                }
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
