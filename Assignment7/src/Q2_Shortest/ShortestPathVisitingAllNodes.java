package Q2_Shortest;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathVisitingAllNodes {
    public static void main (String[] args) {
        int[][] graph = {{1,2,3},{0},{0},{0}};
        System.out.println(shortestPathLength(graph));
    }
    public static int shortestPathLength(int[][] graph) {
        int len = graph.length;
        boolean[][] vstd = new boolean[len][1 << len];
        int val = (1 << len) - 1;
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < len; i++) que.offer(new int[]{i, 1 << i});
        int ans = -1;
        while (!que.isEmpty()) {
            ans++;
            int size = que.size();
            for (int s = 0; s < size; s++) {
                int[] cur = que.poll();
                int node = cur[0], state = cur[1];
                if (state == val) return ans;
                if (vstd[node][state]) continue;
                vstd[node][state] = true;
                for (int next : graph[node]){
                    que.offer(new int[]{next, state | (1 <<next)});
                }
            }
        }
        return ans;
    }
}
