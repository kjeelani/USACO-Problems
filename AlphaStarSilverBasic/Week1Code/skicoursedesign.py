from sys import stdin

n = int(stdin.readline())
skilist = sorted([int(stdin.readline()) for i in range(n)])
mincost = 10 ** 10

def simulate_cost(s, e):
    tc = 0
    for hill in skilist:
        if(hill < s):
            tc += (s-hill) ** 2
        elif(hill > e):
            tc += (hill-e) ** 2
    return tc

for i in range(1, 84):
    tempcost = simulate_cost(i, i+17)
    if(tempcost < mincost):
        mincost = tempcost

print(mincost)