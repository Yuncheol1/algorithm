import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String wordS = sc.next(); // 비교 대상 문자열
        String wordP = sc.next(); // 검색 대상 문자열
        int startidx = 0;
        int cnt = 0;
        for (int i = 0; i < wordP.length(); i++) {
            if (wordS.indexOf(wordP.substring(startidx, i + 1)) != -1) {
                continue;
            } else {
                cnt++;
                startidx = i;
            }

        }
        System.out.println(cnt + 1);
    }
}
