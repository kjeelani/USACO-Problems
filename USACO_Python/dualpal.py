"""
ID: kaif.aj1
LANG: PYTHON3
PROG: dualpal
"""
#init
fin = open("dualpal.in", "r")
fout = open("dualpal.out", "w")
num_out, startpoint = map(int, fin.readline().rstrip().split(' '))
first_x = []

def convert_base(b, n):
	'''converts a number into given base'''
	remainder_string = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'
	to_return = ''
	while n>0:
		to_return += remainder_string[n % b]
		n //= b
	return palindrome(to_return)

def palindrome(s):
	'''returns string's palindrome'''
	return s[::-1]

while True:
	startpoint += 1
	temp_counter = 0
	for i in range(2, 11):
		t = convert_base(i, startpoint)
		if(palindrome(t) == t):
			temp_counter += 1
		if(temp_counter >= 2):
			first_x.append(startpoint)
			break
	if(len(first_x) >= num_out):
		break

for e in first_x:
	fout.write(str(e) + "\n")
fout.close()
