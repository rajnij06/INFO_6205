import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TwoSumIVInputisaBST {
    public static void main (String args[]) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(3);
//        root.right = new TreeNode(6);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);
//        root.right.right = new TreeNode(7);
//        int k = 9;
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        int k = 6;
        System.out.println(findTarget(root, k));
    }
    public static boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return false;
        }
        ArrayList<Integer> valarr = new ArrayList<>();
        Queue<TreeNode> quenode = new LinkedList<>();
        quenode.add(root);
        while (!quenode.isEmpty()) {
            TreeNode node = quenode.remove();
            valarr.add(node.val);
            if (node.left != null) quenode.add(node.left);
            if (node.right != null) quenode.add(node.right);
        }
        for (int i=0; i<valarr.size(); i++) {
            for (int j=0; j<valarr.size(); j++) {
                if (valarr.get(i)+valarr.get(j) == k && i!=j) return true;
            }
        }
        return false;
    }
}
