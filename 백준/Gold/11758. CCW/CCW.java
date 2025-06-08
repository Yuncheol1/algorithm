import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();
        int ans=(x1*y2+x2*y3+x3*y1)-(x2*y1+x3*y2+x1*y3);
        if(ans>0){
            System.out.print(1);
        }
        else if(ans<0){
            System.out.print(-1);
        }
        else{
            System.out.print(0);
        }
    }
}
