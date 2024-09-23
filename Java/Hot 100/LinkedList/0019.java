class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummmy = new ListNode(0);
        dummmy.next = head;
        ListNode pre = dummmy;
        ListNode cur = dummmy;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        while (cur.next != null) {
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummmy.next;
    }
}