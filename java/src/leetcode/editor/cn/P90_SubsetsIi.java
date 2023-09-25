//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// 
// 
// Related Topics 位运算 数组 回溯 👍 874 👎 0

package leetcode.editor.cn.java;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：子集 II
class P90_SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new P90_SubsetsIi().new Solution();
        System.out.println(solution.subsetsWithDup(new int[]{1, 2, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        ArrayDeque<Integer> path = new ArrayDeque<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            backTracking(nums, 0);
            return result;
        }

        public void backTracking(int[] nums, int startIndex) {
            result.add(new ArrayList<>(path));
            for (int i = startIndex; i < nums.length; i++) {
                if (i > startIndex && nums[i] == nums[i - 1]) {
                    continue;
                }
                path.addLast(nums[i]);
                backTracking(nums, i + 1);
                path.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
