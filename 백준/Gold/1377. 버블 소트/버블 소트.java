import java.util.*;
import java.io.*;
class idxData implements Comparable<idxData>{
    int v;
    int idx;
    public idxData(int v,int idx){
        this.v=v;
        this.idx=idx;
    }
    @Override
    public int compareTo(idxData o) {
        return this.v-o.v;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       int n=Integer.parseInt(br.readLine());
      idxData[] x=new idxData[n];
      for(int i=0;i<n;i++){
          int input=Integer.parseInt(br.readLine());
          x[i]=new idxData(input,i);
      }
      Arrays.sort(x);
      int max=0;
      for(int i=0;i<n;i++){
          max=Math.max(max,x[i].idx-i);
      }
      System.out.print(max+1);
    }
}
