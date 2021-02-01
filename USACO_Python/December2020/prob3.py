from sys import stdin as s

'''
1.) Read data. Create cow class of direction, coords, and minimum. Keep 2 sorted list of cows based on direction
2.) Check each cow within the list for current minimum if there is any
3.) Check each cow within the other lists for minimum. Once a minimum is found, break
4.) Output all cows
'''
cowsN, cowsE = [], []

class Cow():

	def __init__(self, l):
		self.d = l[0]
		self.coord = (int(l[1]), int(l[2]))
		self.minimum = 10**9

		if(self.d == "N"): cowsN.append(self)
		else: cowsE.append(self)

	@staticmethod
	def sortEast(v):
		return (v.coord[1], v.coord[0])

	@staticmethod
	def sortNorth(v):
		return v.coord
	
	def __repr__(self):
		return(str(self.coord) + " " + str(self.minimum))

	def __str__(self):
		return(str(self.coord) + " " + str(self.minimum))
		
N = int(s.readline())
cows = [Cow(s.readline().rstrip().split(' ')) for i in range(N)]
cowsN.sort(key=Cow.sortNorth); cowsE.sort(key=Cow.sortEast)

def checkSameDirection(c1, c2):
	if(c1.d == "N"): i = 0
	else: i = 1
	if(c1.coord[i] == c2.coord[i] and c1.coord[1-i] < c2.coord[1-i]): 
		c1.minimum = min(c1.minimum, c2.coord[1-i] - c1.coord[1-i])
	else: return

def checkDifferentDirection(c1, c2):
	if(c1.d == "N"): i = 0
	else: i = 1
	if(c1.coord[i] >= c2.coord[i] and c1.coord[1-i] <= c2.coord[1-i]):
		pricoordiff = c1.coord[i] - c2.coord[i]
		seccoorddiff = c2.coord[1-i] - c1.coord[1-i]
		if(pricoordiff < seccoorddiff and c2.minimum + c2.coord[i] > seccoorddiff):
			c1.minimum = min(c1.minimum, seccoorddiff)
			return True
		elif(pricoordiff != seccoorddiff):
			c2.minimum = min(c2.minimum, pricoordiff)
			return False
		else:
			return False
	else: return False

for c1 in cowsE:
	for c2 in cowsE:
		if c1 == c2: continue
		checkSameDirection(c1, c2)

for c1 in cowsN:
	for c2 in cowsN:
		if c1 == c2: continue
		checkSameDirection(c1, c2)

for c1 in cowsE:
	for c2 in cowsN:
		if(checkDifferentDirection(c1, c2)): break

for c1 in cowsN:
	for c2 in cowsE:
		if(checkDifferentDirection(c1, c2)): break




for c in cows:
	if(c.minimum == 10**9): print("Infinity")
	else: print(c.minimum)


