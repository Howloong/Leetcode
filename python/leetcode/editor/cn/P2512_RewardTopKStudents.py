import heapq
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def topStudents(self, positive_feedback: List[str], negative_feedback: List[str], report: List[str],
                    student_id: List[int], k: int) -> List[int]:
        feedback = {}
        for w in positive_feedback:
            feedback[w] = 3
        for w in negative_feedback:
            feedback[w] = -1
        h = []
        for s, i in zip(report, student_id):
            score = sum(feedback.get(w, 0) for w in s.split(" "))
            h.append([-score, i])
        heapq.heapify(h)
        return [t for _, t in heapq.nsmallest(k, h)]


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().topStudents(["smart", "brilliant", "studious"],
                             ["not"],
                             ["this student is studious", "the student is smart"],
                             [1, 2], 2))
