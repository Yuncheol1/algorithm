import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[]arr=new int[n];
    for(int i=0;i<n;i++){
        arr[i]=sc.nextInt();
    }
    int x=sc.nextInt();
    Arrays.sort(arr);
    int start=0;
    int end=n-1;
    int cnt=0;
    while(start<end){
        int ans=arr[start]+arr[end];
        if(ans>x){
            end--;
            continue;
        }
        if(ans<x){
            start++;
            continue;
        }
        else{
            cnt++;
            end--;
        }
    }
    System.out.print(cnt);

    }
}