package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import  static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    ProductRepository repo = Mockito.mock(ProductRepository.class);
    ProductManager manager = new ProductManager(repo);
    Product book1 = new Book(1, "Мы", "Замятин", 1000);
    Product book2 = new Book(2, "Стена", "Сартр", 800);
    Product phone1 = new Smartphone(3, "Apple", "iPhone-5S", 15000);
    Product phone2 = new Smartphone(4, "Apple", "iPhone-5", 15000);

    @Test
    public void ShouldSearch() {
        Product[] products = {book1, book2, phone1, phone2};
        doReturn(products).when(repo).getProducts();


        Product[] actual = manager.searchBy("iPhone");
        Product[] expected = {phone1, phone2};

        assertArrayEquals(expected, actual);
    }
}
