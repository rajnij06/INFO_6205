package Q2;

public class LCAncestorofaBT {
//------------------Start-----------------------
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode l = (lowestCommonAncestor(root.left, p, q));
        TreeNode r = (lowestCommonAncestor(root.right, p, q));
        if(l == null && r == null) return null;
        else if(l != null && r != null) return root;
        if(l == null) return r;
        else return l;
    }
//------------------End-----------------------
}
