/*Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head. */

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

  public ListNode removeElements(ListNode head, int val) {
    ListNode h = new ListNode();
    h.next = head;
    ListNode p = h;
    while (p.next != null) {
      if (p.next.val == val) {
        p.next = p.next.next;
      } else {
        p = p.next;
      }
    }
    return h.next;
  }
}
