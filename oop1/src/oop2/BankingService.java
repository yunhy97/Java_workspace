package oop2;

/**
 * 고객들의 계좌정보를 관리한다.
 * 신규계좌의 등록, 계좌에 대한 입출금/해지 등의 서비스를 제공한다.
 * @author JHTA
 *
 */
public class BankingService {

	//모든 개설된 계좌정보를 저장하는 배열
	Banking[] db = null;
	int savePosition = 0;
	
	//기본생성자를 사용하는 경우 계좌정보 100개를 저장할 수 있는 배열을 생성함.
	BankingService() {
		db = new Banking[100];
	}
	
	//이 생성자를 사용하는 경우 전달받은 size만큼 계좌정보를 저장할 수 있는 배열을 생성함.
	BankingService(int size) {
		db = new Banking[size];
	}
	
	//1.등록된 전체 계좌정보를 출력하는 서비스
	void printAllBankings() {
		System.out.println("==================================");
		System.out.println("예금주\t계좌번호\t잔액\t가입기간");
		System.out.println("==================================");
		
		for(int i=0; i<savePosition; i++) {
			Banking banking = db[i];
			System.out.print(banking.name + "\t");
			System.out.print(banking.no + "\t");
			System.out.print(banking.balance + "\t");
			System.out.println(banking.period);
		}
		System.out.println("=================================");
	}
	
	//3.신규계좌를 등록하는 서비스
	void addNewBanking(String name, int password, long money) {
		Banking banking = new Banking();
		
		banking.name = name;
		banking.no = "" + (int)(Math.random()*100000 + 10000);		//계좌번호
		banking.password = password;
		banking.balance = money;
		banking.period = 24;				//계약기간
		
		db[savePosition] = banking;
		savePosition++;
	}
	
	//2.계좌번호에 해당하는 계좌정보를 조회(출력)하는 서비스
	void printBankingByNo(String bankingNo) {
		Banking foundBank = findBankingByNo(bankingNo);
		
		if(foundBank != null) {
			foundBank.display();
		}else {
			System.out.println("[" + bankingNo + "]과 일치하는 계좌정보가 존재하지 않습니다.");
		}
	}
	
	//4.계좌번호, 입금액을 전달받아서 해당 계좌에 입금하는 서비스
	void depositBanking(String bankingNo, long money) {
		Banking foundNo = findBankingByNo(bankingNo);
		
		if(foundNo != null) {
			foundNo.deposit(money);
			foundNo.display();
		}else {
			System.out.println("[" + bankingNo + "]과 일치하는 계좌정보가 존재하지 않습니다.");
		}
	}
	
	//5.계좌번호, 비밀번호, 출금액을 전달받아서 출금액만큼 반환하는 서비스
	long withdrawFromBanking(String bankingNo, int pwd, long money) {
		long result = 0L;
		
		Banking foundNo = findBankingByNo(bankingNo);
		
		if(foundNo != null) {
			result = foundNo.withdraw(money,pwd);
			foundNo.display();
		}else {
			System.out.println("[" + bankingNo + "]과 일치하는 계좌정보가 존재하지 않습니다.");
		}
		return result;
	}
	
	//6.계좌번호, 비밀번호를 전달받아서 계좌를 해지하고, 해지금액 전체를 반환하는 서비스
	long closeBanking(String bankingNo, int pwd) {
		long result = 0L;
		
		Banking foundNo = findBankingByNo(bankingNo);
		
		if(foundNo != null) {
			result = foundNo.close(pwd);
		}else {
			System.out.println("[" + bankingNo + "]과 일치하는 계좌정보가 존재하지 않습니다.");
		}
		return result;
	}
	
	//서비스에서 자주 사용되는 계좌번호에 해당하는 계좌정보를 찾아서 반환하는 기능
	Banking findBankingByNo(String bankingNo) {
		Banking foundNo = null;
		
		for(int i=0; i<savePosition; i++) {
			Banking banking = db[i];
			if(bankingNo.equals(banking.no)) {
				foundNo = banking;
				break;				
			}
		}
		return foundNo;
	}
}
