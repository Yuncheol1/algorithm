import java.io.BufferedReader;
import java.util.*;
import java.io.*;
/*
D는 앞에꺼 삭제
만약 R이 되면
D는 뒤에꺼 삭제
R이 짝수면 그냥 출력, 홀수면 뒤집어서 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    int T=Integer.parseInt(br.readLine());
    for(int test=0;test<T;test++){
        boolean empty=false;
        ArrayList<Integer>x=new ArrayList<>();
        String func=br.readLine();
        int n=Integer.parseInt(br.readLine());
        String arr=br.readLine();
        int idx=1;
        for(int i=1;i<arr.length();i++){
            if((arr.charAt(i)==','||arr.charAt(i)==']')&&n!=0){
                String num=arr.substring(idx,i);
                x.add(Integer.valueOf(num));
                idx=i+1;
            }
        }

        boolean delete=false;
        int cnt=0;
        for(int i=0;i<func.length();i++){
            if(func.charAt(i)=='R'){
                cnt++;
                if(!delete) {
                    delete = true;
                    continue;
                }
                if(delete){
                    delete=false;
                    continue;
                }
            }
            if(func.charAt(i)=='D'){
                if(x.isEmpty()){
                    empty=true;
                    System.out.println("error");
                    break;
                }
                if(!delete&&!x.isEmpty()){
                    x.remove(0);
                }
                if(delete&&!x.isEmpty()){
                    x.remove(x.size()-1);
                }
            }
        }
        if(cnt%2!=0){
            Collections.reverse(x);
        }
        if(!empty&&!x.isEmpty()) {
            StringBuilder sb=new StringBuilder();
            sb.append("[");
            for(int i=0;i<x.size()-1;i++){
                sb.append(x.get(i));
                sb.append(",");
            }
            sb.append(x.get(x.size()-1));
            sb.append("]");
            System.out.println(sb);
        }
        if(!empty&&x.isEmpty()){
            System.out.println(x);
        }
    }






    }
}
