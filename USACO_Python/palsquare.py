"""
ID: kaif.aj1
LANG: PYTHON3
PROG: palsquare
"""
#init
fin = open("palsquare.in", "r")
fout = open("palsquare.out", "w")
base = int(fin.readline().rstrip())
palindrome_squares = []

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

#main
for i in range(1, 301):
	squared = i**2
	squared, i = convert_base(base, squared), convert_base(base, i)
	if(palindrome(squared) == squared):
		palindrome_squares.append([i, squared])
for i in palindrome_squares:
	fout.write(" ".join(i) + "\n")
fout.close()
