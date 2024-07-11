//package algorithm;
import java.io.*;
import java.util.*;
import java.util.Scanner;
public class  Main {
    public static void main(String[] args)throws IOException {
        Stack<Integer> stack=new Stack<>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int n,m;
        n=Integer.parseInt(br.readLine());
        m=Integer.parseInt(br.readLine());
        String[] str=br.readLine().split(" ");
        Integer[] arr=new Integer[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        int start_point=0;
        int end_point=n-1;
        int cnt=0;
        while(start_point<end_point){
            if(arr[start_point]+arr[end_point]<m)start_point++;
           else if(arr[start_point]+arr[end_point]==m) {
                cnt++;
                start_point++;
                end_point--;
            }
            else end_point--;
        }
        System.out.print(cnt);
    }
}