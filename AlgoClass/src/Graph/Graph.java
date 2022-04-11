//package Graph;
//
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Locale;
//import java.util.Queue;
//
//public class Graph {
//    public HashMap<String, Node> nodes;
//    public Graph() {
//        nodes = new HashMap<>();
//    }
//    public void addNode(String nodeName) {
//        if(nodes.containsKey(nodeName.toLowerCase())) return;
//        Node node = new Node(nodeName.toLowerCase());
//        nodes.put(nodeName.toLowerCase(), node);
//    }
//    public void addEdge (String node1, String node2) {
//        from = from.toLowerCase();
//        to = to.toLowerCase();
//        if (!nodes.containsKey(node1.toLowerCase()) || !nodes.containsKey(node2.toLowerCase())) {
//            return;
//        }
//        Edge edge = new Edge(from, to);
//        Node fromNode = nodes.get(from);
//
//        fromNode.neighbours.add(edge);
//    }
//    public void reretVisited() {
//        for (Node node : nodes.values()) {
//            node.isVisised = false;
//        }
//    }
//    public void BFSearch(String start) {
//        Node startNode = nodes.get(start.toLowerCase());
//        if (startNode == null) {
//            return;
//        }
//        reretVisited();
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(startNode);
//        queue.add(null);
//        while (!queue.isEmpty()) {
//            Node node = queue.remove();
//            if (node != null) {
//                if (node.isVisised == true) {
//                    continue;
//                }
//                node.isVisised = true;
//                System.out.print(node.name + ", ");
//
//                for (Edge edge: node.neighbours) {
//                    Node neighbour = nodes.get(edge.endNode);
//                    if (neighbour.isVisised == false) {
//                        queue.add(neighbour);
//                    }
//                }
//            }
//            else {
//                System.out.println();
//                if (queue.isEmpty()) {
//                    break;
//                }
//                queue.add(null);
//            }
//        }
//    }
//}
