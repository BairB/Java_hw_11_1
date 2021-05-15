package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    Product book1 = new Book(1, "Тарас Бульба", 100, "Гоголь");
    Product book2 = new Book(2, "Последний из могикан", 200, "Купер");
    Product book3 = new Book(3, "Дюна", 300, "Герберт");
    Product smartphone1 = new Smartphone(4, "Iphone", 1000, "Apple");
    Product smartphone2 = new Smartphone(5, "Galaxy Note 6", 400, "Samsung");
    Product smartphone3 = new Smartphone(6, "Redmi 8", 700, "Xiaomi");

    @Test
    void shouldSearchByAuthor() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.addProductToRepository(book1);
        manager.addProductToRepository(book2);
        manager.addProductToRepository(book3);

        Product[] expected = new Product[]{book2};
        Product[] actual = manager.searchBy("Купер");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.addProductToRepository(book1);
        manager.addProductToRepository(book2);
        manager.addProductToRepository(book3);

        Product[] expected = new Product[]{book3};
        Product[] actual = manager.searchBy("Дюна");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByProducer() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.addProductToRepository(smartphone1);
        manager.addProductToRepository(smartphone2);
        manager.addProductToRepository(smartphone3);

        Product[] expected = new Product[]{smartphone3};
        Product[] actual = manager.searchBy("Xiaomi");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldnotSearchIfNull() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Гоголь");
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchIfOne() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.addProductToRepository(smartphone1);

        Product[] expected = new Product[]{smartphone1};
        Product[] actual = manager.searchBy("Apple");
        assertArrayEquals(expected, actual);
    }
}