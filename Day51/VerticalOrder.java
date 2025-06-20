/*
 * Imagine you are a librarian organizing books on vertical shelves in a grand library. 
The books are currently scattered across a tree-like structure, 
where each book (node) has a position determined by its shelf number (column) 
and row number (level).

Your task is to arrange the books on shelves so that:
1. Books are placed column by column from left to right.
2. Within the same column, books are arranged from top to bottom (i.e., by row).
3. If multiple books belong to the same shelf and row, they should be arranged from left to right, just as they appear in the original scattered arrangement.

Sample Input-1:
---------------
3 9 20 -1 -1 15 7

Sample Output-1:
----------------
[[9],[3,15],[20],[7]]

Explanation:
         3
       /   \
      9     20
          /    \
         15     7

Shelf 1: [9]
Shelf 2: [3, 15]
Shelf 3: [20]
Shelf 4: [7]

Sample Input-2:
---------------
3 9 8 4 0 1 7

Sample Output-2:
----------------
[[4],[9],[3,0,1],[8],[7]]

Explanation:
          3
       /     \
      9       8
    /   \   /   \
   4     0 1     7

Shelf 1: [4]
Shelf 2: [9]
Shelf 3: [3, 0, 1]
Shelf 4: [8]
Shelf 5: [7]

Library Organization Rules:
1. Each column represents a shelf from left to right.
2. Books on the same shelf are arranged from top to bottom.
3. If books share the same position, they are arranged left to right in order of appearance.
 */

 import java.util.*;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
}
class Solution
{
	public List<List<Integer>> verticalOrder(TreeNode root) {
		//WRITE YOUR CODE HERE AND RETURN THE LIST
		List<List<Integer>> list=new ArrayList<>();
		if(root==null){
		    return list;
		}
		Map<Integer,List<Integer>> m=new TreeMap<>();
		Queue<Integer> index=new LinkedList<>();
		Queue<TreeNode> value=new LinkedList<>();
		index.offer(0);
		value.offer(root);
		while(!index.isEmpty()){
		    int ind=index.poll();
		    TreeNode v=value.poll();
		    if(!m.containsKey(ind)){
	           List<Integer> l=new ArrayList<>();
	            l.add(v.val);
	            m.put(ind,l);
	        }
	        else{
	            List<Integer> l=m.get(ind);
	            l.add(v.val);
	            m.put(ind,l);
	        }
	        if(v.left!=null){
	            index.offer(ind-1);
	            value.offer(v.left);
	        }
	        if(v.right!=null){
	            index.offer(ind+1);
	            value.offer(v.right);
	        }
		}
		for(Map.Entry<Integer,List<Integer>> e:m.entrySet()){
		    list.add(e.getValue());
		}
		return list;
	}
}
public class VerticalOrder {
    
    public static TreeNode buildTree(List<Integer> data) {
        if (data.isEmpty() || data.get(0) == -1) return null;
        
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(data.get(0));
        queue.offer(root);
        
        int i = 1;
        while (i < data.size()) {
            TreeNode current = queue.poll();
            
            if (i < data.size() && data.get(i) != -1) {
                current.left = new TreeNode(data.get(i));
                queue.offer(current.left);
            }
            i++;
            
            if (i < data.size() && data.get(i) != -1) {
                current.right = new TreeNode(data.get(i));
                queue.offer(current.right);
            }
            i++;
        }
        
        return root;
    }
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        List<Integer> data = new ArrayList<>();
        for(String s:input) {
            data.add(Integer.parseInt(s));
        }
        scanner.close();
        
        TreeNode root = buildTree(data);
        
        System.out.println(new Solution().verticalOrder(root));
        scanner.close();
    }
}
