import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Map<String,Integer> pkm=new TreeMap<String,Integer>();
        Map<Integer,String> pkm2=new TreeMap<Integer,String>();
        for(int i=1;i<=N;i++){
            String p=sc.next();
            pkm.put(p,i);
            pkm2.put(i,p);
        }
        for(int i=0;i<K;i++){
            String s=sc.next();
            if(!pkm.containsKey(s)){
                int a=Integer.parseInt(s);
                System.out.println(pkm2.get(a));
            }
            else{
                System.out.println(pkm.get(s));
            }
        }



    }
}