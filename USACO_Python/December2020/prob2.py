from sys import stdin as s

N = int(s.readline())
flowers = [int(x) for x in s.readline().rstrip().split(' ')]
aflowers = 0

for i in range(N):
	for j in range(i, N):
		subblist = flowers[i:j+1]
		slAverage = sum(subblist)/(j+1-i)
		if(slAverage in subblist): aflowers += 1

print(aflowers)