fin = open("meetings.in", "r")
fout = open("meetings.out", "w")

'''
1.)Read data and create a Cow class. While reading data, sum up weights in totalcw/2
2.)Until totalcw/2 reaches 0, use a while loop to increment t by .5, where for each increment
	a.)Move each cow in their velocity direction * .5
	b.)If they reach the barn or 0, pop them from the list and subtract its weight from totalcw/2
	c.)If two "collide", switch their velocities and incrmeent meetings
NOTE: THIS IS INTENDED TO SOLVE ONLY 7 TEST CASES
'''

class Cow:
	totalcw = 0

	def __init__(self, carr):
		self.pos, self.weight, self.vel = map(int, carr)
		Cow.totalcw += self.weight

n, l = map(int, fin.readline().rstrip().split())
cowlist = [Cow(fin.readline().rstrip().split(" ")) for i in range(n)]
Cow.totalcw /= 2

meetings = 0
while Cow.totalcw > 0:
	delete, pos_dict = [], {}
	for i in range(len(cowlist)):
		c = cowlist[i]
		c.pos += .5 * c.vel
		j = pos_dict.get(c.pos) 
		pos_dict[c.pos] = i
		if(c.pos == 0 or c.pos == l):
			Cow.totalcw -= c.weight
			delete.append(i)
		elif(j != None):
			meetings += 1
			cowlist[j].vel *= -1
			c.vel *= -1

fout.write(str(meetings) + "\n")
fout.close()

			
