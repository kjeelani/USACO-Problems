fin = open("word.in", "r")
fout = open("word.out", "w")

'''
1.)Read data into a queue
2.)Take out elements and place them into a temporary list. If the list meets the requirements, push the list into the print list
'''

nwords, k = map(int, fin.readline().rstrip().split(" "))
words = fin.readline().rstrip().split(" ")

def len_str_lst(l):
	c = 0
	for e in l:
		c += len(e)
	return c

line = []
while len(words) != 0:
	x = words.pop(0)
	if(len(x) + len_str_lst(line) <= k):
		line.append(x)
	else:
		fout.write(" ".join(line) + "\n")
		line = []
		line.append(x)
if(len(line) != 0):
	fout.write(" ".join(line) + "\n")

fout.close()

