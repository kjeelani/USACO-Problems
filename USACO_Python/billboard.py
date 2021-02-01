fin = open("billboard.in", "r")
fout = open("billboard.out", "w")

'''
1.)Store data into vars
2.)Get all coordinates within each rectangle
3.)Filter all coordinates from the first two billboards, and add their lengths together
4.)This length will then be outputted to the judge
'''

def find_coords(rectangle):
	coordlist = []
	for x in range(rectangle[0], rectangle[2]):
		for y in range(rectangle[1], rectangle[3]):
			coordlist.append((x,y))
	return coordlist


billboard1, billboard2, covering_billboard = [int(elem) for elem in fin.readline().rstrip().split(' ')], [int(elem) for elem in fin.readline().rstrip().split(' ')], [int(elem) for elem in fin.readline().rstrip().split(' ')]
covering_billboardcoords = find_coords(covering_billboard)

def find_coordsB(rectangle):
	coordlist = []
	for x in range(rectangle[0], rectangle[2]):
		for y in range(rectangle[1], rectangle[3]):
			if((x,y) not in covering_billboardcoords):
				coordlist.append((x,y))
	return coordlist


bb1list, bb2list = find_coordsB(billboard1), find_coordsB(billboard2)

print(bb1list)
print(bb2list)

fout.write(str(len(bb1list) + len(bb2list)) + "\n")
fout.close()
