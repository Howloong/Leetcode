//给你一个整数数组 arr，只有可以将其划分为三个和相等的 非空 部分时才返回 true，否则返回 false。 
//
// 形式上，如果可以找出索引 i + 1 < j 且满足 (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + 
//arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1]) 
//就可以将数组三等分。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [0,2,1,-6,6,-7,9,1,2,0,1]
//输出：true
//解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
// 
//
// 示例 2： 
//
// 
//输入：arr = [0,2,1,-6,6,7,9,-1,2,0,1]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：arr = [3,3,6,5,-2,2,5,1,-9,4]
//输出：true
//解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
// 
//
// 
//
// 提示： 
//
// 
// 3 <= arr.length <= 5 * 10⁴ 
// -10⁴ <= arr[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 👍 175 👎 0

package leetcode.editor.cn.java;

import java.util.Arrays;

//Java：将数组分成和相等的三个部分
class P1013_PartitionArrayIntoThreePartsWithEqualSum {
    public static void main(String[] args) {
        Solution solution = new P1013_PartitionArrayIntoThreePartsWithEqualSum().new Solution();
        System.out.println(solution.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1}));
        System.out.println(solution.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1}));
        System.out.println(solution.canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4}));
//        System.out.println(solution.canThreePartsEqualSum(new int[]{1, -1, 1, -1}));
        System.out.println(solution.canThreePartsEqualSum(new int[]{0, 0, 0, 0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canThreePartsEqualSum(int[] arr) {
            int sum = Arrays.stream(arr).sum();
            if (sum % 3 != 0) {
                return false;
            }
            sum = sum / 3;
            int i = 0;
            int j = arr.length - 1;
            int leftSum = 0;
            int rightSum = 0;
            while (i < arr.length) {
                leftSum += arr[i];
                if (leftSum == sum) {
                    break;
                }
                i++;
            }
            while (j >= 0) {
                rightSum += arr[j];
                if (rightSum == sum) {
                    break;
                }
                j--;
            }
            return j - i > 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
