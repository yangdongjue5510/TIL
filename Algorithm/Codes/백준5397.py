testCase = int(input())
for _ in range(testCase):
    pw = list(input())
    stk = []
    tmp = []
    for i in range(len(pw)):
        if pw[i] == '-':
            if len(stk) != 0:
                stk.pop()
        elif pw[i] == '<':
            if len(stk) != 0: # if stk :
                letter = stk.pop() # tmp.append(stk.pop())
                tmp.append(letter)
        elif pw[i] == '>':
            if len(tmp) != 0: # if tmp :
                letter = tmp.pop() # stk.append(tmp.pop())
                stk.append(letter)
        else : stk.append(pw[i])
        
    for _ in range(len(tmp)): #stk.extend(reversed(tmp))
        stk.append(tmp.pop())
    for i in stk:   #print(''.join(stk))
        print(i, end='')
    print()