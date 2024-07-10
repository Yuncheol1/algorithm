//package algorithm;
import java.io.*;
import java.util.*;
import java.util.Scanner;
public class  Main {
    public static void main(String[] args)throws IOException {
        Stack<Integer> stack=new Stack<>();
        Scanner sc=new Scanner(System.in);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        String []str=br.readLine().split(" ");
        int[] input =new int[n];
        int[] ans =new int[n];

        for(int i=0;i<n;i++){
            input[i]=Integer.parseInt(str[i]);
        }
stack.push(0);
        for(int i=1;i<n;i++){
            while(!stack.empty()&&input[stack.peek()]<input[i]){
                ans[stack.pop()]=input[i];
            }
            stack.push(i);
        }
while(!stack.empty()){
    ans[stack.pop()]=-1;
}
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0;i<n;i++)bw.write(ans[i]+" ");

    bw.flush();

    }
}