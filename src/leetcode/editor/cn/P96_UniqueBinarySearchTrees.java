//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
//
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 1860 👎 0

package leetcode.editor.cn;

//Java:不同的二叉搜索树
//Time:2022-07-25 18:02:13
class P96_UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new P96_UniqueBinarySearchTrees().new Solution();
        int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        Solution.process(arr, 0, 2);
        System.out.println(Solution.max);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public static int max = 0;
        public static void process(int[] arr, int index, int k) {
            if (k == 0 || index == arr.length) {//如果已经将k个0变成1了，或者到达了字符串末尾了
                int tmp = 0;//开始统计计数连续1的个数
                for (int j : arr) {
                    if (j == 1) {
                        tmp++;
                        max = Math.max(max, tmp);
                    } else {//一旦遇到0，之前的计数清零
                        tmp = 0;
                    }
                }
                return;//结束
            }
            //回溯的思想
            for (int j = index; j < arr.length; j++) {
                if (arr[j] == 0) {
                    arr[j] = 1;
                    process(arr, index + 1, k - 1);
                    arr[j] = 0;
                }
            }
        }
    }
}


//leetcode submit region end(Prohibit modification and deletion)


