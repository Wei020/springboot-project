package com.example;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.BookDao;
import com.example.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTest {

    @Autowired
    private BookDao bookDao;
    @Test
    void testSelectAll(){

    }

    @Test
    void testSava() {
        Book book = new Book();
        book.setType("计算机");
        book.setName("Java编程思想");
        book.setDescription("java学习宝典");
        bookDao.insert(book);
    }

    @Test
    void testGetPage(){
        IPage page = new Page(1,2);
        bookDao.selectPage(page,null);
        System.out.println(page.getSize());
        System.out.println(page.getCurrent());
        System.out.println(page.getRecords());
        System.out.println(page.getTotal());
    }

    @Test
    void testGetBy(){
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","Java");
        bookDao.selectList(queryWrapper);
    }
    @Test
    void testGetBy2(){
        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Book::getName,"Java");
        bookDao.selectList(queryWrapper);
    }

    @Test
    void testGetBy3(){
        String name = "a";
        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(name != null,Book::getName,name);
        bookDao.selectList(queryWrapper);
    }
}
