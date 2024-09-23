import java.util.*;

class LRUCache {

  private static class Node {

    int key;
    int value;

    Node prev;
    Node next;

    Node(int k, int v) {
      key = k;
      value = v;
    }
  }

  private final int capacity;
  private final Node dum = new Node(0, 0);
  private final Map<Integer, Node> map = new HashMap<>();

  public LRUCache(int capacity) {
    this.capacity = capacity;
    dum.prev = dum;
    dum.next = dum;
  }

  public int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    } else {
      Node node = map.get(key);
      remove(node);
      insert(node);
      return node.value;
    }
  }

  public void remove(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  public void insert(Node node) {
    node.prev = dum;
    node.next = dum.next;
    dum.next = node;
    node.next.prev = node;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      node.value = value;
      return;
    } else {
      Node newNode = new Node(key, value);
      map.put(key, newNode);
      insert(newNode);
      if (map.size() > capacity) {
        Node tail = dum.prev;
        map.remove(tail.key);
        remove(tail);
      }
    }
  }
}
