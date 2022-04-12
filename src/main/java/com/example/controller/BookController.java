package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.controller.utls.R;
import com.example.domain.Book;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@ResponseBody
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll(){
        return new R(true,bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book){
        boolean flag = bookService.save(book);
        return new R(flag,flag?"添加成功!":"添加失败!");
    }

    @PutMapping
    public R update(@RequestBody Book book){
        boolean flag = bookService.updateById(book);
        return new R(flag,flag?"修改成功!":"修改失败!");
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id){
        boolean flag = bookService.removeById(id);
        return new R(flag,flag?"删除成功!":"删除失败!");
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,bookService.getById(id));
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,Book book){
        IPage<Book> page = bookService.getPage(currentPage,pageSize,book);
//        如果当前页码值大于总页码值，重新执行查询操作
        if(page.getCurrent() > page.getPages()){
            page = bookService.getPage((int)page.getPages(),pageSize,book);
        }
        return new R(true,page);
    }
}
