import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            Map<String, Integer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            int ans = 1;
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String wear = st.nextToken();
                if (!map.containsKey(wear)) {
                    map.put(wear, 1);
                } else {
                    map.put(wear, map.get(wear) + 1);
                }
            }
            for (var i : map.values()) {
                ans *= (i + 1);
            }
            System.out.println(ans - 1);
        }

    }
}