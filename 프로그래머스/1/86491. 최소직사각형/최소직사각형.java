import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int[]x=new int[sizes.length*2];
        int idx=0;
        for(int i=0;i<sizes.length;i++){
            for(int j=0;j<2;j++){
                x[idx++]=sizes[i][j];
            }
        }
        Arrays.sort(x);
        int weight=x[x.length-1];
        int min=weight*x[x.length-2];
        for(int ii=x.length-2;ii>=0;ii--){
            int height=x[ii];
            boolean check=false;
            for(int i=0;i<sizes.length;i++){
                if((sizes[i][0]<=weight&&sizes[i][1]<=height)||sizes[i][0]<=height&&sizes[i][1]<=weight ){
                    check=false;
                }
                else{
                    check=true;
                    break;
                }
            }
            if(!check){
                min=Math.min(min,weight*height);
            }
            
        }
        
        
        int answer = min;
        return answer;
    }
}