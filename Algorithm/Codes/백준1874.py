n = int(input())
lst = []
for _ in range(n):
    lst.append(int(input()))
stk = []
num = 0
top = None
answerStk=[]
for i in range(n):
    if len(stk)!=0:
        top = stk[len(stk)-1]
    if lst[i] > num:
        for j in range(num+1, lst[i]+1):
            stk.append(j)
            answerStk.append('+')
        stk.pop()
        answerStk.append('-')
        num = lst[i]
    elif lst[i] < num:
        if top == lst[i]:
            stk.pop()
            answerStk.append('-')
        else:
            answerStk.append('NO')
            break

if answerStk[len(answerStk)-1]=='NO':
    print('NO')
else:
    for k in range(len(answerStk)):
        print(answerStk[k])
