package Q7;

public class SumRoottoLeafNumbers {
//------------------Start-----------------------
    public int sumNumbers(TreeNode root) {
        return DFS(root, 0);
    }
    public int DFS(TreeNode root, int sum){
        if(root == null) return 0;
        sum = sum * 10 + root.val;
        if(root.left == null && root.right == null){
            return sum;
        }
        int ans = DFS(root.left, sum) + DFS(root.right, sum);
        return ans;
    }
//------------------End-----------------------
}
