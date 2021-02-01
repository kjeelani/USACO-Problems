'''
1.)
'''
from sys import stdin

fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
N, K = map(int, fin.readline().rstrip().split(' '))
constraints = {i:[] for i in range(N)}
ncombs = 0

def fill_constraints():
    global constraints
    for i in range(K):
        x = fin.readline().rstrip().split(' ')
        constraints[int(x[1])-1].append((int(x[2])-1, x[0]))
        constraints[int(x[2])-1].append((int(x[1])-1, x[0]))
    for i in range(N):
        constraints[i].sort()

fill_constraints()

'''
0.)H
1.)J
2.)G
'''
print(constraints)
def find_combinations(arr, index):
    global ncombs
    if(index == N):
        ncombs += 1
        return
    possibilities = [0,1,2]
    print(arr)
    for c in constraints[index]:
        if(c[0] < index):
            if(c[1] == "S"): 
                if(arr[c[0]] in possibilities): possibilities = [arr[c[0]]]
                else: possibilities = []; break
            else:
                try: possibilities.remove(arr[c[0]])
                except: pass
        else:
            break
    for p in possibilities:
        find_combinations(arr + [p], index + 1)
        

find_combinations([0], 1)

print(ncombs * 3)

