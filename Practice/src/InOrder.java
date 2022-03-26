// https://leetcode.com/problems/range-sum-of-bst/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
public class InOrder {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(10);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(21);
        System.out.print(deserialize(serialize(root)));
    }

    public static String sep = ",";
    public static String sub = "x";

    public static String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder str = new StringBuilder();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int x = 1;
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            if (node == null) str.append(sub);
            else {
                str.append(node.val);
                que.add(node.left);
                que.add(node.right);
                x--;
                if (node.left != null) x++;
                if (node.right != null) x++;
            }
            if (x == 0) break;
            str.append(sep);
        }
        return str.toString();

//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(3);
//        root.right = new TreeNode(6);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);
//        root.right.right = new TreeNode(8);
//        root.left.left.left = new TreeNode(1);
//        root.right.right.left = new TreeNode(7);
//        root.right.right.right = new TreeNode(9);
//        increasingBST(root);
//    }
//    public static TreeNode InOrder(TreeNode root, List lst) {
//        if (root == null) return null;
//        InOrder(root.left, lst);
//        lst.add(root.val);
//        InOrder(root.right, lst);
//        return root;
//    }
//    public static TreeNode increasingBST(TreeNode root) {
//        if (root == null) return null;
//        ArrayList lst = new ArrayList<Integer>();
//        InOrder(root, lst);
//        return createFromList(lst);
//    }
//    public static TreeNode createFromList(ArrayList<Integer> list) {
//        TreeNode root = new TreeNode(list.get(0));
//        TreeNode returnRoot = root;
//        for (int i = 1; i < list.size(); i++) {
//            TreeNode temp = new TreeNode(list.get(i));
//            root.right = temp;
//            root = root.right;
//        }
//        return returnRoot;
    }

    public static TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] strArr = data.split(",");
        Queue<String> que = new LinkedList<>();
        for (String s : strArr) que.add(s);
        Queue<TreeNode> nodeQue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(que.poll()));
        nodeQue.add(root);
        while (!que.isEmpty()) {
            TreeNode node = nodeQue.poll();
            String l = que.poll();
            String r = que.size() == 0 ? sub : que.poll();
            TreeNode ln = l.equals(sub) ? null : new TreeNode(Integer.parseInt(l));
            TreeNode rn = r.equals(sub) ? null : new TreeNode(Integer.parseInt(r));
            node.left = ln;
            node.right = rn;
            if (ln != null) nodeQue.add(ln);
            if (rn != null) nodeQue.add(rn);
        }
        return root;
    }
}
