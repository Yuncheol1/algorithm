import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]x=new int[n];
        for(int i=0;i<n;i++){
            x[i]=sc.nextInt();
        }
        Stack<Integer>st=new Stack<>();
        long ans=0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&st.peek()<=x[i]){
                st.pop();
            }
            st.push(x[i]);
            ans+=st.size()-1;
        }
        System.out.print(ans);

    }
}