package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import  static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Product book1 = new Book(1, "Мы", "Замятин", 1000);
    Product book2 = new Book(2, "Стена", "Сартр", 800);
    Product phone1 = new Smartphone(3, "Apple", "iPhone-5S", 15000);
    Product phone2 = new Smartphone(4, "Apple", "iPhone-5", 15000);

    @Test
    public void ShouldSearch() {
        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);

        Product[] actual = manager.searchBy("iPhone");
        Product[] expected = {phone1, phone2};

        assertArrayEquals(expected, actual);
    }
}
