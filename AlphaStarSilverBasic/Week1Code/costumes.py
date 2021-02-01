'''
1.)Read Data
2.)Keep a scanner on both sides. If right+left > S, move right scanner. Else, use UB-LB 
functions to get # of cows in that interval and move left scanner
3.)Return total cows
'''
from sys import stdin
fin = open("test.in", "r")

n,s  = map(int, fin.readline().rstrip().split(' '))
cows = sorted([int(fin.readline()) for i in range(n)])
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

1,2,3,5

lscan, rscan = 0, n-1
while lscan != rscan:
    lc, rc = cows[lscan], cows[rscan]
    if(lc+rc > s):
        rscan -= 1
    else:
        count += rscan-lscan
        lscan += 1

print(count)