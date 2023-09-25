//给你一个数组 target 和一个整数 n。每次迭代，需要从 list = { 1 , 2 , 3 ..., n } 中依次读取一个数字。 
//
// 请使用下述操作来构建目标数组 target ： 
//
// 
// "Push"：从 list 中读取一个新元素， 并将其推入数组中。 
// "Pop"：删除数组中的最后一个元素。 
// 如果目标数组构建完成，就停止读取更多元素。 
// 
//
// 题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。 
//
// 请返回构建目标数组所用的操作序列。如果存在多个可行方案，返回任一即可。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = [1,3], n = 3
//输出：["Push","Push","Pop","Push"]
//解释： 
//读取 1 并自动推入数组 -> [1]
//读取 2 并自动推入数组，然后删除它 -> [1]
//读取 3 并自动推入数组 -> [1,3]
// 
//
// 示例 2： 
//
// 
//输入：target = [1,2,3], n = 3
//输出：["Push","Push","Push"]
// 
//
// 示例 3： 
//
// 
//输入：target = [1,2], n = 4
//输出：["Push","Push"]
//解释：只需要读取前 2 个数字就可以停止。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target.length <= 100 
// 1 <= n <= 100 
// 1 <= target[i] <= n 
// target 严格递增 
// 
//
// Related Topics 栈 数组 模拟 👍 78 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java:用栈操作构建数组
//Time:2022-10-15 16:25:23
class P1441_BuildAnArrayWithStackOperations {
    public static void main(String[] args) {
        Solution solution = new P1441_BuildAnArrayWithStackOperations().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> buildArray(int[] target, int n) {
            int index = 1;
            int i = 0;
            List<String> res = new ArrayList<>();
            while (i < target.length) {
                if (target[i] == index) {
                    res.add("Push");
                    index++;
                    i++;
                } else {
                    while (target[i] != index && index <= n) {
                        res.add("Push");
                        res.add("Pop");
                        index++;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
