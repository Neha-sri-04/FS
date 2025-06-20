/*
 * You are given a string S representing a positive integer and an integer k. Your task is to find the smallest possible number that can be formed by performing at most k swaps between any two digits of the string.
If k == 0, return the original number.
If the number is already the smallest possible permutation, return it as-is.
If the input is null or empty, return it unchanged.

A swap operation means exchanging the positions of any two digits (not necessarily adjacent). Each swap counts as one operation. The goal is to minimize the number.

Input Format:
-----------
A string S of digits (1 ≤ S.length ≤ 10)
An integer k (0 ≤ k ≤ 10) representing the number of allowed swaps.

Output Format:
------------
A string representing the smallest number possible after performing at most k swaps.

Constraints:
--------------
1 ≤ length(S) ≤ 10
0 ≤ k ≤ 10
Digits are in the range '0' to '9'
No leading zeros in input unless the number is exactly "0"
Each swap counts as 1 operation, regardless of position

Sample Input-1:
------------
934651
2

Sample Output-1:
----------------
134569

Sample Input-2:
-------------
11111
3
Sample Output-2:
--------------
11111
 */

import java.util.*;
class MinNumber{
    String minString;
    public String helper(String n,int k){
        if(n==null || k==0){
            return n;
        }
        minString=n;
        backtrack(n.toCharArray(),k,0);
        return minString;
    }
    public void backtrack(char[] arr,int k,int index){
        if(k==0 || index==arr.length){
            String str=new String(arr);
            if(str.compareTo(minString)<0){
                minString=str;
            }
            return;
        }
        char min=arr[index];
        for(int i=index+1;i<arr.length;i++){
            if(min>arr[i]){
                min=arr[i];
            }
        }
        if(min==arr[index]){
            backtrack(arr,k,index+1);
            return;
        }
        for(int i=index+1;i<arr.length;i++){
            if(min==arr[i]){
                swap(arr,index,i);
                backtrack(arr,k-1,index+1);
                swap(arr,index,i);
            }
        }
    }
    public void swap(char[] arr,int i,int j){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        MinNumber obj=new MinNumber();
        String n=sc.next();
        int k=sc.nextInt();
        System.out.println(obj.helper(n,k));
        sc.close();
    }
}