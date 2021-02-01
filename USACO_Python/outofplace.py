fin = open("outofplace.in", "r")
fout = open("outofplace.out", "w")

'''
1.)Read data into vars
2.)Use a for loop to find the index and value of Bessie
3.)Use another for loop to find the index where she should be
4.)Create a list splice and remove all duplicates
5.)Output list slice's length to file
'''

def remove_duplicates(l):
	temp_l = []
	for e in l:
		if(e not in temp_l):
			temp_l.append(e)
	return temp_l

ncows = int(fin.readline())
heights = [int(fin.readline()) for i in range(ncows)]
b_index, b_value, trueb_index = 0, 0, 0
max_swaps = 0
print(heights)

for i in range(ncows):
	if(i == 0):
		if(heights[i + 1] < heights[i]):
			b_index, b_value = i, heights[i]
			break
	elif(i == ncows - 1):
		if(heights[i - 1] > heights[i]):
			b_index, b_value = i, heights[i]
			break
	else:
		if(heights[i + 1] < heights[i] or heights[i - 1] > heights[i]):
			b_index, b_value = i+1, heights[i+1]
			break

for i in range(ncows):
	if(i == 0):
		if(b_value <= heights[i]):
			trueb_index = i-1
			break
		elif(b_value >= heights[i] and b_value <= heights[i+1]):
			trueb_index = i
			break
	elif(i == ncows - 1):
		if(b_value >= heights[i]):
			trueb_index = i 
			break
	else:
		if(b_value >= heights[i] and b_value <= heights[i+1]):
			trueb_index = i
			break

print(trueb_index, b_index)
if(trueb_index < b_index):
	max_swaps = len(remove_duplicates(heights[trueb_index+1:b_index]))
else:
	max_swaps = len(remove_duplicates(heights[b_index+1:trueb_index+1]))

fout.write(str(max_swaps) + "\n")
fout.close()
