package collection.recruit.repo;

import java.util.ArrayList;
import java.util.Iterator;

import collection.recruit.vo.Career;
import collection.recruit.vo.Recruitment;

public class RecruitmentRepository {

	private ArrayList<Recruitment> db = new ArrayList<Recruitment>();
	private int sequence = 100;
	
	// 구직신청 등록하기
	public int addRecuitment(Recruitment recruitment) {
		recruitment.setNo(sequence++);
		db.add(recruitment);
		return sequence - 1;
	}
	
	// 나의 구직신청 현황 조회하기
	public Recruitment getRecruitmentByNo(int recruitmentNo) {
		Recruitment result = null;
		for(Recruitment recruitment : db) {
			if(recruitment.getNo() == recruitmentNo) {
				result = recruitment;
			}
		}
		return result;
	}
	
	// 나의 구직신청 삭제하기
	public void deleteRecruitmentByNo(int recruitmentNo) {
		Recruitment result = getRecruitmentByNo(recruitmentNo);
		db.remove(result);
		
	}
	//경력사항 삭제하기
	public void deleteCareerByNoCompanyName(int recruitmentNo, String companyName) {
		Recruitment result = getRecruitmentByNo(recruitmentNo);
		ArrayList<Career> result2 = result.getCareers();
		Iterator<Career> itr = result2.iterator();
		while(itr.hasNext()) {
			Career result3 = itr.next();
			if(result.getNo() == recruitmentNo && result3.getCompanyName().equals(companyName)) {
				itr.remove();
			}
		}		
	}
	
	// 전체 구직현황 조회하기
	public ArrayList<Recruitment> getAllRecruitments() {
		return db;
	}
}