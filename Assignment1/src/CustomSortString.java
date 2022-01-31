import java.util.Arrays;

public class CustomSortString {
    public static void main(String[] args) {
        String order = "cba", s = "abcd"; //cbad
//        String order = "cbafg", s = "abcd"; //cbad
        System.out.println(customSortString(order, s));
    }
    public static String customSortString(String order, String s) {
        int[] sortMap = new int[26];
        for(char c: s.toCharArray()) {
            sortMap[c-'a'] = sortMap[c-'a'] + 1;
        }
        StringBuilder result = new StringBuilder();
        for (char c: order.toCharArray()) {
            int val = c - 'a';
            while (sortMap[val] > 0) {
                result.append(c);
                sortMap[val]--;
            }
        }
        for (int i=0; i<sortMap.length; i++) {
            while (sortMap[i] > 0) {
                char cha = (char)(i+'a');
                result.append(cha);
                sortMap[i]--;
            }
        }
        return result.toString();
    }
}
