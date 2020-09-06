package array;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 基于LinkedHashMap实现LRU缓存
 * 靠近尾节点的是最近访问的节点
 * 靠近头节点的是最久访问的节点
 * Created by xsg on 2019/5/6.
 */
public class LRUBaseLinkedHashMap<K, V> {

    private LinkedHashMap<K, V> container;

    public LRUBaseLinkedHashMap(int capacity) {
        this.container = new LinkedHashMap<K, V>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return this.size() > capacity;
            }
        };
    }

    /**
     * 添加数据到缓存中
     * @param key key
     * @param value value
     */
    public void add(K key, V value) {
        this.container.put(key, value);
    }

    /**
     * 缓存缓存中的数据
     * @param key key
     * @return key对应的value
     */
    public V get(K key) {
        return this.container.get(key);
    }
}