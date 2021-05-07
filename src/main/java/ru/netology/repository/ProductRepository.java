package ru.netology.repository;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductRepository {
    Product[] items = {new Book(1, "Тарас Бульба", 100, "Гоголь"),
            new Book(2, "Последний из могикан", 200, "Купер"),
            new Book(3, "Дюна", 300, "Герберт"),
            new Smartphone(4, "Iphone", 1000, "Apple"),
            new Smartphone(5, "Galaxy Note 6", 400, "Samsung"),
            new Smartphone(6, "Redmi 8", 700, "Xiaomi")};

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] getAll() {
        return items;
    }

    public void revomeById(int id) {
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

}

