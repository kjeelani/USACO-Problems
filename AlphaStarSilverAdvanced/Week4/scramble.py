'''
1.) Read data and make an object with the lowest and highest characters
2.) Create two copies of a sorted list with lowest and highest characters
3.) Run through both lists and add index low and index high attributes
4.) Use an algorithm with lower and upper bound to find indices
'''
from sys import stdin 

class Cow:
    
    def __init__(self, word):
        self.data = word
        self.mindata = sorted(word)
        self.maxdata = sorted(word, reverse=True)
    
    @staticmethod
    def lowSort(v):
        return v.mindata
    
    @staticmethod
    def highSort(v):
        return v.maxdata


fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
N = int(fin.readline())
cows = [Cow(fin.readline().rstrip()) for i in range(N)]
lowcows, highcows = sorted(cows[:], key=Cow.lowSort), sorted(cows[:], key=Cow.highSort)

    

def upperbound(x, arr):
    left, right = 0, N
    while left < right:
        mid = (right + left) // 2
        if(x.maxdata >= arr[mid].mindata):
            left = mid + 1
        else:
            right = mid
    return left

def lowerbound(x, arr):
    left, right = 0, N
    while left < right:
        mid = (right + left) // 2
        if(x.mindata <= arr[mid].maxdata):
            right = mid
        else:
            left = mid + 1
    return left

print([x.data for x in highcows])
for i in range(N): lowcows[i].minI = i
for i in range(N): highcows[i].maxI = i
for c in cows: print(lowerbound(c, highcows)+1, upperbound(c, lowcows))