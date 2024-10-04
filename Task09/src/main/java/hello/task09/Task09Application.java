package hello.task09;

import hello.task09.Domain.Cart;
import hello.task09.Domain.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Task09Application {

    public static void main(String[] args) {
        SpringApplication.run(Task09Application.class, args);

        // 상품 목록 생성
        Set<Product> productSet = new HashSet<>();

        // TODO : 상품 클래스를 생성하여 상품 목록에 넣는다.
        Product apple = new Product(0L, "사과", 1000L);
        Product milk = new Product(1L, "우유", 2500L);

        productSet.add(apple);
        productSet.add(milk);

        // 상품 목록 확인
        System.out.println("고유한 상품 목록");
        for (Product product : productSet) {
            System.out.println(product.getName() + " : " + product.getPrice());
        }
        System.out.println();

        // 장바구니 생성
        Cart myCart = new Cart();

        // TODO : 상품을 장바구니에 추가
        myCart.addProduct(apple, 2L);
        myCart.addProduct(milk, 1L);

        // TODO : 상품을 장바구니에서 제거
        myCart.removeProduct(apple, 1L);
        myCart.removeProduct(milk, 3L);

        // TODO : 장바구니에 현재 담긴 상품들을 출력 ( 상품 이름, 각 상품의 개수 )
        myCart.showItems();
    }
}
