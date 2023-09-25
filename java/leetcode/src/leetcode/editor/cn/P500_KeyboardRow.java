//给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。 
//
// 美式键盘 中： 
//
// 
// 第一行由字符 "qwertyuiop" 组成。 
// 第二行由字符 "asdfghjkl" 组成。 
// 第三行由字符 "zxcvbnm" 组成。 
// 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["Hello","Alaska","Dad","Peace"]
//输出：["Alaska","Dad"]
// 
//
// 示例 2： 
//
// 
//输入：words = ["omk"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：words = ["adsdf","sfd"]
//输出：["adsdf","sfd"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 20 
// 1 <= words[i].length <= 100 
// words[i] 由英文字母（小写和大写字母）组成 
// 
//
// Related Topics 数组 哈希表 字符串 👍 217 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//Java:键盘行
//Time:2022-09-10 22:25:45
class P500_KeyboardRow {
    public static void main(String[] args) {
        Solution solution = new P500_KeyboardRow().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findWords(String[] words) {
            List<String> res = new ArrayList<>();
            HashSet<Character> hashSet1 = new HashSet<>();
            char[] c = new char[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
            for (char c1 : c) {
                hashSet1.add(c1);
            }
            HashSet<Character> hashSet2 = new HashSet<>();
            c = new char[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
            for (char c1 : c) {
                hashSet2.add(c1);
            }
            HashSet<Character> hashSet3 = new HashSet<>();
            c = new char[]{'z', 'x', 'c', 'v', 'b', 'n', 'm'};
            for (char c1 : c) {
                hashSet3.add(c1);
            }
            for (String word : words) {
                String temp = word;
                word = word.toLowerCase();
                char c1 = word.charAt(0);
                boolean isContain = true;
                if (hashSet1.contains(c1)) {
                    for (int i = 1; i < word.length(); i++) {
                        if (!hashSet1.contains(word.charAt(i))) {
                            isContain = false;
                            break;
                        }
                    }
                } else if (hashSet2.contains(c1)) {
                    for (int i = 1; i < word.length(); i++) {
                        if (!hashSet2.contains(word.charAt(i))) {
                            isContain = false;
                            break;
                        }
                    }
                } else {
                    for (int i = 1; i < word.length(); i++) {
                        if (!hashSet3.contains(word.charAt(i))) {
                            isContain = false;
                            break;
                        }
                    }
                }
                if (isContain) {
                    res.add(temp);
                }
            }
            String[] strings = new String[res.size()];
            return res.toArray(strings);
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}
