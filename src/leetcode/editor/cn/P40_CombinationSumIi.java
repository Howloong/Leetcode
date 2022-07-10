//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 👍 1026 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：组合总和 II
class P40_CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new P40_CombinationSumIi().new Solution();
        System.out.println(solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> result;
        public ArrayDeque<Integer> path;
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            result = new ArrayList<>();
            path = new ArrayDeque<>();
            Arrays.sort(candidates);
            backTracking(candidates, target, 0, 0);
            return result;
        }

        public void backTracking(int[] candidates, int target, int sum, int index) {
            if (sum == target) {
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = index; i < candidates.length && sum < target; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                path.addLast(candidates[i]);
                backTracking(candidates, target, sum + candidates[i], i + 1);
                path.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
