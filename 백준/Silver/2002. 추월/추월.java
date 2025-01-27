import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedHashMap<String, Integer> in = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> out = new LinkedHashMap<>();
        String input;
        for (int i = 0; i < n; i++) {
            input = br.readLine();
            in.put(input, i);
        }
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            input = br.readLine();
            x[i] = in.get(input);
        }
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (x[i] > x[j]) {
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}