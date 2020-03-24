package com.geeks.must;

import java.util.HashMap;

class CNode {
  CNode next, prev;
  int data;

  CNode(int data) {
    this.data = data;
  }
}


public class Cache {

  int cacheSize = 3;
  CNode head;
  CNode tail;
  HashMap<Integer, CNode> map = new HashMap<>();

  public void add(int n) {
    CNode node = new CNode(n);
    if (head == null) {
      head = node;
      tail = node;
    } else {
      addFirst(n);
      if (map.size() >= cacheSize) {
        removeLast();
      }
    }
    printDLL();
  }

  public int get(int i) {
    if (map.containsKey(i)) {
      remove(map.get(i));
      addFirst(i);
    }
    return -1;
  }

  public void removeLast() {
    CNode node = tail.prev;
    node.next = null;
    tail.prev = null;
    tail = node;
  }

  public void remove(CNode node) {
    if (node.data == tail.data) {
      tail = tail.prev;
    }
    if (node.data != head.data) {
      node.prev.next = node.next;
      if (node.next != null)
        node.next.prev = node.prev;
    } 
  }

  public void addFirst(int n) {
    CNode node = new CNode(n);
    map.put(n, node);
    head.prev = node;
    node.next = head;
    head = node;
  }

  public void printDLL() {
    System.out.println();
    CNode temp = head;
    while (temp != null) {
      System.out.print(" " + temp.data);
      temp = temp.next;
    }
  }

  public static void main(String[] args) {
    Cache cache = new Cache();
    cache.add(1);
    cache.add(2);
    cache.add(3);
    cache.add(4);
    cache.add(5);

    System.out.println();
    cache.get(3);
    cache.printDLL();

    System.out.println();
    cache.get(4);
    cache.printDLL();

    cache.add(7);
  }
}
