import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] x;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] city = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                city[i][j] = sc.nextInt();
            }
        }
        int []travel=new int[m+1];
        for(int i=1;i<=m;i++)travel[i]=sc.nextInt();
        x=new int[n+1];
        for(int i=1;i<=n;i++)x[i]=i;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(city[i][j]==1)union(i,j);
            }
        }
        int idx=find(travel[1]);
        for(int i=2;i<=m;i++){
            if(idx!=find(travel[i])){
                System.out.print("NO");
            return;
            }
        }
        System.out.print("YES");
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) x[b] = a;
    }

    static int find(int a) {
        if (x[a] == a) return a;
        else return x[a] = find(x[a]);
    }
}
