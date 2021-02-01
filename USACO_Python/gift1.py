"""
ID: kaif.aj1
LANG: PYTHON3
PROG: gift1
"""
fin = open("gift1.in", "r")
fout = open("gift1.out", "w")
numpeople = int(fin.readline().rstrip())
people_list = [[fin.readline().rstrip(), 0] for i in range(numpeople)]
people_name = [people_list[i][0] for i in range(numpeople)]

for i in range(numpeople):
	person = fin.readline().rstrip()
	money, people_to_check = map(int, fin.readline().rstrip().split(' '))
	if(people_to_check == 0):
		continue
	leftover = money % people_to_check
	people_list[people_name.index(person)][1] += (leftover-money)
	divided_money = money // people_to_check
	for j in range(people_to_check):
		reciever = fin.readline().rstrip()
		people_list[people_name.index(reciever)][1] += divided_money


for i in range(numpeople):
    fout.write(people_list[i][0] + " " + str(people_list[i][1]) + "\n")
fout.close()
    

