//现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 
//prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。 
//
// 
// 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。 
// 
//
// 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：[0,1]
//解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
// 
//
// 示例 2： 
//
// 
//输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//输出：[0,2,1,3]
//解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
//因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。 
//
// 示例 3： 
//
// 
//输入：numCourses = 1, prerequisites = []
//输出：[0]
// 
//
// 
//提示：
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= numCourses * (numCourses - 1) 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// ai != bi 
// 所有[ai, bi] 互不相同 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 827 👎 0

package leetcode.editor.cn.java;

import java.util.*;

//Java:课程表 II
//Time:2023-09-10 09:51:56
class P210_CourseScheduleIi {
    public static void main(String[] args) {
        Solution solution = new P210_CourseScheduleIi().new Solution();
//        System.out.println(Arrays.toString(solution.findOrder(2, new int[][]{{1, 0}})));
//        System.out.println(Arrays.toString(solution.findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}})));
        System.out.println(Arrays.toString(solution.findOrder(2, new int[][]{{0, 1}, {1, 0}})));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<List<Integer>> list;
            int[] inDegree;
            int[] res;
            int index;
            list = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                list.add(new ArrayList<>());
            }
            inDegree = new int[numCourses];
            res = new int[numCourses];
            index = 0;
            for (int[] prerequisite : prerequisites) {
                list.get(prerequisite[1]).add(prerequisite[0]);
                inDegree[prerequisite[0]]++;
            }
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) {
                    deque.offer(i);
                }
            }
            while (!deque.isEmpty()) {
                int head = deque.poll();
                res[index++] = head;
                for (int tail : list.get(head)) {
                    inDegree[tail]--;
                    if (inDegree[tail] == 0) {
                        deque.offer(tail);
                    }
                }
            }
            if (index != numCourses) {
                return new int[]{};
            }
            return res;
        }*/
        boolean valid = true;
        int index;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<List<Integer>> edges;
            int[] visited;
            valid = true;
            edges = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                edges.add(new ArrayList<>());
            }
            visited = new int[numCourses];
            index = numCourses - 1;
            for (int[] prerequisite : prerequisites) {
                edges.get(prerequisite[1]).add(prerequisite[0]);
            }
            int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                if (!valid) {
                    return new int[0];
                }
                if (visited[i] == 0) {
                    dfs(i, visited, edges, res);
                }
            }
            return res;
        }

        public void dfs(int u, int[] visited, List<List<Integer>> edges,int[] res) {
            visited[u] = 1;
            for (int i : edges.get(u)) {
                if (visited[i] == 0) {
                    dfs(i, visited, edges,res);
                    if (!valid) {
                        return;
                    }
                } else if (visited[i] == 1) {
                    valid = false;
                    return;
                }
            }
            visited[u] = 2;
            res[index--] = u;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}
