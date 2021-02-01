fin, fout = open("triangles.in", "r"), open("triangles.out", "w")

class Coord():
	
	def __init__(self, l):
		self.x, self.y = int(l[0]), int(l[1])

N = int(fin.readline())
coords = [Coord(fin.readline().rstrip().split(' ')) for i in range(N)]
maxarea = 0

def findArea(l):
	xcoords, ycoords = list(set([c.x for c in l])), list(set([c.y for c in l]))
	if(len(xcoords) != 2 or len(ycoords) != 2): return -1
	else: return abs(xcoords[0] - xcoords[1]) * abs(ycoords[0] - ycoords[1])

for i in range(N):
	for j in range(i+1, N):
		for k in range(j+1, N):
			maxarea = max(maxarea, findArea([coords[i], coords[j], coords[k]]))
fout.write("{}\n".format(maxarea)); fout.close()