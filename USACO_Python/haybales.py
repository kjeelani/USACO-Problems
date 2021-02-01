fin = open("haybales.in", "r")
fout = open("haybales.out", "w")

'''
1.)Read data, create a haybale list an queryrange list
2.)For each query, use the x in range method to add number of hayblaes to query
'''

n, q = map(int, fin.readline().rstrip().split(" "))
haybales = [int(x) for x in fin.readline().rstrip().split(" ")]
haybales.sort()
queries = []
for x in range(q):
	l = []
	for y in fin.readline().rstrip().split(" "):
		l.append(int(y))
	l.append(x)
	queries.append(l)
queries.sort()
# print(haybales)
# print("---")
# print(queries)
query_answers = []

si = 0
for e in queries:
	c = 0
	#print("---")
	reached = False
	for h in range(si, n):
		if(haybales[h] > e[1]):
			break
		elif(haybales[h] >= e[0]):
			if(not reached):
				reached = True
				if(h-1 < 0):
					si = 0
				else:
					si = h-1
			c += 1
	query_answers.append([c, e[2]])

# print(query_answers)

def second(v):
	return v[1]

query_answers.sort(key=second)
for item in query_answers:
	fout.write(str(item[0]) + "\n")
fout.close()
