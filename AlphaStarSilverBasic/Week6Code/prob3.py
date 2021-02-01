'''
1.)This is a simple deque problem where we process whether we need to append or remove cows, and from what end
'''
from sys import stdin
from collections import deque

N = int(stdin.readline())
operations = [stdin.readline().rstrip().split(' ') for i in range(N)]

d = deque([])
c = 1

for o in operations:
    if(o[0] == "A"):
        if(o[1] == "L"):
            d.appendleft(c)
        else:
            d.append(c)
        c += 1
    else:
        if(o[1] == "L"):
            for i in range(int(o[2])):
                d.popleft()
        else:
            for i in range(int(o[2])):
                d.pop()

for e in list(d):
    print(e)
    