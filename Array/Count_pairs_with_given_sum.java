//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().getPairsCount(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        // code here
      HashMap <Integer,Integer> map= new HashMap<>();
      int output = 0;
      
    //   for(int i=0;i<n;i++) {
    //      int c = k - arr[i]
    //       for(int j =i+1; j<n ;j++){
    //           if(arr[i]+ arr[j] != k)
    //           i++;
    //           else if(!map.containsKey(i))
    //          {
    //              output += 1;
    //               map.put(i,j);
    //           }
    //           else if (j == map.get(i))
    //           i++;
    //           else{
                  
    //               map.put(i,j);
    //               output += 1;
    //           }
    //       }
    //   }
 
        for (int i =0 ; i< n; i++){
            int c = k - arr[i];
            if (map.containsKey( c ) ) {
                output += map.get( c );
            }
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else
            {
                map.put(arr[i],1);
            }
        }
      // count no keys present in hash table
      return output;
    }
}
 