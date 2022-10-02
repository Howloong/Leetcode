//在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。一次移动操作指用一个"LX"替换一个"XL"，或
//者用一个"XR"替换一个"RX"。现给定起始字符串start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换成end时， 返回
//True。 
//
// 
//
// 示例 : 
//
// 输入: start = "RXXLRXRXL", end = "XRLXXRRLX"
//输出: True
//解释:
//我们可以通过以下几步将start转换成end:
//RXXLRXRXL ->
//XRXLRXRXL ->
//XRLXRXRXL ->
//XRLXXRRXL ->
//XRLXXRRLX
// 
//
// 
//
// 提示： 
//
// 
// 1 <= len(start) = len(end) <= 10000。 
// start和end中的字符串仅限于'L', 'R'和'X'。 
// 
//
// Related Topics 双指针 字符串 👍 182 👎 0

package leetcode.editor.cn;

//Java:在LR字符串中交换相邻字符
//Time:2022-10-02 12:22:13
class P777_SwapAdjacentInLrString {
    public static void main(String[] args) {
        Solution solution = new P777_SwapAdjacentInLrString().new Solution();
        System.out.println(solution.canTransform("RXXLRXRXL", "XRLXXRRLX"));
        System.out.println(solution.canTransform("X", "L"));
        System.out.println(solution.canTransform("XXXXXLXXXX", "LXXXXXXXXX"));
        System.out.println(solution.canTransform("RLX", "XLR"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canTransform(String start, String end) {
            int i = 0;
            int j = 0;
            char[] startChar = start.toCharArray();
            char[] endChar = end.toCharArray();
            int len = start.length();
            while (i < len || j < len) {
                while (i < len && startChar[i] == 'X') {
                    i++;
                }
                while (j < len && endChar[j] == 'X') {
                    j++;
                }
                if (i == len || j == len) {
                   break;
                }
                if (startChar[i] != endChar[j]) {
                    return false;
                }
                if (startChar[i] == 'L' && i < j || startChar[i] == 'R' && i > j) {
                    return false;
                }
                i++;
                j++;
            }
            if (i == len) {
                while (j < len) {
                    if (endChar[j] != 'X') {
                        return false;
                    }
                    j++;
                }
            }
            if (j == len) {
                while (i < len) {
                    if (startChar[i] != 'X') {
                        return false;
                    }
                    i++;
                }
            }
            return true;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
