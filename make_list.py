f = open('words.txt','r')
L=[]
for x in f:
	x = x.replace('\n','')
	L.append(x)
print L