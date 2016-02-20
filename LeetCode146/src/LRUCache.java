import java.util.LinkedHashMap;
import java.util.Map;
public class LRUCache {
    LinkedHashMap<Integer, Integer> cache;
    @SuppressWarnings("serial")
    public LRUCache(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>(capacity, .75F, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }
    public int get(int key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else {
            return -1;
        }
    }
    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
            cache.put(key, value);
        } else {
            cache.put(key, value);
        }
    }
}