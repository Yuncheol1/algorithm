import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[]count=new int[26];
        char[]ans=new char[input.length()];
        for(int i=0;i<input.length();i++){
          count[input.charAt(i)-'A']++;
        }
        boolean odd=false;
        if(input.length()%2==0)odd=true;
        for(int i=0;i<26;i++){
            if(count[i]%2!=0){
                if(odd){
                    System.out.print("I'm Sorry Hansoo");
                    return;
                }
                else{
                    odd=true;
                }
                ans[input.length()/2]=(char)(i+'A');
                count[i]--;
            }
        }
        int start=0;
        int end=ans.length-1;
        for(int i=0;i<26;i++){
            while(count[i]>0){
                ans[start++]=(char)(i+'A');
                ans[end--]=(char)(i+'A');
                count[i]-=2;
            }
        }
        for(int i=0;i<ans.length;i++)System.out.print(ans[i]);
    }
}