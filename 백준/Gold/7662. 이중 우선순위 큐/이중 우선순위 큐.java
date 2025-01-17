import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> doubleQ = new TreeMap<>();
            while (K-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                int n = Integer.parseInt(st.nextToken());
                if (s.equals("I")) {
                    if (doubleQ.containsKey(n)) {
                        doubleQ.put(n, doubleQ.get(n) + 1);
                    } else {
                        doubleQ.put(n, 1);
                    }
                }
                if (s.equals("D")) {
                    if (doubleQ.isEmpty()) {
                        continue;
                    }
                    if (n == -1) {
                        var q = doubleQ.firstEntry();
                        if (q.getValue() <= 1) {
                            doubleQ.pollFirstEntry();
                        } else {
                            doubleQ.put(q.getKey(), q.getValue() - 1);
                        }
                    } else {
                        var q = doubleQ.lastEntry();
                        if (q.getValue() <= 1) {
                            doubleQ.pollLastEntry();
                        } else {
                            doubleQ.put(q.getKey(), q.getValue() - 1);
                        }
                    }
                }

            }
            if (doubleQ.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(doubleQ.lastKey() + " " + doubleQ.firstKey());
            }
        }
    }
}