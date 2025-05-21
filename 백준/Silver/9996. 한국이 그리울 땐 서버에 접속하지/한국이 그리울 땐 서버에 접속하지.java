import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      String pattern=sc.next();
      String[]str=new String[n];
      for(int i=0;i<n;i++){
          str[i]=sc.next();
      }
      //케이스 나누기
      if(pattern.charAt(0)=='*'){//*이 첫번째일때
          String p=pattern.substring(1);
          for(int i=0;i<n;i++){
              if(p.equals(str[i])){
                  System.out.println("DA");
                  continue;
              }
              if(str[i].length()<p.length()){
                  System.out.println("NE");
                  continue;
              }
              String s=str[i].substring(str[i].length()-p.length());
              if(p.equals(s)){
                  System.out.println("DA");
              }
              else{
                  System.out.println("NE");
              }
          }
      }
      else if(pattern.charAt(pattern.length()-1)=='*'){//*이 마지막일때
            String p=pattern.substring(0,pattern.length()-1);
            for(int i=0;i<n;i++){
                if(p.equals(str[i])){
                    System.out.println("DA");
                    continue;
                }
                if(str[i].length()<p.length()){
                    System.out.println("NE");
                continue;
                }
                String s=str[i].substring(0,p.length());
                if(p.equals(s)){
                    System.out.println("DA");
                }
                else{
                    System.out.println("NE");
                }
            }
      }
      else{ //*이 중간에 있을때
          int star=0;
          for(int i=0;i<pattern.length();i++){
            if(pattern.charAt(i)=='*'){
                star=i;
                break;
            }
        }
        String p1=pattern.substring(0,star);
        String p2=pattern.substring(star+1);
        String p3=p1+p2;
        for(int i=0;i<n;i++){
            if(p3.equals(str[i])){
                System.out.println("DA");
                continue;
            }
            if(str[i].length()<p3.length()){
                System.out.println("NE");
                continue;
            }
            String s1=str[i].substring(0,p1.length());
            String s2=str[i].substring(str[i].length()-p2.length());
            if(s1.equals(p1)&&s2.equals(p2)){
                System.out.println("DA");
            }
            else{
                System.out.println("NE");
            }
        }


      }








    }
}