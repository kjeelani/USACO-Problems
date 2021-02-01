'''
1.)Read and sort haybales
2.)Use binary search from 1 to N//2 + 1 representing R
    a.)For each binary search, see if the # of cows to drop with a greedy algorithm exceeds K
3.)Return optimal R
'''

fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
N, K = map(int, fin.readline().rstrip().split(' '))
haybales = sorted([int(fin.readline()) for i in range(N)])

def ub(x):
    left, right = 0, N
    while left < right:
        mid = (right + left) // 2
        if(x >= haybales[mid]):
            left = mid + 1
        else:
            right = mid
    return left

def shootAllCows(R):
    nCows = 0
    i, upperI = 0, 0
    while True:
        nCows += 1
        upperI = ub(haybales[i] + 2*R)
        if(upperI == N):
            break
        i = upperI
    return nCows <= K

mn, mx, md = 1, N, 0
while mx - mn > 1:
    md = (mx + mn) // 2
    if shootAllCows(md): 
        mx = md
    else: 
        mn = md + 1
if(mx == mn): print(str(mx))
elif(shootAllCows(mn)): print(str(mn))
else: print(str(mx))

    
    

