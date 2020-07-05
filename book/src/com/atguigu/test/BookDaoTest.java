package com.atguigu.test;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: jiang
 * @Date: 6/28/2020
 * Description: TODO
 */
public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "Hello World", "Xu Jiang", new BigDecimal(9999), 110000, 110, null));
        
    }

    @Test
    public void deleteBookById() {
        int i = bookDao.deleteBookById(22);
        System.out.println(i);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(22, "XXX World", "Xu Jiang", new BigDecimal(9999), 110000, 110, null));
    }

    @Test
    public void queryBookById() {
        Book book = bookDao.queryBookById(22);
        System.out.println(book);
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());

    }

    @Test
    public void queryForPageItems() {
    bookDao.queryForPageItems(8, 4).forEach(System.out::println);

    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(10,50));

    }

    @Test
    public void queryForPageItemsByPrice() {
        bookDao.queryForPageItemsByPrice(0,4,10, 50).forEach(System.out::println);

    }
}