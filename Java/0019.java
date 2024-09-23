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

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dhead = new ListNode();
    dhead.next = head;
    ListNode fast = dhead;
    ListNode slow = dhead;
    for (int i = 0; i < n + 1; i++) {
      fast = fast.next;
    }
    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
    return dhead.next;
  }
}
