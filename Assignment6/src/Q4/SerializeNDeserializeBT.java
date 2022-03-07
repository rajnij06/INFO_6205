package Q4;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeNDeserializeBT {
//------------------Start-----------------------
    public final String nullc = "x";
    public final String sep = ",";
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int x = 1;
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            if (node == null) sb.append(nullc);
            else {
                sb.append(node.val);
                que.add(node.left);
                que.add(node.right);
                x = x-1;
                if (node.left != null) x += 1;
                if (node.right != null) x += 1;
            }
            if (x == 0) break;
            sb.append(sep);
        }
        return sb.toString();
    }
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] parts = data.split(",");
        Queue<String> que = new LinkedList<>();
        for (String part : parts) que.add(part);
        Queue<TreeNode> nodes = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(que.poll()));
        nodes.add(root);
        while (!que.isEmpty()) {
            TreeNode node = nodes.poll();
            String left = que.poll();
            String right = que.size() == 0 ? nullc : que.poll();
            TreeNode l = left.equals(nullc) ? null : new TreeNode(Integer.parseInt(left));
            TreeNode r = right.equals(nullc) ? null : new TreeNode(Integer.parseInt(right));
            node.left = l;
            node.right = r;
            if (l != null) nodes.add(l);
            if (r != null) nodes.add(r);
        }
        return root;
    }
//------------------End-----------------------
}
