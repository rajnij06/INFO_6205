package Q5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VerticalOrderTraversalofaBT {
//------------------Start-----------------------
    public class Node{
        TreeNode index;
        int x, y;
        public Node(TreeNode p, int x, int y){
            index = p;
            this.x = x;
            this.y = y;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Node> lst = new ArrayList();
        grph(lst, root, 0, 0);
        Collections.sort(lst, (a, b) -> (a.y==b.y ?(a.x==b.x ?a.index.val-b.index.val:a.x -b.x):a.y -b.y));
        List<List<Integer>> ans = new ArrayList<>();
        int pre = 1001;
        for (Node i : lst) {
            if (i.y !=pre) {
                ans.add(new ArrayList<>());
                pre = i.y;
            }
            ans.get(ans.size()-1).add(i.index.val);
        }
        return ans;
    }
    private void grph(List<Node> l, TreeNode index, int i, int j){
        if (index == null) return;
        l.add(new Node(index, i, j));
        grph(l, index.left, i+1, j-1);
        grph(l, index.right, i+1, j+1);
    }
//------------------End-----------------------
}
