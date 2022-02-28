// https://leetcode.com/problems/range-sum-of-bst/

import java.util.ArrayList;
import java.util.List;

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
public class InOrder {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(8);
        root.left.left.left = new TreeNode(1);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);
        increasingBST(root);
    }
    public static TreeNode InOrder(TreeNode root, List lst) {
        if (root == null) return null;
        InOrder(root.left, lst);
        lst.add(root.val);
        InOrder(root.right, lst);
        return root;
    }
    public static TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        ArrayList lst = new ArrayList<Integer>();
        InOrder(root, lst);
        return createFromList(lst);
    }
    public static TreeNode createFromList(ArrayList<Integer> list) {
        TreeNode root = new TreeNode(list.get(0));
        TreeNode returnRoot = root;
        for (int i = 1; i < list.size(); i++) {
            TreeNode temp = new TreeNode(list.get(i));
            root.right = temp;
            root = root.right;
        }
        return returnRoot;
    }
}