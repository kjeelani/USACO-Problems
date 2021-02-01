fin, fout = open("swap.in", "r"), open("swap.out", "w")

N, K = map(int, fin.readline().rstrip().split(' '))
step1, step2 = [int(x)-1 for x in fin.readline().rstrip().split(' ')], [int(x)-1 for x in fin.readline().rstrip().split(' ')]

listOfLists = [[i for i in range(1, N+1)]]

def output(l):
	for e in l:
		fout.write("{}\n".format(e))
	fout.close()

def doSteps(l):
	print(l)
	s1 = l[:step1[0]] + l[step1[0]:step1[1]+1][::-1] + l[step1[1]+1:]
	return s1[:step2[0]] + s1[step2[0]:step2[1]+1][::-1] + s1[step2[1]+1:]

c = 1
while True:
	c += 1
	listOfLists.append(doSteps(listOfLists[-1]))
	print(listOfLists)
	if(c > K):
		output(listOfLists[-1])
		break
	if(listOfLists[-1] == listOfLists[0]):
		listOfLists.pop(0)
		output(listOfLists[K%len(listOfLists)-1])
		break
