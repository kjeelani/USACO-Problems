fin = open("countcross.in", "r")
fout = open("countcross.out", "w")

from collections import deque
'''
1.)Read data(n, r roads, k cow locations)
2.)Build grid based on N
	a.)For O(n^2), create a node with 4 pointers in all directions. Set them all to False
	b.)For each road, locate the pointer node and where it is pointing and set it to True
	c.)For each cow, set hasCow equal to true in that node
3.)Use a funky BFS for each cow to find all pairs
'''
class Farm:

	def __init__(self, coords):
		self.hasCow = False
		self.coords = coords
		self.e, self.w, self.n, self.s = False, False, False, False
		if(coords[0] == 0):
			self.n = True
		if(coords[0] == n-1):
			self.s = True
		if(coords[1] == 0):
			self.w = True
		if(coords[1] == n-1):
			self.e = True

	def __str__(self):
		return self.coords

	def __repr__(self):
		return "[{}, {}, e:{}]".format(self.coords[0], self.coords[1], self.e)

n, k, r = map(int, fin.readline().rstrip().split(" "))
farm_matrix = [[Farm([r,c]) for c in range(n)] for r in range(n)]
cow_coords = []
encapsulated_cows = 0
pairs = -1 * k


def find_direction(x1, y1, x2, y2):
	if(x1-x2 != 0):
		if(x1-x2 > 0):
			return "n"
		else:
			return "s"
	elif(y1-y2 > 0):
		return "w"
	else:
		return "e"

def opposite(d):
	if(d == "s"):
		return "n"
	elif(d == "n"):
		return "s"
	elif(d == 'w'):
		return "e"		
	else:
		return "w"

for i in range(r):
	x1, y1, x2, y2 = map(int, fin.readline().rstrip().split(" "))
	farm1, farm2 = farm_matrix[x1-1][y1-1], farm_matrix[x2-1][y2-1]
	f1tof2 = find_direction(x1, y1, x2, y2)
	f2tof1 = opposite(f1tof2)
	for e, d in zip([farm1, farm2], [f1tof2, f2tof1]):
		if(d == "s"):
			e.s = True
		elif(d == "n"):
			e.n = True
		elif(d == "e"):
			e.e = True
		else:
			e.w = True

for i in range(k):
	x, y = map(int, fin.readline().rstrip().split(" "))
	farm_matrix[x-1][y-1].hasCow = True
	cow_coords.append((x-1,y-1))

# for x in farm_matrix:
# 	for c in x:
# 		print(c)

for crds in cow_coords:
	cow = farm_matrix[crds[0]][crds[1]]
	#Simulating BFS I think idrk
	cowlist = []
	cowqueue = deque([cow])
	while len(cowqueue) > 0:

		#print(list(cowqueue), cowlist)
		c = cowqueue.popleft()
		if(c in cowlist):
			continue
		cowlist.append(c)
		if(c.hasCow):
			pairs += 1

		x, y = map(int, c.coords)
		if(not c.e):
			n = farm_matrix[x][y+1]
			cowqueue.append(n)
		if(not c.w):
			n = farm_matrix[x][y-1]
			cowqueue.append(n)
		if(not c.n):
			n = farm_matrix[x-1][y]
			cowqueue.append(n)
		if(not c.s):
			n = farm_matrix[x+1][y]
			cowqueue.append(n)
			
		

fout.write(str(pairs) + "\n")
fout.close()
