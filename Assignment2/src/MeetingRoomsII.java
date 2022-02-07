// https://leetcode.com/problems/meeting-rooms-ii/

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoomsII {
    public static void main (String[] args) {
        int[][] intervals = {{0,30},{5,10},{15,20}}; //2
//        int[][] intervals = {{7,10},{2,4}}; //1
//        int[][] intervals = {{5,10},{2,4},{5,6},{11,13}}; //2
        System.out.println(minMeetingRooms(intervals));
    }
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0)
            return 0;
        int result = 1;
        int[] first = new int[intervals.length];
        int[] sec = new int[intervals.length];
        for (int i=0; i<intervals.length; i++) {
            first[i] = intervals[i][0];
            sec[i] = intervals[i][1];
        }
        Arrays.sort(first);
        Arrays.sort(sec);
        int i=1, j=0, index=1;
        while (i<intervals.length && j<intervals.length) {
            if (first[i]<sec[j]) {
                i++;
                index++;
            }
            else {
                j++;
                index--;
            }
            result = Integer.max(result, index);
        }
        return result;
    }
}
