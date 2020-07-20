package demo1;

public class CustomerDemo {

	public static void main(String[] args) {
		
		Customer customer1 = new Customer("홍길동", 0);
		Customer customer2 = new Customer("홍길동", Grade.VIP);
		Customer customer3 = new Customer("김유신", Grade.Silver);
		
		//상수의 단점
		//지정된 상수외의 값이 대입되는 것을 컴파일시에 체크할 수 없다.
		Customer customer4 = new Customer("김유신", 100);
		
		System.out.println(getPoint1(customer1, 100000));
		System.out.println(getPoint1(customer2, 100000));
		System.out.println(getPoint1(customer3, 100000));
		
		System.out.println(getPoint2(customer1, 100000));
		System.out.println(getPoint2(customer2, 100000));
		System.out.println(getPoint2(customer3, 100000));
	}
	public static int getPoint1(Customer customer, int orderPrice) {
		int point = 0;
		if(customer.getGrade() == 0) {
			point = (int)(orderPrice*0.05);
		} else if(customer.getGrade() == 1) {
			point = (int)(orderPrice*0.03);
		}else if(customer.getGrade() == 2) {
			point = (int)(orderPrice*0.02);
		}else if(customer.getGrade() == 3) {
			point = (int)(orderPrice*0.01);
		}
		return point;
	}
	
	public static int getPoint2(Customer customer, int orderPrice) {
			int point = 0;
			if(customer.getGrade() == Grade.VIP) {
				point = (int)(orderPrice*0.05);
			} else if(customer.getGrade() == Grade.Gold) {
				point = (int)(orderPrice*0.03);
			}else if(customer.getGrade() == Grade.Silver) {
				point = (int)(orderPrice*0.02);
			}else if(customer.getGrade() == Grade.Bronze) {
				point = (int)(orderPrice*0.01);
			}
			return point;
					
	}
}
