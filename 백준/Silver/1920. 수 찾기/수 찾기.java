
import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] x = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] y = new int[m];
        for (int i = 0; i < m; i++) {
            y[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(x);
        for(int i=0;i<m;i++){
        if(Arrays.binarySearch(x,y[i])>=0)sb.append("1\n");
        else sb.append("0\n");

        }

        System.out.print(sb);

    }


}
