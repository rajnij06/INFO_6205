public class Compression {
    public static void main (String[] args) {
//        String str = "aabcccccaaa"; //"a2b1c5a3"
        String str = "ab";        //"ab"
        System.out.println(compressString(str));
    }
    public static String compressString(String str) {
        String ans = "";
        if (str.length() == 1) {
            ans = ans + str.charAt(0);
        }
        int index = 0;
        for (int i=0; i<str.length(); i++) {
            int c = 1;
            if (i+1 != str.length()) {
                int j = i + 1;
                while (str.charAt(i) == str.charAt(j)) {
                    i++; j++; c++;
                    if (j == str.length()) break;
                }
            }
            ans = ans + str.charAt(i);
            index++;
            String s = String.valueOf(c);
            for (int k=0; k<s.length(); k++) {
                ans = ans + s.charAt(k);
                index++;
            }
        }
        String n = ans.replace("1","");
        if (str.length() == n.length()) return str;
        for (int i=0; i<str.length(); i++) {
            String s = str.substring(0, ans.length());
            str = str.replace(s,ans);
        }
        return str.substring(0,ans.length());
    }
}