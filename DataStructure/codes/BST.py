class Node:
    def __init__(self, key):
        self.key = key
        self.parent = self.left = self.right = None

    def __str__(self):
        return str(self.key)


class Tree:
    def __init__(self):
        self.root = None
        self.size = 0

    def __len__(self):
        return self.size

    def preorder(self, v):
        if v:
            print(v.key, end=' ')
            self.preorder(v.left)
            self.preorder(v.right)
    def inorder(self, v):
        if v:
            self.inorder(v.left)
            print(v.key, end=' ')
            self.inorder(v.right)
    def postorder(self, v):
        if v:
            self.postorder(v.left)
            self.postorder(v.right)
            print(v.key, end=' ')
    
    def find_loc(self, key):
        if self.size ==0 : return None
        p = None
        v = self.root
        while v != None:
            if v.key == key : return v
            if v.key<key:
                p = v
                v = v.right
            else :
                p = v
                v = v.left
        return p
                
    def search(self, key):
        v = self.find_loc(key)
        if v and v.key==key:
            return v
        else :
            return None
            
    def insert(self, key):
        # key가 이미 트리에 있다면 에러 출력없이 None만 리턴!
        v = Node(key)
        if self.size==0 : self.root = v
        else :
            p = self.find_loc(key)
            if p and p.key != key:
                if p.key < key: p.right = v
                else : p.left = v
                v.parent = p
            else : return None
        self.size += 1
        return v
T = Tree()