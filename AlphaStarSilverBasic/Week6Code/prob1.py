'''
1.)This is a similar concept to HTML tag parsing
2.)We keep a stack, make > a remove operation and < an add operation. 
3.)If we reach a IndexError or if the stack is not empty by end of operations, it is illegal. Else its legal
'''
from sys import stdin

n = int(stdin.readline())
patterns = []
for i in range(n):
    t = stdin.readline().rstrip().split(' ')
    t[0] = int(t[0])
    patterns.append(t)

for p in patterns:
    stack = []
    for c in p[1]:
        if(c == ">"):
            stack.append(0)
        else:
            try:
                stack.pop()
            except IndexError:
                print("illegal")
                break
    else:
        if(len(stack) != 0):
            print("illegal")
        else:
            print("legal")
