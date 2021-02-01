fin = open("taming.in", "r")
fout = open("taming.out", "w")

'''
Note: This is very inefficient and methods can be utilized in a better way(i.e computing min and max together in one iteration)
'''

n = int(fin.readline())

class Node:

	def __init__(self, num, pos):
		self.type = []
		self.v = int(num)
		self.pos = pos
	
	def __repr__(self):
		#return f"v:{self.v}, pos:{self.pos}, type:{self.type}"
		return "F strings dont work in 3.4.0"

daylist = [Node(v, i) for v, i in zip(fin.readline().rstrip().split(" "), range(n))]
breakout_index, logged_index = [], []

#check for breakout
for i in range(n):
	d = daylist[i]
	if(i == 0):
		d.type.append("breakout")
		breakout_index.append(i)
	elif(d.v != -1):
		d.type.append("logged")
		daylist[i-d.v].type.append("breakout")
		breakout_index.append(i-d.v)
		logged_index.append(i)

breakout_index = list(set(breakout_index))
m = len(breakout_index)

#check validity
def valid():
	#print(breakout_index, logged_index)
	for e in logged_index:
		lr = range(e-daylist[e].v+1,e+1)
		for e2 in breakout_index:
			if(e2 in lr):
				return False
	return True

def find_max():
	lrangelist = []
	for e in logged_index:
		for i in range(e-daylist[e].v+1,e+1):
			lrangelist.append(i)
	M = 0
	for i in range(n):
		d = daylist[i]
		if(d.type == [] and i not in lrangelist):
			M += 1
	return m + M



if(valid()):
	M = find_max()
	fout.write("{} {}\n".format(m, M))
	fout.close()
else:
	fout.write("-1\n")
	fout.close()
