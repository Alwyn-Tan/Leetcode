import java.util.*;

class ListNode {

  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}

class Solution {

  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || k == 1) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pointer = dummy;
    Deque<ListNode> deque = new ArrayDeque<>();
    int count;

    while (true) {
      count = 0;
      ListNode cur = head;
      while (cur != null && count < k) {
        deque.addLast(cur);
        cur = cur.next;
      }
      if (k == count) {
        while (!deque.isEmpty()) {
          pointer.next = deque.pollLast();
          pointer = pointer.next;
        }
      } else {
        break;
      }
      pointer.next = cur;
      head = cur;
    }
    return dummy.next;
  }
}
