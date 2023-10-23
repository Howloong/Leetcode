# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def categorizeBox(self, length: int, width: int, height: int, mass: int) -> str:
        def isBulky():
            t = 10 ** 4
            return length >= t or width >= t or height >= t or length * width * height >= 10 ** 9

        def isHeavy():
            return mass >= 100

        if isBulky() and isHeavy():
            return "Both"
        if not isBulky() and not isHeavy():
            return "Neither"
        if isBulky():
            return "Bulky"
        return "Heavy"
# leetcode submit region end(Prohibit modification and deletion)
