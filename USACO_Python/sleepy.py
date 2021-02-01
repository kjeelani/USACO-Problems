fin = open("sleepy.in", "r")
fout = open("sleepy.out", "w")

N = int(fin.readline())
cows = [int(x) for x in fin.readline().rstrip().split(' ')]
swaps = 0

wrong = False
for i in range(N-2, -1, -1):
	print(i)
	if(cows[i] > cows[i+1]):
		swaps = i+1
		break
fout.write("{}\n".format(swaps)); fout.close()



