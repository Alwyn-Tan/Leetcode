class ListNode {

  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}

class Solution {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int A = 0;
    int B = 0;
    ListNode pA = headA;
    ListNode pB = headB;
    while (pA != null) {
      A++;
      pA = pA.next;
    }
    while (pB != null) {
      B++;
      pB = pB.next;
    }
    pA = headA;
    pB = headB;
    int d = Math.abs(A - B);
    if (A > B) {
      while (d > 0) {
        pA = pA.next;
        d--;
      }
      while (pA != null) {
        if (pA == pB) {
          return pA;
        }
        pA = pA.next;
        pB = pB.next;
      }
    } else {
      while (d > 0) {
        pB = pB.next;
        d--;
      }
      while (pB != null) {
        if (pA == pB) {
          return pA;
        }
        pA = pA.next;
        pB = pB.next;
      }
    }
    return null;
  }
}
