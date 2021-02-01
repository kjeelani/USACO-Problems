fin = open("teleport.in", "r")
fout = open("teleport.out", "w")

from collections import deque
from math import ceil

'''
1.)Read data. For each manure pile read, push it to process or constant
2.)Process the optimal position for the teleporter for both the negative and positive sides in the process, then find di for each while also finding di for const
3.)Return whichever di is greater
'''

n = int(fin.readline())
process, const = [], []
posdi, negdi, constdi, y = 0, 0, 0, 0
for i in range(n):
	x = sorted([int(x) for x in fin.readline().rstrip().split(" ")])
	if((x[0] > 0 and x[1] >0 or x[0] < 0 and x[1] < 0) and abs(x[0]-0) > abs(x[1]-x[0])):
		#const.append(x)
		constdi += abs(x[0] - x[1])
	else:
		process.append(x)

print(process, constdi)
#find const di
# for x in const:
# 	constdi += 3+2

#find positive y
sum,c = 0, 0
for x in process:
	sum += x[1]
	c += 1
y = sum/c

print(y)

#find positive di
for x in process:
	posdi += abs(x[1] - y) + abs(x[0])

#find neg y
sum,c = 0, 0
for x in process:
	if(x[0] < 0):
		sum += x[0]
		c += 1
y = sum/c

print(y)

#find neg di
for x in process:
	negdi += abs(x[0] - y) + abs(x[1])

if(posdi > negdi):
	fout.write(str(ceil(negdi + constdi)) + "\n")
else:
	fout.write(str(ceil(posdi + constdi)) + "\n")
fout.close()
