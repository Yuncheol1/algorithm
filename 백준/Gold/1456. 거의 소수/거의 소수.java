import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
    //    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     StringTokenizer st = new StringTokenizer(br.readLine());
        Scanner sc=new Scanner(System.in);
        long m=sc.nextLong();
        long n=sc.nextLong();
        long []x=new long[10000001];
        for(int i=2;i<x.length;i++)x[i]=i;
        for(int i=2;i<=Math.sqrt(x.length);i++){
            if(x[i]!=0){
                for(int j=i+i;j<x.length;j+=i)x[j]=0;
            }
        }
        int cnt=0;
        for(int i=2;i<10000001;i++){
            if(x[i]!=0){
                long tmp=x[i];
                while((double)x[i]<=(double)n/(double)tmp){
                    if((double)x[i]>=(double)m/(double)tmp){
                        cnt++;
                    }
                    tmp=tmp*x[i];
                }
            }
        }
        System.out.println(cnt);
    }
}