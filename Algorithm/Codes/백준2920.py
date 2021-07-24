# my answer
m = list(map(int, input().split()))
def func(m):
    add=0
    comp=0
    if m[0]==1:
        add=1
    if m[0]==8:
        add=-1
    comp=m[0]
    for i in range(0,len(m)-1):
        if(m[i]!=comp):
            print('mixed')
            return -1
        comp=comp+add
    if add == 1:
        print('ascending')
    else: print('descending')
func(m)

# teacher's answer
a = list(map(int, input().split(' ')))

ascending = True
descending = True

for i in range(1, 8):
    if a[i] > a[i-1]:
        descending =False
    elif a[i] < a[i-1]:
        ascending = False
if ascending : print('ascending')
elif descending: print('descending')
else : print('mixed')