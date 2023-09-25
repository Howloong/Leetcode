//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 1712 👎 0

package leetcode.editor.cn.java;

//Java：在排序数组中查找元素的第一个和最后一个位置
class P34_FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new P34_FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) {
                return new int[]{-1, -1};
            }
            int i = 0, j = nums.length - 1;
            int mid;
            int right = -2;
            int left = -2;
            while (i <= j) {
                mid = (i + j) / 2;
                if (nums[mid] > target) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                    right = i;
                }
            }
            i = 0;
            j = nums.length - 1;
            while (i <= j) {
                mid = (i + j) / 2;
                if (nums[mid] >= target) {
                    j = mid - 1;
                    left = j;
                } else {
                    i = mid + 1;
                }
            }
            if (right == -2 || left == -2) {
                return new int[]{-1, -1};
            }
            if (right - left > 1) {
                return new int[]{left + 1, right - 1};
            }
            return new int[]{-1, -1};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
