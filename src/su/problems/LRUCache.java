package su.problems;

import java.util.Deque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentMap;

/**
 * Created with IntelliJ IDEA.
 * User: Akshat
 * Date: 12/25/12
 * Time: 11:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class LRUCache<K,V> {

    private final ConcurrentMap<K,V> map = new ConcurrentHashMap<K,V>();
    private Deque<K> deque = new ConcurrentLinkedDeque<>();


    private int PAGE_SIZE = 0;

    public LRUCache(int PAGE_SIZE){
        this.PAGE_SIZE = PAGE_SIZE;
    }

    public V get(K key)
    {
        deque.remove(key);
        deque.push(key);

        return map.get(key);
    }

    public void put(K key, V value)
    {
        if(map.size()==PAGE_SIZE)
        {
            K removedKey = deque.removeLast();
            map.remove(removedKey);
        }

        map.put(key, value);
        deque.push(key);
    }

}
