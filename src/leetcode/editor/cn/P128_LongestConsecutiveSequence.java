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

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java:最长连续序列
//Time:2023-03-16 16:47:09
class P128_LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new P128_LongestConsecutiveSequence().new Solution();
//        System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(solution.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
//        System.out.println(solution.longestConsecutive(new int[]{1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int n = nums.length;
            int res = 1;
            UnionFind unionFind = new UnionFind(nums);
            for (int num : nums) {
                if (unionFind.find(num + 1) != Integer.MIN_VALUE) {
                    res = Math.max(res, unionFind.union(num, num + 1));
                }
            }
            return res;
        }
    }

    class UnionFind {
        Map<Integer, int[]> parent;

        public UnionFind(int[] nums) {
            parent = new HashMap<>();
            for (int num : nums) {
                parent.put(num, new int[]{num, 1});
            }
        }

        public int find(int nums) {
            if (!parent.containsKey(nums)) {
                return Integer.MIN_VALUE;
            }
//            while (nums != parent.get(nums)[0]) {
//                nums = parent.get(nums)[0];
//            }
            if (nums != parent.get(nums)[0]) {
                int[] n = parent.get(nums);
                n[0] = find(n[0]);
            }
            return parent.get(nums)[0];
        }

        public int union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return parent.get(rootY)[1];
            }
            int[] n = parent.get(rootX);
            n[0] = rootY;
            parent.get(rootY)[1] += n[1];
            return parent.get(rootY)[1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
