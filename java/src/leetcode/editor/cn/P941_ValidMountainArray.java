//给定一个整数数组 arr，如果它是有效的山脉数组就返回 true，否则返回 false。 
//
// 让我们回顾一下，如果 arr 满足下述条件，那么它是一个山脉数组： 
//
// 
// arr.length >= 3 
// 在 0 < i < arr.length - 1 条件下，存在 i 使得： 
// 
// arr[0] < arr[1] < ... arr[i-1] < arr[i] 
// arr[i] > arr[i+1] > ... > arr[arr.length - 1] 
// 
// 
//
// 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [2,1]
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：arr = [3,5,5]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：arr = [0,3,2,1]
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10⁴ 
// 0 <= arr[i] <= 10⁴ 
// 
//
// Related Topics 数组 👍 193 👎 0

package leetcode.editor.cn.java;

//Java:有效的山脉数组
//Time:2022-10-03 15:57:55
class P941_ValidMountainArray {
    public static void main(String[] args) {
        Solution solution = new P941_ValidMountainArray().new Solution();
//        System.out.println(solution.validMountainArray(new int[]{2, 1}));
//        System.out.println(solution.validMountainArray(new int[]{3,5,5,6}));
//        System.out.println(solution.validMountainArray(new int[]{0,3,2,1}));
//        System.out.println(solution.validMountainArray(new int[]{0,1,2,3,4,5,6,7,8,9}));
        System.out.println(solution.validMountainArray(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validMountainArray(int[] arr) {
            int len = arr.length;
            if (len < 3) {
                return false;
            }
            int i = 0;
            while (i < len - 1 && arr[i] < arr[i + 1]) {
                i++;
            }
            int j = len - 1;
            while (j > i && arr[j - 1] > arr[j]) {
                j--;
            }
            return i == j && j != len - 1 && i != 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
