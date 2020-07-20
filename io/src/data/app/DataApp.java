package data.app;

import java.util.Scanner;

import data.service.DataService;

public class DataApp {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		DataService service = new DataService();
		
		while(true) {
			System.out.println("==============================================");
			System.out.println("1.전체조회  2.지역별조회  3.날짜별조회  4.통계  0.종료");
			System.out.println("==============================================");
			
			System.out.print("메뉴를 선택하세요: ");
			int menuNo = sc.nextInt();
			
			if(menuNo == 1) {
				System.out.println("[전체 사고건수 조회]");
				service.printAllDataCount();
			}else if(menuNo == 2) {
				System.out.println("[지역별 사고건수 조회]");
				System.out.print("조회할 시,도를 입력하세요(2글자): ");
				String sido = sc.next();
				service.printDataBySido(sido);
			}else if(menuNo == 3) {
				System.out.println("[날짜별 사고건수 조회]");
				System.out.println("날짜를 입력하세요: ");
				System.out.println("조회할 날짜를 입력하세요(MM-dd): ");
				String day = sc.next();
				service.printDataByDay(day);
			}else if(menuNo == 4) {
				System.out.println("[통계 조회]");
				System.out.println("==============================================");
				System.out.println("1.지역별  2.월별  3.요일별  4.위반내용별  5.요약");
				System.out.println("==============================================");
				System.out.println("통계 메뉴를 선택하세요: ");
				int subMenuNo = sc.nextInt();
				
				if(subMenuNo == 1) {
					System.out.println("[지역별]");
					System.out.print("조회할 시,도를 입력하세요(2글자): ");
					String sido = sc.next();
					service.printDataStatBySido(sido);
				} else if(subMenuNo == 2) {
					System.out.println("[월별]");
					
					service.printDataStatByMonth();
				} else if(subMenuNo == 3) {
					System.out.println("[요일별]");
					
					service.printDataStatByDay();
				} else if(subMenuNo == 4) {
					System.out.println("[위반내용별]");
					
					service.printDataStatByViolation();
				} else if(subMenuNo == 5) {
					System.out.println("[요약]");
					
					service.printDataStat();
				}
			}else if(menuNo == 0) {
				System.out.println("[종료]");
				break;
			}
		}
	}
}
