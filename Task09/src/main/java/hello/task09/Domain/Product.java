package hello.task09.Domain;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Product {
    private final Long key;
    private final String name;
    private final Long price;

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if(!(obj instanceof Product))
            return false;
        Product product = (Product) obj;
        return Objects.equals(this.name, product.name);
    }

    public Product(Long key, String name, Long price) {
        this.key = key;
        this.name = name;
        this.price = price;
    }
}
