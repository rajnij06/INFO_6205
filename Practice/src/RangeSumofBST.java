import java.util.ArrayList;

public class RangeSumofBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int sum = 0;
        ArrayList<Integer> arrlist = new ArrayList<Integer>();
        InOrder (root, arrlist);
        for (int i=0; i<arrlist.size(); i++) {
            System.out.println(arrlist.get(i));
            if (arrlist.get(i) >= low && arrlist.get(i) <= high) {
                sum = sum + arrlist.get(i);
                if (arrlist.get(i+1) > high ) break;
            }
        }
        return sum;
    }
    public TreeNode InOrder(TreeNode node, ArrayList<Integer> arrlist) {
        if (node == null) return null;
        InOrder(node.left, arrlist);
        arrlist.add(node.val);
        InOrder(node.right, arrlist);
        return node;
    }
}
