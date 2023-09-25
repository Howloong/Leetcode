//给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//解释：[4,9] 也是可通过的
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 550 👎 0

package leetcode.editor.cn.java;

import java.util.HashSet;
import java.util.Set;

//Java：两个数组的交集
class P349_IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new P349_IntersectionOfTwoArrays().new Solution();
        solution.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            if (nums1.length == 0 || nums2.length == 0) {
                return new int[0];
            }
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            for (int i :
                    nums1) {
                set1.add(i);
            }
            for (int i : nums2
            ) {
                if (set1.contains(i)) {
                    set2.add(i);
                }
            }
            int[] result = new int[set2.size()];
            int index = 0;
            for (int i : set2
            ) {
                result[index++] = i;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
