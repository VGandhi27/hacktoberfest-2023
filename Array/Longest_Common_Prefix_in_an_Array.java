//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestCommonPrefix(String arr[], int n){
  
    // Arrays.sort(arr);
    // n =arr.length-1;
    // String compre="";
    // for(int i = 0; i<Math.min(arr[0].length(),arr[n].length());i++){
            
    //         if( arr[0].charAt(i) == arr[n].charAt(i)){
    //             compre += arr[0].charAt(i);
    //         }else{
    //             break;
    //         }
            
    //     }
     
    //         if(compre.isEmpty())
    //             return "-1";
    //         else 
    //         return compre;
    // }
    
    int minimumLengthWord=Integer.MAX_VALUE;
        String minimumWord="";
        boolean flag=true;
        String result="";
        for(int i=0;i<arr.length;i++){
            if(arr[i].length()<minimumLengthWord){
                minimumLengthWord= arr[i].length();
                 minimumWord= arr[i];
            }
        }
        
        for(int i=0;i<minimumLengthWord;i++){
       
        for(int j=0;j<arr.length;j++){
            if(minimumWord.charAt(i)!=arr[j].charAt(i) ){
                flag=false;
            }
            
        }
        if(flag){
            result=result+minimumWord.charAt(i);
            
        }
      
        
        }
        
        
        // System.out.print(minimumLengthWord+"   "+thatword);
        return result.length()==0?"-1":result;

    
    
    
    
    
    
    }
}