n, m = list(map(int, input().split(' ')))
lst = list(map(int, input().split(' ')))
result = 0
for i in range(0,n-2):
    for j in range(i+1, n-1):
        for k in range(j+1, n):
            sum =lst[i]+lst[j]+lst[k]
            if sum <= m :
                result = max(result, sum)
print(result)