//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 并查集 数组 哈希表 👍 1579 👎 0

package leetcode.editor.cn.java;

import java.util.HashMap;
import java.util.Map;

//Java:最长连续序列
//Time:2023-03-16 16:47:09
class P128_LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new P128_LongestConsecutiveSequence().new Solution();
//        System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(solution.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
//        System.out.println(solution.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
//        System.out.println(solution.longestConsecutive(new int[]{1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
         /*   Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int max = 0;
            for (Integer integer : set) {
                if (set.contains(integer - 1)) {
                    continue;
                }
                int cur = integer;
                int count = 1;
                while (set.contains(cur + 1)) {
                    cur++;
                    count++;
                }
                max = Math.max(max, count);
            }
            return max;*/
            Node node = new Node(nums.length);
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                if (i == map.get(nums[i]) && map.containsKey(nums[i] + 1)) {
                    node.union(i, map.get(nums[i] + 1));
                }
            }
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                res = Math.max(res, node.rank[node.find(i)]);
            }
            return res;
        }

    }

    class Node {
        int[] parent;
        int[] rank;

        public Node(int N) {
            parent = new int[N];
            rank = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            return x == parent[x] ? x : (parent[x] = find(parent[x]));
        }

        public void union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) {
                return;
            }
            if (rank[x] < rank[y]) {
                parent[x] = y;
                rank[y] += rank[x];
            } else {
                parent[y] = x;
                rank[x] += rank[y];
            }
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}
