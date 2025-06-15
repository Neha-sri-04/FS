package Day47;
/*
 * Imagine you're a top-secret agent receiving an encrypted directive from headquarters. 
The message comes as a string of digits, 
and each digit (from 2 to 9) is a cipher for a set of potential code letters. 

To uncover the true instruction, you must translate the string into 
every possible combination of letters by substituting each digit with 
its corresponding set of letters. The final decoded messages listed in lexicographycal order.

Below is the mapping of digits to letters (as found on a traditional telephone keypad):

| Digit | Letters       |
|-------|---------------|
| 2     | a, b, c       |
| 3     | d, e, f       |
| 4     | g, h, i       |
| 5     | j, k, l       |
| 6     | m, n, o       |
| 7     | p, q, r, s    |
| 8     | t, u, v       |
| 9     | w, x, y, z    |

Note: The digit 1 does not correspond to any letters.

Input Format:
-------------
Line-1: A string, represents the message (2-9 inclusive)

Output Format:
--------------
Line-1: List of valid combination

Sample Input-1:
---------------
23

Sample Output-1:
----------------
[ad, ae, af, bd, be, bf, cd, ce, cf]


Sample Input-2: 
---------------
2

Sample Output-2:
----------------
[a, b, c]


Constraints:
------------
- 0 <= digits.length <= 4  
- Each digit in the input is between '2' and '9'.
 */

import java.util.*;
class LetterCombo{
    public static void helper(String s,Map<Character,String> h,String temp,int index,List<String> l){
        if(temp.length()==s.length()){
            l.add(temp);
            return;
        }
        String str=h.get(s.charAt(index));
        for(int i=0;i<str.length();i++){
            helper(s,h,temp+str.charAt(i),index+1,l);
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        Map<Character,String> h=new HashMap<>();
        h.put('2',"abc");
        h.put('3',"def");
        h.put('4',"ghi");
        h.put('5',"jkl");
        h.put('6',"mno");
        h.put('7',"pqrs");
        h.put('8',"tuv");
        h.put('9',"wxyz");
        List<String> l=new ArrayList<>();
        helper(s,h,"",0,l);
        System.out.print(l);
        sc.close();
    }
}