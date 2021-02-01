fin = open("moocast.in", "r")
fout = open("moocast.out", "w")
from copy import deepcopy

'''
1.)Read input
2.)For each cow, find distance from all other cows and add up all cows less than print
3.)return greatest cow
'''

class Cow:

	def __init__(self, cowlist):
		self.x, self.y, self.r = cowlist[0], cowlist[1], cowlist[2]
		self.pointers = []

ncows = int(fin.readline())
cows = [Cow([int(x) for x in fin.readline().rstrip().split(" ")]) for i in range(ncows)]
max_cow = 0

def find_distance(x1,x2,y1,y2):
	return ((x2-x1)**2 + (y2-y1)**2)**.5

for e1 in cows:
	for e2 in cows:
		if(find_distance(e1.x, e2.x, e1.y, e2.y) < e1.r):
			e1.pointers.append(e2)

def find_cow_connections(cow):
	cowqueue, already_checked, total = [cow], [], 0
	while len(cowqueue) != 0:
		temp_c = cowqueue.pop(0)
		for e in temp_c.pointers:
			if(e not in already_checked):
				cowqueue.append(e)
				already_checked.append(e)
				total += 1
	return total

for e in cows:
	t = find_cow_connections(e)
	if(t > max_cow):
		max_cow = t



	

fout.write(str(max_cow) + "\n")
fout.close()
