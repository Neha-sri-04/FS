/*
 * You are a robot explorer navigating a vast digital maze stored as a string of digits. 
Each digit or pair of digits on the path represents a movement instruction, 
which translates to a specific direction using the following map:

"1" → Move 'A'

"2" → Move 'B'

...

"26" → Move 'Z'

However, the maze has tricky encoding rules.
Sometimes a single digit can be read alone, and sometimes two digits together 
form a valid move — but not every combination is valid. 
For example, "05" is invalid, while "5" is fine. 
Your robot can only navigate using valid instruction steps, and you must 
find how many unique navigation sequences the robot can follow to reach the end of the maze.

Given the string s of digits, determine the total number of distinct ways the robot 
can interpret and follow the path from start to end without making an invalid move.

If no valid navigation is possible, return 0.


Input Format:
-------------
A string s.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
123

Sample Output-1:
----------------
3

Explanation:
------------
123 can be converted as: ABC, LC, AW


Sample Input-2:
---------------
326

Sample Output-2:
----------------
2

Explanation:
------------
326 can be converted as: CBF, CZ
 */
import java.util.*;
class DigitalMaze{
    public static int count(String s){
        if(s.length()==0){
            return 0;
        }
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        dp[1]=s.charAt(0)!='0'?1:0;
        for(int i=2;i<=s.length();i++){
            if(s.charAt(i-1)!='0'){
                dp[i]+=dp[i-1];
            }
            if(s.charAt(i-2)!='0'){
                String sub=s.substring(i-2,i);
                int num=Integer.parseInt(sub);
                if(num>=1 && num<=26){
                    dp[i]+=dp[i-2];
                }
            }
        }
        return dp[s.length()];
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(count(s));
    }
}