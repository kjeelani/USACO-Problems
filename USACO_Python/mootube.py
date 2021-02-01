fin = open("mootube.in", "r")
fout = open("mootube.out", "w")
from collections import deque
'''
1.)Read data
2.)Build data structure with attributes of vidnum and connections(a list of tuples, with each tuple containing the vid node it is connected with and the relevance)
3.)Connect all the nodes
4.)For each Q(k,v) query, do a dfs to see how many videos with relevance of at least k vid v can reach
'''

class vidNode():

	def __init__(self, num):
		self.connections = []
		self.num = num
	
	def __str__(self):
		print("Id:", self.num, "connections:", self.connections)
		return "\n"
	
	def __repr__(self):
		return str(self.num)


n, q = map(int, fin.readline().rstrip().split(" "))
network = [vidNode(i) for i in range(n)]

def printNodes():
	for node in network:
		print(node)

def bfs(k, v):
	nvids = 0
	bfsqueue = deque([network[v-1]])
	already_visited = []
	while len(bfsqueue) > 0:
		current_vid = bfsqueue.popleft()
		if(current_vid in already_visited):
			continue
		already_visited.append(current_vid)
		for c in current_vid.connections:
			if(k <= c[1]):
				nvids += 1
				bfsqueue.append(c[0])
	return nvids

for i in range(n-1):
	v1, v2, r = map(int, fin.readline().rstrip().split(" "))
	x, y = network[v1-1], network[v2-1]
	y.connections.append((x, r))
	x.connections.append((y, r))

for i in range(q):
	k, v = map(int, fin.readline().rstrip().split(" "))
	fout.write(str(bfs(k,v)//2) + "\n")

fout.close()
