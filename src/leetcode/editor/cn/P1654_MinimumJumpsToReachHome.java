//有一只跳蚤的家在数轴上的位置 x 处。请你帮助它从位置 0 出发，到达它的家。 
//
// 跳蚤跳跃的规则如下： 
//
// 
// 它可以 往前 跳恰好 a 个位置（即往右跳）。 
// 它可以 往后 跳恰好 b 个位置（即往左跳）。 
// 它不能 连续 往后跳 2 次。 
// 它不能跳到任何 forbidden 数组中的位置。 
// 
//
// 跳蚤可以往前跳 超过 它的家的位置，但是它 不能跳到负整数 的位置。 
//
// 给你一个整数数组 forbidden ，其中 forbidden[i] 是跳蚤不能跳到的位置，同时给你整数 a， b 和 x ，请你返回跳蚤到家的最少跳跃
//次数。如果没有恰好到达 x 的可行方案，请你返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：forbidden = [14,4,18,1,15], a = 3, b = 15, x = 9
//输出：3
//解释：往前跳 3 次（0 -> 3 -> 6 -> 9），跳蚤就到家了。
// 
//
// 示例 2： 
//
// 
//输入：forbidden = [8,3,16,6,12,20], a = 15, b = 13, x = 11
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：forbidden = [1,6,2,14,5,17,4], a = 16, b = 9, x = 7
//输出：2
//解释：往前跳一次（0 -> 16），然后往回跳一次（16 -> 7），跳蚤就到家了。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= forbidden.length <= 1000 
// 1 <= a, b, forbidden[i] <= 2000 
// 0 <= x <= 2000 
// forbidden 中所有位置互不相同。 
// 位置 x 不在 forbidden 中。 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 👍 101 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java:到家的最少跳跃次数
//Time:2023-08-30 09:16:02
class P1654_MinimumJumpsToReachHome {
    public static void main(String[] args) {
        Solution solution = new P1654_MinimumJumpsToReachHome().new Solution();
//        System.out.println(solution.minimumJumps(new int[]{14, 4, 18, 1, 15}, 3, 15, 9));
//        System.out.println(solution.minimumJumps(new int[]{8, 3, 16, 6, 12, 20}, 15, 13, 11));
        System.out.println(solution.minimumJumps(new int[]{61, 104, 19, 60, 68, 157, 183, 148, 116, 93, 190, 13, 177, 47, 15, 133, 111}, 75, 165, 150));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumJumps(int[] forbidden, int a, int b, int x) {
            Queue<int[]> queue = new ArrayDeque<>();
            Set<Integer> visited = new HashSet<>();
            queue.offer(new int[]{0, 1, 0});
            visited.add(0);
            int lower = 0, upper = Math.max(Arrays.stream(forbidden).max().getAsInt() + a, x) + b;
            Set<Integer> forbiddenSet = new HashSet<>();
            for (int position : forbidden) {
                forbiddenSet.add(position);
            }
            while (!queue.isEmpty()) {
                int[] arr = queue.poll();
                int position = arr[0], direction = arr[1], step = arr[2];
                if (position == x) {
                    return step;
                }
                int nextPosition = position + a;
                int nextDirection = 1;
                if (lower <= nextPosition && nextPosition <= upper && !visited.contains(nextPosition * nextDirection) && !forbiddenSet.contains(nextPosition)) {
                    visited.add(nextPosition * nextDirection);
                    queue.offer(new int[]{nextPosition, nextDirection, step + 1});
                }
                if (direction == 1) {
                    nextPosition = position - b;
                    nextDirection = -1;
                    if (lower <= nextPosition && nextPosition <= upper && !visited.contains(nextPosition * nextDirection) && !forbiddenSet.contains(nextPosition)) {
                        visited.add(nextPosition * nextDirection);
                        queue.offer(new int[]{nextPosition, nextDirection, step + 1});
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
