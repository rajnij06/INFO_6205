class TreeNode {
    int val;
    TreeNode lf;
    TreeNode rt;
    TreeNode(int x) { val = x; }
}
public class LCA {
    public static void main (String[] args) {
        TreeNode root = new TreeNode(6);
        root.lf = new TreeNode(2);
        root.rt = new TreeNode(8);
        root.lf.lf = new TreeNode(0);
        root.lf.rt = new TreeNode(4);
        root.rt.lf = new TreeNode(7);
        root.rt.rt = new TreeNode(9);
        root.lf.rt.lf = new TreeNode(3);
        root.lf.rt.rt = new TreeNode(5);
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        lowestCommonAncestor(root, p, q);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            if (root == p || root == q) return root;
            TreeNode l = (lowestCommonAncestor(root.lf, p, q));
            TreeNode r = (lowestCommonAncestor(root.rt, p, q));
            if (l == null && r == null) return null;
            else if (l != null && r != null) return root;
            if (l == null) return r;
            else return l;
    }
}
