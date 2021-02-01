'''
For this one you can do two checks.

1.)Sort all barrels by width and see the maximum stack you can make
2.)Sort all barrels by height and see the maximum stack you can make
3.)Return maximum stack

Of course we factor in constraints when making the stack

'''
x = input("enter something")

fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
road = fin.readline().rstrip()
N = len(road)
combN = 0

def find_combinations(pos):
    global combN
    if(pos >= N-1):
        if(pos == N-1):
            combN += 1
        return
    if(road[pos + 1] != "#"):    
        find_combinations(pos + 1)
    try:
        if(road[pos + 2] != "#"):
            find_combinations(pos + 2)
    except:
        pass

find_combinations(0)

print(combN)