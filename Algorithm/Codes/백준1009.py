testCase = int(input())
output = []
for _ in range(testCase):
    N, M = list(map(int, input().split()))
    result = 1
    count = 0
    for i in range(M):
        result = ( result * N ) % 10
        count += 1
        if result == 1:
            M = M % count
            if M == 0 : result = 1
            else : 
                for j in range(M):result = ( result * N ) % 10
            break
    if result == 0 : result = 10
    output.append(result)
for i in output:
    print(i)
