import java.util.*;
class Solution {
    public ArrayList solution(int[] array, int[][] commands) {
        ArrayList<Integer> ans=new ArrayList<>();
        for(int a=0;a<commands.length;a++){
            ArrayList<Integer>x=new ArrayList<>();
            for(int i=commands[a][0]-1;i<commands[a][1];i++){
                x.add(array[i]);
            }
            Collections.sort(x);
            ans.add(x.get(commands[a][2]-1));
        }
        
        
        
        
        return ans;
    }
}