package com.geeks.must;

import java.util.*;


/*
 * O(1) for add 
 * O(1) for retrieval 
 * doubly Linked List
 * 
 * inbuilt collection
 * 
 */
class LRUCache {
  int size;
  Deque<Integer> Q = new ArrayDeque<>();
  Map<Integer, Integer> map = new HashMap<>();

  public LRUCache(int size) {
    this.size = size;
  }

}


public class LRU {
  LRUCache cache;

  LRU(LRUCache cache) {
    this.cache = cache;
  }

  public void add(int n) {
    if (cache.size <= cache.Q.size() && !cache.Q.isEmpty()) {
      int z = cache.Q.removeLast();
      cache.map.remove(z, z);
    }
    cache.Q.addFirst(n);
    cache.map.put(n, n);
    printCache();
  }

  public int get(int i) {
    if (cache.map.containsKey(i)) {
      cache.Q.remove(i);
      cache.Q.addFirst(i);
      return cache.map.get(i);
    }
    return -1;
  }


  private void printCache() {
    System.out.println();
    cache.Q.stream().iterator().forEachRemaining(i -> System.out.print(" " + i));
  }

  public static void main(String[] args) {
    LRUCache cache = new LRUCache(3);
    LRU lru = new LRU(cache);
    lru.add(1);
    lru.add(2);
    lru.add(3);
    lru.add(4);
    lru.add(5);

    System.out.println();
    lru.get(3);
    lru.printCache();
    
    System.out.println();
    lru.get(4);
    lru.printCache();
    
    lru.add(11);
    lru.printCache();
  }

}
