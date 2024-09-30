import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n, m;
    public static int v[] = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 100001; i++) v[i] = -1;  // 방문 여부를 -1로 초기화
        v[n] = 0;  // 시작점의 방문 시간을 0으로 설정
        find_bro(n);
        System.out.print(v[m]);
    }

    static void find_bro(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        while (!q.isEmpty()) {
            int a = q.poll();
           
            // a * 2가 배열 범위를 벗어나지 않는지 확인
            if (a * 2 < 100001 && v[a * 2] == -1) {
                q.add(a * 2);
                v[a * 2] = v[a];
            }
            // a - 1이 배열 범위를 벗어나지 않는지 확인
            if (a - 1 >= 0 && v[a - 1] == -1) {
                q.add(a - 1);
                v[a - 1] = v[a] + 1;
            }

            // a + 1이 배열 범위를 벗어나지 않는지 확인
            if (a + 1 < 100001 && v[a + 1] == -1) {
                q.add(a + 1);
                v[a + 1] = v[a] + 1;
            }

           

            // 목표 지점 m에 도달하면 더 이상 탐색할 필요가 없음
            if (v[m] != -1) {
                break;
            }
        }
    }
}
