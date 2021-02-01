from sys import stdin

n = int(stdin.readline())
cows = sorted([int(stdin.readline()) for i in range(n)])
count = 0

def upperbound(x):
    left, right = 0, n
    while left < right:
        mid = (right + left) // 2
        if(x >= cows[mid]):
            left = mid + 1  
        else:
            right = mid
    return left

def lowerbound(x):
    left, right = 0, n
    while left < right:
        mid = (right + left) // 2
        if(x <= cows[mid]):
            right = mid
        else:
            left = mid + 1
    return left

for i in range(n-2):
    for j in range(i+1, n-1):
        x, y = cows[i], cows[j]
        d = y-x
        count += upperbound(2*d+y) - lowerbound(d+y)

print(count)