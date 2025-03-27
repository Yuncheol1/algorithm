import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int []x=new int[n+1];
        Arrays.fill(x,1);
        for(int i:lost){
            x[i]--;
        }
        for(int i:reserve){
            x[i]++;
        }
         for(int i=1;i<=n;i++){
             if(x[i]==0){
                 if(i-1>=1&&x[i-1]==2){
                     x[i]++;
                     x[i-1]--;
                 }
                 else if(i+1<=n&&x[i+1]==2){
                     x[i]++;
                     x[i+1]--;
                 }
             }
         }
        int answer = 0;
       
        for(int i=1;i<=n;i++){
            if(x[i]>=1)answer++;
        }
        return answer;
    }
}