package Q1;

import java.util.ArrayList;

public class PathSumIII {
//------------------Start-----------------------
    public static int ans = 0;
    public static int pathSum(TreeNode root, int targetSum) {
        ans = 0;
        count(root,targetSum);
        return ans;
    }
    public static ArrayList<Integer> count(TreeNode root,int sum)
    {
        if(root == null) return new ArrayList<>();
        ArrayList<Integer> l = count(root.left,sum);
        ArrayList<Integer> r = count(root.right,sum);
        ArrayList<Integer> lst = new ArrayList<>();
        for (int i : l) {
            lst.add(i+root.val);
            if (i+root.val == sum) ans++;
        }
        for(int i : r) {
            lst.add(i+root.val);
            if (i+root.val == sum) ans++;
        }
        lst.add(root.val);
        if (root.val == sum) ans++;
        return lst;
    }
//------------------End-----------------------
}
