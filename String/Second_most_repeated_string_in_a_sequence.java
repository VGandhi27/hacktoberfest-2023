//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            for(int i = 0;i<n;i++)
                arr[i] = sc.next();
            
            Solution ob = new Solution();
            
            System.out.println(ob.secFrequent(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    String secFrequent(String arr[], int N)
    {
        // your code here
        HashMap <String ,Integer> map = new HashMap<>(); 
        for (int i=0 ; i<N; i++){
            if (map.containsKey(arr[i])) {
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }
        
        // Access map
        int max = Collections.max(map.values()); 
        ArrayList<Integer> a = new ArrayList<>(); 
        for (Map.Entry<String, Integer> j : map.entrySet()) { 
            if (j.getValue() != max) { 
                a.add(j.getValue()); 
            } 
        } 
        Collections.sort(a); 
        for (Map.Entry<String, Integer> x : map.entrySet()) { 
            if (x.getValue() == a.get(a.size() - 1)) { 
                return x.getKey(); 
            } 
        } 
        return "-1"; 
    }
}