//给定一个数组 nums ，将其划分为两个连续子数组 left 和 right， 使得： 
//
// 
// left 中的每个元素都小于或等于 right 中的每个元素。 
// left 和 right 都是非空的。 
// left 的长度要尽可能小。 
// 
//
// 在完成这样的分组后返回 left 的 长度 。 
//
// 用例可以保证存在这样的划分方法。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,0,3,8,6]
//输出：3
//解释：left = [5,0,3]，right = [8,6]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1,0,6,12]
//输出：4
//解释：left = [1,1,1,0]，right = [6,12]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁶ 
// 可以保证至少有一种方法能够按题目所描述的那样对 nums 进行划分。 
// 
//
// Related Topics 数组 👍 138 👎 0

package leetcode.editor.cn.java;

//Java:分割数组
//Time:2022-10-24 10:00:40
class P915_PartitionArrayIntoDisjointIntervals {
    public static void main(String[] args) {
        Solution solution = new P915_PartitionArrayIntoDisjointIntervals().new Solution();
        System.out.println(solution.partitionDisjoint(new int[]{5, 0, 3, 8, 6}));
        System.out.println(solution.partitionDisjoint(new int[]{1, 1, 1, 0, 6, 12}));
        System.out.println(solution.partitionDisjoint(new int[]{32, 57, 24, 19, 0, 24, 49, 67, 87, 87}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int partitionDisjoint(int[] nums) {
            int left = 0;
            int right = 1;
            int max = nums[0];
            int temp = nums[0];
            while (right < nums.length) {
                if (max > nums[right]) {
                    left = right;
                    max = temp;
                }
                temp = Math.max(temp, nums[right]);
                right++;
            }
            return left + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
