testCase = int(input())
for _ in range(testCase):
    n, m = list(map(int, input().split(' ')))
    lst = list(map(int, input().split(' ')))
    target = lst[m]
    count = 0
    while True:
        if max(lst) == target : break
        while lst[0] != max(lst):
            num = lst.pop(0)
            lst.append(num)
            if m == 0 : m = len(lst)-1
            else: m = m-1
        lst.pop(0)
        count +=1
        m-=1
    for i in range(len(lst)):
        if i == m:
            count+=1
            break
        elif lst[i] == target:
            count+=1
    print(count)
        
    