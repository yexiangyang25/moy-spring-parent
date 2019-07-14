package org.moy.test.elasticsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


/**
 * <p>Description: [程序入口]</p>
 * Created on 2018/9/10
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@SpringBootApplication
@RestController
public class ElasticsearchApplication {

    @Autowired
    BookEsRepository bookEsRepository;

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchApplication.class, args);
    }

    @RequestMapping("/")
    public Book hello() {
        Book book = new Book();
        book.setId(UUID.randomUUID().toString());
        book.setName(Thread.currentThread().getName());
        book.setDesc("线程名" + Thread.currentThread().getName() + "时间:" + String.valueOf(System.currentTimeMillis()));
        return bookEsRepository.save(book);
    }

    @RequestMapping("/find/{id}")
    public Book find(@PathVariable("id") String id) {
        Optional<Book> bookOptional = bookEsRepository.findById(id);
        return bookOptional.orElse(null);
    }

    @RequestMapping("/find/name/{name}")
    public List<Book> findName(@PathVariable("name") String name) {
        return bookEsRepository.findBooksByName(name);
    }


    @RequestMapping("/find/desc/{desc}")
    public Page<List<Book>> findDesc(@PathVariable("desc") String desc) {
        return bookEsRepository.findBooksByDescLike(desc, PageRequest.of(0, 10));
    }
}
