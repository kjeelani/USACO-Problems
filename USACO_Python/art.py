fin = open("art.in", "r")
fout = open("art.out", "w")

class Box():

	def __init__(self, a,b,c,d):
		self.lx, self.hx = b, a
		self.ly, self.hy = d,c
	
	def __repr__(self):
		return "({}, {}, {}, {})".format(self.lx, self.hx, self.ly, self.hy)

n = int(fin.readline())
painting = [fin.readline().rstrip() for i in range(n)]
bounds = {str(i):Box(-1,11,-1,11) for i in range(0,10)}
colors = []

for i in range(n):
	for j in range(n):
		id = painting[i][j]
		if(id == "0"):
			continue
		if(id not in colors):
			colors.append(id)
		box = bounds[id]
		if(i > box.hx): box.hx = i
		if(i < box.lx): box.lx = i
		if(j < box.ly): box.ly = j
		if(j > box.hy): box.hy = j

tempc = [t for t in colors]
for color in colors:
	box = bounds[color]
	for i in range(box.lx, box.hx+1):
		for j in range(box.ly, box.hy+1):
			if(color != painting[i][j]):
				if(painting[i][j] in tempc):
					tempc.remove(painting[i][j])

print(bounds)
fout.write(str(len(tempc)) + "\n")
fout.close()



