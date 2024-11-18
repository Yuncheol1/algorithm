import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pNum = new PriorityQueue<>((o1, o2) -> o2 - o1); // 양수 내림차순
        PriorityQueue<Integer> nNum = new PriorityQueue<>(); // 음수 오름차순
        int one = 0;
        int zero = 0;

        int sum = 0;
        int n = sc.nextInt();

        // 입력 처리
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x > 1) {
                pNum.add(x);
            } else if (x < 0) {
                nNum.add(x);
            } else if (x == 1) {
                one++;
            } else {
                zero++;
            }
        }

        // 양수 처리
        while (pNum.size() > 1) {
            int a = pNum.poll();
            int b = pNum.poll();
            sum += (a * b); // 큰 수 두 개를 곱함
        }
        if (!pNum.isEmpty()) {
            sum += pNum.poll(); // 남은 양수는 더함
        }

        // 음수 처리
        while (nNum.size() > 1) {
            int a = nNum.poll();
            int b = nNum.poll();
            sum += (a * b); // 작은 음수 두 개를 곱함
        }
        if (!nNum.isEmpty()) {
            if (zero == 0) {
                sum += nNum.poll(); // 0이 없으면 남은 음수를 더함
            }
        }

        // 1 처리
        sum += one;

        // 결과 출력
        System.out.println(sum);
    }
}
