package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    @Test
    void shouldSearchByAuthor() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Book(2, "Последний из могикан", 200, "Купер")};
        Product[] actual = manager.searchBy("Купер");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Book(3, "Дюна", 300, "Герберт")};
        Product[] actual = manager.searchBy("Дюна");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByProducer() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Smartphone(6, "Redmi 8", 700, "Xiaomi")};
        Product[] actual = manager.searchBy("Xiaomi");
        assertArrayEquals(expected, actual);
    }
}