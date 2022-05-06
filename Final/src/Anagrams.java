import java.util.*;

public class Anagrams {
    public static void main (String[] args) {
//        String[] strs = {"eat","tea","tan","ate","nat","bat"};  //[["bat"],["nat","tan"],["ate","eat","tea"]]
//        String[] strs = {""};     //[[""]]
        String[] strs = {"a"};      //[["a"]]
        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for (String s: strs) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String sString = String.valueOf(temp);
            List<String> currList = map.getOrDefault(sString, new ArrayList());
            currList.add(s);
            map.put(sString, currList);
        }
        return new ArrayList(map.values());
    }
}