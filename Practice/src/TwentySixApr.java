import javax.swing.plaf.synth.SynthUI;
import java.security.Key;
import java.util.*;

public class TwentySixApr {
    public static void main (String[] args) {
//        String num = "1432219"; int k = 3;
//        System.out.println(SmallestNo(num, k));
//        String a = "11", b = "1";
//        System.out.println(sum(a,b));
//        String s = "K1:L2";
//        CellsRangeExcelSheet(s);
//        String rings = "B0B6G0R6R0R6G9";
//        System.out.println(RingsandRods(rings));
//        String[] words = {"gin","zen","gig","msg"};
//        System.out.println(uniqueMorseRepresentations(words));
//        String s = "a1c1e1";
//        System.out.println(replaceDigits(s));
//        String s = "(()())(())(()(()))";
//        System.out.println(s);
//        System.out.println(removeOuterParentheses(s));
//        String[] patterns = {"hetnovaoigv","vrh"};
//        String word = "csfjksvqfdojsfrjhetnovaoigvgk";
//        System.out.println(numOfStrings(patterns, word));
//        String[] words = {"abc","car","ada","racecar","cool"};
//        System.out.println(firstPalindrome(words));
//        String s = "Let's take LeetCode contest";
//        System.out.println(reverseWords(s));
//        int[] prices = {7,1,5,3,6,4};
////        System.out.println(maxProfit(prices));
//        char[] chars = {'a','b','c'};
//        System.out.println(compress(chars));
//        String s = "bpfbhmipx";
//        System.out.println(lengthOfLongestSubstring(s));
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
    public static List<String> letterCombinations(String digits) {
        Map<Integer, String> mp = new HashMap<>();

        List<String> ans = new ArrayList<>();

        return ans;
    }
//    public static int lengthOfLongestSubstring(String s) {
//        if (s.length() == 0 || s.length() == 1) return s.length();
//        if (s.length() == 2) {
//            if (s.charAt(0)==s.charAt(1))
//                return 1;
//            else return 2;
//        }
//        int max = 1;
//        Stack<Character> st = new Stack<>();
//        for (int i=0; i<s.length(); i++) {
//            System.out.println(s.charAt(i));
//            String sb = "";
//            int sz=0;
//            if (st.contains(s.charAt(i))) {
//                System.out.println("if - "+s.charAt(i));
//                max = Math.max(st.size(), max);
//                String ns = "";
//                for (char c : st) {
//                    System.out.println("top - "+c);
//                    ns = ns + c;
//                    if (c == s.charAt(i)) {
//                        ns = "";
//                    }
//                }
//                while (!st.isEmpty()) {
//                    System.out.println(st.size());
//                    sb = sb + st.pop();
//                }
//                for (int x=ns.length()-1; x>=0; x--) {
//                    st.push(ns.charAt(x));
//                }
//            }
//            st.push(s.charAt(i));
//        }
//        return Math.max(max, st.size());
//    }
//    public static int compress(char[] chars) {
//        if (chars.length == 1) return 1;
//        int index = 0;
//        for (int i=0; i<chars.length; i++) {
//            int c = 1;
//            if (i+1 != chars.length) {
//                int j = i + 1;
//                while (chars[i] == chars[j]) {
//                    i++;
//                    j++;
//                    c++;
//                    if (j == chars.length) break;
//                }
//            }
//            chars[index] = chars[i];
//            index++;
//            if (c > 1) {
//                String s = String.valueOf(c);
//                for (int k=0; k<s.length(); k++) {
//                    chars[index] = s.charAt(k);
//                    index++;
//                }
//            }
//        }
//        return index;
//    }
//    public static int maxProfit(int[] prices) {
//        int dif = 0;
//        int v = -1;
//        for (int i = 0; i < prices.length; i++) {
//            int min = prices[i];
//            for (int j=i; j<prices.length; j++) {
//                dif = Math.max(dif, prices[j]-min);
//            }
//        }
//        return dif;
//    }
//    public static String reverseWords(String s) {
//        String[] arr = s.split(" ");
//        StringBuilder ans = new StringBuilder();
//        for (int i=0; i<arr.length; i++) {
//            StringBuilder c = new StringBuilder(arr[i]);
//            ans.append(c.reverse());
//            if (i!=arr.length-1) ans.append(" ");
//        }
//        return ans.toString();
//    }
//    public static String firstPalindrome(String[] words) {
//        String ans = "";
//        for (int i=0; i<words.length; i++) {
//            String c = words[i];
//            int s = 0, e = c.length() - 1, flag = 0;
//            while (s <= e) {
//                if (c.charAt(s) != c.charAt(e)) {
//                    flag = 1;
//                    break;
//                }
//                s++; e--;
//            }
//            if (flag == 0) return c;
//        }
//        return ans;
//    }
//    public static int numOfStrings(String[] patterns, String word) {
//        int count = 0;
//        for (String str : patterns) {
//            if (word.contains(str)) count++;
//        }
//        return count;
//    }
//    public static String removeOuterParentheses(String s) {
//        String ans = "";
//        Stack<Character> st = new Stack<>();
//        Set<Integer> set = new HashSet<>();
//        set.add(0);
//        set.add(s.length()-1);
//        for (int i=0; i<s.length(); i++) {
//            if (st.isEmpty()) {
//                if (i!=0) {
//                    set.add(i - 1);
//                    set.add(i);
//                }
//            }
//            char c = s.charAt(i);
//            if (c == '(') {
//                st.push(c);
//            }
//            else {
//                st.pop();
//            }
//        }
//        for (int i=0; i<s.length(); i++) {
//            if (!set.contains(i)) ans = ans + s.charAt(i);
//        }
//        return ans ;
//    }
//    public static String replaceDigits(String s) {
//        String ans = "";
//        for (int i=0; i<s.length(); i++) {
//            char c = s.charAt(i);
//            ans = ans + c;
//            if (i+1 != s.length()) i++;
//            else break;
//            int n = Character.getNumericValue(s.charAt(i));
//            c+=n;
//            ans = ans + c;
//        }
//        return ans;
//    }
//    public static int uniqueMorseRepresentations(String[] words) {
//        String[] code = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
//        Set<String> ansSt = new HashSet<>();
//        Map<Character, String> mp = new HashMap<>();
//        int n=0;
//        for (char i = 'a'; i<='z'; i++) {
//            mp.put(i, code[n]);
//            n++;
//        }
//        for (int i=0; i<words.length; i++) {
//            String tmp = words[i], cd = "";
//            for (int j=0; j<tmp.length(); j++) {
//                char c = tmp.charAt(j);
//                cd = cd + mp.get(c);
//            }
//            if (!ansSt.contains(cd)) ansSt.add(cd);
//        }
//        return ansSt.size();
//    }
//    public static int RingsandRods(String rings) {
//        int c=0;
//        Map<Integer, String> mp = new HashMap<>();
//        for (int i=0; i<rings.length(); i+=2) {
//            char col = rings.charAt(i);
//            int no = Character.getNumericValue(rings.charAt(i+1));
//            if (mp.containsKey(no)) {
//                mp.put(no,mp.get(no)+col);
//            }
//            else {
//                mp.put(no,""+col);
//            }
//        }
//        for (int j : mp.keySet()) {
//            if (mp.get(j).contains("R") && mp.get(j).contains("B") && mp.get(j).contains("G")) c++;
//        }
//        return c;
//    }
//    public static List<String> CellsRangeExcelSheet(String s) {
//        List<String> lst = new ArrayList<>();
//        char c1 = s.charAt(0), c2 = s.charAt(3);
//        int n1 = Character.getNumericValue(s.charAt(1)), n2 = Character.getNumericValue(s.charAt(4));
//        for (char c=c1; c<=c2; c++) {
//            for (int n=n1; n<=n2; n++) {
//                String st = c+Integer.toString(n);
//                lst.add(st);
//            }
//        }
//        return lst;
//    }
//    public static String SmallestNo(String num, int k) {
//        if (num.length() == k) return "0";
//        int[] arr = new int[num.length()];
//        for (int i=0; i< num.length(); i++) {
//            arr[i] = Character.getNumericValue(num.charAt(i));
//        }
//        int sz = num.length()-k;
//        ArrayList<String> arrLst = new ArrayList<>();
//        StringBuffer str = new StringBuffer((num.length()-k)+1);
////        String ans;
//        for (int i=0; i<num.length()-k; i++) {
////            System.out.println(arr[i]);
//            String sSb = num.substring(i, i + sz);
//            arrLst.add(sSb);
//            System.out.println(sSb);
//        }
//        return "1";
//    }
    public static String sum(String a, String b) {
        if (a.length() != b.length()) {
            if (a.length() > b.length()) {
                int s = a.length()-b.length();
                String str = "0";
                for (int i=1; i<s; i++) {
                    str = str + "0";
                }
                b = str + b;
            }
            else {
                int s = b.length()-a.length();
                String str = "0";
                for (int i=1; i<s; i++) {
                    str = str + "0";
                }
                a = str + a;
            }
        }
        int i=a.length()-1, c=0;
        String ans = "";
        while (i>=0) {
            int as = Character.getNumericValue(a.charAt(i));
            int bs = Character.getNumericValue(b.charAt(i));
            if (as+bs+c == 3) {
                ans = "1" + ans;
                c = 1;
            }
            else if (as+bs+c == 2) {
                ans = "0" + ans;
                c = 1;
            }
            else if (as+bs+c == 1) {
                ans = "1" + ans;
                c = 0;
            }
            else {
                ans = "0" + ans;
                c = 0;
            }
            i--;
        }
        if (c==1) ans = "1" + ans;
        return ans;
    }
}
