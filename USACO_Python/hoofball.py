fin = open("hoofball.in", "r")
fout = open("hoofball.out", "w")

'''
1.)Read data into vars
2.)Create a list called oscillators that store the indices of oscillating pairs
3.)Find the slices between each oscillating pair. If the slice points towards either oscillating pair, add +1 to their pointer counter
4.)Loop through the list, add 2 the the output_counter if the pointer counter is 2 and 1 for all other numbers
5.)Output output_counter
'''

ncows = int(fin.readline())
cows = [int(x) for x in fin.readline().rstrip().split(' ')]
cows.sort()
print(cows)
osc_i = []

#find pairs
for i in range(ncows):
	if(i < 2):
		if(i == 1):
			if(cows[i+1] - cows[i] > cows[i] - cows[i-1]):
				osc_i.append([i, 0])
	elif(i == ncows - 1):
		if(cows[i-1] - cows[i-2] > cows[i] - cows[i-1]):
			osc_i.append([i, 0])
	else:
		if(cows[i+1] - cows[i] > cows[i] - cows[i-1]
		and cows[i-1] - cows[i-2] > cows[i] - cows[i-1]):
			osc_i.append([i, 0])


for i in range(len(osc_i)):
	ci = osc_i[i][0]
	if(i == 0):
		if(ci != 1):
			osc_i[0][1] += 1
		if(ci + 2 <= len(cows)-1): 
			if(cows[ci + 1] - cows[ci] < cows[ci + 2] - cows[ci + 1]):
				osc_i[i][1] += 1
	elif(i == len(osc_i)-1):
		if(ci != ncows-1):
			osc_i[-1][1] += 1
		if(ci-3 >= 0):
			if(cows[ci - 2] - cows[ci - 1] < cows[ci - 3] - cows[ci - 2]):
				osc_i[i][1] += 1
	else:
		if(ci-3 >= 0):
			try:
				if(ci - osc_i[i-1][0] == 2):
					continue
			except:
				pass
			if(cows[ci - 2] - cows[ci - 1] < cows[ci - 3] - cows[ci - 2]):
				osc_i[i][1] += 1
		if(ci + 2 <= len(cows)-1): 
			try:
				if(osc_i[i+1][0] - ci == 2):
					continue
			except:
				pass
			if(cows[ci + 1] - cows[ci] < cows[ci + 2] - cows[ci + 1]):
				osc_i[i][1] += 1

print(osc_i)


act_c = 0
for e in osc_i:
	if(e[1] == 2):
		act_c += 2
	else:
		act_c += 1

fout.write(str(act_c) + "\n")
fout.close()
