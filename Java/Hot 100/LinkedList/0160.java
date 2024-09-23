import java.util.Set;

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
        Set<ListNode> set = new HashSet<>();
        while (headA != null || headB != null) {
            if (headA != null) {
                if (!set.contains(headA)) {
                    set.add(headA);
                } else {
                    return headA;
                }
                headA = headA.next;
            }
            if (headB != null) {
                if (!set.contains(headB)) {
                    set.add(headB);
                } else {
                    return headB;
                }
                headB = headB.next;
            }
        }
        return null;
    }
}