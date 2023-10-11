//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution 
{
    public:
    //Function to find a Mother Vertex in the Graph.
	void dfs(int i, vector<int>adj[], vector<bool> &vis){
        vis[i] = true;
        
        for(auto it: adj[i]){
            if(!vis[it]){
                dfs(it, adj, vis);
            }
        }
    }
    
	int findMotherVertex(int V, vector<int>adj[])
	{
	    // Code here
	    vector<bool>vis(V,false);
	    int possible_mother_vertex;
	    
	    for(int i=0;i<V;i++){
	        if(!vis[i]){
	            dfs(i,adj,vis);
	            possible_mother_vertex = i;
	        }
	    }
	    
	    for(int i=0;i<V;i++) vis[i]=false;
	    
	    dfs(possible_mother_vertex, adj, vis);
	    
	    for(int i=0;i<V;i++){
	        if(!vis[i]) return -1;
	    }
	    return possible_mother_vertex;
	}

};

};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int V, E;
		cin >> V >> E;
		vector<int>adj[V];
		for(int i = 0; i < E; i++){
			int u, v;
			cin >> u >> v;
			adj[u].push_back(v);
		}
		Solution obj;
		int ans = obj.findMotherVertex(V, adj);
		cout << ans <<"\n";
	}
	return 0;
}
// } Driver Code Ends