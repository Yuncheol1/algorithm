import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str=sc.next();
        String str2=new StringBuilder(str).reverse().toString();
        if(str.equals(str2)){
            System.out.print(1);
        }
        else{
            System.out.print(0);
        }
    }
}