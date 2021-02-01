fin = open("lineup.in", "r") 
fout = open("lineup.out", "w")



'''
1.)Precreate the 8 cows using a Cow class that has a node called after and before
2.)For each constraint, connect each cow to any available node
3.)Reorder the node so that each cow is connected in order
4.)Line up nodes in order
THIS CODE IS NOT OPTIMIZED. BEWARE OF BAD CODE
'''

def name(v):
	return v.name

class Cow:

	def __init__(self, name):
		self.name = name
		self.connections = []
	
	def __str__(self):
		return "{}: {}\n".format(self.name, ", ".join([c.name for c in self.connections]))
	
	def __repr__(self):
		return self.name

cows = [Cow("Bessie"), Cow("Buttercup"), Cow("Belinda"), Cow("Beatrice"), Cow("Sue"), Cow("Betsy"), Cow("Blue"), Cow("Bella")]
cows.sort(key=name)
cow_index = {"Beatrice":0, "Belinda":1, "Bella":2, "Bessie":3, "Betsy":4, "Blue":5, "Buttercup":6, "Sue":7}
nconstraints = int(fin.readline())
constraints = [[x for x, j in zip(fin.readline().rstrip().split(" "), range(6)) if j == 0 or  j == 5] for i in range(nconstraints)]

#connect cows
for q in constraints:
	c1, c2 = cows[cow_index[q[0]]], cows[cow_index[q[1]]]
	c1.connections.append(c2)
	c2.connections.append(c1)

#print connections
for c in cows:
	print(c)

def find_connections(cowlist, direction):
	'''find the connections between the cows and return a list'''
	if(direction == "left"):
		if(cowlist[-1].connections != 2):
			return cowlist
		for x in cowlist[-1].connections:
			if x not in cowlist:
				cowlist.append(x)
				return find_connections(cowlist, direction)
	elif(direction == "right"):
		if(cowlist[0].connections != 2):
			return cowlist
		for x in cowlist[0].connections:
			if x not in cowlist:
				cowlist.insert(0, x)
				return find_connections(cowlist, direction)

def merge(l):
	tl = []
	for i in l:
		tl += i
	return tl

true_cow_list = []
#order the cows(this code could be improved)
for c in cows:
	tl = merge(true_cow_list)
	if(c in tl):
		continue
	if(len(c.connections) == 0):
		true_cow_list.append([c])
		continue
	tl = []
	for d in c.connections:
		#print(c, d)
		try:
			if(d.name > c.name and tl[-1] == c):
				tl.extend(find_connections([c, d], "left"))
			elif(tl[0] == c):
				tl = find_connections([d, c], "right") + tl
		except IndexError:
			if(d.name > c.name):
				tl.extend(find_connections([c, d], "left"))
			elif(tl[0] == c):
				tl = find_connections([d, c], "right") + tl
			
		
	print(tl)
	print(c)
	if(tl.count(c) > 1):
		tl.remove(c)
	true_cow_list.append(tl)

def sortkey2(v):
	return v[0].name

print(true_cow_list)

true_cow_list.sort(key=sortkey2)

for c in true_cow_list:
	for csub in c:
		fout.write(csub.name + "\n")
fout.close()
			





