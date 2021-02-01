'''
1.)
'''

fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
N = int(fin.readline())
nset = fin.readline().rstrip().split(' ')
K = int(fin.readline())
comb_list = []

def find_combinations(arr):
    if(len(arr) == K):
        comb_list.append(arr)
        return
    for i in range(N):
        find_combinations(arr + [nset[i]])

find_combinations([])

for c in comb_list:
    print("".join(c))
