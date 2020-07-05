package com.atguigu.test;

import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Author: jiang
 * @Date: 6/28/2020
 * Description: TODO
 */
public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {

        bookService.addBook(new Book(null, "hellpow", "xxx", new BigDecimal(1000), 100, 124, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(23);

    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(23, "sdfsdfdsf", "xxx", new BigDecimal(1000), 100, 124, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(23));
    }

    @Test
    public void queryBooks() {
        System.out.println(bookService.queryBooks());
    }
    @Test
    public void page() {
        System.out.println(bookService.page(1, 4));
    }

    @Test
    public void pageByPrice() {
        System.out.println(bookService.pageByPrice(1, 4,10,50));
    }


}