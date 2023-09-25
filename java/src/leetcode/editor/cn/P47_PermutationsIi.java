//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 👍 1119 👎 0

package leetcode.editor.cn.java;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：全排列 II
class P47_PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new P47_PermutationsIi().new Solution();
        System.out.println(solution.permuteUnique(new int[]{1, 1, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> result = new ArrayList<>();
        public ArrayDeque<Integer> path = new ArrayDeque<>();
        public boolean[] used;

        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            used = new boolean[nums.length];
            backTracking(nums);
            return result;
        }

        public void backTracking(int[] nums) {
            if (path.size() == nums.length) {
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                if (!used[i]) {
                    path.addLast(nums[i]);
                    used[i] = true;
                    backTracking(nums);
                    used[i] = false;
                    path.removeLast();
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
