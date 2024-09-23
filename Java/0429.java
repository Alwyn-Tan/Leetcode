import java.util.*;

class Node {

  public int val;
  public List<Node> children;

  public Node() {}

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, List<Node> _children) {
    val = _val;
    children = _children;
  }
}

class Solution {

  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (root == null) {
      return res;
    }
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> levelList = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        Node tempNode = queue.poll();
        levelList.add(tempNode.val);
        if (tempNode.children != null) {
          for (Node child : tempNode.children) {
            queue.add(child);
          }
        }
      }
      res.add(levelList);
    }
    return res;
  }
}
