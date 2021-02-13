package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {



    @Test
    void shouldSearchByNameBook() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "The Great Gatsby", 300, "Francis Scott Key Fitzgerald");
        Book book2 = new Book(2, "Dracula", 400, "Bram Stoker");
        Book book3 = new Book(3, "Martin Eden", 100, "Jack London");
        Book book4 = new Book(4, "Airport", 2300, " Arthur Hailey");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        Product[] actual = manager.searchBy("Dracula");
        Product[] expected = new Product[] {book2};
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchByAuthorBook() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "The Great Gatsby", 300, "Francis Scott Key Fitzgerald");
        Book book2 = new Book(2, "Dracula", 400, "Bram Stoker");
        Book book3 = new Book(3, "Martin Eden", 100, "Jack London");
        Book book4 = new Book(4, "Airport", 2300, "Arthur Hailey");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        Product [] actual = manager.searchBy("Arthur Hailey");
        Product [] expected = new Product[] {book4};
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchByNameSmartphone() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Smartphone smartphone1 = new Smartphone(1, "XIAOMI", 4000, "China");
        Smartphone smartphone2 = new Smartphone(2, "Samsung", 9000, "Korea");
        Smartphone smartphone3 = new Smartphone(3, "iPhone", 2000, "USA");
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = new Product[] {smartphone2};
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldSearchByProducerSmartphone() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Smartphone smartphone1 = new Smartphone(1, "XIAOMI", 4000, "China");
        Smartphone smartphone2 = new Smartphone(2, "Samsung", 9000, "Korea");
        Smartphone smartphone3 = new Smartphone(3, "iPhone", 2000, "USA");
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        Product[] actual = manager.searchBy("USA");
        Product[] expected = new Product[] {smartphone3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchTwoBooks() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "The Great Gatsby", 300, "Francis Scott Key Fitzgerald");
        Book book2 = new Book(2, "Dracula", 400, "Bram Stoker");
        Book book3 = new Book(3, "Martin Eden", 100, "Jack London");
        Book book4 = new Book(4, "Dracula", 400, "Bram Stoker");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        Product[] actual = manager.searchBy("Dracula"  );
        Product[] expected = new Product[] {book2, book4};
        assertArrayEquals(expected, actual);

    }


    @Test
    void shouldSearchByTwoNameSmartphones() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Smartphone smartphone1 = new Smartphone(1, "XIAOMI", 4000, "China");
        Smartphone smartphone2 = new Smartphone(2, "Samsung", 9000, "Korea");
        Smartphone smartphone3 = new Smartphone(3, "iPhone", 2000, "USA");
        Smartphone smartphone4 = new Smartphone(4, "iPhone", 8000, "USA");
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        Product[] actual = manager.searchBy("iPhone");
        Product[] expected = new Product[] {smartphone3, smartphone4};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNothing() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Smartphone smartphone1 = new Smartphone(1, "XIAOMI", 4000, "China");
        Smartphone smartphone2 = new Smartphone(2, "Samsung", 9000, "Korea");
        Smartphone smartphone3 = new Smartphone(3, "iPhone", 2000, "USA");
        Smartphone smartphone4 = new Smartphone(4, "iPhone", 8000, "USA");
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        Product[] actual = manager.searchBy(" ");
        Product[] expected = new Product[] { };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameOfBookAndSmartphone() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Smartphone smartphone1 = new Smartphone(1, "XIAOMI", 4000, "China");
        Smartphone smartphone2 = new Smartphone(2, "Samsung", 9000, "Korea");
        Smartphone smartphone3 = new Smartphone(3, "iPhone", 2000, "USA");
        Smartphone smartphone4 = new Smartphone(4, "iPhone", 8000, "USA");
        Book book3 = new Book(3, "Martin Eden", 100, "Jack London");
        Book book4 = new Book(4, "Samsung", 400, "Bram Stoker");
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = new Product[] {book4, smartphone2};
        assertArrayEquals(expected, actual);
    }






}