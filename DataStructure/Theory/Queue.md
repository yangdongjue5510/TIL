### **a. 큐 Queue**

가장 최근에 저장된 값 다음에 저장.

반환은 가장 먼저 저장된 값부터. FIFO(First in First out)원칙.

<table style="border-collapse: collapse; width: 100%;" border="1" data-ke-align="alignLeft"><tbody><tr><td style="width: 50%;">enqueue</td><td style="width: 50%;">큐의 오른쪽에 삽입(push와 같음)</td></tr><tr><td style="width: 50%;">dequeue</td><td style="width: 50%;">가장 왼쪽에 저장된 값을 삭제 후 리턴</td></tr><tr><td style="width: 50%;">front</td><td style="width: 50%;">가장 왼쪽에 저장된 값을 삭제하지 않고 리턴</td></tr><tr><td style="width: 50%;">isEmpty</td><td style="width: 50%;">큐가 비어져있는지 참거짓</td></tr><tr><td style="width: 50%;">len</td><td style="width: 50%;">큐의 요소 갯수 반환</td></tr></tbody></table>

```
class Queue:
     def __init__(self):
         self.items=[]
         self.front_index=0 #다음 dequeue될 값의 인덱스
     def enqueue(self, val):
         self.items.append(val)
     def dequeue(self):
         if len(self.items)==0 or self.front_index==len(self.items):
             print("Queue is empty")
         else : 
             x = self.items[self.front_index]
             self.front_index +=1
             return x
     def front(self):
         if len(self.items) ==0 or self.front_index == len(self.items):
             print("queue is empty")
         else:
             return self.items[self.front_index]
     def __len__(self):
         return len(self.items)-self.front_index
     def isEmpty(self):
         return len(self)
```

**_dequeue를 상수시간에 실행하기 위해선 dequeue가 될 값의 인덱스를 저장하고 관리해야 한다._**

\-> dequeue가 되면, 그 값을 실제로 지우는 것이 아닌 front\_index값을 하나 늘려가며 다음 dequeue 될 예정 값의 인덱스를 가르키도록 관리한다.

실제로 dequeue될 때마다 값을 삭제시키면, 모든 값들을 한 칸씩 왼쪽으로 이동하는 시간이 소요되게 된다.O(n)

### **a-1. 큐 활용 : Josephus game**

```
import Queue #큐 클래스 import. 이 부분은 달라질 수 있음
def Josephus(n, k):
    Q=Queue()
    for v in range(1, n+1):
        Q.enqueue(v)
    while len(Q)>1:
        for i in range(1, k):
            Q.enqueue(Q.dequeue())
        Q.dequeue() #k번째 수 제거
    return Q.dequeue()
```

### **b. Dequeue**

왼쪽과 오른쪽에서 모두 삽입과 삭제가 가능한 큐

두 가지 버전의 pop과 push 연산을 구현

python collections 모듈에 deque 클래스로 구현되어 있음(덱으로 발음)

오른쪽 push : append / 왼쪽 push : appendleft

오른쪽 pop : pop / 왼쪽 pop : popleft
