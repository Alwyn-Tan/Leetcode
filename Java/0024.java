/*Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.) */
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

class Solution {

  public ListNode swapPairs(ListNode head) {
    ListNode dhead = new ListNode();
    dhead.next = head;
    ListNode cur = dhead;
    ListNode temp;
    ListNode x;
    ListNode y;
    while (cur.next != null && cur.next.next != null) {
      x = cur.next;
      y = cur.next.next;
      temp = y.next;
      cur.next = cur.next.next;
      y.next = x;
      x.next = temp;
      cur = x;
    }
    return dhead.next;
  }
}
