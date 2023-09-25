//有时候人们会用重复写一些字母来表示额外的感受，比如 "hello" -> "heeellooo", "hi" -> "hiii"。我们将相邻字母都相同的一串
//字符定义为相同字母组，例如："h", "eee", "ll", "ooo"。 
//
// 对于一个给定的字符串 S ，如果另一个单词能够通过将一些字母组扩张从而使其和 S 相同，我们将这个单词定义为可扩张的（stretchy）。扩张操作定义如下
//：选择一个字母组（包含字母 c ），然后往其中添加相同的字母 c 使其长度达到 3 或以上。 
//
// 例如，以 "hello" 为例，我们可以对字母组 "o" 扩张得到 "hellooo"，但是无法以同样的方法得到 "helloo" 因为字母组 "oo" 
//长度小于 3。此外，我们可以进行另一种扩张 "ll" -> "lllll" 以获得 "helllllooo"。如果 s = "helllllooo"，那么查询词
// "hello" 是可扩张的，因为可以对它执行这两种扩张操作使得 query = "hello" -> "hellooo" -> "helllllooo" = 
//s。 
//
// 输入一组查询单词，输出其中可扩张的单词数量。 
//
// 
//
// 示例： 
//
// 
//输入： 
//s = "heeellooo"
//words = ["hello", "hi", "helo"]
//输出：1
//解释：
//我们能通过扩张 "hello" 的 "e" 和 "o" 来得到 "heeellooo"。
//我们不能通过扩张 "helo" 来得到 "heeellooo" 因为 "ll" 的长度小于 3 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, words.length <= 100 
// 1 <= words[i].length <= 100 
// s 和所有在 words 中的单词都只由小写字母组成。 
// 
//
// Related Topics 数组 双指针 字符串 👍 84 👎 0

package leetcode.editor.cn.java;

import java.util.ArrayList;
import java.util.List;

//Java:情感丰富的文字
//Time:2022-11-25 12:42:15
class P809_ExpressiveWords {
    public static void main(String[] args) {
        Solution solution = new P809_ExpressiveWords().new Solution();
//        solution.expressiveWords("heeellooo", new String[]{""});
//        System.out.println(solution.expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
        System.out.println(solution.expressiveWords("heeellooo", new String[]{"heeelloooworld"}));
//        System.out.println(solution.expressiveWords("zzzzzyyyyy", new String[]{"zzyy", "zy", "zyy"}));
//        System.out.println(solution.expressiveWords("abcd", new String[]{"abc"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int expressiveWords(String s, String[] words) {
            List<Integer> wordList = new ArrayList<>();
            int i = 0;
            int j = 0;
            int index = 0;
            int count = 0;
            int res = words.length;
            while (j < s.length()) {
                if (s.charAt(i) == s.charAt(j)) {
                    count++;
                    j++;
                } else {
                    wordList.add(index++, count);
                    count = 0;
                    i = j;
                }
            }
            wordList.add(index, count);
            index = 0;
            Outer:
            for (String word : words) {
                if (word.length() > s.length()) {
                    res--;
                    continue;
                }
                i = 0;
                j = 0;
                int sum = 0;
                count = 0;
                index = 0;
                while (j < word.length()) {
                    if (word.charAt(i) == word.charAt(j)) {
                        count++;
                        j++;
                    } else {
                        int letterCount = wordList.get(index);
//                        字母不相同，不符合
                        if (word.charAt(i) != s.charAt(sum) ||
                                count > letterCount ||
                                (letterCount == 2 && count != letterCount)) {
                            res--;
                            continue Outer;

                        }
                        sum += letterCount;

//                        word的字母数大于s，不符合
//                        s的字母数为2，word若大于2则在上面break；否则不能扩张
                        index++;
                        i = j;
                        count = 0;
                    }
                }
                count = j - i;
                int letterCount = wordList.get(index);
                if (word.charAt(i) != s.charAt(sum) ||
                        count > letterCount ||
                        (letterCount == 2 && count != letterCount) || index != wordList.size() - 1) {
                    res--;
                }

            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}


