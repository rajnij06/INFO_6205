package Q3_Max;

import java.util.HashMap;
import java.util.Map;

public class MaxPathQualityofGraph {
    public static void main (String[] args) {
        int[] values = {0,32,10,43};
        int[][] edges = {{0,1,10},{1,2,15},{0,3,10}};
        int maxTime = 49;
        System.out.println(maximalPathQuality(values, edges, maxTime));
    }
    public static int max;
    public static int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new HashMap<>());
            map.putIfAbsent(edge[1], new HashMap<>());
            map.get(edge[0]).put(edge[1], edge[2]);
            map.get(edge[1]).put(edge[0], edge[2]);
        }
        int[] vstd = new int[values.length];
        maxPath(0, 0, values, map, vstd, maxTime);
        return max;
    }
    public static void maxPath(int curr, int value, int[] values, Map<Integer, Map<Integer, Integer>> map, int[] vstd, int time) {
        vstd[curr]++;
        if (vstd[curr] <= 1) value += values[curr];
        if (curr == 0) max = Math.max(value, max);
        if (map.containsKey(curr)) {
            for (Map.Entry<Integer, Integer> pair : map.get(curr).entrySet()) {
                int val = pair.getValue();
                int next = pair.getKey();
                if (val > time) continue;
                maxPath(next, value, values, map, vstd, time - val);
            }
        }
        vstd[curr]--;
        return;
    }
}
