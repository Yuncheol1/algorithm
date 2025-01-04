#pragma warning(disable:4996)
#include <stdio.h>
int main()
{
	int a, b, c, d,e;
	scanf("%d%d", &a, &b);
	if (a == 0&&b>=45)
	{
		printf("%d %d", a, b - 45);
	}
	else if (a == 0 && b < 45)
	{
		a = 23;
		c = 60 + (b - 45);
		printf("%d %d", a, c);
	}

	else if (a > 0)
	{
		c = 60 * a + b - 45;
		d = c / 60;
		e = c % 60;
		printf("%d %d", d, e);
	}




	return 0;
}