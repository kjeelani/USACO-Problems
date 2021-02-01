'''
1.) Read data
2.) For each cow, return a pair of integers Ui and Wi using the functions given and sort them
ascending(make sure to use pow's modulus operator)
3.) Iterate through each cow in list until you reach N, then add their weights
'''

fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
N, a, b, c, d, e, f, g, h, M = map(int, fin.readline().rstrip().split(' '))

def powK(B, E, MOD):
    result = 1
    for i in range(E):
        result *= B % MOD
    return result % MOD

def weights(i):
    return (a%d*pow(i,5,d)+(b%d*pow(i,2,d)+c%d)%d)%d

def utility(i):
    return (e%h*pow(i,5,h)+(f%h*pow(i,3,h)+g%h)%h)%h

def k(v):
    return (-v[0], v[1])

cows = sorted([(utility(i), weights(i)) for i in range(3*N)], key=k)

s = 0
for i in range(N):
    s += cows[i][1] % M
print(str(s % M))
print(powK(6,3,7))