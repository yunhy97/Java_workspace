package collection.recruit.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import collection.recruit.repo.RecruitmentRepository;
import collection.recruit.vo.Career;
import collection.recruit.vo.Recruitment;
import collection.recruit.vo.Resume;

public class RecruitmentService {

	private RecruitmentRepository repo = new RecruitmentRepository();
	Scanner sc = new Scanner(System.in);
	// 이력서 등록기능
	public void addNewResume(Resume resume) {
		// 구직신청객체 생성
		// 구직신청객체에 전달받은 이력서 객체 저장
		// 레포지토리객체를 사용해서 db에 저장하고, 자신의 구직신청번호를 반환받는다.
		// 구직신청번호를 출력한다.
		Recruitment recruitment = new Recruitment();
		recruitment.setResume(resume);
		
		int no = repo.addRecuitment(recruitment);
		System.out.println("구직신청번호: "+ no);
	}
	
	// 경력사항 등록기능
	public void addCareer(int recruitmentNo, Career career) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 조회한다.
		// 구직신청객체의 경력사항에 전달받은 경력사항객체를 추가한다.
		Recruitment recruitment = repo.getRecruitmentByNo(recruitmentNo);
		recruitment.addCareer(career);
	}
	
	// 구직신청 상태 조회 기능
	public void printRecruitmentDetail(int recruitmentNo) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 조회해서 화면에 출력한다.
		Recruitment recruitments = repo.getRecruitmentByNo(recruitmentNo);
		if(recruitments == null) {
			System.out.println("정보를 찾지 못했습니다.");
			return;
		}
		System.out.println("===구직신청정보===");
		System.out.println("구직신청번호\t이름\t전화번호\t지원부서\t합격여부");
		System.out.println("--------------------------------------------------");
		System.out.print(recruitments.getNo() + "\t");
		System.out.print(recruitments.getResume().getName() + "\t");
		System.out.print(recruitments.getResume().getTel() + "\t");
		System.out.print(recruitments.getResume().getDept() + "\t");
		System.out.println(recruitments.isPassed());
		
		System.out.println("===경력사항정보===");
		System.out.println("재직회사\t근무부서\t최종직급\t근무기간");
		System.out.println("--------------------------------------------------");
		for(Career c : recruitments.getCareers()) {
			System.out.print(c.getCompanyName() + "\t");
			System.out.print(c.getDept() + "\t");
			System.out.print(c.getPosition() + "\t");
			System.out.println(c.getYear());
		}
		
	}
	
	// 이력서 수정 기능
	public void updateResume(int recruitmentNo, Resume resume) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 조회한다.
		// 구직신청객체의 이력서정보를 전달받은 이력서 정보로 교체한다.
		Recruitment recruitments = repo.getRecruitmentByNo(recruitmentNo);
		recruitments.setResume(resume);
		
	}
	
	// 구직신청 삭제하기
	public void deleteRecruitment(int recruitmentNo) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 삭제한다.
		repo.deleteRecruitmentByNo(recruitmentNo);
	}
	
//	//경력사항 수정하기
//	public void updateCareer(int recruitmentNo, String companyName) {
//		Recruitment results = repo.getRecruitmentByNo(recruitmentNo);
//		ArrayList<Career> result2 = results.getCareers();
//		for(Career c : result2) {
//			if(results.getNo() == recruitmentNo && c.getCompanyName().equals(companyName)) {
//				
//				
//			}
//		}
//	}
	
	//경력사항 삭제하기
	public void deleteCareer(int recruitmentNo, String companyName) {
		repo.deleteCareerByNoCompanyName(recruitmentNo, companyName);
	}
	
	// 전체 구직신청정보 간단 조회
	public void printAllRecruitment() {
		// 레포지토리에서 모든 구직신청 정보를 조회해서 화면에 출력한다.
		ArrayList<Recruitment> results = repo.getAllRecruitments();
		
		System.out.println("구직신청번호\t이름\t전화번호\t지원부서\t합격여부");;
		for(Recruitment result : results) {
			System.out.print(result.getNo() + "\t");
			System.out.print(result.getResume().getName() + "\t");
			System.out.print(result.getResume().getTel() + "\t");
			System.out.print(result.getResume().getDept() + "\t");
			System.out.println(result.isPassed());
		}
	}
	
	// 구직신청 심사하기
	public void checkRecruitment(int recruitmentNo, boolean passed) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 조회한다.
		// 합격/불합격여부를 결정한다.
		Recruitment results = repo.getRecruitmentByNo(recruitmentNo);
		if(results == null) {
			System.out.println("정보를 찾지 못했습니다.");
			return;
		}
		
		results.setPassed(passed);
	}
}