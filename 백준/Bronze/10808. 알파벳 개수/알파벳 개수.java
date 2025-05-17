import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException{
        Scanner sc=new Scanner(System.in);
       String w=sc.next();
        char a='a';
        for(int i=0;a+i<='z';i++){
           int cnt=0;
            for(int j=0;j<w.length();j++){
                if(w.charAt(j)==a+i){
                    cnt++;
                }
            }
            System.out.print(cnt+" ");
        }

    }
}