from typing import List, Optional


# leetcode submit region begin(Prohibit modification and deletion)
class Node:
    def __init__(self):
        self.children: List[Optional[Node]] = [None] * 26
        self.isEnd = False


class Trie:

    def __init__(self):
        self.root = Node()

    def insert(self, word: str) -> None:
        node = self.root
        for ch in word:
            ch = ord(ch) - ord('a')
            if not node.children[ch]:
                node.children[ch] = Node()
            node = node.children[ch]
        node.isEnd = True

    def searchPrefix(self, prefix: str) -> Optional[Node]:
        node = self.root
        for ch in prefix:
            ch = ord(ch) - ord('a')
            if not node.children[ch]:
                return None
            node = node.children[ch]
        return node

    def search(self, word: str) -> bool:
        node = self.searchPrefix(word)
        return node is not None and node.isEnd

    def startsWith(self, prefix: str) -> bool:
        return self.searchPrefix(prefix) is not None

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
# leetcode submit region end(Prohibit modification and deletion)
