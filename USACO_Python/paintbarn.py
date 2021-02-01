fin = open("paintbarn.in", "r")
fout = open("paintbarn.out", "w")
import numpy as np
'''
1.)Read data to list
2.)Process each rectangle and all of the coordinates within it, incrementing the value of the key(coord) in the hashmap by 1
3.)Get all values of hashmap and find the count of K
'''
maxX, maxY = 0, 0
class Coords:
	

	def __init__(self, c):
		global maxX, maxY
		self.x1, self.y1, self.x2, self.y2 = map(int, c)
		if(self.x2 > maxX):
			maxX = self.x2
		if(self.y2 > maxY):
			maxY = self.y2

n, k = map(int, fin.readline().rstrip().split(' '))
coordlist = [Coords(fin.readline().rstrip().split(' ')) for i in range(n)]
simcoords = np.array([[0 for i in range(maxY)] for i in range(maxX)])

for c in coordlist:
	print(c)
	simcoords[c.x1:c.x2, c.y1:c.y2] += 1

def findK():
	c = 0
	for x in simcoords:
		for y in x:
			if(y == k):
				c+=1
	return c

fout.write("{}\n".format(str(findK())))
fout.close()
