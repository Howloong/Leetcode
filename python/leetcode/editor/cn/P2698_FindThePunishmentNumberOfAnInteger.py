# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def punishmentNumber(self, n: int) -> int:

        def func(num: int, num_sqrt: str, index: int, _sum: int):
            nonlocal isValid
            if index == len(num_sqrt):
                isValid = _sum == num
                return
            for i in range(index, len(num_sqrt)):
                t = int(num_sqrt[index:i + 1])
                if _sum + t > int(num_sqrt):
                    break
                if not isValid:
                    func(num, num_sqrt, i + 1, _sum + t)

        res = 0
        for i in range(1, n + 1):
            isValid = False
            func(i, str(i * i), 0, 0)
            if isValid:
                res += i * i
        return res


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().punishmentNumber(37))
