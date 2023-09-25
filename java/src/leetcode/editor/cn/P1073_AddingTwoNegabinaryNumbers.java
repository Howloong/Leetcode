//给出基数为 -2 的两个数 arr1 和 arr2，返回两数相加的结果。 
//
// 数字以 数组形式 给出：数组由若干 0 和 1 组成，按最高有效位到最低有效位的顺序排列。例如，arr = [1,1,0,1] 表示数字 (-2)^3 +
// (-2)^2 + (-2)^0 = -3。数组形式 中的数字 arr 也同样不含前导零：即 arr == [0] 或 arr[0] == 1。 
//
// 返回相同表示形式的 arr1 和 arr2 相加的结果。两数的表示形式为：不含前导零、由若干 0 和 1 组成的数组。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr1 = [1,1,1,1,1], arr2 = [1,0,1]
//输出：[1,0,0,0,0]
//解释：arr1 表示 11，arr2 表示 5，输出表示 16 。
// 
//
// 
// 
//
// 示例 2： 
//
// 
//输入：arr1 = [0], arr2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：arr1 = [0], arr2 = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
// 
//
// 
// 1 <= arr1.length, arr2.length <= 1000 
// arr1[i] 和 arr2[i] 都是 0 或 1 
// arr1 和 arr2 都没有前导0 
// 
//
// Related Topics 数组 数学 👍 82 👎 0

package leetcode.editor.cn.java;

import java.util.Arrays;

//Java:负二进制数相加
//Time:2023-05-18 11:37:55
class P1073_AddingTwoNegabinaryNumbers {
    public static void main(String[] args) {
        Solution solution = new P1073_AddingTwoNegabinaryNumbers().new Solution();
        System.out.println(Arrays.toString(solution.addNegabinary(new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 1})));
        System.out.println(Arrays.toString(solution.addNegabinary(new int[]{0}, new int[]{0})));
        System.out.println(Arrays.toString(solution.addNegabinary(new int[]{0}, new int[]{1})));
        System.out.println(Arrays.toString(solution.addNegabinary(new int[]{1, 0, 1}, new int[]{1})));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] addNegabinary(int[] arr1, int[] arr2) {
            int len1 = arr1.length;
            int len2 = arr2.length;
            if (len1 < len2) {
                return addNegabinary(arr2, arr1);
            }
            int[] res = new int[len1];
            int[] temp = new int[len1];
            System.arraycopy(arr2, 0, temp, len1 - len2, len2);
            int carry = 0;
            int i, j;
            for (i = len1 - 1; i >= 0; i--) {
                res[i] = arr1[i] + temp[i] + carry;
                if (res[i] == -1) {
                    res[i] = 1;
                    carry = 1;
                } else {
                    carry = res[i] >= 2 ? -1 : 0;
                    res[i] = res[i] % 2;
                }
            }
            if (carry == -1) {
                int[] n = new int[len1 + 2];
                System.arraycopy(res, 0, n, 2, len1);
                n[0] = 1;
                n[1] = 1;
                return n;
            }
            i = 0;
            while (i != len1 - 1 && res[i] == 0) {
                i++;
            }
            return Arrays.copyOfRange(res, i, len1);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
