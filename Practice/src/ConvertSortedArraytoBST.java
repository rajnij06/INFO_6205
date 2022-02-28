public class ConvertSortedArraytoBST {
    public static void main (String args[]) {
        int[] nums = {-10,-3,0,5,9};
        preOrder(sortedArrayToBST(nums));
    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return new TreeNode();
        if (nums.length == 1) return new TreeNode(nums[0]);
        return constructBST(nums,0,nums.length-1);
    }
    public static TreeNode constructBST(int[] nums, int start, int end) {
        if(start > end) return null;
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructBST(nums,start,mid-1);
        root.right = constructBST(nums, mid+1, end);
        return root;
    }
    public static void preOrder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
}
