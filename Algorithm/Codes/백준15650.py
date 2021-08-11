N, M = list(map(int, input().split()))
def func(N,M,p,r):
    if r==M:
        print()
    if p==N and r!=M:
        return None
    for i in range(p+1, N+1):
        r+=1
        print(i, end=' ')
        func(N,M,i,r)
r =0
func(N,M,0,r)