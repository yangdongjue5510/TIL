class Node:
    def __init__(self, key=None, value=None):
        self.key = key
        self.value = value
        self.next = None
    
    def __str__(self):
        return str(self.key)

class SinglyLinkedList:
    def __init__(self):
        self.head = None
        self.size = 0
    
    def __iter__(self): #반복하게 만드는 반복자. yield가 있는게 generator
        v = self.head
        while v != None:
            yield v #return과 비슷.
            v = v.next
    
    def __str__(self):
        return "->".join(str(v) for v in self)
    
    #push
    def pushFront(self, key, value=None):
        new_node = Node(key, value)
        new_node.next = self.head
        self.head = new_node
        self.size += 1
    
    def pushBack(self, key, value=None):
        new_node = Node(key, value)
        if self.size == 0:
            self.head = new_node
        else:
            tail = self.head
            while tail.next != None:
                tail = tail.next
            tail.next = new_node
        self.size += 1
    
    #pop
    def popFront(self):
        if self.size == 0:
            return None
        else:
            x = self.head
            key = x.key
            self.head = x.next
            self.size = self.size-1
            del x
            return key
    
    def popBack(self):
        if self.size == 0 :
            return None
        else:
            prev = None
            tail = self.head
            while tail.next != None:
                prev = tail
                tail = tail.next
            if prev == None: self.head = None
            else :
                prev.next = tail.next
            key = tail.key
            del(tail)
            self.size -= 1
            return key

    #search
    def search(self, key):
        v = self.head
        while v.next == None:
            if v.key == key: 
                return v
            v = v.next
        return v

    def searchFor(self, key):
        for v in self:
            if v.key == key:
                return v
        return None

    #remove
    def remove(self, v):
        if self.size == 0 or v == None: return False
        if v == self.head: 
            self.popFront()
            return False
        else:
            pre = None
            now = self.head
            while now != v:
                pre = now
                now = now.next
            pre.next = now.next
            del now
            self.size -= 1
            return True