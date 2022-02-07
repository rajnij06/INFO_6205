//https://leetcode.com/problems/interval-list-intersections/

import java.util.ArrayList;

public class IntervalListIntersections {
    public static void main (String[] args) {
        int[][] firstList = {{0,2},{5,10},{13,23},{24,25}}, secondList = {{1,5},{8,12},{15,24},{25,26}}; //[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
//        int[][] firstList = {{1,3},{5,9}}, secondList = {}; //[]
        System.out.println(intervalIntersection(firstList,secondList));
    }
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0)
            return new int[0][0];
        ArrayList<int[]> result = new ArrayList<>();
        int l1 = firstList.length, l2 = secondList.length, i = 0, j = 0;
        while (i<l1 && j<l2) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            if (start <= end)
                result.add(new int[]{start,end});
            if (firstList[i][1] < secondList[j][1])
                i++;
            else
                j++;
        }
        return result.toArray(new int[result.size()][]);
    }
}
