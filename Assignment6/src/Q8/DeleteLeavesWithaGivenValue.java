package Q8;

public class DeleteLeavesWithaGivenValue {
//------------------Start-----------------------
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return postorder(root, target) ? null : root;
    }
    public static boolean postorder(TreeNode root, int target) {
        if(root == null) return false;
        if(postorder(root.left, target)) root.left = null;
        if(postorder(root.right, target)) root.right = null;
        return root.val == target && (root.left == null && root.right == null);
    }
//------------------End-----------------------
}
