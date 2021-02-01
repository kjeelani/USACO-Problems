'''
1.)Use our combinations function with special pruning
    a.)The base case is when the sum is greater than or equal to the shelf
    b.)For each recursive call, add on a new cow who doesnt exceed the length more than the
    current minimum
'''
from sys import stdin

fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
N, S = map(int, fin.readline().rstrip().split(' '))
cows = sorted([int(fin.readline()) for i in range(N)], reverse=True)
current_minimum = 100000

def find_combinations(arr, sumCows):
    global current_minimum
    if(sumCows - S >= 0 and sumCows - S < current_minimum):
        current_minimum = sumCows - S
        return
    try:
        for i in range(arr[-1], N):
            if i not in arr:
                find_combinations(arr + [i], sumCows + cows[i])
    except:
        for i in range(N):
            if i not in arr:
                find_combinations(arr + [i], sumCows + cows[i])

find_combinations([], 0)

print(current_minimum)
