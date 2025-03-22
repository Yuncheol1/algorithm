import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> h = new HashMap<>();

       
        for (String p : participant) {
            h.put(p, h.getOrDefault(p, 0) + 1);
        }

       
        for (String c : completion) {
            h.put(c, h.get(c) - 1);
        }

        String ans = "";

       
        for (Map.Entry<String, Integer> t : h.entrySet()) {
            if (t.getValue() > 0) {
                ans = t.getKey();
                break;
            }
        }

        return ans;
    }
}
