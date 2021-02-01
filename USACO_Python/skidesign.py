"""
ID: kaif.aj1
LANG: PYTHON3
PROG: skidesign
"""
fin = open("skidesign.in", "r")
fout = open("skidesign.out", "w")


'''
1.)Read data
2.)For each N from 1-83(since the constraint for hill length is 100), for each hill x find absolue distance from x to N and N+17
3.)Return minimum cost
'''

nhills = int(fin.readline().rstrip())
hill_lengths = [int(fin.readline()) for i in range(nhills)]
hill_lengths.sort()
money = 10**10

def find_cost(s):
	e = s + 17
	c = 0
	for x in hill_lengths:
		if(x >= e):
			c += (x-e) ** 2
		elif(x <= s):
			c += (s-x) ** 2
	return c

for i in range(1, 83):
	y = find_cost(i)
	if(y < money):
		money = y

fout.write(str(money) + "\n")
fout.close()
