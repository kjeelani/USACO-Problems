fin = open("circlecross.in", "r")
fout = open("circlecross.out", "w")
from string import ascii_uppercase

'''
1.)Store input in variable
2.)For each letter in alphabet(A), loop through string:
	a.)Find the start A and the end A. Find the number of single letters in between them
	b.)For each single letter, increase the crossing_pair_counter by 1
3.)At the end, divide the crossing_pair_counter by 2 in order to account for the overlap and output it
'''

cowcircle = fin.readline().rstrip()
crossing_pair_counter = 0

def find_indices(char):
	'''finds the start and end index of the character'''
	indices = [i for i, x in enumerate(cowcircle) if x == char]
	return indices


for char in ascii_uppercase:
	start, end = map(int, find_indices(char))
	circle_slice = cowcircle[start+1:end]
	for elem in circle_slice:
		if(circle_slice.count(elem) == 1):
			crossing_pair_counter += 1

fout.write(str(crossing_pair_counter//2) + "\n")
fout.close()
