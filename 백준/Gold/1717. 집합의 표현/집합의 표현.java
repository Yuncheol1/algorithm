import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Main {
    static int[]x;
    static void union(int a,int b){
        a=find(a);
        b=find(b);
        if(a!=b)x[b]=a;
    }
    static int find(int a) {
        if (a == x[a]){
            return a;
        }
        else{
            return x[a]=find(x[a]);
        }
    }
    static boolean same(int a,int b){
        int ans1=find(a);
        int ans2=find(b);
        if(ans1==ans2)return true;
        else return false;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        x=new int[n+1];
        for(int i=0;i<n+1;i++)x[i]=i;
        for(int i=0;i<m;i++){
            int q=sc.nextInt();
            int a=sc.nextInt();
            int b=sc.nextInt();

            if(q==0){
                union(a,b);
            }
            else{

               if(same(a,b))System.out.println("yes");
               else System.out.println("no");
            }
        }

    }
}
