/*
 * You're hiking along a beautiful mountain trail, and the elevation at each point is recorded in an array heights, 
where each element represents the height at that specific point.
A scenic peak is a spot on the trail that is not lower than its immediate neighbors. 
That means it either stands higher than those beside it or is at the start or end of the trail and not lower than its single neighbor.

Your goal is to identify any one such scenic peak and return its elevation (value).

Input Format:
-------------
Line-1: An integer n, the size of the array
Line-2: A list of n space-separated integers representing heights

Output Format:
-------------
Line-1: The elevation value of any one scenic peak

Sample Input-1:
-------------
5
2 4 6 3 1

Sample Output-1:
-------------
6

Sample Input-2:
-------------
6
1 3 20 4 1 0

Sample Output-2:
-------------
20

Sample Input-3:
-------------
4
10 8 6 4

Sample Output-3:
-------------
10


 Constraints:
-------------
-> 1 ≤ n ≤ 10^5
-> -10^9 ≤ heights[i] ≤ 10^9
-> n must be greater than or equal to 1
-> There will always be at least one scenic peak in the array
-> Output must be a single elevation value from the array that qualifies as a scenic peak
-> An efficient approach is expected, ideally O(log n)

 */
import java.util.*;
class ScenicPeak{
    public static int peak(int[] arr,int n){
        if(n==1){
            return arr[0];
        }
        int left=0;
        int right=n-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(mid>0 && mid<n-1){
                if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]){
                    return arr[mid];
                }
                else if(arr[mid]>arr[mid+1] && arr[mid]<arr[mid-1]){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
            else{
                if(mid==0){
                    if(arr[mid]>arr[mid+1]){
                        return arr[mid];
                    }
                    else{
                        return arr[mid+1];
                    }
                }
                else if(mid==n-1){
                    if(arr[mid]>arr[mid-1]){
                        return arr[mid];
                    }
                    else{
                        return arr[mid-1];
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];    
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(peak(arr,n));
        sc.close();
    }
}