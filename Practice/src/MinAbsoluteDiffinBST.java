import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MinAbsoluteDiffinBST {
    public static void main (String args[]) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(getMinimumDifference(root));
    }
    public static int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;
        ArrayList<Integer> valarr = new ArrayList<>();
        Queue<TreeNode> quenode = new LinkedList<>();
        quenode.add(root);
        while (!quenode.isEmpty()) {
            TreeNode node = quenode.remove();
            valarr.add(node.val);
            if (node.left != null) quenode.add(node.left);
            if (node.right != null) quenode.add(node.right);
        }
        int mindiff = 100000;
        for (int i=0; i<valarr.size(); i++) {
            for (int j=0; j<valarr.size(); j++) {
                if (i!=j) {
                    int diff = valarr.get(i)-valarr.get(j);
                    if (diff < 0) diff = diff*(-1);
                    if (diff < mindiff) mindiff = diff;
                }
            }
        }
        return mindiff;
    }
}
