package Q2;

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
public class FindLeavesofBinaryTree {
    public static void main (String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode (4);
        root.right.left = new TreeNode(5);
        System.out.println(findLeaves(root));
    }
    public static List<List<Integer>> findLeaves(TreeNode root) {
//--------------------------Main Code Start-------------------------------
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        leafLevel(root, ans);
        return ans;
    }
    public static Integer leafLevel(TreeNode node, List<List<Integer>> ans) {
        if (node == null) return -1;
        int leafLevel = Math.max(leafLevel(node.left, ans),leafLevel(node.right,ans))+1;
        if (ans.size() <= leafLevel) ans.add(new ArrayList<>());
        ans.get(leafLevel).add(node.val);
        return leafLevel;
//--------------------------Main Code End-------------------------------
    }
}
