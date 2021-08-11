'''my code that time over!
targetCount = int(input())
targetList = list(map(int, input().split()))

inputCount = int(input()) 
inputList = list(map(int, input().split()))

hashTable = [[]]*63
def hashFunc(n):
    hashIndex = 0
    while True:
        if n//512 != 0:
            n = n % 512
            hashIndex += 1
        else:
            break
    return hashIndex

for i in range(targetCount):
    hashIndex = hashFunc(targetList[i])
    hashTable[hashIndex].append(targetList[i])

for j in range(inputCount):
    hashIndex = hashFunc(inputList[j])
    if inputList[j] in hashTable[hashIndex]:
        print('1')
    else: print('0')
'''
#python에서는 해쉬를 활용할 때 딕셔너리를 사용하도 된다!
#이 문제는 set으로도 풀 수 있다. set은 중복을 허락하지 않기 때문에 빠르다?

n = int(input())
array = list(map(int, input().split()))
m = int(input())
x = list(map(int, input().split()))

for i in x:
    if i not in array:
        print('0')
    else:
        print('1')