import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      Map<String,Integer>player=new TreeMap<>();
      for(int i=1;i<=n;i++){
          String str2=sc.next();
          String str=str2.substring(0,1);
          player.put(str,player.getOrDefault(str,0)+1);
      }
      Boolean b=false;
      for(var k:player.keySet()){
          if(player.get(k)>=5){
              b=true;
              System.out.print(k);
          }
      }
if(!b){
    System.out.print("PREDAJA");
}




    }
}