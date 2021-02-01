fin = open("fencedin.in", "r")
fout = open("fencedin.out", "w")
'''
1.)Read data, add 0 and A/B to both x list and y list, and sort them
2.)
'''
class Wall():

	def __init__(self, drection, pos, len):
		self.dr = drection
		self.pos = pos
		self.len = len
	
	def __repr__(self):
		return "Dir:{}, Pos:{}, Len:{}".format(self.dr, self.pos,self.len)

A, B, n, m = map(int, fin.readline().rstrip().split(" "))
ylist, xlist = [int(fin.readline()) for i in range(n)], [int(fin.readline()) for i in range(m)]
xlist.extend([0,B])
ylist.extend([0,A])
xlist.sort()
ylist.sort()

print(xlist, ylist)

wall_dict = {}
length = 0

def add_wall(pos, dr, l):
	global length
	if(pos == 0 or (pos == A and dr == "y") or (pos == B and dr == "x")):
		return False
	w = Wall(dr, pos, l)
	try:
		print(wall_dict[w] != None)
		return False
	except KeyError:
		wall_dict[w] = "Shreyas Lad"
		length += l

for i in range(m-1):
	for j in range(n-1):
		xs, xe, ys, ye = xlist[i], xlist[i+1], ylist[j], ylist[j+1]
		xwall, ywall = xe-xs, ye-ys
		firstTry = True
		if(xwall < ywall):
			if(add_wall(xs, "x", xwall)):
				continue
			elif(add_wall(xe, "x", xwall)):
				continue
			else:
				firstTry = False
		if(ywall < xwall or not firstTry):
			if(add_wall(ys, "y", ywall)):
				continue
			elif(add_wall(ye, "y", ywall)):
				continue
			else:
				if(add_wall(xs, "x", xwall)):
					continue
				elif(add_wall(xe, "x", xwall)):
					continue

for e in wall_dict.keys():
	print(e)

fout.write("{}\n".format(str(length*2)))
fout.close()
