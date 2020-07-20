package collection.recruit;

import java.util.Scanner;

import collection.recruit.service.RecruitmentService;
import collection.recruit.vo.Career;
import collection.recruit.vo.Recruitment;
import collection.recruit.vo.Resume;

public class RecruitApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		RecruitmentService service = new RecruitmentService();
		
		while (true) {
			System.out.println("=========================================");
			System.out.println("1.구직자  2.인사담당자  0.종료");
			System.out.println("=========================================");
			
			System.out.print("메뉴를 선택하세요: ");
			int menuNo = sc.nextInt();
			
			if (menuNo == 1) {
				System.out.println("==========================================================================================");
				System.out.println("1.이력서등록 2.경력사항등록 3.채용상태확인 4.이력서수정 5.구직신청 삭제 6.경력사항수정 7.구직신청 현황조회");
				System.out.println("==========================================================================================");
				
				System.out.print("구직자 메뉴를 선택하세요: ");
				int empMenuNo = sc.nextInt();
				
				if (empMenuNo == 1) {
					// 이름, 전화번호, 지원부서를 입력받는다.
					System.out.println("[이력서 등록하기]");
					System.out.print("이름을 입력하세요: ");
					String name = sc.next();
					System.out.print("전화번호를 입력하세요: ");
					String tel = sc.next();
					System.out.print("지원부서를 입력하세요: ");
					String dept = sc.next();
					
					Resume resume = new Resume();
					resume.setName(name);
					resume.setTel(tel);
					resume.setDept(dept);
					service.addNewResume(resume);
					System.out.println("###이력서가 등록되었습니다.");
				} else if (empMenuNo == 2) {
					// 재직회사명, 근무부서, 직위, 근무년수를 입력받는다.
					System.out.println("[경력사항 등록하기]");
					System.out.print("구직신청번호를 입력하세요: ");
					int recruitmentNo =sc.nextInt();
					System.out.print("재직회사명을 입력하세요: ");
					String companyName = sc.next();
					System.out.print("근무부서를 입력하세요: ");
					String dept = sc.next();
					System.out.print("직위를 입력하세요: ");
					String position = sc.next();
					System.out.print("근무년수를 입력하세요: ");
					int year = sc.nextInt();
					
					Career career = new Career();
					career.setCompanyName(companyName);
					career.setDept(dept);
					career.setPosition(position);
					career.setYear(year);
					service.addCareer(recruitmentNo, career);
					System.out.println("###경력사항이 등록되었습니다.");
				} else if (empMenuNo == 3) {
					// 구직신청번호를 입력받는다.
					System.out.println("[채용상태 확인하기]");
					System.out.print("구직신청번호를 입력하세요: ");
					int recruitmentNo =sc.nextInt();
					
					service.printRecruitmentDetail(recruitmentNo);
				} else if (empMenuNo == 4) {
					// 구직신청번호, 이름, 전화번호, 지원부서를 입력받는다.
					System.out.println("[이력서 수정하기]");
					System.out.print("구직신청번호를 입력하세요: ");
					int recruitmentNo =sc.nextInt();
					System.out.print("이름을 입력하세요: ");
					String name = sc.next();
					System.out.print("전화번호를 입력하세요: ");
					String tel = sc.next();
					System.out.print("지원부서를 입력하세요: ");
					String dept = sc.next();
					
					Resume resume = new Resume();
					resume.setName(name);
					resume.setTel(tel);
					resume.setDept(dept);
					
					service.updateResume(recruitmentNo, resume);
					System.out.println("###이력서가 수정되었습니다.");
				} else if (empMenuNo == 5) {
					// 구직신청번호를 입력받는다.
					System.out.println("[구직신청 삭제하기]");
					System.out.print("구직신청번호를 입력하세요: ");
					int recruitmentNo =sc.nextInt();
					
					service.deleteRecruitment(recruitmentNo);
				} else if(empMenuNo == 6) {
					System.out.println("[경력사항 수정하기]");
					System.out.print("구직신청번호를 입력하세요: ");
					int recruitmentNo =sc.nextInt();
					System.out.print("재직회사명을 입력하세요: ");
					String companyName = sc.next();
					
					System.out.println("=========================================");
					System.out.println("1.경력사항삭제  2.경력사항수정 ");
					System.out.println("=========================================");
					System.out.print("항목을 선택하세요: ");
					int subMenuNo = sc.nextInt();
					if(subMenuNo == 1) {
						System.out.println("[경력사항 삭제하기]");
						service.deleteCareer(recruitmentNo, companyName);
						System.out.println("###경력사항이 삭제되었습니다.");
						
					}else if(subMenuNo == 2) {
						System.out.println("[경력사항 수정하기]");
						//service.updateCareer(recruitmentNo, companyName);
						System.out.print("재직회사명을 입력하세요: ");
						String companyName2 = sc.next();
						System.out.print("근무부서를 입력하세요: ");
						String dept = sc.next();
						System.out.print("직위를 입력하세요: ");
						String position = sc.next();
						System.out.print("근무년수를 입력하세요: ");
						int year = sc.nextInt();
						System.out.println("###경력사항이 수정되었습니다.");
					}
					//보류
				} else if(empMenuNo == 7) {
					System.out.println("[구직신청현황 조회하기]");
					
				}
				
			} else if (menuNo == 2) {
				System.out.println("==========================================================================");
				System.out.println("1.채용신청서 조회  2.채용신청서 상세조회  3.채용신청서 심사  4.전체 구직신청조회");
				System.out.println("==========================================================================");
				
				System.out.print("구직자 메뉴를 선택하세요: ");
				int empMenuNo = sc.nextInt();
				
				if (empMenuNo == 1) {
					// 입력값 없음
					System.out.println("[채용신청서 간단조회하기]");
					service.printAllRecruitment();
				} else if (empMenuNo == 2) {
					// 구직신청번호를 입력받는다.
					System.out.println("[채용신청서 상세조회하기]");
					System.out.print("구직신청번호를 입력하세요: ");
					int recruitmentNo =sc.nextInt();
					
					service.printRecruitmentDetail(recruitmentNo);
				} else if (empMenuNo == 3) {
					// 구직신청번호와 합격불합격여부를 Y/N으로 입력받는다.
					System.out.println("[채용신청서 심사하기]");
					System.out.print("구직신청번호를 입력하세요: ");
					int recruitmentNo =sc.nextInt();
					System.out.print("합격불합격여부를 Y/N으로 입력하세요: ");
					String pass =sc.next();
					boolean passed = false;
					
					if(pass.equals("Y")) {
						passed = true;
					}else if(pass.equals("N")) {
						passed = false;
					}

					service.checkRecruitment(recruitmentNo, passed);
				} else if(empMenuNo == 4) {
					System.out.println("[전체 구직신청 조회하기]");
				}
				
			} else if (menuNo == 0) {
				System.out.println("### 프로그램을 종료합니다.");
				break;
			}
			System.out.println();
		}
		sc.close();
	}
}