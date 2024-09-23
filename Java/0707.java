/*
 * Design your implementation of the linked list. You can choose to use a singly or doubly linked
 * list. A node in a singly linked list should have two attributes: val and next. val is the value
 * of the current node, and next is a pointer/reference to the next node. If you want to use the
 * doubly linked list, you will need one more attribute prev to indicate the previous node in the
 * linked list. Assume all nodes in the linked list are 0-indexed.
 */
class ListNode {

  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

class MyLinkedList {

  int size;
  ListNode head;

  public MyLinkedList() {
    size = 0;
    head = new ListNode();
  }

  public int get(int index) {
    if (index < 0 || index >= size) {
      return -1;
    }
    ListNode p = head;
    for (int i = 0; i <= index; i++) {
      p = p.next;
    }
    return p.val;
  }

  public void addAtHead(int val) {
    addAtIndex(0, val);
  }

  public void addAtTail(int val) {
    addAtIndex(size, val);
  }

  public void addAtIndex(int index, int val) {
    if (index > size) {
      return;
    } else if (index < 0) {
      index = 0;
    }
    ListNode p = head;
    for (int i = 0; i < index; i++) {
      p = p.next;
    }
    ListNode new_node = new ListNode(val);
    new_node.next = p.next;
    p.next = new_node;
    size++;
  }

  public void deleteAtIndex(int index) {
    if (index < 0 || index >= size) {
      return;
    }
    ListNode p = head;
    for (int i = 0; i < index; i++) {
      p = p.next;
    }
    p.next = p.next.next;
    size--;
  }
}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
