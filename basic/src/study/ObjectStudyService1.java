package study;

public class ObjectStudyService1 {

	ObjectStudy1[] db = new ObjectStudy1[100];
	int savePosition = 0;
	
	//수령자정보 등록 메소드
	//같은 수령자 등록시 택배수량 증가 메소드
	public void insertNewInfo(ObjectStudy1 os1) {
		
		ObjectStudy1 os = null;
		for (int i=0; i<savePosition; i++) {
			if (db[i].ID.equals(os1.ID)) {
				os = db[i];
				break;
			}
		}
		
		if (os == null) {
			db[savePosition] = os1;
			savePosition++;			
			
		} else {
			os.stock += os1.stock;
		}
		
	}

	//수령자확인 후 배송여부 true로 변경 메소드
	public void checkSentByID(String ID, String name) {
		if(ID == null || name == null) {
			System.out.println("정보를 찾지 못했습니다.");
			return;
		}
		for(int i=0; i<savePosition; i++) {
			if(db[i].ID.equals(ID) && db[i].name.equals(name)) {
				db[i].sent=true;
			}
		}
	}
	
	//해당 ID를 가진 수령자의 정보 출력 메소드
	public void printInfoByID(String ID) {
		ObjectStudy1 result = null;
		
		for(int i=0; i<savePosition; i++) {
			ObjectStudy1 os = db[i];
			
			if(ID.equals(ID)) {
				result = os;
				break;
			}
		}
		if(result != null) {
			result.display();
		}else {
			System.out.println("등록된 ID가 없습니다.");
		}
	}
	
	//등록된 모든 수령자 정보 출력 메소드
	public void printAllInfo() {
		System.out.println("===========================================");
		System.out.println("아이디  수령자명  수령주소  택배수량  배송여부");
		System.out.println("===========================================");
		
		for(int i=0; i<savePosition; i++) {
			System.out.println(db[i].ID + "  ");
			System.out.println(db[i].name + "  ");
			System.out.println(db[i].address + "  ");
			System.out.println(db[i].stock + "  ");
			System.out.println(db[i].sent + "  ");
		}
	}
}
