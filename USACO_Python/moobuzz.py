fin = open("moobuzz.in", "r") 
fout = open("moobuzz.out", "w")

'''
1.)Read data
2.)Using the knowledge that every 8 numbers, the pattern repeats, create a dictionary with the result of each of the 8 numbers should they pop up as the remainder
3.)Print out the resulting #
'''

remainder_dict = {0:-1, 1:1, 2:2, 3:4, 4:7, 5:8, 6:11, 7:13}
n = int(fin.readline())
x = (15 * (n//8)) + remainder_dict[n%8]

fout.write(str(x) + "\n")
fout.close()
