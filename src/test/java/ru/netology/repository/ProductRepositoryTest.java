package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();

    Product product1 = new Book(1, "Мы", "Замятин", 1000);
    Product product2 = new Book(2, "Стена", "Сартр", 800);
    Product product3 = new Smartphone(3, "iPhone", "X", 10000);
    Product product4 = new Smartphone(4, "iPhone", "11", 15000);

    @Test
    public void ShouldSave() {
        repo.save(product1);
        repo.save(product3);

        Product[] expected = {product1, product3};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void ShouldRemoveById() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.removeById(1);
        repo.removeById(3);

        Product[] expected = {product2, product4};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(actual, expected);
    }

}
