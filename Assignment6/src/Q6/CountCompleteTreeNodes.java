package Q6;

public class CountCompleteTreeNodes {
//------------------Start-----------------------
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int l = countNodes(root.left);
        int r = countNodes(root.right);
        return l+r+1;
    }
//------------------End-----------------------
}
