class MinStack {

    private class Node {
        int val;
        int min;
        Node next;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    private Node head;

    public MinStack() {
        head = null;
    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val);
        } else {
            Node tmp = head;
            head = new Node(val, Math.min(val, head.min));
            head.next = tmp;
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */