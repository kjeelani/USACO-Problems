fin = open("pairup.in", "r")
fout = open("pairup.out", "w")
from collections import deque

class Node:

	def __init__(self, lis):
		self.nc = int(lis[0])
		self.v = int(lis[1])
	
	def __repr__(self):
		return "{} - {}".format(self.nc, self.v)

def sec(v):
	return v.v

n = int(fin.readline())
pairings = deque(sorted([Node(fin.readline().rstrip().split(' ')) for i in range(n)], key=sec))

maxtime = 0
while True:
	#print(pairings)
	try:
		fe, le = pairings[0], pairings[-1]
	except IndexError:
		break
	if(fe == le):
		break
	if(fe.v + le.v > maxtime):
			maxtime = fe.v + le.v
	if(fe.nc > le.nc):
		fe.nc -= le.nc
		pairings.pop()
	elif(fe.nc < le.nc):	
		le.nc -= fe.nc
		pairings.popleft()
	else:
		pairings.pop()
		pairings.popleft()


fout.write("{}\n".format(maxtime))
fout.close()