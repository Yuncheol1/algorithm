import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 첫 번째 줄 입력: N, M, Q
        int N = sc.nextInt();
        int M = sc.nextInt();
        int Q = sc.nextInt();

        // 행(row)과 열(col) 배열 초기화
        int[] row = new int[N + 1];
        int[] col = new int[M + 1];

        // Q개의 명령 처리
        for (int i = 0; i < Q; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();

            if (n1 == 1) {
                row[n2] += n3;
            } else if (n1 == 2) {
                col[n2] += n3;
            }
        }

        // 결과 출력
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                System.out.print((row[i] + col[j]) + " ");
            }
            System.out.println();
        }

        
    }
}
