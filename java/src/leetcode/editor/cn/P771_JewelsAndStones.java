//给你一个字符串 jewels 代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。 stones 中每个字符代表了一种你拥有的石头的类型，
//你想知道你拥有的石头中有多少是宝石。 
//
// 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。 
//
// 
//
// 示例 1： 
//
// 
//输入：jewels = "aA", stones = "aAAbbbb"
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：jewels = "z", stones = "ZZ"
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= jewels.length, stones.length <= 50 
// jewels 和 stones 仅由英文字母组成 
// jewels 中的所有字符都是 唯一的 
// 
//
// Related Topics 哈希表 字符串 👍 750 👎 0

package leetcode.editor.cn.java;

import java.util.HashSet;
import java.util.Set;

//Java:宝石与石头
//Time:2023-07-24 08:54:34
class P771_JewelsAndStones {
    public static void main(String[] args) {
        Solution solution = new P771_JewelsAndStones().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numJewelsInStones(String jewels, String stones) {
            Set<Character> jewel = new HashSet<>();
            for (Character character : jewels.toCharArray()) {
                jewel.add(character);
            }
            int sum = 0;
            for (Character stone : stones.toCharArray()) {
                if (jewel.contains(stone)) {
                    sum++;
                }
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
