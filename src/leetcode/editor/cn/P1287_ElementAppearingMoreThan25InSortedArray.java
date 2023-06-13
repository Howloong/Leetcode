//给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。 
//
// 请你找到并返回这个整数 
//
// 
//
// 示例： 
//
// 
//输入：arr = [1,2,2,6,6,6,6,7,10]
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^4 
// 0 <= arr[i] <= 10^5 
// 
//
// Related Topics 数组 👍 64 👎 0

package leetcode.editor.cn;

//Java：有序数组中出现次数超过25%的元素
class P1287_ElementAppearingMoreThan25InSortedArray {
    public static void main(String[] args) {
        Solution solution = new P1287_ElementAppearingMoreThan25InSortedArray().new Solution();
//        System.out.println(solution.findSpecialInteger(new int[]{1, 2, 2,6, 6, 6, 6, 7, 10}));
        System.out.println(solution.findSpecialInteger(new int[]{1, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findSpecialInteger(int[] arr) {
            int sum = 1;
            if (arr.length == 1) {
                return arr[0];
            }
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] == arr[i + 1]) {
                    sum++;
                    if (sum > arr.length / 4) {
                        return arr[i];
                    }
                } else {
                    sum = 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
