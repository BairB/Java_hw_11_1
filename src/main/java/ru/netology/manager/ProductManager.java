package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;
@Data
@AllArgsConstructor

public class ProductManager {
    private ProductRepository items;

    public void addProductToRepository(Product item){
        items.save(item);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product item: items.getAll()) {
            if (item.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        return result;
    }
}
