/*
 Given a string s, reverse only all the vowels in the 
string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can 
appear in both lower and upper cases, more than once.

Sample Input-1:
---------------
hello

Sample Output-1:
----------------
holle

Sample Input-2:
----------------
Keshavmemorial

Sample Output-2:
----------------
Kashivmomerael

 */
import java.util.*;
class ReverseVowels{
    public static char[] helper(String s,int n){
        int left=0;
        int right=n-1;
        char[] arr=s.toCharArray();
        List<Character> l=new ArrayList<>();
        l.add('a');
        l.add('e');
        l.add('i');
        l.add('o');
        l.add('e');
        while(left<=right){
            if(l.contains(arr[left]) && l.contains(arr[right])){
                char temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right--;
            }
            else if(l.contains(arr[left])){
                right--;
            }
            else{
                left++;
            }
        }
        return arr;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        char[] arr=helper(s,s.length());
        for(int i=0;i<s.length();i++){
            System.out.print(arr[i]);
        }
        sc.close();
    }
}