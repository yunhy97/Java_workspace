package oop4;

import oop2.Banking;

public class ProductService {

	Product[] db = new Product[20];
	int position = 0;
	
	//배열에 저장된 모든 상품정보를 출력한다.
	void printAllProducts() {
		
		System.out.println("===========================================");
		System.out.println("상품명  제조사  카테고리  가격  할인율  절판여부");
		System.out.println("===========================================");
		
		for(int i=0; i<position; i++) {
			Product product = db[i];
			
			System.out.print(product.name+ "   ");
			System.out.print(product.maker+ "   ");
			System.out.print(product.category+ "   ");
			System.out.print(product.price+ "   ");
			System.out.print(product.discountRate+ "   ");
			System.out.println(product.isSoldOut);
			
		}
		System.out.println("===========================================");
	}
	
	//2-1,2.상품객체(새 상품, 이월상품)를 전달받아서 배열에 저장한다.
	void insertProduct(Product product) {
		
		db[position] = product;
		position++;
	}
	
	//2.상품명과 입고량을 전달받아서 이미 배열에 저장된 상품의 재고량을 증가시킨다.
	void addProductStock(String name, int amount) {
		Product result = findProductByName(name);
		
		if(result != null) {
			result.stock += amount;
			result.isSoldOut = true;
			result.display();
		}else {
			System.out.println("상품명이 일치하지 않습니다.");
		}
	}
	
	//3.상품명과 출고량을 전달받아서 배열에서 해당 상품을 찾아서 재고량을 감소시킨다.
	//단, 재고량보다 출고량이 많은 경우 오류 메세지를 표시한다.
	//단, 재고량이 0이 되면 해당상품의 절판여부를 true로 설정한다.
	void exportProduct(String name, int amount) {
		Product result = findProductByName(name);
		
		if(result != null) {
			if(result.stock >= amount) {
				result.stock -= amount;
				
				if (result.stock == 0) {
					result.isSoldOut = true;
				}
				
				result.display();
				
			} else {
				System.out.println("재고량보다 출고량이 많습니다. 오류!!");
			}
			
		}else {
			System.out.println("상품명이 일치하지 않습니다.");
		}
	}	
	
	//4.상품명을 전달받아서 배열에서 상품명이 일치하는 상품정보를 출력한다.
	void printProductsByName(String name) {
		Product result = findProductByName(name);
		
		if(result != null) {
			result.display();
			
		} else {
			System.out.println("상품명이 일치하지 않습니다.");
		}
	}

	//제조사명을 전달받아서 배열에서 제조사명이 일치하는 상품정보를 출력한다.
	void printProductsByMaker(String maker) {
		
		Product result = null;
		
		for(int i=0; i<position; i++) {
			Product product = db[i];
			
			if(maker.equals(product.maker)) {
				result = product;
				break;				
			}
		}
		if(result != null) {
			result.display();
			
		} else {
			System.out.println("제조사가 일치하지 않습니다.");
		}
	}
	
	//카테고리명을 전달받아서 배열에서 카테고리명이 일치하는 상품정보를 출력한다.
	void printProductsByCategory(String category) {
		Product result = null;
		
		for(int i=0; i<position; i++) {
			Product product = db[i];
			
			if(category.equals(product.category)) {
				result = product;
				break;				
			}
		}
		if(result != null) {
			result.display();
			
		} else {
			System.out.println("카테고리가 일치하지 않습니다.");
		}
	}
	
	//최저가격과 최고가격을 전달받아서 배열에서 가격범위가 속하는 상품정보를 출력한다.
	void printProductsByPrice(int minPrice, int maxPrice) {
		Product result = null;
		
		for(int i=0; i<position; i++) {
			Product product = db[i];
			
			if(minPrice <= product.price && maxPrice >= product.price) {
				result = product;
				break;				
			}
		}
		if(result != null) {
			result.display();
			
		} else {
			System.out.println("가격범위에 해당되지 않습니다.");
		}
	}
	
	Product findProductByName(String name) {
		Product found = null;
		
		for(int i=0; i<position; i++) {
			Product product = db[i];
			
			if(name.equals(product.name)) {
				found = product;
				break;				
			}
		}
		return found;
	}
}
