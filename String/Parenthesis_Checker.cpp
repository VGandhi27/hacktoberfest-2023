//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution
{
    public:
    //Function to check if brackets are balanced or not.
    bool ispar(string x)
    {
        // Your code here
        bool match(char c1, char c2) {
        return ((c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']'));
    }
    bool ispar(string str) {
        stack<char>s;
        for(int i = 0; i < str.length(); i++) {
            if(str[i] == '(' || str[i] == '{' || str[i] == '[') s.push(str[i]);
            else {
                if(s.empty() || !(match(s.top(), str[i]))) return false;
                else s.pop();
            }
        }
         return s.empty();
    }

};

//{ Driver Code Starts.

int main()
{
   int t;
   string a;
   cin>>t;
   while(t--)
   {
       cin>>a;
       Solution obj;
       if(obj.ispar(a))
        cout<<"balanced"<<endl;
       else
        cout<<"not balanced"<<endl;
   }
}
// } Driver Code Ends