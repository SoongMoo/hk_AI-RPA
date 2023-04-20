import csv
def testFunc():
	location = '야탑2'
	f = open("src/main/resources/templates/thymeleaf/python/202302_202302_연령별인구현황_월간.csv")
	data = csv.reader(f)
	header = next(data)
	result = []
	for row in data:
	    i1 = 0
	    if location in row[0]:
	        i1 += 1
	        print(row[0])
	        for i in row[3:]:
	            result.append(int(i.replace(",","")))
	        if i1 == 1:
	            break