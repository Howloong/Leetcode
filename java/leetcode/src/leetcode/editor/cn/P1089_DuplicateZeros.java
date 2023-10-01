//给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。 
//
// 注意：请不要在超过该数组长度的位置写入元素。 
//
// 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。 
//
// 
//
// 示例 1： 
//
// 输入：[1,0,2,3,0,4,5,0]
//输出：null
//解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
// 
//
// 示例 2： 
//
// 输入：[1,2,3]
//输出：null
//解释：调用函数后，输入的数组将被修改为：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10000 
// 0 <= arr[i] <= 9 
// 
// Related Topics 数组 双指针 👍 184 👎 0

package leetcode.editor.cn;

//Java：复写零
class P1089_DuplicateZeros {
    public static void main(String[] args) {
        Solution solution = new P1089_DuplicateZeros().new Solution();
//        solution.duplicateZeros(new int[]{1, 0, 2, 3, 0, 4, 5, 0});
        solution.duplicateZeros(new int[]{0, 1, 0});
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void duplicateZeros(int[] arr) {
            int i = 0;
            while (i < arr.length - 1) {
                if (arr[i] == 0) {
                    if (arr.length - 1 - (i + 1) >= 0)
                        System.arraycopy(arr, i + 1, arr, i + 2, arr.length - 1 - (i + 1));
                    arr[i + 1] = 0;
                    i += 2;
                } else {
                    ++i;
                }
            }
            System.out.println("1");
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
