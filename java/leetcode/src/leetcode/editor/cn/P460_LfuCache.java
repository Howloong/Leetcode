//请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。 
//
// 实现 LFUCache 类： 
//
// 
// LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象 
// int get(int key) - 如果键 key 存在于缓存中，则获取键的值，否则返回 -1 。 
// void put(int key, int value) - 如果键 key 已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量 
//capacity 时，则应该在插入新项之前，移除最不经常使用的项。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。 
// 
//
// 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。 
//
// 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
//
// 
//
// 示例： 
//
// 
//输入：
//["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", 
//"get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
//输出：
//[null, null, null, 1, null, -1, 3, null, -1, 3, 4]
//
//解释：
//// cnt(x) = 键 x 的使用计数
//// cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
//LFUCache lfu = new LFUCache(2);
//lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
//lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
//lfu.get(1);      // 返回 1
//                 // cache=[1,2], cnt(2)=1, cnt(1)=2
//lfu.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
//                 // cache=[3,1], cnt(3)=1, cnt(1)=2
//lfu.get(2);      // 返回 -1（未找到）
//lfu.get(3);      // 返回 3
//                 // cache=[3,1], cnt(3)=2, cnt(1)=2
//lfu.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
//                 // cache=[4,3], cnt(4)=1, cnt(3)=2
//lfu.get(1);      // 返回 -1（未找到）
//lfu.get(3);      // 返回 3
//                 // cache=[3,4], cnt(4)=1, cnt(3)=3
//lfu.get(4);      // 返回 4
//                 // cache=[3,4], cnt(4)=2, cnt(3)=3 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 10⁴ 
// 0 <= key <= 10⁵ 
// 0 <= value <= 10⁹ 
// 最多调用 2 * 10⁵ 次 get 和 put 方法 
// 
//
// Related Topics 设计 哈希表 链表 双向链表 👍 721 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

//Java:LFU 缓存
//Time:2023-09-25 12:58:50
class P460_LfuCache {
    public static void main(String[] args) {
        LFUCache lfuCache = new P460_LfuCache().new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3, 3);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
        lfuCache.put(4, 4);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LFUCache {
        private static class Node {
            int key, value, freq = 1; // 新书只读了一次
            Node prev, next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private final int capacity;
        private final Map<Integer, Node> keyToNode = new HashMap<>();
        private final Map<Integer, Node> freqToDummy = new HashMap<>();
        private int minFreq;

        public LFUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = getNode(key);
            return node != null ? node.value : -1;
        }

        public void put(int key, int value) {
            Node node = getNode(key);
            if (node != null) { // 有这本书
                node.value = value; // 更新 value
                return;
            }
            if (keyToNode.size() == capacity) { // 书太多了
                Node dummy = freqToDummy.get(minFreq);
                Node backNode = dummy.prev; // 最左边那摞书的最下面的书
                keyToNode.remove(backNode.key);
                remove(backNode); // 移除
                if (dummy.prev == dummy) { // 这摞书是空的
                    freqToDummy.remove(minFreq); // 移除空链表
                }
            }
            node = new Node(key, value); // 新书
            keyToNode.put(key, node);
            pushFront(1, node); // 放在「看过 1 次」的最上面
            minFreq = 1;
        }

        private Node getNode(int key) {
            if (!keyToNode.containsKey(key)) { // 没有这本书
                return null;
            }
            Node node = keyToNode.get(key); // 有这本书
            remove(node); // 把这本书抽出来
            Node dummy = freqToDummy.get(node.freq);
            if (dummy.prev == dummy) { // 抽出来后，这摞书是空的
                freqToDummy.remove(node.freq); // 移除空链表
                if (minFreq == node.freq) { // 这摞书是最左边的
                    minFreq++;
                }
            }
            pushFront(++node.freq, node); // 放在右边这摞书的最上面
            return node;
        }

        // 创建一个新的双向链表
        private Node newList() {
            Node dummy = new Node(0, 0); // 哨兵节点
            dummy.prev = dummy;
            dummy.next = dummy;
            return dummy;
        }

        // 在链表头添加一个节点（把一本书放在最上面）
        private void pushFront(int freq, Node x) {
            Node dummy = freqToDummy.computeIfAbsent(freq, k -> newList());
            x.prev = dummy;
            x.next = dummy.next;
            x.prev.next = x;
            x.next.prev = x;
        }

        // 删除一个节点（抽出一本书）
        private void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
