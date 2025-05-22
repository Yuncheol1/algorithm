import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int k = sc.nextInt(); 
        int[][] x = new int[n][3]; 

        for (int i = 0; i < n; i++) {
            x[i][0] = sc.nextInt(); 
            x[i][1] = sc.nextInt(); 
            x[i][2] = sc.nextInt(); 
        }

        Arrays.sort(x, (o1, o2) -> {
            long a = (long) o1[2] * o2[1]; 
            long b = (long) o2[2] * o1[1]; 

            if (a != b) return Long.compare(b, a); // 가성비 내림차순
            if (o1[1] != o2[1]) return o1[1]-o2[1]; // 가격 오름차순
            return o1[0]-o2[0]; // 번호 오름차순
        });

        for (int i = 0; i < k; i++) {
            System.out.println(x[i][0]);
        }

        sc.close();
    }
}
