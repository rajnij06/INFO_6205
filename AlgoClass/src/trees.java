import java.util.LinkedList;
import java.util.Queue;

public class trees {
    public static void main(String args[]) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        initializeTree();
    }
    private static void initializeTree() {
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);

        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        root.right.left = new Node<>(6);
        root.right.right = new Node<>(7);
    }
}
class Node <T>{
    public Node<T> left;
    public Node<T> right;
    public T data;
//    public ArrayList<Node<T>> chil;

    public Node(T data) {
        this.data = data;
    }
}
class BinaryTree<T> {
    public Node<T> root;
    public BinaryTree() {

    }
    public void preOrder() {
        preOrder(root);
    }
    private void preOrder(Node<T> node) {
        if (node != null) {
            System.out.print(node.data + " , ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    private void inOrder(Node<T> node) {
        if (node != null) {
            preOrder(node.left);
            System.out.print(node.data + " , ");
            preOrder(node.right);
        }
    }
    private void postOrder(Node<T> node) {
        if (node != null) {
            preOrder(node.left);
            preOrder(node.right);
            System.out.print(node.data + " , ");
        }
    }
    public void levelOrder() {
        if(root == null)
            return;
        Queue<Node<T>> que = new LinkedList<>();
        que.add(root);
        que.add(null);
        while (!que.isEmpty()) {
            Node<T> node = que.remove();
            if (node != null) {
                System.out.println(node.data + " , ");
                if (node.left != null) {
                    que.add(node.right);
                }
            }
            else {
                System.out.println();
                if (que.isEmpty()) {
                    break;
                }
                que.add(null);
            }
        }
    }
}
