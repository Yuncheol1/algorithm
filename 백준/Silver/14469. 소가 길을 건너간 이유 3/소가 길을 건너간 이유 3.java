import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] line = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line, Comparator.comparingInt(o1 -> o1[0]));
        int time = line[0][0] + line[0][1];
        for (int i = 1; i < N; i++) {
            if (line[i][0] >= time) {
                time = line[i][0] + line[i][1];
            } else {
                time = line[i][0] + line[i][1] + (time - line[i][0]);
            }
        }

        System.out.println(time);
    }
}