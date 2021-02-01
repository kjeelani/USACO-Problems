'''
1.)Treate line like queue, create list of stacks for each regsiter
2.)process commands
3.)Return all stacks line by line hashed
'''
from queue import Queue
fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
n = int(fin.readline())
commands = [[int(y) if i == 1 else y for y, i in zip(x.rstrip().split(' '), (0,1))] for x in fin.readlines()]
registers = [[] for i in range(n)]
queue = Queue()

for cmd in commands:
    if(cmd[0] == "C"):
        queue.put(cmd[1])
    else:
        registers[cmd[1]-1].append(str(queue.get()))
    print(registers)

for r in registers:
    fout.write(str(len(r)) + " " + " ".join(r) + "\n")
fout.close()