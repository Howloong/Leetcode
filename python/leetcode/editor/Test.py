n = 4
m = 5
# 存储了某个节点所对应的边的集合（链表）的头结点
head = [-1] * n
# 存储访问的某一条边所指向的节点
edges = [0] * m
# 由于是使用的链表存储的边，该数组存储的是下一条边
next = [0] * m
# 存储某条边权重是多少
weights = [0] * m
index = 0


def add(_from: int, _to: int, weight: int) -> None:
    global index
    # 第index条边指向了_to
    edges[index] = _to
    # 头插法，第index个边的下一个边指向head所指向的节点
    next[index] = head[_from]
    # 第index个边的权重
    weights[index] = weight
    # 将新插入的边接在head的下一个
    head[_from] = index
    index += 1


def traverse(_from: int):
    # 从_from点开始，e为_from点的第一条边
    e = head[_from]
    while e != -1:
        # 表示存在一条从_from到_to的边
        _to = edges[e]
        weight = weights[e]
        # 找到下一条边的编号
        e = next[e]


add(0, 1, 1)
add(0, 2, 2)
add(1, 2, 3)
pass
