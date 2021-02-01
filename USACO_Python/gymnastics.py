fin = open("gymnastics.in", "r") 
fout = open("gymnastics.out", "w")

nsessions, ncows = map(int, fin.readline().rstrip().split(" "))
sessions = [[int(x) for x in fin.readline().rstrip().split(" ")] for i in range(nsessions)]

'''
1.)Read data
2.)Using brute force(O(K*n^2)), for each pairing of cows possible, check if one scored consistently higher than another(if yes, then increment pair_counter)
3.)Return pair counter
'''

print(sessions)

pair_counter = 0
for i in range(1, ncows+1):
	for j in range(1, ncows+1):
		i_on_top = True
		if(i == j):
			continue
		for s in sessions:
			if(s.index(i) >= s.index(j)):
				i_on_top = False
				break
		if(i_on_top):
			pair_counter += 1
			#print(i,j)
		

fout.write(str(pair_counter) + "\n")
fout.close()
