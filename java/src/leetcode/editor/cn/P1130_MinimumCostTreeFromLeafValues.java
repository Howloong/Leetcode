//给你一个正整数数组 arr，考虑所有满足以下条件的二叉树： 
//
// 
// 每个节点都有 0 个或是 2 个子节点。 
// 数组 arr 中的值与树的中序遍历中每个叶节点的值一一对应。 
// 每个非叶节点的值等于其左子树和右子树中叶节点的最大值的乘积。 
// 
//
// 在所有这样的二叉树中，返回每个非叶节点的值的最小可能总和。这个和的值是一个 32 位整数。 
//
// 如果一个节点有 0 个子节点，那么该节点为叶节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：arr = [6,2,4]
//输出：32
//解释：有两种可能的树，第一种的非叶节点的总和为 36 ，第二种非叶节点的总和为 32 。 
// 
//
// 示例 2： 
// 
// 
//输入：arr = [4,11]
//输出：44
// 
//
// 
//
// 提示： 
//
// 
// 2 <= arr.length <= 40 
// 1 <= arr[i] <= 15 
// 答案保证是一个 32 位带符号整数，即小于 2³¹ 。 
// 
//
// Related Topics 栈 贪心 数组 动态规划 单调栈 👍 309 👎 0

package leetcode.editor.cn.java;

import java.util.ArrayDeque;
import java.util.Deque;

//Java:叶值的最小代价生成树
//Time:2023-05-31 10:25:04
class P1130_MinimumCostTreeFromLeafValues {
    public static void main(String[] args) {
        Solution solution = new P1130_MinimumCostTreeFromLeafValues().new Solution();
        System.out.println(solution.mctFromLeafValues(new int[]{6, 2, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mctFromLeafValues(int[] arr) {
            Deque<Integer> stack = new ArrayDeque<>();
            stack.add(Integer.MAX_VALUE);
            int sum = 0;
            for (int i : arr) {
                while (stack.peek() < i) {
                    sum += stack.pop() * Math.min(i, stack.peek());
                }
                stack.push(i);
            }
            while (stack.size() > 2) {
                sum += stack.pop() * stack.peek();
            }
            return sum;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}