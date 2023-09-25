//整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。 
//
// 
// 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。 
// 
//
// 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就
//是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。 
//
// 
// 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。 
// 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。 
// 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。 
// 
//
// 给你一个整数数组 nums ，找出 nums 的下一个排列。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 双指针 👍 1788 👎 0

package leetcode.editor.cn.java;

import java.util.Arrays;

//Java：下一个排列
class P31_NextPermutation {
    public static void main(String[] args) {
        Solution solution = new P31_NextPermutation().new Solution();
        solution.nextPermutation(new int[]{2, 6, 3, 5, 4, 1});
        solution.nextPermutation(new int[]{1, 2, 3});
        solution.nextPermutation(new int[]{3, 2, 1});
        solution.nextPermutation(new int[]{1, 1, 5});
        solution.nextPermutation(new int[]{3, 6, 8, 4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            int i = nums.length - 1;
            int j = i;
            while (j > 0) {
                if (nums[j] <= nums[j - 1]) {
                    --j;
                    continue;
                }
                int t = j;
                int min = Integer.MAX_VALUE;
                while (i >= j) {
                    if (nums[j - 1] < nums[i]) {
                        if (nums[i] < min) {
                            min = nums[i];
                            t = i;
                        }
                    }
                    --i;
                }
                int temp = nums[j - 1];
                nums[j - 1] = nums[t];
                nums[t] = temp;

                break;
            }
            i = nums.length - 1;
            int temp;
            while (j < i) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                --i;
                ++j;
            }
            System.out.println(Arrays.toString(nums));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
