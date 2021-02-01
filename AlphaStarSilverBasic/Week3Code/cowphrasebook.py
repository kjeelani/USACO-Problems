'''
1.)For each cow message
    a.)Loop through the book using lowerbound
    Once you find the starting points, search to see if it is a prefix
'''

fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
m, n = map(int, fin.readline().rstrip().split(' '))
phrasebook = sorted([fin.readline().rstrip() for i in range(m)])
messages = [fin.readline().rstrip() for i in range(n)]
counter = 0

def lowerbound(x):
    left, right = 0, m
    while left < right:
        mid = (right + left) // 2
        if(x <= phrasebook[mid]):
            right = mid
        else:
            left = mid + 1
    return left

for message in messages:
    lb_i = lowerbound(message)
    try:
        if(phrasebook[lb_i][:len(message)] == message):
            counter += 1
    except IndexError:
        pass

fout.write(str(counter) + "\n")
fout.close()
    