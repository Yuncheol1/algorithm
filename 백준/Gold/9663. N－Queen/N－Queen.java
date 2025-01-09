import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int[] chess;
    static int n;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        chess = new int[n];
        Queen(0);
        System.out.print(cnt);

    }

    static void Queen(int depth) {
        if (depth == n) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            chess[depth] = i;
            if (checkQueen(depth)) {
                Queen(depth + 1);
            }
        }
    }

    static boolean checkQueen(int col) {
        for (int i = 0; i < col; i++) {
            if (chess[i] == chess[col]) {
                return false;
            }
            if (Math.abs(chess[col] - chess[i]) == Math.abs(col - i)) {
                return false;
            }
        }
        return true;
    }
}