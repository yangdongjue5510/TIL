class Node:
	def __init__(self, key, value=None):
		self.key = key
		self.value = value
		self.next = None
	def __str__(self):
		return str(self.key)

class SinglyLinkedList:
	def __init__(self):
		self.head = None
	def __iter__(self):
		v = self.head
		while v != None:
			yield v
			v = v.next
	def __str__(self):
		return " -> ".join(str(v.key) for v in self) + " -> None"

	def pushFront(self, key, value=None):
		new_node = Node(key)
		new_node.next = self.head
		self.head = new_node

	def popFront(self):
		if self.head == None: # empty list
			return None
		else:
			key = self.head.key
			self.head = self.head.next
			return key

	def search(self, key):
		v = self.head
		while v != None:
			if v.key == key: return v
			v = v.next
		return v

	def remove(self, v):
		if v == None or self.head == None: return None
		key = v.key
		if v == self.head:
			return self.popFront()
		else:
			prev, curr = None, self.head
			while curr != None and curr != v:
				prev = curr
				curr = curr.next
			if curr == v:
				prev.next = curr.next
			return key

class HashChaining:
	def __init__(self, size=10):
		self.size = size
		self.H = [SinglyLinkedList() for x in range(self.size)]
	def __str__(self):
		s = ""
		i = 0
		for k in self:
			s += "|{0:-3d}| ".format(i) + str(k) + "\n"
			i += 1
		return s
	def __iter__(self):
		for i in range(self.size):
			yield self.H[i]

	def hash_function(self, key):
		return key % self.size

	def find_slot(self, key):
		return self.hash_function(key)

	def set(self, key, value=None):
		i = self.find_slot(key)
		v = self.H[i].search(key)
		if v == None :
			self.H[i].pushFront(key , value)
		else:
			v.value = value
	
	def remove(self, key):
		i = self.find_slot(key)
		v = self.H[i].search(key)
		if v:
			outputKey = v.key
			self.H[i].remove(v)
			return outputKey
		return None
	
	def search(self, key):
		i = self.find_slot(key)
		v = self.H[i].search(key)
		if v:
			return v
		return None