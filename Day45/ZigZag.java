/*
 * A software engineer is designing a display panel that arranges characters of a given string 
in a decorative wave pattern across multiple lines. 

The panel has k horizontal rows, and characters are written in a downward and then upward zigzag fashion across these rows.
Once all characters are placed in the wave pattern, the engineer wants to read the characters row by row 
to generate the final output that will be printed on the screen.

Input Format:
---------------
Line-1: A string `S` (the message to display)
Line-2: An integer `k` representing the number of rows on the display

Sample Format:
----------------------   
A string — the message as it appears when read row-by-row from the wave pattern

Explanation
------------
We are given a string and a number k, and we want to print the string as if it's written in a zigzag across k rows.

Example 
Input: "THISPROBLEMISAWESOME", k = 4
Row0:   T      	       O       	  A           E
Row1:      H         R   L      S   W       M
Row2:          I   P   	  E   I       E   O]
Row3:            S          M           S
Reading row by row:

Output: TOWHLBSMIPEAESM

Sample input: 
----------------
ZIGZAGPATTERN
3
Sample Output:
-----------------
ZATNIZGATRGPE

 */

import java.util.*;
class Main{
    public static String helper(String s,int rows){
        if(rows==1 || rows>=s.length()){
            return s;
        }
        StringBuilder[] sb=new StringBuilder[rows];
        for(int i=0;i<rows;i++){
            sb[i]=new StringBuilder();
        }
        int cur=0;
        boolean down=false;
        for(int i=0;i<s.length();i++){
            sb[cur].append(s.charAt(i));
            if(cur==0 || cur==rows-1){
                down=!down;
            }
            if(down){
                cur+=1;
            }
            else{
                cur-=1;
            }
        }
        StringBuilder st=new StringBuilder();
        for(int i=0;i<rows;i++){
            st.append(sb[i]);
        }
        return st.toString();
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int rows=sc.nextInt();
        System.out.println(helper(s,rows));
        sc.close();
    }
}