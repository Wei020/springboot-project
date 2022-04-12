package com.example.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.Book;

public interface IBookService extends IService<Book> {

    IPage<Book> getPage(int currengePage, int pageSize, Book book);

}
