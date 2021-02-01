import sys

#intializing
first_line = sys.stdin.readline().split(" ")
bracelet_length = int(first_line[0])
numCharms = int(first_line[1])
nailNum = int(first_line[2])

#DroopDistanceFunction
def findDroopDistance(length, position):
    droop_distance = abs(nailNum-position) + length
    print(droop_distance)

#looping through inputs
for i in range(numCharms):
    line = sys.stdin.readline().split(" ")
    findDroopDistance(int(line[0]), int(line[1]))
