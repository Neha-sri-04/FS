package Day32;
// Program to implement Disjoint Set Data Structure.
/*
5 = number of friends
3 = number of relationships
2 = number of friendship check
input=5
3
0 2
4 2
3 1
2
4 0
1 0
output=4 is a friend of 0
1 is not a friend of 0

*/
import java.util.*;

class DisjointUnionSets {
	int[] rank, parent;
	int n;

	public DisjointUnionSets(int n){
		rank = new int[n];
		parent = new int[n];
		this.n = n;
		makeSet();
	}
	// Creates n sets with single item in each
	void makeSet(){
		for(int i=0;i<n;i++){
		    parent[i]=i;
		}
	}

	// Returns representative of x's set
	int find(int x){
		if(parent[x]!=x){
		    return find(parent[x]);
		}
		return x;
	}

	// Unites the set that includes x and the set that includes x
	void union(int x, int y){
	    int xRoot=find(x);
	    int yRoot=find(y);
	    if(xRoot==yRoot){
	        return;
	    }
	    if(rank[xRoot]>rank[yRoot]){
	        parent[yRoot]=xRoot;
	    }
	    else if(rank[xRoot]<rank[yRoot]){
	        parent[xRoot]=yRoot;
	    }
	    else{
	        parent[yRoot]=xRoot;
	        rank[xRoot]++;
	    }
	}
}

class test {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		DisjointUnionSets dus=new DisjointUnionSets(n);
		int s=sc.nextInt();
		for(int i=0;i<s;i++){
		    dus.union(sc.nextInt(),sc.nextInt());
		}
		int c=sc.nextInt();
		for(int i=0;i<c;i++){
		    int m=sc.nextInt();
		    int na=sc.nextInt();
		    int a=dus.find(m);
		    int b=dus.find(na);
		    if(a==b){
		        System.out.println(m+" is a friend of "+na);
		    }
		    else{
		        System.out.println(m+" is not a friend of "+na);
		    }   
		}
		sc.close();
	}
}
