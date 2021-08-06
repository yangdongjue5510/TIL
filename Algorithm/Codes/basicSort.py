def selection_sort(A,n):
    for i in range(n-1, 0, -1):
        m = A.index(max(A[0:i+1])) #정렬되지 않은 수 중 가장 큰 값의 인덱스
        A[i], A[m]=A[m], A[i]
def insertion_sort(A,n):
    for i in range(1,n):
        m=0
        for j in range(i-1, -1, -1):
            if A[j]<A[i]:
                m=j+1
                break
        for k in range(i, m, -1):
            A[k], A[k-1] = A[k-1], A[k]
def bubble_sort(A,n):
    for i in range(n):
        for j in range(n-1, i, -1):
            if A[j-1] > A[j]:
                A[j-1], A[j] = A[j], A[j-1]
