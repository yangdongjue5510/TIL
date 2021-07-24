### **a. 스택 Stack**

차례대로 삽입하고 최근에 저장된 값을 삭제(FILO)

<table style="border-collapse: collapse; width: 100%; height: 100px;" border="1" data-ke-align="alignLeft" data-ke-style="style4"><tbody><tr style="height: 20px;"><td style="width: 50%; height: 20px;">push</td><td style="width: 50%; height: 20px;">스택에 값 추가</td></tr><tr style="height: 20px;"><td style="width: 50%; height: 20px;">pop</td><td style="width: 50%; height: 20px;">가장 나중에 push된 값을 스택에서 제거하고 반환</td></tr><tr style="height: 20px;"><td style="width: 50%; height: 20px;">top</td><td style="width: 50%; height: 20px;">가장 나중에 push된 값을 제거하지 않고 반환</td></tr><tr style="height: 20px;"><td style="width: 50%; height: 20px;">__len__</td><td style="width: 50%; height: 20px;">스택의 저장된 요소 갯수를 반환</td></tr><tr style="height: 20px;"><td style="width: 50%; height: 20px;">isEmpty</td><td style="width: 50%; height: 20px;">스택에 요소가 존재하는지 참거짓</td></tr></tbody></table>

```
# stack_queue.py 에 저장
class Stack:
	def __init__(self):
		self.items = []	# 데이터 저장을 위한 리스트 준비
	def push(self, val):
		self.items.append(val)
	def pop(self):
		try:	# pop할 아이템이 없으면
			return self.items.pop()
		except IndexError:	# indexError 발생
			print("Stack is empty")
	def top(self):
		try:
			return self.items[-1]
		except IndexError:
			print("Stack is empty")
	def __len__(self):	# len()로 호출하면 stack의 item 수 반환
 		return len(self.items)
	def isEmpty(self):
		return self.__len__() == 0

# for test
S = Stack()
S.push(10)
S.push(2)
print(S.top())
print(S.pop())
print(len(S))
print(S.isEmpty())
```

### **b. 스택 활용**

#### b-1. 괄호짝 맞추기

입력 값 : 괄호로 이뤄져 있는 문자열 ex. ()()()

반환 값 : 괄호 짝이 맞는지 참 거짓 ex. True

```
class Stack:
	def __init__(self):
		self.item=[]
	def push(self, a):
		self.item.append(a)
	def pop(self):
		try:
			return self.item.pop()
		except IndexError:
			print('Stack is empty.')
	def top(self):
		try:
			return self.item[-1]
		except IndexError:
			print('Stack is empty.')
	def __len__(self):
		return len(self.item)
	def isEmpty(self):
		return len(self.item)==0
	
# pseudo code
def parChecker(parSeq):
	S=Stack()
	for i in parSeq:
		if i =='(':
			S.push('(')
		elif i ==')':
			if S.isEmpty():
				print(False)
				return False
			else : 
				S.pop()
	if S.isEmpty():
		print(True)
		return True
	else : 
		print(False)
		return False
parSeq=list(input())
parChecker(parSeq)
```

#### b-2. infix 수식을 postfix로 바꾸기

```
class Stack:
	def __init__(self):
				self.items = []
	def push(self, val):
				self.items.append(val)
	def pop(self):
		try:
			return self.items.pop()
		except IndexError:
			print("Stack is empty")
	def top(self):
		try:
			return self.items[-1]
		except IndexError:
			print("Stack is empty")
	def __len__(self):
		return len(self.items)
	def isEmpty(self):
		return self.__len__() == 0
def infix_to_postfix(infix):
	opstack = Stack()
	outstack = []
	token_list = infix.split()
			# 연산자의 우선순위 설정
	prec = {}
	prec['('] = 0
	prec['+'] = 1
	prec['-'] = 1
	prec['*'] = 2
	prec['/'] = 2
	prec['^'] = 3
	for token in token_list:
		if token == '(':
			opstack.push(token)
		elif token == ')':
			while True:
				if opstack.top()=='(':
				    opstack.pop()
				    break
				else :
					outstack.append(opstack.pop())
		elif token in '+-/*^':
			while True:
				if opstack.isEmpty():
					opstack.push(token)
					break
				elif prec[opstack.top()]>=prec[token]:
					    outstack.append(opstack.pop())
				else:
					opstack.push(token)
					break
		else: # operand일 때
			outstack.append(token)
			# opstack 에 남은 모든 연산자를 pop 후 outstack에 append
	for i in range(opstack.__len__()):
		outstack.append(opstack.pop())
	return " ".join(outstack)

infix_expr = input()
postfix_expr = infix_to_postfix(infix_expr)
print(postfix_expr)
```

#### b-3. Postfix 계산

```
class Stack:
	def __init__(self):
		self.items=[]
	def push(self, val):
		return self.items.append(val)
	def pop(self):
		try:
			return self.items.pop()
		except IndexError:
			print('stack is empty')
	def top(self):
		try:
			return self.items[self.items.len()-1]
		except IndexError:
			print('stack is empty')
	def __len__(self):
		return self.items.len()
def compute_postfix(postfix):
	opstack = Stack()
	token_list = postfix.split()
	for i in token_list:
		if i in '+-*/^':
			a=opstack.pop()
			b=opstack.pop()
			if i =='+':
				opstack.push(a+b)
			elif i =='-':
				opstack.push(b-a)
			elif i =='*':
				opstack.push(a*b)
			elif i =='/':
				opstack.push(b/a)
			elif i =='^':
				opstack.push(b**a)
		else:
			opstack.push(int(i))
	print('%.4f'%opstack.pop())

postfix=input()
compute_postfix(postfix)
```

### **c. 인터뷰 문제**

1\. 스택을 하나 혹은 두개 사용해 push, pop, min 세 연산 모두 O(1) 시간에 수행되도록 하려면?

2\. 스택 두 개를 써서 큐를 구현해라.(enqueue, dequeue를 구현하라)
