//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.Hashtable;
//import java.util.PriorityQueue;
//
///**
// * Created by sujith.j on 17/04/16.
// */
//public class LRUCache {
//    int capacity = 0;
//    HashMap<Integer, Long> cacheValue = new HashMap<>();
//    Long timeStamp = (long)0;
//    PriorityQueue<CacheTime> recency ;
//
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//        recency = new PriorityQueue<>(capacity, new Comparator<CacheTime>() {
//            @Override
//            public int compare(CacheTime o1, CacheTime o2) {
//                return o1.compareTo(o2);
//            }
//        });
//    }
//
//    public int get(int key) {
//        recency.remove();
//
//
//
//    }
//
//    public void set(int key, int value) {
//        timeStamp++;
//        cacheValue.get(key);
//        CacheTime temp;
//        while (cacheValue.size() >= capacity) {
//            temp = recency.poll();
//            cacheValue.remove(temp.key);
//        }
//        recency.add(new CacheTime(timeStamp,key));
//    }
//
//
//}
//
//class CacheTime implements Comparable<CacheTime>{
//    long timeStamp;
//    int key;
//
//    public CacheTime(long timeStamp, int key) {
//        this.timeStamp = timeStamp;
//        this.key = key;
//    }
//
//    @Override
//    public int compareTo(CacheTime x) {
//        return Long.compare(timeStamp,x.timeStamp);
//    }
//}