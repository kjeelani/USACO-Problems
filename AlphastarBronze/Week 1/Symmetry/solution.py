#first find the center of the grid by using dividing on two numbers. If the modulus of any number is 0, stop(repeat for every subaction)
#Then divide both rows and columns by 2 and round down and assign those vars to itself
#Repeat first step until condition doesnt work
import sys

rows_columns = sys.stdin.readline().split()
rows = int(rows_columns[0])
columns = int(rows_columns[1])
num_of_cows = 0
cow_spread_tier = 0

while True:
    if(rows % 2 == 0 or columns % 2 == 0):
        break
    else:
        num_of_cows = num_of_cows + (4**cow_spread_tier)
        if(rows == 1 or columns == 1):
            break
        cow_spread_tier += 1
        rows = int(rows/2)
        columns = int(columns/2)

print(num_of_cows)
    
    

