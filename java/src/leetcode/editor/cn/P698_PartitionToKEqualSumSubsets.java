//给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。 
//
// 
//
// 示例 1： 
//
// 
//输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//输出： True
//说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4], k = 3
//输出: false 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= len(nums) <= 16 
// 0 < nums[i] < 10000 
// 每个元素的频率在 [1,4] 范围内 
// 
//
// Related Topics 位运算 记忆化搜索 数组 动态规划 回溯 状态压缩 👍 713 👎 0

package leetcode.editor.cn.java;

import java.util.Arrays;

//Java:划分为k个相等的子集
//Time:2022-09-20 10:18:01
class P698_PartitionToKEqualSumSubsets {
    public static void main(String[] args) {
        Solution solution = new P698_PartitionToKEqualSumSubsets().new Solution();
//        System.out.println(solution.canPartitionKSubsets(new int[]{1, 1, 1, 1, 2, 2, 2, 2}, 2));
//        System.out.println(solution.canPartitionKSubsets(new int[]{10, 12, 1, 2, 10, 7, 5, 19, 13, 1}, 4));
//        System.out.println(solution.canPartitionKSubsets(new int[]{4,3,2,3,5,2,1}, 4));
        System.out.println(solution.canPartitionKSubsets(new int[]{1, 1, 2, 4}, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //桶视角
/*        public boolean backTracking(int startIndex, int[] nums, int[] bucket, int target) {
            if (startIndex ==-1) {
                return true;
            }
            for (int i = 0; i < bucket.length; i++) {
//                if (target == bucket[i]) {
//                    return true;
//                }
                if (nums[startIndex] + bucket[i] > target) {
                    continue;
                }
                if (i > 0 && bucket[i] == bucket[i - 1]) {
                    continue;
                }
                bucket[i] += nums[startIndex];
                if (backTracking(startIndex - 1, nums, bucket, target)) {
                    return true;
                }
                bucket[i] -= nums[startIndex];
            }
            return false;
        }*/
//        球视角
        public boolean backTracking(int startIndex, int[] nums, int[] bucket, int target) {
            if (startIndex == -1) {
                return true;
            }
            for (int i = 0; i < bucket.length; i++) {
                if (i > 0 && bucket[i] == bucket[i - 1]) {
                    continue;
                }
                if (bucket[i] + nums[startIndex] > target) {
                    continue;
                }
                bucket[i] += nums[startIndex];
                if (backTracking(startIndex - 1, nums, bucket, target)) {
                    return true;
                }
                bucket[i] -= nums[startIndex];
            }
            return false;
        }

        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = Arrays.stream(nums).sum();
            if (sum % k != 0) {
                return false;
            }
            int target = sum / k;
            Arrays.sort(nums);
            int[] bucket = new int[k];
//            bucket[k-1] = nums[nums.length-1];
            return backTracking(nums.length - 1, nums, bucket, target);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
