class ListNode {

  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}

class Solution {

  public ListNode detectCycle(ListNode head) {
    ListNode quick = new ListNode(0);
    quick.next = head;
    ListNode slow = new ListNode(0);
    slow.next = head;
    while (true) {
      if (quick == null || quick.next == null) {
        return null;
      }
      if (quick.equals(slow)) {
        break;
      }
      quick = quick.next.next;
      slow = slow.next;
    }
    ListNode n = new ListNode(0);
    n.next = head;
    while (!n.equals(slow)) {
      n = n.next;
      slow = slow.next;
    }
    return n;
  }
}
