from sys import stdin

'''
1.)
'''

N = 12
cows = [int(stdin.readline()) for i in range(N)]
minDist = 10 ** 7

def update(b, l):
    new = b[:]
    for x in l:
        new[x] = True
    return new

def find_combinations(arr, b):
    global minDist
    if(len(arr) == N/3):
        tempD = max(arr) - min(arr)
        if(minDist > tempD):
            minDist = tempD
        return
    if(len(arr) > 1 and max(arr) - min(arr) > minDist): return
    for i in range(2,N):
        if b[i]: continue
        for j in range(i):
            if b[j]: continue
            for k in range(j):
                if b[k]: continue
                find_combinations(arr + [sum([cows[x] for x in (i,j,k)])], update(b, [i,j,k]))

            

find_combinations([],[False for i in range(N)])
print(str(minDist))