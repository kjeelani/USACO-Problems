fin = open("mixmilk.in", "r")
fout = open("mixmilk.out", "w")

buckets = [[int(x) for x in fin.readline().rstrip().split(' ')] for i in range(3)]

c = 0
while c < 100:
	prevB, nextB = buckets[c%3], buckets[(c+1)%3]
	amountRemaining = nextB[0] - nextB[1]
	if(prevB[1] - amountRemaining < 0):
		nextB[1] += prevB[1]
		prevB[1] = 0
	else:
		nextB[1] = nextB[0]
		prevB[1] -= amountRemaining
	c += 1

fout.write("{}\n{}\n{}\n".format(buckets[0][1], buckets[1][1], buckets[2][1])); fout.close()
