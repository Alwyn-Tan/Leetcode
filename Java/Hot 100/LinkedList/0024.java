class ListNode {

  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}

class Solution {

  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = head;
    ListNode cur = head.next;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = pre;
      pre.next = next;
      if (next != null && next.next != null) {
        pre.next = next.next;
        pre = next;
        cur = next.next;
      } else {
        break;
      }
    }
    return head;
  }
}
