/**
 * 146. LRU 缓存机制
 * <p>
 * 运用你所掌握的数据结构，设计和实现一个  LRU (least recently used 最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * <p>
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *  
 * <p>
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= capacity <= 3000
 * 0 <= key <= 3000
 * 0 <= value <= 104
 * 最多调用 3 * 104 次 get 和 put
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非业转载请注明出处。
 */

import java.util.HashMap;

/**
 * 实际是实现一种查找快、插入快、删除快的有序链表。哈希表查找快，但是数据无固定顺序；链表有顺序之分，插入删除快，但是查找慢。所以结合一下，形成一种新的数据结构：哈希链表。
 */
public class LRUCache {

    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int cap;

    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>(capacity);
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        cache.remove(node);
        cache.addFirst(node);
        return node.val;
    }

    public void put(int key, int value) {
        //新节点
        Node x = new Node(key, value);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
        }
        cache.addFirst(x);
        map.put(key, x);
        if (cache.getCount() > cap) {
            map.remove(cache.removeLast().key);
        }
    }


    public static void main(String[] args) {

        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        int a = lRUCache.get(1);    // 返回 -1 (未找到)
        int b = lRUCache.get(3);    // 返回 3
        int c = lRUCache.get(4);    // 返回 4
        System.out.println(a + "、" + b + "、" + c);
    }
}

/**
 * 双向链表的节点类
 */
class Node {
    public int key, val;
    public Node next, prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }

    public Node() {
    }
}

/**
 * 基于节点类的双向链表
 */
class DoubleList {
    //不计算在实际链表中
    private Node head;
    //不计算在实际链表中
    private Node tail;
    private int count = 0;

    public DoubleList() {
        head = new Node();
        tail = new Node();
        head.prev = null;
        head.next = tail;
        tail.prev = head;
        tail.next = null;
    }


    //头部添加元素
    public void addFirst(Node x) {
        x.next = head.next;
        x.prev = head;
        head.next.prev = x;
        head.next = x;
        count++;

    }

    //删除链表中的x节点，hash链表查找复杂度为O(1)
    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        count--;
    }

    // 删除最后一个节点并返回该节点
    public Node removeLast() {
        Node x = tail.prev;
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        count--;
        return x;
    }

    public int getCount() {
        return count;
    }


}

