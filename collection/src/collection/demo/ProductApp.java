package collection.demo;

import java.util.ArrayList;
import java.util.Scanner;

import vo.Product;

public class ProductApp {

	public static void main(String[] args) {
		
		ProductRepository repo = new ProductRepository();
		
		while(true){
			try {
				Scanner sc = new Scanner(System.in);
				
				System.out.println("=================================================");
				System.out.println("1.전체조회  2.검색  3.등록  0.종료");
				System.out.println("=================================================");
				System.out.print("메뉴를 선택하세요: ");
				int menuNo = sc.nextInt();
				
				if(menuNo == 1) {
					System.out.println("[전체 상품 조회]");
					
					ArrayList<Product> products = repo.getAllProducts();
					if(products.isEmpty()) {
						System.out.println("### 조회된 상품이 없습니다.");
					} else {
						System.out.println("상품번호\t상품명\t가격");
						for(Product product : products) {
							System.out.print(product.getNo() + "\t");
							System.out.print(product.getName() + "\t");
							System.out.println(product.getPrice() + "\t");
						}
					}
				}else if(menuNo == 2) {
					System.out.println("[상품 검색]");
					
					System.out.println("검색어를 입력하세요: ");
					String keyword = sc.next();
					
					ArrayList<Product> products = repo.searchProducts(keyword);
					if(products.isEmpty()) {
						System.out.println("### ["+ keyword +"] 검색어에 해당하는 상품을 찾을 수 없습니다.");
					}else {
						System.out.println("전체 ["+ products.size() +"] 건이 조회되었습니다.");
						
						System.out.println("상품번호\t상품명\t가격");
						for(Product product : products) {
							System.out.print(product.getNo() + "\t");
							System.out.print(product.getName() + "\t");
							System.out.println(product.getPrice() + "\t");
						}
					}
				}else if(menuNo == 3) {
					System.out.println("[신규 상품 등록]");
					
					System.out.print("상품명을 입력하세요: ");
					String name = sc.next();
					System.out.print("제조사를 입력하세요: ");
					String maker = sc.next();
					System.out.print("가격을 입력하세요: ");
					int price = sc.nextInt();
					
					Product product = new Product();
					product.setName(name);
					product.setMaker(maker);
					product.setPrice(price);
					
					repo.insertProduct(product);
					System.out.println("### 신규 상품이 등록되었습니다.");
				}else if(menuNo == 0) {
					System.out.println("[종료]");
					break;
				}
			}catch (Exception e) {
				System.out.println("### 메인 메뉴로 되돌아갑니다.");
			}
				
		}
		
	}
}
/*
 * *조회
 * 한 건 또는 null
 * 		학번, 상품번호, 책 번호, 사원아이디, 주민번호, 이메일
 * 		유니크한 값으로 조회
 * ArrayList
 * 		전체, 성별, 등급, 이름, 학년, 출신지역, 카테고리, 제목, 가격, 날짜
 */
