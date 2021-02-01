"""
ID: kaif.aj1
LANG: PYTHON3
PROG: cowsignal
"""
fin = open("cowsignal.in", "r")
fout = open("cowsignal.out", "w")
nrows, ncols, factor = map(int, fin.readline().rstrip().split(' '))
signal = [fin.readline().rstrip() for r in range(nrows)]
newsignal = []

for line in signal:
	ln = ""
	for char in line:
		for i in range(factor):
			ln += char
	for i in range(factor):
		newsignal.append(ln)

for line in newsignal:
	fout.write(line + "\n")
fout.close()
