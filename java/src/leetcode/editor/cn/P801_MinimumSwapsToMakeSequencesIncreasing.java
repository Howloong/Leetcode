//我们有两个长度相等且不为空的整型数组 nums1 和 nums2 。在一次操作中，我们可以交换 nums1[i] 和 nums2[i]的元素。 
//
// 
// 例如，如果 nums1 = [1,2,3,8] ， nums2 =[5,6,7,4] ，你可以交换 i = 3 处的元素，得到 nums1 =[1,2,3
//,4] 和 nums2 =[5,6,7,8] 。 
// 
//
// 返回 使 nums1 和 nums2 严格递增 所需操作的最小次数 。 
//
// 数组 arr 严格递增 且 arr[0] < arr[1] < arr[2] < ... < arr[arr.length - 1] 。 
//
// 注意： 
//
// 
// 用例保证可以实现操作。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: nums1 = [1,3,5,4], nums2 = [1,2,3,7]
//输出: 1
//解释: 
//交换 A[3] 和 B[3] 后，两个数组如下:
//A = [1, 3, 5, 7] ， B = [1, 2, 3, 4]
//两个数组均为严格递增的。 
//
// 示例 2: 
//
// 
//输入: nums1 = [0,3,5,8,9], nums2 = [2,1,4,6,9]
//输出: 1
// 
//
// 
//
// 提示: 
//
// 
// 2 <= nums1.length <= 10⁵ 
// nums2.length == nums1.length 
// 0 <= nums1[i], nums2[i] <= 2 * 10⁵ 
// 
//
// Related Topics 数组 动态规划 👍 358 👎 0

package leetcode.editor.cn.java;

//Java:使序列递增的最小交换次数
//Time:2022-10-10 17:00:35
class P801_MinimumSwapsToMakeSequencesIncreasing {
    public static void main(String[] args) {
        Solution solution = new P801_MinimumSwapsToMakeSequencesIncreasing().new Solution();
//        System.out.println(solution.minSwap(new int[]{1, 3, 5, 4}, new int[]{1, 2, 3, 7}));
//        System.out.println(solution.minSwap(new int[]{0, 3, 5, 8, 9}, new int[]{2, 1, 4, 6, 9}));
        System.out.println(solution.minSwap(new int[]{0, 7, 8, 10, 10, 11, 12, 13, 19, 18}, new int[]{4, 4, 5, 7, 11, 14, 15, 16, 17, 20}));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    final class Solution {
        public int minSwap(int[] nums1, int[] nums2) {
            int len = nums1.length;
            int a = 0, b = 1;
            for (int i = 1; i < len; i++) {
                int atemp = a;
                int btemp = b;
                a = b = len;
                if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                    a = Math.min(a, atemp);
                    b = Math.min(b, btemp + 1);
                }
                if (nums1[i - 1] < nums2[i] && nums2[i - 1] < nums1[i]) {
                    a = Math.min(a, btemp);
                    b = Math.min(b, atemp + 1);
                }
            }
            return Math.min(a, b);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
