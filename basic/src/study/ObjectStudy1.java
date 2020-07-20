package study;

public class ObjectStudy1 {

	String ID;
	String name;
	String address;
	int stock = 0;
	boolean sent;
	
	ObjectStudy1(){
		
	}
	
	ObjectStudy1(String ID, String name, String address, int stock, boolean sent){
		this.ID = ID;
		this.name = name;
		this.address = address;
		this.stock = stock;
		this.sent = false;
	}
	
	void display() {
		System.out.println("-----------배송정보----------");
		System.out.println("아 이 디: " + ID);
		System.out.println("수령자명: " + name);
		System.out.println("수령주소: " + address);
		System.out.println("택배수량: " + stock);
		System.out.println("배송여부: " + sent);
		System.out.println("----------------------------");
	}
	
}
