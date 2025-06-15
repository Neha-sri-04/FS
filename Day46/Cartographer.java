/*
 * In the Kingdom of Arboran, the Great World Tree links numerous realms. 
Each realm may branch into two sub-realms through a Northern gate (N) or a Southern gate (S). 
The heart of the tree is Realm 1. A frontier realm is one without any outgoing gates, 
marking the edge of explored lands.

Your mission is to aid the Royal Cartographer by listing every route 
from each frontier realm back to Realm 1.

Input Format:
-------------
Line-1: Space-separated integers gives the tree in level-order, using -1 to mark a missing child.

Output Format:
--------------
Line-1: Return a list of paths, where each list is one frontier-to-root path.

Sample Input-1:
---------------
1 2 3 4 5 6 7 -1 -1 -1 -1 8 9

Sample Output-1:
----------------
[[4,2,1], [5,2,1], [8,6,3,1], [9,6,3,1], [7,3,1]]

Explanation:
------------
Given tree
        1
      /   \
     2     3
    / \   / \
   4  5  6   7
         / \
        8   9
The binary tree has five leaf-to-root paths:
4 —> 2 —> 1
5 —> 2 —> 1
8 —> 6 —> 3 —> 1
9 —> 6 —> 3 —> 1
7 —> 3 —> 1

 */