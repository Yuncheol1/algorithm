import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String[] word=new String[n];
        for(int i=0;i<n;i++){
            word[i]=sc.next();
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            Stack<Character> st=new Stack<>();
            for(int j=0;j<word[i].length();j++){
                if(st.isEmpty()||st.peek()!=word[i].charAt(j)){
                    st.push(word[i].charAt(j));
                }
                else if(st.peek()==word[i].charAt(j))st.pop();
            }
            if(st.size()==0)cnt++;
        }
        System.out.print(cnt);

    }
}