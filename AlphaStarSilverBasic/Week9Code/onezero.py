'''
1.)
'''
from sys import stdin

N = int(stdin.readline())
comb_list = []

def find_combinations(arr):
    global current_minimum
    if(len(arr) == N):
        if(arr.count(1) > N//2):
            comb_list.append(arr)
        return
    for i in range(2):
        find_combinations(arr + [i])

find_combinations([])

for c in comb_list:
    s = ""
    for e in c:
        s += str(e)
    print(s)
print(len(comb_list))
