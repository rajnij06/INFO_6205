package Q3;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    public TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class MaxWidthofBinaryTree {
    public static void main (String args[]) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(3);
//        root.right = new TreeNode(2);
//        root.left.left = new TreeNode(5);
//        root.right.right = new TreeNode(9);
//        root.left.left.left = new TreeNode(6);
//        root.right.right.right = new TreeNode(7); //8
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(3);
//        root.left.left = new TreeNode(5);
//        root.left.right = new TreeNode(3);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(3); //2
        System.out.print(widthOfBinaryTree(root));
    }
    public static int widthOfBinaryTree(TreeNode root) {
//----------------------------Main Code Start------------------------------------
        int maxwidth = 1;
        Queue<TreeNode> nodeQue = new LinkedList<TreeNode>();
        root.val = 0;
        nodeQue.add(root);
        while(!nodeQue.isEmpty()) {
            int size = nodeQue.size();
            int start = nodeQue.peek().val;
            int end = 0;
            for (int i = 0; i<size; i++) {
                TreeNode node = nodeQue.remove();
                if (node.left != null) {
                    node.left.val = (node.val * 2);
                    nodeQue.offer(node.left);
                }
                if (node.right != null) {
                    node.right.val = (node.val * 2) +1;
                    nodeQue.offer(node.right);
                }
                if (i == size-1) end = node.val;
            }
            maxwidth = Math.max(maxwidth,end - start + 1);
        }
        return maxwidth;
//----------------------------Main Code End------------------------------------
    }
}
