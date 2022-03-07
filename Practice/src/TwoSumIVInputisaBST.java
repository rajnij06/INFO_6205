import java.util.*;

public class TwoSumIVInputisaBST {
    public static void main (String args[]) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        int targetSum = 8;
        System.out.println(pathSum(root, targetSum));
    }
    public static int total=0;
    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        count (root, targetSum);
        count (root.left, targetSum);
        count (root.right,targetSum);
        return total;
    }
    public static void count(TreeNode root, int sum) {
        if (root == null) return;
        if (root.val == sum) {
            total++;
        }
        sum -= root.val;
        count (root.left, sum);
        count (root.right, sum);
    }
}
