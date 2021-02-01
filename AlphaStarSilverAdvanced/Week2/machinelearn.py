'''
1.) Precompute midpoints of all cows known in the graph
    a.) For each midpoint, have a tuple of 3 values
    b.)(average of two values, (Startpoint), (Endpoint))
2.) Loop through all midpoints and find number of cows that are spotted
3.) Return that sum plus cows at each endpoint
'''
from math import ceil, floor
from sys import stdin 

class Point:
    def __init__(self, data):
        self.data = int(data[1])
        self.type = data[0]
        
    @staticmethod
    def sortstyle(v):
        return v.data
    
    def __repr__(self):
        return("({}, {})".format(self.data, self.type))

class Interval:
    
    def __init__(self,s,e):
        self.s = s
        self.e = e
    
    def contains(self, n):
        if(self.s <= n <= self.e): return True
        else: return False
    
    def __repr__(self):
        return("({}, {})".format(self.s, self.e))

fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
N, A, B = map(int, fin.readline().rstrip().split(' '))
points = sorted([Point(fin.readline().rstrip().split(' ')) for i in range(N)], key=Point.sortstyle)
intervals = []
nspotted = 0

def floorS(p1, p2):
    global nspotted
    n = (p1.data + p2.data)/2
    if(int(n) == n and p1.type == "S" and A <= n <= B): nspotted -= 1
    return floor(n)

for i in range(N):
    p = points[i]
    if(p.type == "S"):
        if(i == 0): intervals.append(Interval(0, floorS(points[i+1],p)))
        elif(i == N-1): intervals.append(Interval(ceil((p.data + points[i-1].data)/2), 10**10))
        else: intervals.append(Interval(ceil((p.data + points[i-1].data)/2), floorS(points[i+1],p)))

for i in intervals:
    if(i.e < A): continue
    if(i.s > B): break
    if(i.contains(A)): i.s = A
    if(i.contains(B)): i.e = B
    nspotted += i.e - i.s + 1

print(intervals)
print(int(nspotted))
        