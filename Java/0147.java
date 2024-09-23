class Solution {

  public ListNode insertionSortList(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode last = head;
    ListNode cur = head.next;
    while (cur != null) {
      if (last.val > cur.val) {
        ListNode pre = dummy;
        while (pre.next.val <= cur.val) {
          pre = pre.next;
        }
        last.next = cur.next;
        cur.next = pre.next;
        pre.next = cur;
      } else {
        last = last.next;
      }
      cur = last.next;
    }
    return dummy.next;
  }
}
