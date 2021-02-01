"""
ID: kaif.aj1
LANG: PYTHON3
PROG: square
"""
fin = open("square.in", "r")
fout = open("square.out", "w")
square1 = [int(x) for x in fin.readline().rstrip().split(' ')]
square2 = [int(x) for x in fin.readline().rstrip().split(' ')]

def find_vert_dist():
	'''find max vertical distance'''
	vertlist = [square1[1], square1[3], square2[1], square2[3]]
	return max(vertlist) - min(vertlist)

def find_horzdist():
	'''find max horizontal distance'''
	horizlist = [square1[0], square1[2], square2[0], square2[2]]
	return max(horizlist) - min(horizlist)

truedist = max([find_vert_dist(), find_horzdist()]) ** 2

fout.write(str(truedist) + "\n")
fout.close()
