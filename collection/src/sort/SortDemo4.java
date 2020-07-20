package sort;

import java.util.ArrayList;
import java.util.Collections;

public class SortDemo4 {

	public static void main(String[] args) {
		
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		
		contacts.add(new Contact(10, "류관순", "010-1111-2222", "ryu@gmail.com"));
		contacts.add(new Contact(7, "강감찬", "010-7894-7894", "kang@naver.com"));
		contacts.add(new Contact(3, "이순신", "010-7777-2222", "lee@hanmail.net"));
		contacts.add(new Contact(6, "김유신", "010-3535-3561", "kim@daum.net"));
		contacts.add(new Contact(2, "윤봉길", "010-7822-3333", "yun@naver.com"));
		
		Collections.sort(contacts);
		
		for(Contact c : contacts) {
			System.out.println(c.getNo() + ", " + c.getName()+ ", " + c.getTel() + ", " + c.getEmail());
		}
	}
}
