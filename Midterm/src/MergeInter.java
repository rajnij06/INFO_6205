// Question 4

import java.util.*;
class Interval {
    int start;
    int end;
    Interval(int start, int end)
    {
        this.start = start;
        this.end = end;
    }
}
public class MergeInter {
    public static void main(String args[]) {
        //input
        int[][] intervals  = {{1,3}, {2,6}, {8,10}, {15,18}};
        // int[][] intervals  = {{1,4}, {4,5}};
        // result arraylist
        int[][] res =  mergeIntervals(intervals);
        // printing result
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i][0] + " - " + res[i][1]);
            System.out.println();
        }
    }
    public static int[][] mergeIntervals(int[][] intervals) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int[][] emptyRes = new int[0][0];
        Interval[] arr = new Interval[intervals.length];
        // adding input to format required
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            Interval cur = new Interval(start, end);
            arr[i] = cur;
        }
        if (arr.length <= 0) return emptyRes;
        Stack<Interval> stack=new Stack<>();
        Arrays.sort(arr,new Comparator<Interval>(){
            public int compare(Interval i1,Interval i2)
            {
                return i1.start-i2.start;
            }
        });
        stack.push(arr[0]);
        for (int i = 1 ; i < arr.length; i++) {
            Interval top = stack.peek();
            if (top.end < arr[i].start) {
                stack.push(arr[i]);
            } else if (top.end < arr[i].end) {
                top.end = arr[i].end;
                stack.pop();
                stack.push(top);
            }
        }
        while (!stack.isEmpty()) {
            Interval t = stack.pop();
            ArrayList<Integer> innerRes = new ArrayList<>();
            innerRes.add(t.start);
            innerRes.add(t.end);
            res.add(innerRes);
        }
        int[][] arrayOutput = new int[res.size()][2];
        for (int i = 0; i < arrayOutput.length; i++) {
            arrayOutput[i][0] = res.get(i).get(0);
            arrayOutput[i][1] = res.get(i).get(1);
        }
        return arrayOutput;
    }
}