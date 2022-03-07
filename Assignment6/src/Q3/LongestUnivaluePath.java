package Q3;

public class LongestUnivaluePath {
//------------------Start-----------------------
    public int count = 0;
    public int longestUnivaluePath(TreeNode root) {
        longestpath(root);
        return  count;
    }
    public int longestpath(TreeNode root) {
        if (root == null) return 0;
        int l = longestpath(root.left);
        int r = longestpath(root.right);
        int lc = 0, rc = 0;
        if (root.left != null && root.left.val == root.val) lc += l + 1;
        if (root.right != null && root.right.val == root.val) rc += r+ 1;
        count = Math.max(count, lc+rc);
        return Math.max(lc, rc);
    }
//------------------End-----------------------
}
