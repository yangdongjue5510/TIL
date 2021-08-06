def merge_sort(A, first, last):
    if first >= last : return
    middle = (first+last)//2
    merge_sort(A,first, middle)
    merge_sort(A, middle+1, last)
    B = []
    i = first
    j = middle+1
    while i <= middle and j <= last:
        if A[i] <= A[j]:
            B.append(A[i])
            i+=1
        else:
            B.append(A[j])
            j+=1
    for i in range(i, middle+1): B.append(A[i])
    for j in range(j, last+1): B.append(A[j])
    for k in range(first, last+1): A[k] = B[k-first]

A=[2,3,5,1,5,6,8]
merge_sort(A,0,len(A)-1)
print(A)