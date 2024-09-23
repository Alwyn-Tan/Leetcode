class ListNode {

  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}

class Solution {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    return add(l1, l2, 0);
  }

  public ListNode add(ListNode l1, ListNode l2, int carry) {
    if (l1 == null && l2 == null) {
      if (carry == 0) {
        return null;
      } else {
        return new ListNode(carry);
      }
    }
    if (l1 == null) {
      l1 = l2;
      l2 = null;
    }
    int sum = l1.val + (l2 == null ? 0 : l2.val) + carry;
    l1.val = sum % 10;
    carry = sum / 10;
    l1.next = add(l1.next, (l2 == null ? null : l2.next), carry);
    return l1;
  }
}
