import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class point {
    int i;
    int j;

    public point(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class Main {
    static int w, h;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] x;
    static Queue<point> q;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int asdf = 0; asdf < T; asdf++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            x = new char[h][w];
            q = new LinkedList<>();
            for (int i = 0; i < h; i++) {
                String input = br.readLine();
                for (int j = 0; j < input.length(); j++) {
                    x[i][j] = input.charAt(j);
                }
            }

            int startI = 0;
            int startJ = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (x[i][j] == '@') {
                        startI = i;
                        startJ = j;
                    }
                    if (x[i][j] == '*') {
                        q.add(new point(i, j));
                    }
                }
            }

            boolean escape = bfs(startI, startJ);
            if (escape) {
                System.out.println(cnt + 1);
            } else {
                System.out.println("IMPOSSIBLE");
            }

        }
    }

    static boolean bfs(int I, int J) {
        cnt = 0;
        Queue<point> sq = new LinkedList<>();
        sq.add(new point(I, J));
        while (!sq.isEmpty()) {
            int sqsize = sq.size();
            int qsize = q.size();
            for (int ai = 0; ai < sqsize; ai++) {
                point pp = sq.poll();
                if (x[pp.i][pp.j] == '*') {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int nx = pp.i + dx[k];
                    int ny = pp.j + dy[k];
                    if (nx < 0 || ny < 0 || nx > h - 1 || ny > w - 1) {
                        return true;
                    }
                    if (nx >= 0 && ny >= 0 && nx < h &&
                            ny < w && x[nx][ny] == '.') {
                        x[nx][ny] = '@';
                        sq.add(new point(nx, ny));
                    }
                }

            }
            for (int ia = 0; ia < qsize; ia++) {
                point p = q.poll();

                for (int k = 0; k < 4; k++) {
                    int nx = p.i + dx[k];
                    int ny = p.j + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < h && ny < w &&
                            (x[nx][ny] == '@' || x[nx][ny] == '.')) {
                        x[nx][ny] = '*';
                        q.add(new point(nx, ny));
                    }
                }
            }
            cnt++;
       /*     for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    System.out.print(x[i][j]);
                }
                System.out.println();
            }
            System.out.println();
       */
        }
        return false;
    }
}
