import java.util.*;

public class Main {

    static int[] card;
    static int N;
    static Set<Integer> sums = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        N = scanner.nextInt();
        card = new int[N];
        int M = 0;
        for (int i = 0; i < N; i++) {
            card[i] = scanner.nextInt();
            M += card[i];
        }

       
        calculateSums(0, 0);

        
        int result = M - sums.size() + 1;
        System.out.println(result);
    }

    public static void calculateSums(int idx, int sum) {
        sums.add(sum);

        if (idx == N) {
            return;
        }

        // 현재 카드를 포함하는 경우
        calculateSums(idx + 1, sum + card[idx]);

        // 현재 카드를 포함하지 않는 경우
        calculateSums(idx + 1, sum);
    }
}