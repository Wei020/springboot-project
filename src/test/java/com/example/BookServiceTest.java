package com.example;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.Book;
import com.example.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private IBookService bookService;
    @Test
    void testGetById(){
        System.out.println(bookService.getById(1));
    }

    @Test
    void testSelectList(){
        System.out.println(bookService.list());
    }

    @Test
    void testSelectPage(){
        IPage<Book> page = new Page<>(2,2);
        System.out.println(bookService.page(page));
    }
}
