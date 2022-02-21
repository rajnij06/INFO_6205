// https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/

import java.util.ArrayList;
import java.util.List;

public class MinNMaxNoofNodesBtwCriticalPoints {
//-----------------------------------Main code Start-----------------------------
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer>  cPoints = new ArrayList<>();
        int i=0;
        ListNode prev = null;
        while (head.next != null) {
            if (prev == null) {
                i++;
                prev = head;
                head = head.next;
                continue;
            }
            if (prev.val > head.val && head.next.val > head.val) cPoints.add(i);
            else if (prev.val < head.val && head.next.val < head.val) cPoints.add(i);
            i++;
            prev = head;
            head = head.next;
        }
        int min = Integer.MAX_VALUE;
        if (cPoints.size() < 2) return new int[]{-1,-1};
        int max = cPoints.get(cPoints.size()-1)-cPoints.get(0);
        for (int j=1; j<cPoints.size(); j++) {
            if (cPoints.get(j) - cPoints.get(j-1) < min) min = cPoints.get(j) - cPoints.get(j-1);
        }
        return new int[]{min,max};
    }
//-----------------------------------Main code End-----------------------------
}
