//https://leetcode.com/problems/insert-interval/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main (String[] args) {
//        int[][] intervals = {{1,3},{6,9}}; int[] newInterval = {2,5}; //[[1,5],[6,9]]
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}}; int[] newInterval = {4,8}; //[[1,2],[3,10],[12,16]]
        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for (int[] i : intervals) {
            if (i[1] < newInterval[0]) {
                result.add(i);
            }
            else if (newInterval[1] < i[0]) {
                result.add(newInterval);
                newInterval = i;
            }
            else {
                newInterval[0] = Math.min(i[0], newInterval[0]);
                newInterval[1] = Math.max(i[1], newInterval[1]);
            }
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
}
