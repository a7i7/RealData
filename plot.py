import matplotlib.pyplot as plt
import matplotlib.dates as mdates
import matplotlib.ticker as mticker
import datetime as dt

def startPlotting(X,Y):
	for i in range(len(X)):
		# print X[i]
		X[i] = X[i][0:X[i].index("/20")]+"/1999"
		# print "*",X[i]
		# X[i] = X[i][-4]+"1999"
		# print X[i]
	X = [dt.datetime.strptime(d,'%d/%m/%Y').date() for d in X]
	# print X
	plt.plot(X,Y)

myLocator = mticker.MultipleLocator(30)
plt.gca().xaxis.set_major_formatter(mdates.DateFormatter('%d/%m/%Y'))
plt.gca().xaxis.set_major_locator(mdates.DayLocator())
plt.gca().xaxis.set_major_locator(myLocator)
plt.gcf().autofmt_xdate()

twelve = {}
thirteen = {}
fourteen = {}

#scan 2012 data
f = open("2012.txt","r")
X = []
Y = []
for r in f:
	x,y=r.split("\t")
	y = y.replace("\n","")
	X.append(x)
	Y.append(y)
	temp = x.split("/")
	twelve[(int(temp[0]),int(temp[1]))]=y

startPlotting(X,Y)
#END 2012 scan

# print twelve

#scan 2013 data
f = open("2013.txt","r")
X = []
Y = []
for r in f:
	x,y=r.split("\t")
	y = y.replace("\n","")
	X.append(x)
	Y.append(y)
	temp = x.split("/")
	thirteen[(int(temp[0]),int(temp[1]))]=y

startPlotting(X,Y)
#END 2013 scan

#scan 2014 data
f = open("2014.txt","r")
X = []
Y = []
for r in f:
	x,y=r.split("\t")
	y = y.replace("\n","")
	X.append(x)
	Y.append(y)
	temp = x.split("/")
	fourteen[(int(temp[0]),int(temp[1]))]=y

startPlotting(X,Y)

# f = open("predictedData.txt","r")
# X = []
# Y = []
# for r in f:
# 	x,y=r.split("\t")
# 	y = y.replace("\n","")
# 	X.append(x)
# 	Y.append(y)
# 	temp = x.split("/")
# 	fourteen[(int(temp[0]),int(temp[1]))]=y

# startPlotting(X,Y)

# f = open("predictedData2.txt","r")
# X = []
# Y = []
# for r in f:
# 	x,y=r.split("\t")
# 	y = y.replace("\n","")
# 	X.append(x)
# 	Y.append(y)
# 	temp = x.split("/")
# 	fourteen[(int(temp[0]),int(temp[1]))]=y

# startPlotting(X,Y)

#END 2014 scan

# #difference
# res = []
# X = []
# Y = []
# X1 = []
# Y1 = []
# for i in sorted(thirteen.keys(),key=lambda x:(x[1],x[0])):
# 	print i
# 	if twelve.has_key(i):
# 		X.append(str(i[0])+"/"+str(i[1])+"/"+"2012")
# 		Y.append(int(thirteen[i])-int(twelve[i]))
# 	if fourteen.has_key(i):
# 		X1.append(str(i[0])+"/"+str(i[1])+"/"+"2012")
# 		Y1.append(int(fourteen[i])-int(thirteen[i]))
# # print sorted(res)
# print X
# print Y

# startPlotting(X,Y)
# startPlotting(X1,Y1)


# X = []
# Y = []
# prev = None
# for i in sorted(thirteen.keys(),key=lambda x:(x[1],x[0])):
# 	if prev==None:
# 		prev = thirteen[i]
# 		continue
# 	X.append(str(i[0])+"/"+str(i[1])+"/"+"2012")
# 	Y.append(int(thirteen[i])-int(prev))
# 	prev = thirteen[i]
# 	print prev
# 	print i
	
# # print sorted(res)
# print X
# print Y
# startPlotting(X,Y)

# TEMP0 = X
# TEMP1 = Y
# X = []
# Y = []
# print TEMP0
# print TEMP1

# print "kajsh"
# begin = True
# counter = 0
# error = 0
# for i in sorted(fourteen.keys(),key=lambda x:(x[1],x[0])):
# 	X.append(str(i[0])+"/"+str(i[1])+"/"+"2012")
# 	if begin:
# 		Y.append(int(fourteen[i]))
# 		error+=0
# 	else:
# 		print len(Y)-1
# 		Y.append(Y[int(len(Y)-1)]+int(TEMP1[counter]))
# 		error+=abs(int(fourteen[i])-Y[len(Y)-1])
# 	begin = False
# 	counter+=1

# print error
# startPlotting(X,Y)

# X = []
# Y = []
# prev = None
# for i in sorted(fourteen.keys(),key=lambda x:(x[1],x[0])):
# 	if prev==None:
# 		prev = fourteen[i]
# 		continue
# 	X.append(str(i[0])+"/"+str(i[1])+"/"+"2012")
# 	Y.append(int(fourteen[i])-int(prev))
# 	prev = fourteen[i]
# 	print prev
# 	print i
	
# # # print sorted(res)
# print X
# print Y
# startPlotting(X,Y)

# X = []
# Y = []
# prev = None
# for i in sorted(twelve.keys(),key=lambda x:(x[1],x[0])):
# 	if prev==None:
# 		prev = twelve[i]
# 		continue
# 	X.append(str(i[0])+"/"+str(i[1])+"/"+"2012")
# 	Y.append(int(twelve[i])-int(prev))
# 	prev = twelve[i]
# 	print prev
# 	print i
	
# # print sorted(res)
# print X
# print Y
# startPlotting(X,Y)


plt.show()