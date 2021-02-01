'''
1.) Read data
2.) Sort dates and keep track of all changes in a dict
3.) For each production change, check to see if the change puts the cow
above max, next to max, or out of max
'''
from sys import stdin 

fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
N, G = map(int, fin.readline().rstrip().split(' '))
logs = sorted([[int(x) for x in fin.readline().rstrip().split(' ')] for i in range(N)])
leaderboard, maxCow, nChange, nCows = {}, 0, 0, N

for log in logs:
    if log[1] not in leaderboard:
        leaderboard[log[1]] = 0

for log in logs:
    cow = leaderboard[log[1]]
    leaderboard[log[1]] = cow + log[2]
    if(cow + log[2] == maxCow and cow < maxCow): 
        maxCow = cow + log[2]
        nChange += 1; nCows += 1
    elif(cow + log[2] > maxCow and (cow < maxCow or (cow == maxCow and nCows != 1))): 
        maxCow = cow + log[2]
        nChange += 1; nCows = 1
    else:
        v = max(leaderboard.values())
        if(cow == maxCow and cow + log[2] < maxCow and nCows == 1 and v != cow + log[2]):
            maxCow = v
            nChange += 1
    print(leaderboard, nChange, maxCow, nCows)

print(nChange)


   
'''
Cases Where Leaderboard Changes:
1.) When previous was less than max and current is greater than or equal to max
2.) When previous was equal to max and current is greater than max unless only 1 cow was max
3.) When previous was equal to max and current is less than max if new max is not equal to
current max and only 1 cow was max
'''