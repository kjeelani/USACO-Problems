fin, fout = open("guess.in", "r"), open("guess.out", "w")

cowset = set()
class Animal():

	def __init__(self, l):
		self.traits = l[2:]
		self.len = l[1]


	def __repr__(self):
		return str(self.traits)


	


N = int(fin.readline())
animals = [Animal(fin.readline().rstrip().split(' ')) for i in range(N)]

maxG = 0
print(animals)
for a1 in animals:
	ntraits = 0
	for a2 in animals:
		if(a1 == a2): continue
		tntraits = 0 
		for t1 in a1.traits:
			if(t1 in a2.traits): tntraits += 1
		ntraits = max(ntraits, tntraits)
	
	if(ntraits == a1.len): maxG = max(maxG, ntraits)
	else: maxG = max(maxG, ntraits+1)

fout.write("{}\n".format(maxG)); fout.close()



