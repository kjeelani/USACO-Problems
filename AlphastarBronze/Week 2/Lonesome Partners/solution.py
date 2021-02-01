import math, sys

class cow_location:
    def __init__(self, x, y):
        self.x = x
        self.y = y

def PythagTheorem(p1, p2):
    xchange = p2.x - p1.x
    ychange = p2.y - p1.y
    hypotenuse = math.sqrt(xchange**2 + ychange**2)
    return hypotenuse

numberofcows = int(sys.stdin.readline())
cows_coordinates = [None] * numberofcows
N = 0
while True:
    cow_point = sys.stdin.readline()
    cow_point_split = cow_point.split()
    if not cow_point:
        break
    cows_coordinates[N] = cow_location(int(cow_point_split[0]), int(cow_point_split[1]))
    N += 1

highest_length = 0
highest_index1 = 0
highest_index2 = 0
for i in range(0, len(cows_coordinates)):
    for j in range(i + 1, len(cows_coordinates)-1):
        if(PythagTheorem(cows_coordinates[i], cows_coordinates[j]) > highest_length):
            highest_length = PythagTheorem(cows_coordinates[i], cows_coordinates[j])
            highest_index1 = i+1
            highest_index2 = j+1
        if(i+1 == len(cows_coordinates)):
            break
  
print(str(highest_index1) + " " + str(highest_index2))#return input shouldn't be a string
