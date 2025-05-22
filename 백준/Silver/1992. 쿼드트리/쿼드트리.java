import java.io.BufferedReader;
import java.util.*;
import java.io.*;
public class Main {
    static StringBuilder sb=new StringBuilder();
    static int[][] x;

    public static void main(String[] args) throws IOException {
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       int n=Integer.parseInt(br.readLine());
        x = new int[n][n];
        for (int i = 0; i < n; i++) {
            String input=br.readLine();
            for(int j=0;j<n;j++){
                x[i][j]=input.charAt(j)-'0';
            }
        }
        QuadTree(0,0,n);
        System.out.println(sb);


    }
    static void QuadTree(int s,int e,int size){
        int c=check(s,e,size);
        if(c==0){
            sb.append(0);
            return;
        }
        if(c==1){
            sb.append(1);
            return;
        }
        int size2=size/2;
        sb.append('(');
        QuadTree(s,e,size2);
        QuadTree(s,e+size2,size2);
        QuadTree(s+size2,e,size2);
        QuadTree(s+size2,e+size2,size2);
        sb.append(')');
    }
    static int check(int s,int e,int size){
        int cnt=0;
        for(int i=s;i<s+size;i++){
            for(int j=e;j<e+size;j++){
                cnt+=x[i][j];
            }
        }
        if(cnt==0){
            return 0;
        }
        if(cnt==size*size){
            return 1;
        }
        return 2;
    }
}
