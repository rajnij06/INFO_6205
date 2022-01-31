import java.util.*;
class Node {
    int freq = 1;
    String s;
}
public class TopKFrequent {
    public static void main (String[] args) {
//        String[] words = {"i","love","leetcode","i","love","coding"}; int k = 2; //["i","love"]
        String[] words = {"the","day","is","sunny","the","the","the","sunny","is","is"}; int k = 4; //["the","is","sunny","day"]

        System.out.println(wordArray(words,k));
    }
    static List<String> wordArray(String[] words, int k) {
        Map<String, Node> map = new HashMap<>();
        for (String s: words) {
            if (map.containsKey(s)) {
                map.get(s).freq++;
            } else {
                Node node = new Node();
                node.s = s;
                map.put(s, node);
            }
        }
        Queue<Node> q = new PriorityQueue<>((a, b) ->
                a.freq - b.freq != 0 ? a.freq - b.freq :
                        b.s.compareTo(a.s));
        for (Node a: map.values()) {
            q.add(a);
            if (q.size() > k) {
                q.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while (k > 0) {
            res.add(0, q.remove().s);
            k--;
        }
        return res;
    }
}
