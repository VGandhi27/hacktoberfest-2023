//{ Driver Code Starts
    import java.io.*;

    import java.util.*;
    
    class Main {
        
        public static void main (String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
            while(t-->0){
                //size of array
                int n = Integer.parseInt(br.readLine().trim());
                int arr[] = new int[n];
                String inputLine[] = br.readLine().trim().split(" ");
                
                //adding elements
                for(int i=0; i<n; i++){
                    arr[i] = Integer.parseInt(inputLine[i]);
                }
                
                Solution obj = new Solution();
                
                //calling maxSubarraySum() function
                System.out.println(obj.maxSubarraySum(arr, n));
            }
        }
    }
    
    
    // } Driver Code Ends
    
    
    class Solution{
    
        // arr: input array
        // n: size of array
        //Function to find the sum of contiguous subarray with maximum sum.
        long maxSubarraySum(int arr[], int n){
            
            long currentSum=0;
            long maxSum=arr[0];
            for(int i=0;i<n;i++){
                currentSum=currentSum+arr[i];
                if(currentSum>maxSum){
                    maxSum=currentSum;
                }
                if(currentSum<0){
                    currentSum=0;
                }
            }
            return maxSum;
            
        }
        
    }
    
    