class Node:
    def __init__(self, key = None):
        self.key = key
        self.next = self.prev = self

    def __str__(self):
        return str(self.key)

class DoublyLinkedList:
    def __init__(self):
        self.head = Node()
        self.size = 0
    def __iter__(self): #반복하게 만드는 반복자. yield가 있는게 generator
        v = self.head
        while v != None:
            yield v #return과 비슷.
            v = v.next
    
    def __str__(self):
        return "->".join(str(v) for v in self)
    
    #splice
    def splice(self, a, b, x):
        if a == None or b == None or x == None :
            return
        ap = a.prev
        bn = b.next

        #cut
        ap.next = bn
        bn.prev = ap

        #insert after x
        xn = x.next
        xn.prev = b
        x.next = a
        b.next = xn
        a.prev = x
    
    #search
    def search(self, key):
        v = self.head
        while v.next != self.head:
            if v.key == key:
                return v
            v = v.next
        return None
    
    #isEmpty
    def isEmpty(self):
        v = self.head
        if v.next ==self.head:
            return True
        else:
            return False
        #first last  
    def first(self):
        v = self.head
        if v.next!=self.head:
            return v.next
        else:
            return None
            
    def last(self):
        v = self.head
        if v.prev != self.head:
            return v.prev
        else:
            return None


    def moveAfter(self, a, x): #노드 a를 노드 x 뒤로 이동
        self.splice(a, a, x) #a를 떼어내어 x뒤로 붙인 것과 같다

    def moveBefore(self, a, x): #노드 a를 노드 x 앞으로 이동
        self.splice(a, a, x.prev)

    def insertAfter(self, x, key): #key값을 갖는 노드를 x뒤에 삽입
        self.moveAfter(Node(key), x)

    def insertBefore(self, x, key): #key값을 갖는 노드를 x앞에 삽입
        self.moveBefore(Node(key), x)
        
    def pushFront(self, key): # key값을 갖는 노드를 헤드 뒤에 삽입
        self.insertAfter(self.head, key)

    def pushBack(self, key): # key값을 갖는 노드를 헤드 앞에 삽입
        self.insertBefore(self.head, key)

    #삭제
    def remove(self, x):
        if x == None or x == self.head: return
        x.prev.next , x.next.prev = x.next, x.prev
    
    def popFront(self):
        if self.isEmpty(): return None
        key = self.head.next.key
        self.remove(self.head.next)
        return key
    
    def popBack(self):
        if self.isEmpty(): return None
        key = self.head.prev.key
        self.remove(self.head.prev)
        return key