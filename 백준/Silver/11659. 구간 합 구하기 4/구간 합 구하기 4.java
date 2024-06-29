
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
int n,m;
n=sc.nextInt();
m=sc.nextInt();
int x[]=new int [100000];
int sum[]=new int[100000];
for(int i=0;i<n;i++) {
	x[i]=sc.nextInt();
}
sum[0]=x[0];
for(int i=1;i<n;i++) {
	sum[i]=sum[i-1]+x[i];
}
int a,b;
for(int i=0;i<m;i++) {
	a=sc.nextInt();
	b=sc.nextInt();
	if(a==1)System.out.println(sum[b-1]);
	else System.out.println(sum[b-1]-sum[a-2]);
}




	}

}
