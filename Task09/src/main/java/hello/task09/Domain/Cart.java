package hello.task09.Domain;

import java.util.HashSet;
import java.util.Set;

public class Cart {
    Set<Item> itemList;

    public Cart() {
        this.itemList = new HashSet<>();
    }

    // 아이템 목록 조회
    public void showItems(){
        System.out.println("<Item List>");
        for (Item item : itemList) {
            System.out.println("Item : " + item.getProduct().getName() + " Count : " + item.getCount());
        }
    }

    // 아이템 추가
    public void addProduct(Product product, Long cnt){
        // 아이템 리스트가 비어있을 때
        if (itemList.isEmpty()) {
            itemList.add(new Item(product, cnt));
            System.out.println("상품을 추가했습니다.");
            System.out.println("Item : " + product.getName() + " Count : " + cnt);
            System.out.println();
            return ;
        }

        // 아이템 리스트에 존재하는 아이템인지 확인
        for (Item item : itemList) {
            if (item.getProduct().equals(product)) {
                item.setCount(item.getCount() + cnt);
                System.out.println("상품을 추가했습니다.");
                System.out.println("Item : " + item.getProduct().getName() + " Count : " + item.getCount());
                System.out.println();
                return ;
            }
        }

        // 아이템 리스트에 존재하지 않는 아이템
        itemList.add(new Item(product, cnt));
        System.out.println("상품을 추가했습니다.");
        System.out.println("Item : " + product.getName() + " Count : " + cnt);
        System.out.println();
    }

    // 아이템 삭제
    public void removeProduct(Product product, Long cnt){
        // 아이템 리스트가 비어있을 때
        if (itemList.isEmpty()) {
            System.out.println("아이템 리스트가 비어있습니다.");
            System.out.println();
            return ;
        }

        // 아이템 리스트에 상품이 존재하는지 확인
        for (Item item : itemList) {
            if (item.getProduct().equals(product)) {
                if (item.getCount() >= cnt) {
                    item.setCount(item.getCount() - cnt);
                    System.out.println("상품을 삭제했습니다.");
                    System.out.println("Item : " + product.getName() + " Count : " + cnt);
                    System.out.println();
                    if (item.getCount() == 0)
                        itemList.remove(item);
                    return ;
                }
                else {
                    System.out.println(product.getName() + " " + cnt + "개를 삭제할 수량이 부족합니다.");
                    System.out.println();
                }
                return ;
            }
        }
    }
}
