fin = open("lemonade.in", "r")
fout = open("lemonade.out", "w")

from collections import deque

'''
NAIVE APPROACH
1.)Read data and sort descending
2.)Push all elements into deque that are greater than N
3.)Find the lowest element's wi in the list and its number. Proceed to push the higest elements into the stack until wi is reached
4.)Repeat thsi double ended pushing and discarding till all element of cow are gone
'''


n = int(fin.readline())
line = deque()

cows = [int(x) for x in fin.readline().rstrip().split(" ")]
cows.sort(reverse=True)
cows = deque(cows)
cur_n = len(line)

#print(line, cows)
#first push for lowest element
while True:
	try:
		x = cows.pop()
	except IndexError:
		break
	while cur_n <= x:
		try:
			line.append(cows.popleft())
		except IndexError:
			break
		cur_n += 1
#print(line, cows)


fout.write(str(cur_n) + "\n")
fout.close()
