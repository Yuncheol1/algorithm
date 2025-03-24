import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(int i:scoville){
            pq.add((long)i);
        }
        int cnt=0;
        while(pq.peek()<K){
            if(pq.isEmpty()){
                return -1;
            }
            long a=pq.poll();
            if(pq.isEmpty()){
                return -1;
            }
            long b=pq.poll();
            long c=a+(b*2);
            pq.add(c);
            cnt++;
        }
        
        
        
        return cnt;
    }
}