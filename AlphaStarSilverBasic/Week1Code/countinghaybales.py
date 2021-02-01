from sys import stdin

n, q = map(int, stdin.readline().rstrip().split(' '))
hblist = sorted([int(x) for x in stdin.readline().rstrip().split(' ')])
qlist = [[int(x) for x in stdin.readline().rstrip().split(' ')] for i in range(q)]

def upperbound(x):
    left, right = 0, n
    while left < right:
        mid = (right + left) // 2
        if(x >= hblist[mid]):
            left = mid + 1  
        else:
            right = mid
    return left

def lowerbound(x):
    left, right = 0, n
    while left < right:
        mid = (right + left) // 2
        if(x <= hblist[mid]):
            right = mid
        else:
            left = mid + 1
    return left

for query in qlist:
    print(upperbound(query[1]) - lowerbound(query[0]))