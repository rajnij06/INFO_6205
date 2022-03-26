// Question 3

import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class PreInOrder {
    public static void main (String[] args) {
        int[] preorder = {3,9,20,15,7}, inorder = {9,3,15,20,7};
        buildTree(preorder, inorder);
    }
    static int preIndex;
    static HashMap<Integer,Integer> hmap;
    static int n;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex=0;
        hmap = new HashMap<Integer, Integer>();
        n = inorder.length; // max length of tree
        for (int i = 0; i < n; i++) {
            hmap.put(inorder[i], i); // adding inorder values with index position in map
        }
        return build(preorder, inorder, 0, n-1);
    }
    public static TreeNode build(int[] preorder, int[] inorder, int start, int end){
        if (start > end || preIndex == n) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preIndex++]);
        if (start == end) {
            return node;
        }
        int index = hmap.get(node.val);
        node.left = build(preorder, inorder, start, index-1); // recursively building left side of tree
        node.right = build(preorder, inorder, index+1, end); // recursively building right side of tree
        return node;
    }
}


