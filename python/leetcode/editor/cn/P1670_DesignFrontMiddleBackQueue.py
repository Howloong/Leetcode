# leetcode submit region begin(Prohibit modification and deletion)
class FrontMiddleBackQueue:

    def __init__(self):
        self.queue = []

    def pushFront(self, val: int) -> None:
        self.queue.append(val)

    def pushMiddle(self, val: int) -> None:
        self.queue.insert((len(self.queue)+1) // 2, val)

    def pushBack(self, val: int) -> None:
        self.queue.insert(0, val)

    def popFront(self) -> int:
        if not self.queue:
            return -1
        return self.queue.pop()

    def popMiddle(self) -> int:
        if not self.queue:
            return -1
        return self.queue.pop((len(self.queue)) // 2)

    def popBack(self) -> int:
        if not self.queue:
            return -1
        return self.queue.pop(0)


# Your FrontMiddleBackQueue object will be instantiated and called as such:
# obj = FrontMiddleBackQueue()
# obj.pushFront(val)
# obj.pushMiddle(val)
# obj.pushBack(val)
# param_4 = obj.popFront()
# param_5 = obj.popMiddle()
# param_6 = obj.popBack()
# leetcode submit region end(Prohibit modification and deletion)
t = FrontMiddleBackQueue()
t.pushFront(1)
t.pushBack(2)
t.pushMiddle(3)
t.pushMiddle(4)
t.popFront()
t.popMiddle()
t.popMiddle()
t.popBack()
t.popFront()
print(t.queue)
