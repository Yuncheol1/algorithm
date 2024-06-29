import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
int n;
n=sc.nextInt();
int sum=1;
int cnt=0;
int start=1,end=1;
while(end<=n) {
	if(sum<n) {
		end++;
		sum+=end;
	}
	if(sum>n) {
		sum-=start;
		start++;
	}
	if(sum==n) {
		cnt++;
		end++;
	sum+=end;
	}
}
System.out.println(cnt);

	}

}
