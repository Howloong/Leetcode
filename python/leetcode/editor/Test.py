from typing import List


class UnionFind:

    def __init__(self, n: int):
        self.nodes = [0] * n
        # 树的高度
        self.rank = [0] * n
        # 初始化n个节点
        for i in range(n):
            # 第i个节点的父节点为nodes[i]
            # 初始化让每个元素的父节点都为自己本身
            self.nodes[i] = i
            self.rank[i] = 0

    # 查找当前元素所在元素树的根节点（代表元素）
    def find(self, x: int) -> int:
        if x == self.nodes[x]:
            return x
        # 将节点直连到根节点
        self.nodes[x] = self.find(self.nodes[x])
        return self.nodes[x]

    # 合并元素x和y的节点
    def unite(self, x: int, y: int) -> None:
        # 先找到y的根节点，然后找到x的根节点，最后让x的根节点指向y
        x = self.find(x)
        y = self.find(y)
        if x == y:
            return
        # 让高度小的树的根指向高度高的树
        if self.rank[x] < self.rank[y]:
            self.nodes[x] = y
        else:
            self.nodes[y] = x
        # 如果树的高度不同，则不会影响到较高树的高度
        # 否则根据以上逻辑，会让y指向x，x的高度会+1
        if self.rank[x] == self.rank[y]:
            self.rank[x] += 1

    # 判断x和y是统一集合
    def isSame(self, x: int, y: int) -> bool:
        return self.find(x) == self.find(y)


class Solution2:
    def countPairs(self, n: int, edges: List[List[int]]) -> int:
        nodes: List[set[int]] = [set() for _ in range(n)]
        for l in edges:
            nodes[l[0]].add(l[1])
            nodes[l[1]].add(l[0])

        def bfs(i: int):
            queue = [i]
            isVisited: List[bool] = [False] * n
            isVisited[i] = True
            while len(queue):
                cur = queue.pop()
                for node in nodes[cur]:
                    if not isVisited[node]:
                        queue.append(node)
                        nodes[i].add(node)
                        isVisited[node] = True
            return

        for i in range(n):
            bfs(i)

        return sum(n - len(t) - 1 for t in nodes) >> 1
