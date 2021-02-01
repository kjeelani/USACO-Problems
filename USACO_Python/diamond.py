fin = open("diamond.in", "r")
fout = open("diamond.out", "w")

'''
1.)Read data
2.)Sort the diamond sizes
3.)In a for loop through the diamond sizes:
	a.)Loop forward and backwards and store it in temporary counter until size is greater than 3
	b.)If the count is greater than maximum count, replace it
4.)Output maximum count
'''

ndiamonds, K = map(int, fin.readline().rstrip().split(' '))
diamonds = [int(fin.readline()) for i in range(ndiamonds)]
max_c = 0

for i in range(ndiamonds):
	current_size = diamonds[i]
	temp_c = 0
	for j in range(ndiamonds):
		if(diamonds[j] in range(current_size, current_size+K+1)):
			temp_c += 1
	# iterator = 0
	# #forward
	# while True:
	# 	iterator += 1
	# 	if(i+iterator < ndiamonds):
	# 		if(diamonds[i+iterator] - diamonds[i] <= K):
	# 			temp_c += 1
	# 		else:
	# 			break
	# 	else:
	# 		break
	# print(i, temp_c)
	if(temp_c > max_c):
	 	max_c = temp_c

fout.write(str(max_c) + "\n")
fout.close()
