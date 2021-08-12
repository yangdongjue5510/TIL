#my code is time over!!!!!!
'''
testCase = int(input())

for _ in range(testCase):
    relationCase = int(input())
    relationList = []
    for i in range(relationCase):
        name1 , name2 = list(input().split())
        set1, set2 = {}, {}
        set1Index, set2Index = 0, 0
        for j in range(len(relationList)):
            if name1 in relationList[j]:
                set1 = relationList[j]
                set1Index = j
                break
        for k in range(len(relationList)):
            if name2 in relationList[k]:
                set2 = relationList[k]
                set2Index = k
                break

        if set1 == {} and set2 == {}:
            relationList.append({name1, name2})
            print(2)
        
        elif set1 != {} and set2 != {}:
            relationList.remove(set1)
            relationList.remove(set2)
            for l in set1:
                set2.add(l)
            relationList.append(set2)
            print(len(set2))
        
        elif set2 != {} :
            set2.add(name1)
            relationList[set2Index] = set2
            print(len(set2))
        
        else:
            set1.add(name2)
            relationList[set1Index] = set1
            print(len(set1))
'''

#with teacher's advice
#Union Find
'''
def find(x):
    if x == parent[x]:
        return x
    else:
        p = find(parent[x])
        parent[x] = p
        return parent[x]
def union(x, y):
    x = find(x)
    y = find(y)
    parent[y] = x
parent = []

for i in range(0, 5):
    parent.append(i)

union(1, 4)
union(2, 4)

for i in range(1, len(parent)):
    print(find(i), end=' ')
'''

def find(x):
    if x == parent[x]:
        return x
    else:
        p = find(parent[x])
        parent[x] = p
        return parent[x]

def union(x, y):
    x = find(x)
    y = find(y)

    if x != y:
        parent[y] = x
        number[x] += number[y]

testCase = int(input())
for _ in range(testCase):
    parent = dict()
    number = dict()

    f = int(input())

    for _ in range(f):
        x, y = input().split(' ')

        if x not in parent:
            parent[x] = x
            number[x] = 1
        if y not in parent:
            parent[y] = y
            number[y] = 1
        union(x, y)
    print(number[find(x)])