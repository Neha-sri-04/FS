/*
 * Malika taught a new fun time program practice for Engineering Students.
As a part of this she has given set of N numbers, and asked the students 
to perform the operations listed below:
1. sumRange(start, end) - return the sum of numbers between the indices start and end, both are inclusive.
2. update(ind, val) - update the value at the index 'ind' to 'val'.

Your task is to solve this problem using Fenwick Tree concept.

Input Format:
-------------
Line-1: Two integers N and Q, size of the array(set of numbers) and query count.
Line-2: N space separated integers.
next Q lines: Three integers option, start/ind and end/val.

Output Format:
--------------
An integer result, for every sumRange query.


Sample Input-1:
---------------
8 5
1 2 13 4 25 16 17 8
1 2 6		//sumRange
1 0 7		//sumRange
2 2 18	//update
2 4 17	//update
1 2 7		//sumRange

Sample Output-1:
----------------
75
86
80



Sample Input-2:
---------------
8 5
1 2 13 4 25 16 17 8
1 2 6		
1 0 7		
2 2 18	
2 4 17	
1 0 7

Sample Output-2:
----------------
75
86
83

 */
import java.util.*;
class FenWickTree{
    int n;
    int[] arr;
    int[] BIT;
    public FenWickTree(int[] arr){
        this.arr=arr;
        n=arr.length;
        BIT=new int[n+1];
        for(int i=0;i<n;i++){
            init(i,arr[i]);
        }
    }
    public void init(int i,int val){
        i++;
        while(i<=n){
            BIT[i]+=val;
            i+=(i&-i);
        }
    }
    public void update(int i,int val){
        int diff=val-arr[i];
        arr[i]=val;
        init(i,diff);
    }
    public int sumRange(int start,int end){
        return getSum(end)-getSum(start-1);
    }
    public int getSum(int i){
        i++;
        int sum=0;
        while(i>0){
            sum+=BIT[i];
            i-=(i&-i);
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ops=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        FenWickTree f=new FenWickTree(arr);
        while(ops-->0){
            int opt=sc.nextInt();
            if(opt==1){
                int s1=sc.nextInt();
                int s2=sc.nextInt();
                System.out.println(f.sumRange(s1,s2));
            }
            else{
                int index=sc.nextInt();
                int value=sc.nextInt();
                f.update(index,value);
            }
        }
        sc.close();
    }
}