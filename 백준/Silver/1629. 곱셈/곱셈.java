import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 모듈러를 고려한 거듭제곱 함수
    public static long powMod(long a, long b, long c) {
        long res = 1;
        a = a % c;  // a가 c보다 큰 경우를 대비해 미리 모듈러 연산을 해줌
        while (b > 0) {
            if ((b & 1) == 1) {  // b의 비트가 1인 경우
                res = (res * a) % c;  // res에 a를 곱한 후 모듈러 연산
            }
            a = (a * a) % c;  // a를 제곱한 후 모듈러 연산
            b >>= 1;  // b를 2로 나눔
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long r = powMod(a, b, c);
        System.out.print(r);
    }
}
