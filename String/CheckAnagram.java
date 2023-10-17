/* 
Link :- https://leetcode.com/problems/valid-anagram
*/

//Bruteforce : HashMaps for char and counts

//Rename this file to CheckAnagram.java
public class CheckAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean result = isAnagram(s, t);
        System.out.println("Anagrams" + result);
    }

    /*
    Only use one definition of isAnagram
     */

//Better : Use Auxiliary arrays with indices as alphabets

    public static boolean isAnagram(String s, String t) {
        int[] sArray = new int[26];
        int[] tArray = new int[26];
        if (s.length() != t.length())
            return false;

        for (int i = 0; i < s.length(); i++) {
            sArray[s.charAt(i) - 97]++;
            tArray[t.charAt(i) - 97]++;
        }

        for (int i = 0; i < 26; i++) {
            if (sArray[i] != tArray[i]) {
                return false;
            }
        }
        return true;
    }
}
