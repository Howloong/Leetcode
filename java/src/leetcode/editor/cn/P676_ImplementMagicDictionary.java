//设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单
//词存在于你构建的字典中。 
//
// 实现 MagicDictionary 类： 
//
// 
// MagicDictionary() 初始化对象 
// void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字
//符串互不相同 
// bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得
//所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。 
// 
//
// 
//
// 
// 
// 
// 示例： 
//
// 
//输入
//["MagicDictionary", "buildDict", "search", "search", "search", "search"]
//[[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
//输出
//[null, null, false, true, false, false]
//
//解释
//MagicDictionary magicDictionary = new MagicDictionary();
//magicDictionary.buildDict(["hello", "leetcode"]);
//magicDictionary.search("hello"); // 返回 False
//magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
//magicDictionary.search("hell"); // 返回 False
//magicDictionary.search("leetcoded"); // 返回 False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= dictionary.length <= 100 
// 1 <= dictionary[i].length <= 100 
// dictionary[i] 仅由小写英文字母组成 
// dictionary 中的所有字符串 互不相同 
// 1 <= searchWord.length <= 100 
// searchWord 仅由小写英文字母组成 
// buildDict 仅在 search 之前调用一次 
// 最多调用 100 次 search 
// 
// 
// 
// 
// Related Topics 设计 字典树 哈希表 字符串 👍 125 👎 0

package leetcode.editor.cn.java;

//Java：实现一个魔法字典
class P676_ImplementMagicDictionary {
    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello", "hallo", "leetcode"});
//        System.out.println(magicDictionary.search("hello")) ; // 返回 False
//        System.out.println(magicDictionary.search("hhllo")); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
//        System.out.println(magicDictionary.search("hell")); // 返回 False
//        System.out.println(magicDictionary.search("leetcoded")); // 返回 False
        System.out.println(magicDictionary.search("hello"));
        System.out.println(magicDictionary.search("hhllo"));
        System.out.println(magicDictionary.search("hell"));
        System.out.println(magicDictionary.search("leetcoded"));

    }


}

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
class MagicDictionary {
    public TrieTree trieTree;

    public MagicDictionary() {
        this.trieTree = new TrieTree();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary
        ) {
            TrieTree p = trieTree;
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (p.children[index] == null) {
                    p.children[index] = new TrieTree();
                }
                p = p.children[index];
            }
            p.isEnd = true;
        }
    }

    public boolean search(String searchWord) {
        return backTracking(searchWord, 0, trieTree, false);
    }

    public boolean backTracking(String word, int pos, TrieTree node, boolean modified) {
        if (pos == word.length()) {
            return node.isEnd && modified;
        }
        int index = word.charAt(pos) - 'a';
        if (node.children[index] != null) {
            if (backTracking(word, pos + 1, node.children[index], modified)) {
                return true;
            }
        }
        if (!modified) {
            for (int i = 0; i < 26; i++) {
                if (i != index && node.children[i] != null) {
                    if (backTracking(word, pos + 1, node.children[i], true)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

class TrieTree {
    public TrieTree[] children;
    public boolean isEnd;

    public TrieTree() {
        this.children = new TrieTree[26];
        this.isEnd = false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)