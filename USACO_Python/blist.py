fin = open("blist.in", "r")
fout = open("blist.out", "w")
from collections import deque

class Cow:

	def __init__(self, l):
		self.s = int(l[0])
		self.e = int(l[1])
		self.b = int(l[2])
	
	@staticmethod
	def start(v):
		return v.s
	
	@staticmethod
	def end(v):
		return v.e

N = int(fin.readline())
cows = deque(sorted([Cow(fin.readline().rstrip().split(' ')) for i in range(N)], key=Cow.start))
cur_cows = []
maxB = 0

def updateBuckets():
	global maxB
	maxB = max(maxB, sum([c.b for c in cur_cows]))

t = 0
while cur_cows or cows:
	t += 1
	if(cows and cows[0].s == t): cur_cows.append(cows.popleft()); cur_cows.sort(key=Cow.end); updateBuckets()
	if(cur_cows and cur_cows[0].e == t): cur_cows.pop(0); updateBuckets()

fout.write("{}\n".format(maxB)); fout.close()