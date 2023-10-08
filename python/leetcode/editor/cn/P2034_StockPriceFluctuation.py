# leetcode submit region begin(Prohibit modification and deletion)
from heapq import heappush, heappop


class StockPrice:
    def __init__(self):
        self.timePriceMap = {}
        self.pqMax = []
        self.pqMin = []
        self.maxTimeStamp = 0

    def update(self, timestamp: int, price: int) -> None:
        self.maxTimeStamp = max(self.maxTimeStamp, timestamp)
        heappush(self.pqMax, (-price, timestamp))
        heappush(self.pqMin, (price, timestamp))
        self.timePriceMap[timestamp] = price

    def current(self) -> int:
        return self.timePriceMap[self.maxTimeStamp]

    def maximum(self) -> int:
        while True:
            price, timestamp = self.pqMax[-1]
            if self.timePriceMap[timestamp] == -price:
                return -price
            heappop(self.pqMax)

    def minimum(self) -> int:
        while True:
            price, timestamp = self.pqMin[-1]
            if self.timePriceMap[timestamp] == price:
                return price
            heappop(self.pqMin)



# Your StockPrice object will be instantiated and called as such:
# obj = StockPrice()
# obj.update(timestamp,price)
# param_2 = obj.current()
# param_3 = obj.maximum()
# param_4 = obj.minimum()
# leetcode submit region end(Prohibit modification and deletion)
