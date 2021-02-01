'''
1.)Truncate city name
2.)Create list with inverted ctystates
3.)Use UB()-LB() to find all pairings for each item
'''
fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
n = int(fin.readline())
citylist = [[x[:2] if len(x)>2 else x for x in fin.readline().rstrip().split()] for i in range(n)]
citylist.sort()
counter = 0

def upperbound(x):
    left, right = 0, n
    while left < right:
        mid = (right + left) // 2
        if(x >= citylist[mid]):
            left = mid + 1
        else:
            right = mid
    return left

def lowerbound(x):
    left, right = 0, n
    while left < right:
        mid = (right + left) // 2
        if(x <= citylist[mid]):
            right = mid
        else:
            left = mid + 1
    return left

#print(citylist, counter)

for c in citylist:
    newc = c[::-1]
    dif = upperbound(newc) - lowerbound(newc)
    if(newc == c):
        counter -= 1
    counter += dif

fout.write(str(counter//2) +"\n")
fout.close()