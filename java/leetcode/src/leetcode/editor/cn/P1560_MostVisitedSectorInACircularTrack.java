//给你一个整数 n 和一个整数数组 rounds 。有一条圆形赛道由 n 个扇区组成，扇区编号从 1 到 n 。现将在这条赛道上举办一场马拉松比赛，该马拉松全
//程由 m 个阶段组成。其中，第 i 个阶段将会从扇区 rounds[i - 1] 开始，到扇区 rounds[i] 结束。举例来说，第 1 阶段从 
//rounds[0] 开始，到 rounds[1] 结束。 
//
// 请你以数组形式返回经过次数最多的那几个扇区，按扇区编号 升序 排列。 
//
// 注意，赛道按扇区编号升序逆时针形成一个圆（请参见第一个示例）。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：n = 4, rounds = [1,3,1,2]
//输出：[1,2]
//解释：本场马拉松比赛从扇区 1 开始。经过各个扇区的次序如下所示：
//1 --> 2 --> 3（阶段 1 结束）--> 4 --> 1（阶段 2 结束）--> 2（阶段 3 结束，即本场马拉松结束）
//其中，扇区 1 和 2 都经过了两次，它们是经过次数最多的两个扇区。扇区 3 和 4 都只经过了一次。 
//
// 示例 2： 
//
// 输入：n = 2, rounds = [2,1,2,1,2,1,2,1,2]
//输出：[2]
// 
//
// 示例 3： 
//
// 输入：n = 7, rounds = [1,3,5,7]
//输出：[1,2,3,4,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 100 
// 1 <= m <= 100 
// rounds.length == m + 1 
// 1 <= rounds[i] <= n 
// rounds[i] != rounds[i + 1] ，其中 0 <= i < m 
// 
// Related Topics 数组 模拟 👍 33 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Java：圆形赛道上经过次数最多的扇区
class P1560_MostVisitedSectorInACircularTrack {
    public static void main(String[] args) {
        Solution solution = new P1560_MostVisitedSectorInACircularTrack().new Solution();
        System.out.println(solution.mostVisited(4, new int[]{1, 3, 1, 2}));
        System.out.println(solution.mostVisited(2, new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2}));
        System.out.println(solution.mostVisited(7, new int[]{1, 3, 5, 7}));
        System.out.println(solution.mostVisited(3, new int[]{3, 2, 1, 2, 1, 3, 2, 1, 2, 1, 3, 2, 3, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> mostVisited(int n, int[] rounds) {
            List<Integer> result = new ArrayList<>();
            int end = rounds[rounds.length - 1];
            int start = rounds[0];
            if (start > end) {
                for (int i = 1; i <= end; i++) {
                    result.add(i);
                }
                for (int i = start; i <= n; i++) {
                    result.add(i);
                }
            } else {
                for (int i = start; i <= end; i++) {
                    result.add(i);
                }
            }
            result.sort(Comparator.comparingInt(o -> o));
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
