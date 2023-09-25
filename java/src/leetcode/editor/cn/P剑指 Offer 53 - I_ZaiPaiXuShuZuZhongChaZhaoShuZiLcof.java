//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
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
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
//
// Related Topics 数组 二分查找 👍 364 👎 0

package leetcode.editor.cn.java;

//Java:在排序数组中查找数字 I
//Time:2022-10-06 16:35:01
class I_ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new I_ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
        System.out.println(solution.search(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            if (nums.length == 0) {
                return 0;
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
                return 0;
            }
            if (right - left > 1) {
                return right - left - 1;
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
