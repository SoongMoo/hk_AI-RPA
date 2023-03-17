# accountMian.py
from accountMod import Account

a = Account()
while True:
	print("1.계좌번호생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료 ")
	num = input("번호를 입력 하시오 : ")
	if num == "1":
		accountNo = input("계좌번호 : ")
		owner = input("계좌주 : ")
		money = input("초기 입금금액 : ")
		a.setData(accountNo,owner,money)
		a.createAccount()
	elif num == "2":
		a.accountPrint()
	elif num == "3":
		print("예금")
		accountNo = input("계좌번호를 입력 하시오 : ")
		a.deposit(accountNo)
	elif num == "4":
		print("출금")
		accountNo = input("계좌번호를 입력 하시오 : ")
		a.withDraw(accountNo)
	elif num == "5":
		print("프로그램이 종료되었습니다.")
		break