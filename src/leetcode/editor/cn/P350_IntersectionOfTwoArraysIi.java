//给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现
//次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
//
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 764 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Java：两个数组的交集 II
class P350_IntersectionOfTwoArraysIi {
    public static void main(String[] args) {
        Solution solution = new P350_IntersectionOfTwoArraysIi().new Solution();
        solution.intersect(new int[]{54, 93, 21, 73, 84, 60, 18, 62, 59, 89, 83, 89, 25, 39, 41, 55, 78, 27, 65, 82, 94, 61, 12, 38, 76, 5, 35,
                6, 51, 48, 61, 0, 47, 60, 84, 9, 13, 28, 38, 21, 55, 37, 4, 67, 64, 86, 45, 33, 41}, new int[]{17, 17, 87, 98, 18, 53, 2, 69, 74, 73, 20, 85, 59, 89, 84, 91, 84, 34, 44, 48, 20, 42, 68, 84, 8, 54, 66, 62, 69, 52, 67, 27, 87, 49, 92, 14, 92, 53, 22, 90, 60, 14, 8, 71, 0, 61, 94, 1, 22, 84, 10, 55, 55, 60, 98, 76, 27, 35, 84, 28, 4, 2, 9, 44, 86, 12, 17, 89, 35, 68, 17, 41, 21, 65, 59, 86, 42, 53, 0, 33, 80, 20});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            HashMap<Integer, Integer> hashMap1 = new HashMap<>();
            HashMap<Integer, Integer> hashMap2 = new HashMap<>();
            int len = 0;
            int[] res = new int[nums1.length];
            if (nums1.length > nums2.length) {
                return intersect(nums2, nums1);
            } else {
                for (int i :
                        nums2) {
                    hashMap1.put(i, hashMap1.getOrDefault(i, 0) + 1);
                }
                for (int i :
                        nums1) {
                    if (hashMap1.containsKey(i)) {
                        hashMap2.put(i, hashMap2.getOrDefault(i, 0) + 1);
                        hashMap1.put(i, hashMap1.get(i) - 1);
                        res[len++] = i;
                        if (hashMap1.get(i) == 0) {
                            hashMap1.remove(i);
                        }
                    }
                }
            }
            return Arrays.copyOfRange(res, 0, len);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
