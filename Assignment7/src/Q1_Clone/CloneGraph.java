package Q1_Clone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
//-------------------------Main Start---------------------
    Map<Integer,Node> nodes = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (nodes.containsKey(node.val)) return nodes.get(node.val);
        Node cloneNode = new Node(node.val);
        nodes.put(cloneNode.val,cloneNode);
        List<Node> list = cloneNode.neighbors;
        for (Node helper : node.neighbors) list.add(cloneGraph(helper));
        return cloneNode;
    }
//-------------------------Main End---------------------
}
