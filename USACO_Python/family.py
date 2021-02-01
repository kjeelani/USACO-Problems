fin = open("family.in", "r")
fout = open("family.out", "w")
from copy import copy
'''
1.)Read data, form tree, save nodes AA and BB
2.)Check if AA and BB have the same root node(if not, not related)
3.)Find the heights of AA and BB and subtract them(0=sisters/cousins, 1=mom/aunt, 2=gmom/gaunt)
4.)Finally check if the node with the higher height is in the linear path to the top node(Yes=Mom/)

Alternative:
1.)Read data, form tree, find height of AA
2.)Start search from Node AA. Go up to parent, check if BB is there. Go to children and check if BB are there.
3.)Start from parent, go to ITS parent, check if BB is there, then go down to all children until you reach height of AA
4.)When you find BB, keep track of its height
'''

n, p1, p2 = map(str, fin.readline().rstrip().split())
n = int(n)
parent_dict, child_dict = {}, {}
#make tree
for i in range(n):
	mother, child = map(str, fin.readline().rstrip().split())
	try:
		child_dict[mother].append(child)
	except KeyError:
		child_dict[mother] = [child]
	parent_dict[child] = mother

height = 0
node = p1
name = "origin"

def search_children(n, temph):
	returnlist = []
	if(temph == 0):
		return None
	try:
		for child in child_dict[n]:
			if(child == node):
				pass
			elif(child == p2):
				return temph
			else:
				returnlist.append(search_children(child, copy(temph-1)))
	except KeyError:
		return None
	for e in returnlist:
		if e is not None:
			return e

while True:
	#parent search
	name = "mother"
	height += 1
	try:
		parent = parent_dict[node]
	except KeyError:
		name = "NOT RELATED"
	if(parent == p2):
		break

	#children search
	scresult = search_children(parent, copy(height))
	if(scresult != None):
		if(height == scresult):
			if(height == 1):
				name = "SIBLINGS"
			else:
				name = "aunt"
		else:
			name = "COUSINS"
		break
	
	node = parent

#naming process

mlist = ["mother", "grand-mother", "great-grand-mother", "great-great-grand-mother, great-great-great-great-grand-mother"]
alist = ["aunt", "great-aunt", "great-great-aunt", "great-great-great-aunt", "great-great-great-great-aunt"]
if(name != "mother" and name != "aunt"):
	fout.write(name + "\n")
elif(name == "mother"):
	fout.write("{} is the {} of {}\n".format(p2, mlist[height-1], p1))
else:
	fout.write("{} is the {} of {}\n".format(p2, alist[height-2], p1))
fout.close()