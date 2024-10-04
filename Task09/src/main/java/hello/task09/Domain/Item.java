package hello.task09.Domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Item {
    private Product product;
    private Long count;

    public Item(Product product, Long count) {
        this.product = product;
        this.count = count;
    }
}
