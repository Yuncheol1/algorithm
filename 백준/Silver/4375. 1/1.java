import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = "";
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            int cnt = 1;
            int a = 1;
            while (a % n != 0) {
                a = (a*10+1)%n;
                cnt++;
            }
            bw.write(cnt + "\n");
        }
        bw.flush();

    }
}