import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int c=sc.nextInt();
        Map<Integer,Integer> bindo=new LinkedHashMap<>();
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            bindo.put(a,bindo.getOrDefault(a,0)+1);
        }
        int[][]x=new int[bindo.size()][2];
        int idx=0;
        for(var t:bindo.entrySet()){
            x[idx][0]=t.getKey();
            x[idx][1]=t.getValue();
            idx++;
        }
        Arrays.sort(x,(o1,o2)->{
           if(o1[1]!=o2[1])return o2[1]-o1[1];
           return 0;
        });
        for(int i=0;i<x.length;i++){
            for(int j=0;j<x[i][1];j++){
                System.out.print(x[i][0]+" ");
            }
        }

    }
}
