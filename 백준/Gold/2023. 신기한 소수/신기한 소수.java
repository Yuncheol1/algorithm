import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }

    static void dfs(int a, int depth) {
        if (depth == n) {
            System.out.println(a);
            return;
        }
        for (int i = 1; i <= 9; i += 2) {
            if (isPrime(a * 10 + i)) {
                dfs(a * 10 + i, depth + 1);
            }
        }
    }

    static boolean isPrime(int p) {
        for (int i = 2; i <= p / 2; i++) {
            if (p % i == 0) {
                return false;
            }
        }
        return true;
    }
}