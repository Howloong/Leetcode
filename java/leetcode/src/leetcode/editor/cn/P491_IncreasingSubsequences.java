//给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。 
//
// 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,6,7,7]
//输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,4,3,2,1]
//输出：[[4,4]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 15 
// -100 <= nums[i] <= 100 
// 
// Related Topics 位运算 数组 哈希表 回溯 👍 471 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//Java：递增子序列
class P491_IncreasingSubsequences {
    public static void main(String[] args) {
        Solution solution = new P491_IncreasingSubsequences().new Solution();
        System.out.println(solution.findSubsequences(new int[]{1, 2, 1, 1}));
//        System.out.println(solution.findSubsequences(new int[]{4,4,3,2,1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> result = new ArrayList<>();
        public ArrayDeque<Integer> path = new ArrayDeque<>();

        public List<List<Integer>> findSubsequences(int[] nums) {
            backTracking(nums, 0);
            return result;
        }

        public void backTracking(int[] nums, int index) {
            if (path.size() >= 2) {
                result.add(new ArrayList<>(path));
            }
            HashSet<Integer> hashSet = new HashSet<>();
            for (int i = index; i < nums.length; i++) {
                if (i > index && nums[i] == nums[i - 1] || hashSet.contains(nums[i]))
                    continue;
                if (path.isEmpty() || nums[i] >= path.getLast()) {
                    path.addLast(nums[i]);
                    hashSet.add(nums[i]);
                    backTracking(nums, i + 1);
                    path.removeLast();
                }


            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
