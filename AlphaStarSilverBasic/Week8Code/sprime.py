'''
1.)
'''

fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
K = int(fin.readline())
comblist = []

def prime(n):
    if(n == 0 or n == 1):
        return False
    for i in range(2, int(n ** .5) + 1):
        if(n % i == 0):
            return False
    else:
        return True

def find_combinations(s):
    if(len(s) == K):
        comblist.append(s)
        return
    for i in range(10):
        x = str(i)
        if prime(int(s+x)):
            find_combinations(s + x)

find_combinations("")

print(prime(2339))

for c in comblist:
    print(c)
