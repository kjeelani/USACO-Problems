'''
Selection Sort:

a[1000]
for i in range(n):
    for j in range(n+1):
        if(a[i] > a[j]):
            swap(a[i], a[j])


Time Complexity: 5*10^8
Memory Complexity: 256MB


Use sort function in Java or Python

Binary Search splits data into two ends, find which end it is nearer to, and change the scope

Upper Bound returns last occurance of number + 1
Lower Bound returns first occurance of number

Helpful for finding number of elements in interval [a,b]
'''
n = 7
array = [1, 4, 7, 9, 13, 14]

def upperbound(x):
    left, right = 0, n
    while left < right:
        mid = (right + left) // 2
        if(x >= array[mid]):
            left = mid + 1
        else:
            right = mid
    return left

def lowerbound(x):
    left, right = 0, n
    while left < right:
        mid = (right + left) // 2
        if(x <= array[mid]):
            right = mid
        else:
            left = mid + 1
    return left
