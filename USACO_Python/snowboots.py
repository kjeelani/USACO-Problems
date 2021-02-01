fin = open("snowboots.in", "r")
fout = open("snowboots.out", "w")

from collections import deque

'''
1.)Read data. Push boots into deque(acting as a stack)
2.)Iterate through the tiles until we reach the end
	a.)For each cycle, find the farthest we can go with our current boots
	b.)If we cannot step with our boots, discard boots until you can stand in the snow, then try to step again(add to discard_counter)
3.)Return discard_counter
'''
class Boots:

	def __init__(self, depth, length):
		self.d = depth
		self.l = length
	
	def __str__(self):
		return "Depth:{}, Length:{}".format(self.d, self.l)
	
	def __repr__(self):
		return "Depth:{}, Length:{}".format(self.d, self.l)

def create_boot(b):
	return Boots(int(b[0]), int(b[1]))

ntiles, nboots = map(int, fin.readline().rstrip().split(" "))
tiles = [int(x) for x in fin.readline().rstrip().split(" ")]
bootstack = deque([create_boot(fin.readline().rstrip().split(" ")) for i in range(nboots)])
discard_counter = 0

def discard_boot(c):
	global discard_counter
	newboot = bootstack.popleft()
	discard_counter += 1
	#print(newboot, c)
	while True:
		if(newboot.d < c):
			newboot = bootstack.popleft()
			discard_counter += 1
			#print(newboot, c)
		else:
			return newboot

cur_bt = bootstack.popleft()
cur_t = 0
while cur_t < ntiles:
	try:
		for i in range(cur_t + cur_bt.l, cur_t, -1):
			if(tiles[i] < cur_bt.d):
				#print(i)
				cur_t = i
				break
		else:
			cur_bt = discard_boot(tiles[cur_t])
	except IndexError:
		break




fout.write(str(discard_counter) + "\n")
fout.close()
