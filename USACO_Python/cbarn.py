fin = open("cbarn.in", "r")
fout = open("cbarn.out", "w")
from collections import deque
'''
1.)Read data and create a list with the data
	-Also create a cow class with distance attribute
2.)Keep on cycling through the list and move each cow one by one circularly until the entire barn is filled with cows
3.)Sum up distance and return it
'''
class Cow:

	def __init__(self, d):
		self.d = d
	
	def __repr__(self):
		return str(self.d)

n = int(fin.readline())
barn = []
for i in range(n):
	tempn = int(fin.readline())
	l = deque()
	for j in range(tempn):
		l.append(Cow(0))
	barn.append(l)

while True:
	isFilled = True
	for i in range(n):
		try:
			d, nextd = barn[i], barn[i+1]
		except IndexError:
			d, nextd = barn[i], barn[0]
		if(len(d) > 1):
			isFilled = False
			d[0].d += 1
			nextd.append(d.popleft())
			
	if(isFilled):
		break


totald = 0
for i in range(n):
	totald += barn[i][0].d ** 2

fout.write("{}\n".format(totald))
fout.close()
