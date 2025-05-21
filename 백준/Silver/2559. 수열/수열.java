import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] x = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
        }
        long sum=0;
        for(int i=0;i<K;i++){
            sum+=x[i];
        }
        if(N==K){
            System.out.print(sum);
            return;
        }
        long max=sum;
        for(int i=1;;i++){
            if(i+K-1>=N)break;
            sum-=x[i-1];
            sum+=x[i+K-1];
            max=Math.max(max,sum);
         //   System.out.println("sum = "+sum);
        }
        System.out.println(max);
    }
}