fin = open("teleport.in", "r")
fout = open("teleport.out", "w")

'''
1.)Read data into vars
2.)Find distance of a->x + y->b, a->y + x->b, and a->b
3.)Output smallest result
'''

a,b,x,y = map(int, fin.readline().rstrip().split(' '))
distances = []
distances.append(abs(a-b))
distances.append(abs(a-x) + abs(b-y))
distances.append(abs(a-y) + abs(b-x))
distances = filter(lambda x: x >= 0, distances)

fout.write(str(min(distances)) + "\n")
fout.close()
