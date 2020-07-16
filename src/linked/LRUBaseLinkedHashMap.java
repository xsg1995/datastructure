package linked;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by xsg on 2020/2/5.
 */
public class LRUBaseLinkedHashMap {

    private final Object obj = new Object();
    private LinkedHashMap<String, Object> linkedHashMap;
    private int capacity;

    public LRUBaseLinkedHashMap(int capacity) {
        this.linkedHashMap = new LinkedHashMap(capacity, 0.75F,true);
        this.capacity = capacity;
    }

    public void add(String str) {
        Object o = this.linkedHashMap.get(str);
        if(o == null) {
            int size = this.linkedHashMap.size();
            if(size == this.capacity) {
                //空间满了，删除第一个元素
                String firstKey = getFirst();
                this.linkedHashMap.remove(firstKey);
                this.linkedHashMap.put(str, obj);
            } else {
                //空间没满
                this.linkedHashMap.put(str, obj);
            }
        } else {
            //移到链表最后
        }
    }

    /**
     * 获取第一个节点的值
     * @return
     */
    public String getFirst() {
        Map.Entry<String, Object> firstEntry = this.linkedHashMap.entrySet().iterator().next();
        String firstKey = firstEntry.getKey();
        return firstKey;
    }

    public void print() {
        this.linkedHashMap.forEach((k, v) -> {
            System.out.println(k);
        });
    }

    public static void main(String[] args) {
        LRUBaseLinkedHashMap lru = new LRUBaseLinkedHashMap(3);

        lru.add("a");
        lru.add("b");
        lru.add("c");
        lru.print();

        System.out.println("--------------------------");
        lru.add("a");
        lru.print();

        System.out.println("--------------------------");
        lru.add("e");
        lru.print();
        
    }
}
