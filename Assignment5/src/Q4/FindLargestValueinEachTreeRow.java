package Q4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
     int val;
     TreeNode left;
      TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
public class FindLargestValueinEachTreeRow {
     public static void main (String args[]) {
         TreeNode root = new TreeNode(1);
         root.left = new TreeNode(3);
         root.right = new TreeNode(2);
         root.left.left = new TreeNode(5);
         root.left.right = new TreeNode(3);
         root.right.right = new TreeNode(9);
         root.right.right.right = new TreeNode(10);
         root.right.right.right.right = new TreeNode(11);
         System.out.println(largestValues(root));
     }
    public static List<Integer> largestValues(TreeNode root) {
//------------------------------Main Code Start---------------------------
         if (root==null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        List<Integer> nodes = new ArrayList<>();
        Queue<TreeNode> queNode = new LinkedList<>();
        queNode.add(root);
        queNode.add(null);
        while (!queNode.isEmpty()) {
            TreeNode node = queNode.remove();
            if (node != null) {
                nodes.add(node.val);
                if (node.left != null) queNode.add(node.left);
                if (node.right != null) queNode.add(node.right);
            }
            else {
                if (!queNode.isEmpty()) queNode.add(null);
                int larg = nodes.get(0);
                for (int i=1; i<nodes.size(); i++) {
                    if (nodes.get(i) > larg) larg=nodes.get(i);
                }
                res.add(larg);
                nodes = new ArrayList<>();
            }
        }
        return res;
//------------------------------Main Code End---------------------------
    }
}
