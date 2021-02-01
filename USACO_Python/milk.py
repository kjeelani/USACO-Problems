"""
ID: kaif.aj1
LANG: PYTHON3
PROG: milk
"""
#init
fin = open("milk.in", "r")
fout = open("milk.out", "w")
units_needed, nfarmers = map(int, fin.readline().rstrip().split())
farmers = [[int(x) for x in fin.readline().rstrip().split()] for i in range(nfarmers)]
farmers.sort()
current_units, total_money = 0, 0

for e in range(nfarmers):
	if(farmers[e][1] + current_units > units_needed):
		last_units = units_needed - current_units
		total_money += last_units * farmers[e][0]
		break
	else:
		current_units += farmers[e][1]
		total_money += farmers[e][1] * farmers[e][0]
fout.write(str(total_money) + "\n")
fout.close()
