/*
Implement LRU Cache
*/

import java.util.concurrent.ConcurrentHashMap;

class LRUCacheValue {
    public String key, value;
    public LRUCacheValue next, previous;
    
    LRUCacheValue(String value) {
        this.value = value;
    }
}

public class LRUCache {

    private final int MAX_ENTRIES;
    private ConcurrentHashMap<String, String> dataStore;
    private LRUCacheValue head, tail;

    public LRUCache(int maxEntries) {
        this.MAX_ENTRIES = maxEntries;
        dataStore = new ConcurrentHashMap<String, String>();
    }

//    public void remove(String key) {
//    	LRUCacheValue value = dataStore.remove(key);
//    	if(value == head) {
//    		head = head.next;
//    	}
//
//
//        LRUCacheValue temp = head;
//        head = head.next;
//    }
//
//    //handle LRU
//    public void put(String key, String value) {
//
//    	System.out.println(dataStore.size());
//
//        if(dataStore.size() >= this.MAX_ENTRIES){
//         	remove(head.key);
//        }
//
//        LRUCache cacheValue = new LRUCache(key, value);
//        cacheValue.next = null;
//        if(tail != null) tail.next = cacheValue;
//        else tail = cacheValue;
//
//        if(head == null) head = cacheValue;
//
//        dataStore.put(key, cacheValue);
//    }
//
//    //update LRU
//    public String get(String key) {
//        LRUCache cacheValue = new LRUCache(value);
//        value = dataStore.get(key);
//
//        value.previous.next = value.next;
//        tail.next = value;
//        value.next = null;
//
//        return value.data;
//    }
//
//    public static void main(String args[]) {
//    	LRUCache cache = new LRUCache(5);
//    	cache.put("Key1", "Value1");
//    	cache.put("Key2", "Value2");
//    	cache.put("Key3", "Value3");
//    	cache.put("Key4", "Value4");
//    	cache.put("Key5", "Value5");
//    	cache.put("Key6", "Value6");
//
//    	System.out.println(cache.get("Key1"));
//    }
//
   
}