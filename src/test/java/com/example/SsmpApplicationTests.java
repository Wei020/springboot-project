package com.example;

import com.example.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SsmpApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
        System.out.println(bookDao.selectList(null));
    }



}
