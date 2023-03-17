# accountMod.py

class Account:
	def setData(self,accountNo,owner,money):
		self.accountNo = accountNo
		self.owner = owner
		self.balance = money

	def createAccount(self):
		with open("account.dat", "a") as f:
			f.write(self.accountNo + " " + self.owner + " " + self.balance + "\n")

	def accountPrint(self):
		print("계좌번호 \t 이름 \t\t 금액 ")
		try:
			with open("account.dat", "r") as f:
				while True:
					line = f.readline()
					if not line :
						break
					data = line.replace("\n","").split(" ") #[1111,aaa,1000]
					print(data[0] + "\t\t" + data[1] + "\t\t" + data[2])
		except FileNotFoundError as e:
			print("계좌를 생성시켜주셔야 합니다.")

	def deposit(self,accountNo):
		try:
			money = input("예금 액 : ")
			dataList = []
			with open("account.dat", "r") as f:
				while True:
					line = f.readline() # 1111 aaa 1000\n
					data = line.replace("\n","").split(" ") ##[1111,aaa,1000\n]
					if data[0] == accountNo:
						data[2] = str(int(data[2]) + int(money))
					if not line:
						break
					else:
						dataList.append(data)
			with open("account.dat", "w") as f:
				for data in dataList:
					f.write(data[0] + " " + data[1] + " " + data[2] + "\n")

		except FileNotFoundError as e:
			print("계좌가 생성되어 있지 않습니다.")
		except ValueError as e:
			print("숫자로 입력해 주세요")
	def withDraw(self,accountNo):
		try:
			money = input("출금 액 : ")
			dataList = []
			with open("account.dat", "r") as f:
				lines = f.readlines()
			
			for line in lines:
				data = line.replace("\n","").split(" ")
				if  data[0] == accountNo:
					data[2] = str(int(data[2]) - int(money))
				dataList.append(data)

			with open("account.dat", "w") as f:
				for data in dataList:
					f.write(data[0] + " " + data[1] + " " + data[2] + "\n")
		except :
			print("계좌가 생되지 않거나 숫자로 입력하지 않았습니다.")





