def fac(n):
    if n==0 or n==1:
        return 1;
    else:
        ans=1
        for i in range(n,1,-1):
            ans*=i
        return ans
n,m = map(int,input().split())
print(fac(n)//(fac(n-m)*fac(m)))
