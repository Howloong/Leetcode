//给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和
//最接近 target （最接近表示两者之差的绝对值最小）。 
//
// 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。 
//
// 请注意，答案不一定是 arr 中的数字。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [4,9,3], target = 10
//输出：3
//解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
// 
//
// 示例 2： 
//
// 输入：arr = [2,3,5], target = 10
//输出：5
// 
//
// 示例 3： 
//
// 输入：arr = [60864,25176,27249,21296,20204], target = 56803
//输出：11361
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^4 
// 1 <= arr[i], target <= 10^5 
// 
//
// Related Topics 数组 二分查找 排序 👍 201 👎 0

package leetcode.editor.cn.java;

//Java:转变数组后最接近目标值的数组和
//Time:2023-08-22 15:28:08
class P1300_SumOfMutatedArrayClosestToTarget {
    public static void main(String[] args) {
        Solution solution = new P1300_SumOfMutatedArrayClosestToTarget().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findBestValue(int[] arr, int target) {
            int left = 0;
            int right = 0;
            for (int i : arr) {
                right = Math.max(right, i);
            }
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (getSum(arr, mid) < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (target - getSum(arr, left - 1) <= getSum(arr, left) - target) {
                return left - 1;
            }
            return left;
        }

        public int getSum(int[] nums, int threshold) {
            int sum = 0;
            for (int num : nums) {
                sum += Math.min(num, threshold);
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
