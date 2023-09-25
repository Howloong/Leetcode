//给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的
//数目来描述。 
//
// 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
//输出：[2,11,7,15]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
//输出：[24,32,8,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= 10⁵ 
// nums2.length == nums1.length 
// 0 <= nums1[i], nums2[i] <= 10⁹ 
// 
//
// Related Topics 贪心 数组 双指针 排序 👍 303 👎 0

package leetcode.editor.cn.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

//Java:优势洗牌
//Time:2022-10-08 18:58:20
class P870_AdvantageShuffle {
    public static void main(String[] args) {
        Solution solution = new P870_AdvantageShuffle().new Solution();
        System.out.println(Arrays.toString(solution.advantageCount(new int[]{2, 0, 4, 1, 2}, new int[]{1, 3, 0, 0, 2})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            int n = nums1.length;
            TreeSet<Integer> treeSet = new TreeSet<>();
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i : nums1) {
                int t = hashMap.getOrDefault(i, 0);
                hashMap.put(i, t + 1);
                if (t == 0) {
                    treeSet.add(i);
                }
            }
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                Integer integer = treeSet.ceiling(nums2[i] + 1);
                if (integer == null) {
                    integer = treeSet.ceiling(-1);
                }
                res[i] = integer;
                int t = hashMap.get(integer);
                hashMap.put(integer, t - 1);
                if (t == 1) {
                    treeSet.remove(integer);
                }
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
