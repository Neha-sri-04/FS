/*
 * Tejaswi playing a game. Game has a display of N numbers in a row, nums[].
Tejaswi has to pick the numbers one after the other.

Once Tejaswi picks a number num[i], she will score num[i] points and 
the number will be disappared on the board, simultaneously all the numbers 
having the value num[i]+1 or num[i]-1 also disappears. 

Tejaswi has to select the numbers, such that no more numbers will be left over 
on the board.

Tejaswi wants to score maximum number of points.

Initially Tejaswi has 0 points with her.
Can you help Tejaswi to score maximum number of points.

Input Format:
-------------
Line-1 -> an integers N, number of numbers on the game board.
Line-2 -> N space separated integers, numbers on the game board nums[].

Output Format:
--------------
Print an integer as result, maximum score she can get.


Sample Input-1:
---------------
3
4 5 3

Sample Output-1:
----------------
8

Explanation: 
------------
Pick a number 5 to score 5 points, simultaneously 4 is disappeared from display.
Then, pick number 3 to score 3 points.
Totally 8 is the score.


Sample Input-2:
---------------
6
4 4 5 5 5 6

Sample Output-2:
----------------
15

Explanation: 
-------------
Delete 5 to earn 5 points, deleting both 4's and the 6.
Then, delete 5 again to earn 5 points, and 5 again to earn 5 points.
Totally 15 is the score.

Pick a number 5 to score 5 points, simultaneously all 4's and 6 are disappeared 
from display. Then, again pick the number 5 to score 5 points.
And again pick the number 5 to score 5 points. Totally 15 is the score.

 */
import java.util.*;
class MaximumScore{
    public static int helper(int[] arr){
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            m.put(arr[i],m.getOrDefault(arr[i],0)+1);
        }
        List<Integer> l=new ArrayList<>(m.keySet());
        Collections.sort(l);
        int n=l.size();
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            int curr=l.get(i);
            int points=curr*m.get(curr);
            if(i==0){
                dp[i]=points;
            }
            else if(curr==l.get(i-1)+1){
                int num=i>=2?dp[i-2]:0;
                dp[i]=Math.max(dp[i-1],num+points);
            }
            else{
                dp[i]=dp[i-1]+points;
            }
        }
        return dp[n-1];
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(helper(arr));
        sc.close();
    }
}