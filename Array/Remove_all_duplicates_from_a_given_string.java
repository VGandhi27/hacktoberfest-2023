//{ Driver Code Starts
//Initial Template for Java



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String str = br.readLine().trim();

            String ans = new Solution().removeDuplicates(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    String removeDuplicates(String str) {
        // code here
        int n =str.length();
        String output="";
        int i = 0;
        int j = 0;
        for( i =0;i<n ;i++) {
            for( j =0;j<i;j++){
                if(str.charAt(i)==str.charAt(j)){
                    break;
                }
            }
            if(j==i){
                output+=str.charAt(i);
            }
            
        }
         return output;   
    }
}

