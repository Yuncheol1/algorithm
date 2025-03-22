import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] x=new int[n+1];
        ArrayList<ArrayList<Integer>> tall = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tall.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            tall.get(a).add(b);
            x[b]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(x[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int now=q.poll();
            System.out.print(now+" ");
            for( var t:tall.get(now)){
            x[t]--;
                if(x[t]==0)q.add(t);
            }

        }


    }
}