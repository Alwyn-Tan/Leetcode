class ListNode {

  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}

class Solution {

  public ListNode sortList(ListNode head) {
    ListNode dum = new ListNode(0);
    dum.next = head;
    ListNode fast = dum;
    ListNode slow = dum;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    ListNode rightHead = slow.next;
    slow.next = null;
    return merge(head, rightHead);
  }

  public ListNode merge(ListNode left, ListNode right) {
    if (left == null) {
      return right;
    }
    if (right == null) {
      return left;
    }
    if (left.val < right.val) {
      left.next = merge(left.next, right);
      return left;
    } else {
      right.next = merge(left, right.next);
      return right;
    }
  }
}
