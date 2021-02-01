'''
1.)We must sort each part by its acceleration(F/M)
2.)Then we must add each of the parts(from most optimized to least) to the car and keep track of how many parts(M_P) we added
for maximum acceleration
3.)Finally, we must print out M_P parts from greatest acceleration(which is a tuple also keeping track of the original index)
and we have our answer
'''
from sys import stdin

def acceleration(v):
    return v[0]/v[1]

CAR_F, CAR_M, N = map(int, stdin.readline().rstrip().split(' '))
parts = [[int(x) for x in stdin.readline().rstrip().split(' ')] + [i] for i in range(N)]
parts.sort(key=acceleration, reverse=True)
max_accel = (0, 0)
current_stats = [CAR_F, CAR_M]

for i in range(N):
    current_stats[0] += parts[i][0]
    current_stats[1] += parts[i][1]
    taccel = current_stats[0]/current_stats[1]
    if(taccel > max_accel[0]):
        max_accel = [taccel, i+1]

final = []
for i in range(max_accel[1]):
    final.append(parts[i][2] + 1)
final.sort()
if(len(final) == 1):
    print("NONE")
else:
    for f in final:
        print(f)