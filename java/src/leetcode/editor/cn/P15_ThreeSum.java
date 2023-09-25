//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 双指针 排序 👍 5078 👎 0

package leetcode.editor.cn.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java:三数之和
//Time:2022-08-04 16:59:53
class P15_ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P15_ThreeSum().new Solution();
//        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(solution.threeSum(new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            int n = nums.length;
            Arrays.sort(nums);
            if (n == 0 || nums[0] > 0 || nums[n - 1] < 0) {
                return list;
            }
            for (int i = 0; i < n; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                if (nums[i] > 0) {
                    break;
                }
                int j = i + 1;
                int k = n - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        while (j < k && nums[j] == nums[j + 1]) {
                            j++;
                        }
                        while (j < k && nums[k] == nums[k - 1]) {
                            k--;
                        }
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        list.add(temp);
                        j++;
                        k--;
                    } else if (sum < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
