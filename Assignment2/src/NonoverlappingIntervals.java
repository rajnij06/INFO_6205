//https://leetcode.com/problems/non-overlapping-intervals/

import java.util.Arrays;

public class NonoverlappingIntervals {
    public static void main (String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}}; //1
//        int[][] intervals = {{1,2},{1,2},{1,2}}; //2
//        int[][] intervals = {{1,2},{2,3}}; //0
//        int[][] intervals = {}; //0
//        int[][] intervals = {{2,3}}; //0
        System.out.println(eraseOverlapIntervals(intervals));
    }
    public static int eraseOverlapIntervals(int[][] intervals) {
        int result = 0;
        if (intervals == null || intervals.length == 0 || intervals[0].length == 1)
            return result;
        Arrays.sort(intervals, (r,c) -> Integer.compare(r[1],c[1]));
        int x = intervals[0][1];
        for (int i=1; i<intervals.length; i++) {
            if (x > intervals[i][0])
                result++;
            else
                x = intervals[i][1];
        }
        return result;
    }
}
