package Day48;
/*
 * Bablu is working in a construction field.
He has N number of building blocks, where the height and width of all the blocks are same.
And the length of each block is given in an array, blocks[].

Bablu is planned to build a wall in the form of a square.
The rules to cunstruct the wall are as follows:
	- He should use all the building blocks.
	- He should not break any building block, but you can attach them with other.
	- Each building-block must be used only once.
	
Your task is to check whether Bablu can cunstruct the wall as a square
with the given rules or not. If possible, print true. Otherwise, print false.

Input Format:
-------------
Line-1: An integer N, number of BuildingBlocks.
Line-2: N space separated integers, length of each block.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
6
1 2 6 4 5 6

Sample Output-1:
----------------
true


Sample Input-2:
---------------
6
5 3 2 5 5 6

Sample Output-2:
----------------
false
 */
import java.util.*;
class BlocksToSquare{
    public static boolean helper(int[] arr,int n){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        if(sum%4!=0){
            return false;
        }
        int[] sides=new int[4];
        return backtrack(sum/4,arr,0,sides);
        
    }
    public static boolean backtrack(int target,int[] arr,int index,int[] sides){
        if(index==arr.length){
            return sides[0]==target && sides[1]==target && sides[2]==target && sides[3]==target;
        }
        for(int i=0;i<4;i++){
            if(sides[i]+arr[index]<=target){
                sides[i]+=arr[index];
                if(backtrack(target,arr,index+1,sides)){
                    return true;
                }
                sides[i]-=arr[index];
            }
            if(sides[i]==0){
                break;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(helper(arr,n));
		sc.close();
    }
}

