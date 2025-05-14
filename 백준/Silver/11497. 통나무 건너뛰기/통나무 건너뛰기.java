import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
           Scanner sc=new Scanner(System.in);
           int T=sc.nextInt();
           for(int test=0;test<T;test++){
               int n=sc.nextInt();
               int[]temp=new int[n];
               for(int i=0;i<n;i++) {
                   temp[i] = sc.nextInt();
               }
               Arrays.sort(temp);
               int[]x=new int[n];
               int s=0;
               int e=n-1;
               int idx=0;
               while(s<=e){
                   x[s++]=temp[idx++];
                   if(idx==n)break;
                   x[e--]=temp[idx++];
                   if(idx==n)break;
               }
               int max=Math.abs(x[0]-x[n-1]);
                for(int i=0;i<n-1;i++){
                    max=Math.max(max,Math.abs(x[i]-x[i+1]));
                }
               System.out.println(max);
           }

    }
}

