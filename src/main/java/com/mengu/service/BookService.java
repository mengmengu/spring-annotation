package com.mengu.service;

import com.mengu.dao.BookDao;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * Service
 *
 * @author mengu
 * @date 2018/11/13
 */
@ToString
@Service
public class BookService {

    // 第一个
    //使用@Qualifier明确指定了一个bean,@Primary默认首选失效
//    @Qualifier("bookDao")
//    @Autowired(required = false)

    // 第二个
//    @Resource(name = "bookDao2")

    // 第三个
    @Inject
    private BookDao bookDao;

    public void print() {
        System.out.println(bookDao);
    }

}
