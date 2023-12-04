# leetcode submit region begin(Prohibit modification and deletion)
import heapq

from sortedcontainers import SortedSet


class SmallestInfiniteSet:

    def __init__(self):
        self.s = SortedSet()
        self.idx = 1

    def popSmallest(self) -> int:
        if self.s:
            return self.s.pop(0)
        t = self.idx
        self.idx += 1
        return t

    def addBack(self, num: int) -> None:
        if num < self.idx:
            self.s.add(num)


# Your SmallestInfiniteSet object will be instantiated and called as such:
# obj = SmallestInfiniteSet()
# param_1 = obj.popSmallest()
# obj.addBack(num)
# leetcode submit region end(Prohibit modification and deletion)
s = SmallestInfiniteSet()
s.addBack(2)
print(s.popSmallest())
print(s.popSmallest())
print(s.popSmallest())
print(s.addBack(1))
print(s.popSmallest())
print(s.popSmallest())
print(s.popSmallest())
