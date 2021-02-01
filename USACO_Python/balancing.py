fin = open("balancing.in", "r")
fout = open("balancing.out", "w")
from collections import deque
'''
1.)Read data, and create two lists, one with coords sorted via x and one with coords sorted by y
2.)Find the halfway point of both lists. These represent a and b
3.)Seperate the coordinates into 4 lists and find the maximum num of coords in each list
4.)Return this maximum
'''
class Coord():

	def __init__(self, coord):
		self.x, self.y = int(coord[0]), int(coord[1]) 

def sortx(v):
	return v.x

def sorty(v):
	return v.y

n = int(fin.readline())
a, b = 0, 0
coords = [Coord(fin.readline().rstrip().split(" ")) for i in range(n)]

coords.sort(key=sortx)
a = coords[n//2-abs((n%2-1))].x
coords.sort(key=sorty)
b = coords[n//2-abs((n%2-1))].y

def find_max(x, y):
	l1, l2, l3, l4 = 0,0,0,0
	for e in coords:
		if(e.x > x):
			if(e.y > y):
				l1 += 1
			else:
				l2 += 1
		else:
			if(e.y > y):
				l3 += 1
			else:
				l4 += 1
	print(l1,l2,l3,l4)
	return max(l1,l2,l3,l4)

mincoords = min(find_max(a+1, b-1), find_max(a-1, b+1), find_max(a+1, b+1), find_max(a-1, b-1))
fout.write("{}\n".format(str(mincoords)))
fout.close()
