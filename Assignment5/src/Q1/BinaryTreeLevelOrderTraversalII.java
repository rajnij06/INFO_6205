package Q1;

import java.util.LinkedList;
import java.util.List;
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
public class BinaryTreeLevelOrderTraversalII {
     public static void main (String args[]) {
         TreeNode root = new TreeNode(3);
         root.left = new TreeNode(9);
         root.right = new TreeNode(20);
         root.left.left = new TreeNode(10);
         root.right.left = new TreeNode(15);
         root.right.right = new TreeNode(7);
         root.right.right.right = new TreeNode(21);
         root.right.right.right.right = new TreeNode(23);
         levelOrderBottom(root);
     }
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
//----------------------------------Main Code Start------------------------------
        if (root == null) return new LinkedList<>();
        List<List<Integer>> finalList = new LinkedList<>();
        List<Integer> curList = new LinkedList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); queue.add(null);
        while( !queue.isEmpty() ){
            TreeNode node = queue.remove();
            if(node != null){
                curList.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right); }
            else { if(queue.isEmpty()) break;
                queue.add(null);
                finalList.add(curList);
                curList = new LinkedList<Integer>(); }}
        if (!curList.isEmpty()) finalList.add(curList);
        List<List<Integer>> returnList = new LinkedList<>();
        for (int i = finalList.size() -1 ; i >= 0; i--) {
            returnList.add(finalList.get(i)); }
        return returnList;
//----------------------------------Main Code End------------------------------
    }
}
