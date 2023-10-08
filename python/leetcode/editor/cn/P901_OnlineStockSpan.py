# leetcode submit region begin(Prohibit modification and deletion)
from math import inf


class StockSpanner:
    def __init__(self):
        self.stack = [(-1, inf)]
        self.idx = -1

    def next(self, price: int) -> int:
        self.idx += 1
        while price >= self.stack[-1][1]:
            self.stack.pop()
        self.stack.append((self.idx, price))
        return self.idx-self.stack[-2][0]



# Your StockSpanner object will be instantiated and called as such:
# obj = StockSpanner()
# param_1 = obj.next(price)
# leetcode submit region end(Prohibit modification and deletion)
s = StockSpanner()
print(s.next(100))
print(s.next(80))
print(s.next(60))
print(s.next(70))
print(s.next(60))
print(s.next(75))
print(s.next(85))
